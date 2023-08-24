# 220903 CryptoZombie Lesson 3



## ***\*Chapter 1: Immutability of Contracts\****

- 이더리움 컨트랙트를 배포하는 순간, 이는 immutable(불변)하다
  - 수정, 업데이트 불가능
- 결함이 있어도 수정 불가능
  - 해당 계약을 사용하는 사람들에게 다른 smart contract를 사용하라고 해야함
- 하지만, 스마트 컨트랙트의 중요한 특징이고도 함
  - ‘코드는 법이다’

### External dependencies

- lesson2에선, CryptoKittes 주소를 하드코딩했음
  - 근데 버그있고, 누가 새끼 고양이들을 다 파괴했으면?
- 가능성은 적지만, 실제로 일어난다면 Dapp은 다 파괴된 고양이들의 주소를 가리키기 떄문에 쓸모가 없어진다.
- 그래서 Dapp의 key portion을 업데이트 하는 기능이 필요하긴 함
  - Dapp에서 CryptoKittes 주소 하드코딩 하는거보다, setKittyContractAddress 라는 function을 만들어서 나중에 바꾸도록 하는게 좋겠다~
- external keyword를 이용해서 외부에서 수정 가능하도록 만든다
  - 근데 아무나 다 바꿀수 있기에, Chap2로 가자

------

## ***\*Chapter 2: Ownable Contracts\****

setKittyContract는 external이라, 누구나 해당 주소를 바꿀 ㅅ ㅜ있다. 누구나 CryptoKittes의 주소를 바꿀수 있기에 우리의 Dapp을 이상하게 만들 수 있음

### OpenZeppelin’s Ownable contract

- 오픈제플린의 Ownable 계약

```solidity
/**
 * @title Ownable
 * @dev The Ownable contract has an owner address, and provides basic authorization control
 * functions, this simplifies the implementation of "user permissions".
 */
contract Ownable {
  address private _owner;

  event OwnershipTransferred(
    address indexed previousOwner,
    address indexed newOwner
  );

  /**
   * @dev The Ownable constructor sets the original `owner` of the contract to the sender
   * account.
   */
  constructor() internal {
    _owner = msg.sender;
    emit OwnershipTransferred(address(0), _owner);
  }

  /**
   * @return the address of the owner.
   */
  function owner() public view returns(address) {
    return _owner;
  }

  /**
   * @dev Throws if called by any account other than the owner.
   */
  modifier onlyOwner() {
    require(isOwner());
    _;
  }

  /**
   * @return true if `msg.sender` is the owner of the contract.
   */
  function isOwner() public view returns(bool) {
    return msg.sender == _owner;
  }

  /**
   * @dev Allows the current owner to relinquish control of the contract.
   * @notice Renouncing to ownership will leave the contract without an owner.
   * It will not be possible to call the functions with the `onlyOwner`
   * modifier anymore.
   */
  function renounceOwnership() public onlyOwner {
    emit OwnershipTransferred(_owner, address(0));
    _owner = address(0);
  }

  /**
   * @dev Allows the current owner to transfer control of the contract to a newOwner.
   * @param newOwner The address to transfer ownership to.
   */
  function transferOwnership(address newOwner) public onlyOwner {
    _transferOwnership(newOwner);
  }

  /**
   * @dev Transfers control of the contract to a newOwner.
   * @param newOwner The address to transfer ownership to.
   */
  function _transferOwnership(address newOwner) internal {
    require(newOwner != address(0));
    emit OwnershipTransferred(_owner, newOwner);
    _owner = newOwner;
  }
}
```

### 생성자 : Constructors

- 컨트랙트랑 이름이 같음
- 컨트랙트가 처음 만들어졌을 때 딱 1번만 실행됨

### 함수 제어자 Function Modifiers

- 기능이, 함수가 실행되기 전에 요구 사항 충족 여부를 확인함
- _; 가 뭔지 이따 알려줌

indexed 그냥 넘어가렴

### Ownable의 기본 기능

- 컨트랙트가 생성되면, 생성자가 owner에 msg.sender(contract 배포자)를 대입
- 특정한 함수들에 대해, 오직 소유자만 접근할 수 있도록 제한 가능한 onlyOwner제어자
- 새로운 소유자에게 해당 컨트랙트들의 소유권을 옮길 수 있도록 함
- 대부분의 smartContract 첫 단엔, ownable 상속받고 시작함

우리는 setKittyContractAddress함수로 onlyOwner로 제한하고 싶지?

------

## Chapter 3. onlyOwner Function Modifier

baseContract인 ZombieFactory는 Ownable 상속받기 때문에

ZombieFeeding에서도 onlyOwner 할 수 있엉

```solidity
ZombieFeeding is ZombieFactory
ZombieFactory is Ownable
```

마찬가지로 Ownable에있는 다른 함수들도 다 쓸 수 있엉

### Function Modifiers

함수처럼 생겼는데 function 자리에 modifier 들어감

바로 부르진 못하고, 함수 뒷편에 콕 붙인다.

```solidity
/**
 * @dev Throws if called by any account other than the owner.
 */
modifier onlyOwner() {
  require(msg.sender == owner);
  _;
}
```

이걸

```solidity
contract MyContract is Ownable {
  event LaughManiacally(string laughter);

  // 아래 `onlyOwner`의 사용 방법을 잘 보게:
  function likeABoss() external onlyOwner {
    LaughManiacally("Muahahahaha");
  }
}
```

likeABoss() 함수를 실행하면 onlyOnwer 코드가 먼저 실행됨

_; 부분은 likeABoss() 함수로 되돌아가 해당 코드를 실행함

제어자는 여러 종류가 있지만,  일반적으로 require 쓴다

