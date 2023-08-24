# 220904 CryptoZombie Lesson 5

## Chapter 1. 이더리움 상의 토큰

- 사실 토큰은 규악을 따르는 스마트 컨트랙트 (ERC-20)
  - 다른 컨트랙트가 따르는 표준 함수 집합
- mapping(address => uint256) balances, 주소에 잔액이 얼마인지
- 토큰도 하나의 컨트랙트, 그 안에서 누가 얼마나 많은 토큰을 가지고 있는지 확인, 몇 함수를 가지고 다른 주소로 전송할 수 있게 해주는거

### ERC 20의 장점

- 다른 어떤 ERC20 토큰이랑도 상호작용 가능
- ex)거래소
  - ERC20 토큰 상장, 이 거래소에서 통신 가능한 또 하나의 스마트컨트랙트 추가
  - DB에 새 컨트랙트 주소 추가만 하면 ERC20 추가됨

### ERC 721

- 대체불가능한 토큰
- 경매, 거래/판매 직접 구현 안 해도 알아서 해줌

------

## Chapter 2~9. ERC-721 구현 관련

- erc-20.sol

```solidity
contract ERC20 {
	function name() public view returns (string)
	function symbol() public view returns (string)
	function decimals() public view returns (uint8)
	function totalSupply() public view returns (uint256)
	function balanceOf(address _owner) public view returns (uint256 balance)
	function transfer(address _to, uint256 _value) public returns (bool success)
	function transferFrom(address _from, address _to, uint256 _value) public returns (bool success)
	function approve(address _spender, uint256 _value) public returns (bool success)
	function allowance(address _owner, address _spender) public view returns (uint256 remaining)
	
	event Transfer(address indexed _from, address indexed _to, uint256 _value)
	event Approval(address indexed _owner, address indexed _spender, uint256 _value)
}
```

- import 해주고, ,를 통해 다수 상속도 가능

구현, 전송, 이것저것 로직 구현

------

## Chapter 9~10. 오버플로우 막기 / 라이브러리 활용

uint8, 8비트, 최대 255(1111111)

```solidity
uint8 number = 255;
number++;
```

- 오 버 플 로 우, 00000000으로 돌아감

### SafeMath 라는게 있지롱

OpenZeppelin 라이브러리

```solidity
using SafeMath for uint256;

uint256 a = 5;
uint256 b = a.add(3); // 5 + 3 = 8
uint256 c = a.mul(2); // 5 * 2 = 10
```

- 임포트 하고, 4가지 연산 더 있음
  - 저렇게 쓰면, 알아서 a가 첫 번째로, 3이 나중으로 드러감
- safemath.sol

```solidity
pragma solidity ^0.4.18;

/**
 * @title SafeMath
 * @dev Math operations with safety checks that throw on error
 */
library SafeMath {

  /**
  * @dev Multiplies two numbers, throws on overflow.
  */
  function mul(uint256 a, uint256 b) internal pure returns (uint256) {
    if (a == 0) {
      return 0;
    }
    uint256 c = a * b;
    assert(c / a == b);
    return c;
  }

  /**
  * @dev Integer division of two numbers, truncating the quotient.
  */
  function div(uint256 a, uint256 b) internal pure returns (uint256) {
    // assert(b > 0); // Solidity automatically throws when dividing by 0
    uint256 c = a / b;
    // assert(a == b * c + a % b); // There is no case in which this doesn't hold
    return c;
  }

  /**
  * @dev Subtracts two numbers, throws on overflow (i.e. if subtrahend is greater than minuend).
  */
  function sub(uint256 a, uint256 b) internal pure returns (uint256) {
    assert(b <= a);
    return a - b;
  }

  /**
  * @dev Adds two numbers, throws on overflow.
  */
  function add(uint256 a, uint256 b) internal pure returns (uint256) {
    uint256 c = a + b;
    assert(c >= a);
    return c;
  }
}
```

- assert는 조건을 만족하지 않으면 에러 발생시킴
- 그리구

```solidity
myUint++;

=> 

myUint = myUint.add(1); // 이렇게 해야함
```

- 심지어 SafeMath16, 32 따로 다 만들 수 있음

주석 달고 끝~