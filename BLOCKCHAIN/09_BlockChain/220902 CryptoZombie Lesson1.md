# 220902 CryptoZombie Lesson1

## Chap1. before begin

DNA : 16-digit-integer

첫 2칸 : 좀비 헤드 타입, 원랜 100가지를 저장할 수 있지만, 편의를 위해 7로 나눈 나머지로 7가지 타입만 지정

- 헤드 : 2자리(7), 눈 : 2자리(7), 셔츠 : 2자리(7)
- 스킨 컬러, 눈색, 옷색 :0~360 3자리

------

## Chap2. Contracts

- 솔리디티 코드는 컨트랙트 안에 싸여있음(encapsulated)
- 컨트랙트 : 이더리움 app의 기본 구성 요소
  - 모든 변수와 함수는 어느 한 컨트랙트에 속하게 마련

### Version pragma

- 모든 소스 코드는 version pragma로 시작
- 새로운 컴파일러 버전이 나와도 기존 코드가 깨지지 않음

------

## Chap3. 상태 변수 / 정수(State Variables & Integers)

- State variables
  - permanently stored in contract storage. (They’re written to the Eth BC)
  - similar to writing in db
- Unsinged Integers : uint
  - value must be non-negative (int 자료형도 따로 있음)
  - uint → uint256, 256비트, 32바이트

------

## Chap4. Math Operations

- +, -, *, /, x%y, 5**2(exponential)
- 좀비 DNA 길이는 16이기때문에, 10^16승을 이용해 나머지 연산으로 16자리 숫자로 편하게 만들어보자

------

## Chap5. Structs

- 조금 복잡한 자료형이 필요할 때. (class와 같음)
- string 자료형도 있따
- 좀비는 여러개 성질이 있기 때문에, struct를 활용해 좀피클래스를 정해보자

------

## Chap6. Arrays

- fixed arrays :
  - uint[2] fixedArray; string[5] stringArray;
- dynamic arrays
  - uint[] dynamicArray
- struct array도 가능
  - Person[] people; (DTO 같은 느낌)
  - DB에 저장되는것처럼 블록체인에 영속적으로 저장되기때문에, struct 사용이 좋다

### Public Arrays

- 베열을 public 선언 : create getter method of it
- 읽기만 하기 떄문에, contract안에 public data를 저장하는데 매우 유용한 패턴이다
- struct 배열 가능!

```solidity
Person[] public people; // 마지막에 변수 이름이 들어가
```

- 좀비 군대를 우리 앱에 저장할예정
- 다른 앱으로 우리 좀비를 자랑 할거얌 ⇒ public

------

## Chap7. 함수 선언

```solidity
function eatHamburgers(string _name, unit _amount){
}
```

- 함수 인자명을 언더스코어(_)로 시작해서 전역 변수와 구별하는것이 관례!
- We're also providing instructions about where the `_name` variable should be stored- in `memory` . This is required for all reference types such as arrays, structs, mappings, and strings.

------

### Chap8. 구조체와 배열 활용하기

- struct , 객체 만들 떈 new는 필요 없음
  - Person satoshi = Person(172. “satoshi);
  - people.push(satoshi)
  - 배열의 끝에 추가됌

------

### Chap9. Private / Public 함수

- 솔리디티 함수는 기본적으로 public
- 다른 컨트랙트(누구나) 만든 컨트랙트 함수를 호출하고 코드 실행 가능
- 공격에 취약. 함수를 private으로 선언하고, 공개할 함수만 public으로!
- private는 컨트랙트 내의 다른 함수들만이 호출 가능
- 함수명 다음에 적음. private한 함수는 _로 시작하는게 관례!

------

### Chap10. 함수 더 알아보기

- 반환값 종류도 포함해서 선언함

```solidity
string greeting = "What's up dog";

function sayHello() public view returns (string) {
	return greeting
}
```

- 해당 sayhello 함수는 솔리디티에서 상태를 변화시키진 않음(값 변경 X)

- view

   로만 선언.

  - 데이터를 보기만하고 변경

- pure, 함수가 앱에서 어떤 데이터도 접근하지 않는 것, 그냥 곱샘같은거

```solidity
fuction _multiply(uint a, uint b) private pure returns (uint){
	return a*b;
}
```

------

## Chap11. Keccak256과 형변환

### Keccak256

- 이더리움은 SHA3의 한 버전인 keccak256을 내장 해시 함수로 가지고있음
- 입력 스트링을 랜덤 256비트 16진수로 매핑
- 여기서는 의사 난수 발생기로만 이용
- 영어 문서에서는, keccak256(abi.encodePacked(_str)) 을 uint형으로 반환

### 형변환

```solidity
uint8 a = 5;
uint b = 6;
uint8 c = a * b; // a*b가 uint8이 아닌 uint를 반환해 에러 메시지 나옴
uint8 c = a * uint8(b) // b를 uint8로 형 변환해 코드가 작동하도록
```

- java : (int) a
- solidity: uint(a)

------

## Chap 13: Events

- Contract to communicate sth happend on the blockchain to Dapp FrontEnd
- listening for certain events and take action what they happen.

```solidity
event IntegersAdded(uint x, uint y, uint result);

function add( uint _x, uint _y) public returns (uint) {
	uint result = _x + _y;
	emit IntegersAdded(_x, _y, result);
	return result;
}
```

in front

```solidity
YourContract.IntegersAdded(function(error, result) {
  // do something with result
})
```

------

## 전체

```solidity
pragma solidity >=0.5.0 <0.6.0;

contract ZombieFactory {

    // declare our event here - web3js랑 놀거
    event NewZombie(uint zombieId, string name, uint dna);

		// 상태 변수
    // 16-digit-integer임을 확인하기 위함
    uint dnaDigits = 16; // 
    uint dnaModulus = 10 ** dnaDigits; // 10^16, 자릿수 확인
		
		// zombie class, 여기선 struct
    struct Zombie {
        string name;
        uint dna;
    }
		// zombie들 담을 배열, 어디서나 볼 수 있다
    Zombie[] public zombies;

		// _붙음 private, 좀비 만들기
    function _createZombie(string memory _name, uint _dna) private {
        uint id = zombies.push(Zombie(_name, _dna)) - 1;
        // and fire it here
        emit NewZombie(id, _name, _dna);
    }

    function _generateRandomDna(string memory _str) private view returns (uint) {
				// keccack256 내장 함수를 이용해 문자열을 숫자로, 16자릿수만 쓴다)
        uint rand = uint(keccak256(abi.encodePacked(_str)));
        return rand % dnaModulus;
    }
		// 여기서 이름만 입력받고, 위로 올라감. public -> 어디서든 쓸 수 있다
    function createRandomZombie(string memory _name) public {
        uint randDna = _generateRandomDna(_name);
        _createZombie(_name, randDna);
    }

}
```

the first line of code should take the `keccak256` hash of `abi.encodePacked(_str)` to generate a pseudo-random hexadecimal, typecast it as a `uint`, and finally store the result in a `uint` called `rand`.