onlyOwner의 경우, 배포한 사람만 호출 가능

- 이런 권한은 자주 필요하지만, 악용 또한 가능, 예를 들어 소유자가 다른 사람의 좀비를 뺏어올 수 있도록 하는 백도어 함수도 추가 가능
- DApp이라고 해서 그것만으로 분산돼있다고는 할 순 없음, 반드시 전체 코드를 읽어보고 소유자에 의한 특별한 제어가 불가능한 상태인지 확인해야함
- 개발자로서 잠재적인 버그를 수정하고 DApp을 안정적으로 유지한느 것과, 사용자들이 그들의 데이터를 믿고 저장할 수 있는, 소유자가 없는 플랫폼을 만드는 것 사이 균형을 잘 잡아야함

------

## Chapter4. 가스(Gas)

- 이더리움 DApp이 사용하는 연료
  - 함수의 로직의 복잡도에 따라 나옴
- 왜 가스?
  - 이더리움은 크고 느린, 하지만 굉장히 안전한 컴퓨터
  - 네트워크상 모든 개별 노드가 함수의 출력값을 검증해야함
  - (누군가 무한 반복문 돌리거나, 자원 소모 큰거 써서 자원 사용하지 못하도록 만듬)
- 그래서 우리는 구조체(struct, class)에서 uint16, uint32등을 사용해 좀비 구조 막을거얌

------

## Chapter 5. Time Units

- now : 현재 시간을 unix timestamp(최신 블록) 나타내줌
  - cf) 유닉스는 32비트, 20년만 쓸 수 있음
- seconds, minutes, hours, days, weeks, years 제공
- 초단위로 제공(uint)

------

## Chapter 6. 좀비 재사용 대기시간

### 구조체(struct)를 인수로 전달하기

- private, 또는 internal 함수의 인수로서, 구조체의 storage 포인터 전달 가능

```solidity
function _doStuff(Zombie storage _zombie) internal {
  // _zombie로 할 수 있는 것들을 처리
}
```

------

## Chapter 7. Public 함수 & 보안

- 보안을 점검하는 좋은 방법은, 모든 public과 external 함수를 검사하고, 사용자들이 그 함수들을 남용할 수 있는 방법을 생각.
- 제어자를 통해 막아야함

------

## Chapter 8. 함수 제어자의 또 다른 특징(modifier)

```solidity
// 사용자의 나이를 저장하기 위한 매핑
mapping (uint => uint) public age;

// 사용자가 특정 나이 이상인지 확인하는 제어자
modifier olderThan(uint _age, uint _userId) {
  require (age[_userId] >= _age);
  _;
}

// 차를 운전하기 위햐서는 16살 이상이어야 하네(적어도 미국에서는).
// `olderThan` 제어자를 인수와 함께 호출하려면 이렇게 하면 되네:
function driveCar(uint _userId) public olderThan(16, _userId) {
  // 필요한 함수 내용들
}
```

- modifier는 인수도 받을 수 있음

------

Chapter 9는, 적용하기

------

## Chapter 10. ‘View’ 함수를 사용해 가스 절약하기

- 데이터를 읽기만 하면 되는건 view씀, 가스 안 씀!
  - 블록체인 상에서 어떤 것도 수정하지 않기 때문에 가스 안 씀,
  - web3.js에 쿼리만 날려. 트랜잭션 안 만들어!
    - 트랜잭션은 모든 개별 노드에서 실행되어야 하고, 가스를 소모함
  - 가능한 모든 곳의 읽기 전용이면, external view 쓰는거
  - 만약 이 view함수를 다른 내부 함수에서 사용하면, 가스 소모돼
  - 외부에서 호출됐을 떄만 무료!

------

## Chapter 11. Storage는 비쌈

- storage도 비싼데, 쓰기는 더 비쌈
- 진짜 필요한 경우가 아니면 storage에 데이터를 안 쓰는게 좋음
- 특정 함수가 호출될 때 마다 배열을 memory에 만드는 방법이 있음

### 메모리에 배열 선언하기

```solidity
function getArray() external pure returns(uint[]) {
  // 메모리에 길이 3의 새로운 배열을 생성한다.
  uint[] memory values = new uint[](3);
  // 여기에 특정한 값들을 넣는다.
  values.push(1);
  values.push(2);
  values.push(3);
  // 해당 배열을 반환한다.
  return values;
}
```

- 이 배열은 함수가 끝날 때 까지만 존재
- storage에 배열 직접 업데이트하는거보다 가스 소모 측면에서 쌈
  - storage 배열과는 다르게 사이즈 선언해줘야함

------

## Chapter 12. for 반복문

```solidity
function getEvens() pure external returns(uint[]) {
  uint[] memory evens = new uint[](5);
  // 새로운 배열의 인덱스를 추적하는 변수
  uint counter = 0;
  // for 반복문에서 1부터 10까지 반복함
  for (uint i = 1; i <= 10; i++) {
    // `i`가 짝수라면...
    if (i % 2 == 0) {
      // 배열에 i를 추가함
      evens[counter] = i;
      // `evens`의 다음 빈 인덱스 값으로 counter를 증가시킴
      counter++;
    }
  }
  return evens;
}
```

- 나중에 좀비의 소유권이 바뀌는 기능을 구현할 텐데, 그럼 storage 배열에서 특정 좀비를 삭제하면 연산이 엄청나게 많이생김
- 그래서 특정 사용자의 좀비들을 구할 때, external view를 이용해 가스 소모 없이 반복문을 돌면서 작은 배열을 만들 수 있어
- 이 작은 배열로 storage값을 바꿀 예정(가스 소모 적다)