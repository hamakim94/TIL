# 220902 CryptoZombie Lesson 2

https://cryptozombies.io/en/lesson/2/chapter/1

## Chapter 1. lesson2 overview

- lesson 1에선, 이름을 가지고 랜덤 좀비를 만들고 이를 db에 저장했음
- lesson 2, 게임처럼 만들거야 : 멀티플레이어, 좀비 좀더 재밌게 만들거야, 랜덤 x
- 새로운 좀비 : “feed” lifeforms, 좀비가 다른 생명체를 먹도록!!!!!!

zombie feeding(좀비 먹이기)

좀비가 먹이를 먹으면 먹이는 바이러스에 감염. → 새로운 좀비로 바꿈

새로운 좀비의 DNA는 이전 좀비의 DNA + 먹이 DNA로 만들거얌

가장 좋아하는 먹이가 뭘까..?

------

## Chapter 2. Mappings and Addressses

- 멀티 플레이어 게임 만들기 위해서 DB에 주소랑 좀비 저장할게 필요

### Addresses(주소)

- 이더리움은 계정(accounts)로 만들어져 있음(은행 계좌 생각)
- 계정은 Ether balance가 있고, 다른계정에게 이더를 보내고, 받는 일을 할수 있다
- 계정은 각자의 주소가 있음. 주소의 형태
  - 0x0cE446255506E92DF41614C46F1d6df9Cc969183 (크립토좀비 팀)
- **주소는 특정 유저나, 스마트 컨트랙트에 소속돼있음
- 주소를 특정 좀비의 고유한 ID로 생각할 수 있음
- 유저가 새로운 좀비를 만들면, 우리는 createZombie 부른 이더리움 주소에 ownership을 부여 할 수 있다

### mapping이란?

- Solidity에서 데이터를 쌓는법

```solidity
// 금융어플에선, 계정이 가지고 있는 이더를 수로 나타낸다
mapping (address => uint) public accountBalance;
// account를 통해 userid 든 다양한걸 받을 수 있음
mapping (uint => string) userIdToName;
```

- key-value 쌍이다

------

## Chapter 3.  Msg.sender

좀비 소유자를 추적하는 매핑(주소 → uint)을 가지고 있으니, _createZombie 업데이트 해서 매핑 써보자

- 솔리디티에선 모든 함수에서 이용 가능한 **특정 전역 변수** 가 있음.
- 현재 함수를 호출한 사람 (혹은 스마트 컨트랙트)의 주소를 가리키는 msg.sender
  - 참고) 솔리디티에서 함수 실행은 항상 외부 호출자가 시작, 컨트랙트는 누군가가 컨트랙트의 함수를 호출할 때 까지 블촉체인상에서 아무것도 안함
- 예시

```solidity
mapping (address => uint) favoriteNumber;

function setMyNumber(uint _myNumber) public {
  // `msg.sender`에 대해 `_myNumber`가 저장되도록 `favoriteNumber` 매핑을 업데이트한다 `
  favoriteNumber[msg.sender] = _myNumber;
  // ^ 데이터를 저장하는 구문은 배열로 데이터를 저장할 떄와 동일하다 
}

function whatIsMyNumber() public view returns (uint) {
  // sender의 주소에 저장된 값을 불러온다 
  // sender가 `setMyNumber`을 아직 호출하지 않았다면 반환값은 `0`이 될 것이다
  return favoriteNumber[msg.sender];
}
```

- msg.sender를 활용하면 보안성 이용. 다른 사람의 데이터를 변경하려면 해당 이더리움 주소와 관련된 개인키를 훔쳐야함

------

## Chapter 4. Require

좀비 인당 1개씩만 만들고 싶오!!

createRandomZombie 1회만 하게 하자!

- require(조건) 쓰면, 특정 조건이 맞아야지만 사용 가능한 부분!

------

## Chapter 5. Inheritance(상속)

- 게이밍 코드가 길어지네,
- 하나의 컨트랙트를 길게 짜는거보다 여러개로 쪼개

```solidity
contract Doge {
  function catchphrase() public returns (string memory) {
    return "So Wow CryptoDoge";
  }
}

contract BabyDoge is Doge {
  function anotherCatchphrase() public returns (string memory) {
    return "Such Moon BabyDoge";
  }
}
```

- BabyDoge를 컴파일하고 배포하면,  catchphrase()도 사용 가능함!!
- 논리적 상속을 위해서 사용가능하지만, 비슷한 로직을 함꼐 모아서 다른 컨트랙트에 사용할 수도 있음

------

## Chapter 6. Import

- ZombieFactory Contract를 zombiefactory.sol로 쪼갬
- 너무 길어지니까 여러 파일로 쪼갠다.(일반적으로 솔리디티 프로젝트 코드를 이렇게 관리함)
- 다른 파일을 import(수입)하고 싶을떄, import 씀

```solidity
import "./someothercontract.sol";
contract newContract is SomeOtherContract {}
```

./ : 같은 디렉토리를 의미함, 컴파일러가 someothercontract.sol을 찾으면 임포팅됨

------

## Chapter 7. Storage vs Memory(Data Location)

변수를 저장하는 2개의 장소가 있음

### Storage (하드디스크같음)

- 블록체인에 영구적으로 저장함

### Memory (램같음)

- 일시적,
- 외부 함수가 우리 계약을 호출하면 지워짐
- 명시적으로 표현할 일이 없음. Solidity Compiler가 알아서 해줌
  - 함수 밖에서 선언한 변수는 Storage에
  - 함수 안에서 선언한 변수는 Memory에

**그러나 struct, array 쓰면 쓸 일 생김**

```solidity
contract SandwichFactory {
  struct Sandwich {
    string name;
    string status;
  }

  Sandwich[] sandwiches;

  function eatSandwich(uint _index) public {
    // Sandwich mySandwich = sandwiches[_index];

    // ^ Seems pretty straightforward, but solidity will give you a warning
    // telling you that you should explicitly declare `storage` or `memory` here.

    // So instead, you should declare with the `storage` keyword, like:
    Sandwich storage mySandwich = sandwiches[_index];
    // ...in which case `mySandwich` is a pointer to `sandwiches[_index]`
    // in storage, and...
    mySandwich.status = "Eaten!";
    // ...this will permanently change `sandwiches[_index]` on the blockchain.

    // If you just want a copy, you can use `memory`:
    Sandwich memory anotherSandwich = sandwiches[_index + 1];
    // ...in which case `anotherSandwich` will simply be a copy of the 
    // data in memory, and...
    anotherSandwich.status = "Eaten!";
    // ...will just modify the temporary variable and have no effect 
    // on `sandwiches[_index + 1]`. But you can do this:
    sandwiches[_index + 1] = anotherSandwich;
    // ...if you want to copy the changes back into blockchain storage.
  }
}
```

- 아직 감 안 잡혀도 ok,
- 함수 안에서 storage를 선언할 수 있음

**함수(), 함수와 () 사이에 띄어쓰면 에러난다**

------

## Chapter 8. Zombie DNA

먹이주고 변신하는거 해보자, 새로운 좀비도 내 좀비에 추가됨

------

## Chapter 9. More on Function Visibility(함수 접근 제어자)

- chap 8에서 코드는 사실 문제가 있어
  - ZombieFactory에서 _createZombie는 사실 private, 상속받아도 사실 못 써!!
  - 사실 ZombieFactory를 상속받아 쓰는 contract들은 private한거 다 못쓰네??
- 그러기 위해서 추가했다!

### internal

- private과 유사
- 상속 받은 곳에선 private 쓸 수 있게

### external

- public과 유사하지만, contract 밖에서만 써!!
- contract 안 다른 함수들에서 쓰지 못함?? (나중에)

```solidity
contract Sandwich {
  uint private sandwichesEaten = 0;

  function eat() internal {
    sandwichesEaten++;
  }
}

contract BLT is Sandwich {
  uint private baconSandwichesEaten = 0;

  function eatWithBacon() public returns (string memory) {
    baconSandwichesEaten++;
    // We can call this here because it's internal
    eat();
  }
}
```

------

## Chapter 10. 좀비는 뭘 먹을까

- eat cryptokitties.. 읽기만 가능하기 때문에, 실제로 먹진 않아!!

### Interacting with other contracts

- we need to define interface

```solidity
contract LuckyNumber {
  mapping(address => uint) numbers;

  function setNum(uint _num) public {
    numbers[msg.sender] = _num;
  }

  function getNum(address _myAddress) public view returns (uint) {
    return numbers[_myAddress];
  }
}
contract NumberInterface {
  function getNum(address _myAddress) public view returns (uint);
}
```

- function과 유사하게 생김
- 차이점 :
  1. 함수만 정의함
  2. 함수 body가 없음 {}, 그냥 ;로 끝남
- 위 두가지 차이점이 컴파일러가 인터페이스로 읽는 이유!
- Contract 단에서 인터페이스를 선언해야하고
- 함수에 끝에 {}없이 ; 붙이는거 알지?

------

## Chapter 11. Using an Interface

```solidity
contract MyContract {
  address NumberInterfaceAddress = 0xab38... 
  // ^ 위에 있는 LuckyNumber Contract Address
  NumberInterface numberContract = NumberInterface(NumberInterfaceAddress);
  // Now `numberContract` is pointing to the other contract

  function someFunction() public {
    // Now we can call `getNum` from that contract:
    uint num = numberContract.getNum(msg.sender);
    // ...and do something with `num` here
  }
}
```

- 위와 같은 방식으로 이더리움 안에 있는 다른 컨트랙트들을 쓸 수 있음
- 해당 function들이 public or external로 선언되었을 떄

------

## Chapter 12. Handling Multiple Return Values

```solidity
function multipleReturns() internal returns(uint a, uint b, uint c) {
  return (1, 2, 3);
}

function processMultipleReturns() external {
  uint a;
  uint b;
  uint c;
  // 여러 개 동시에 할당하는 방법
  (a, b, c) = multipleReturns();
}

// Or if we only cared about one of the values:
function getLastReturnValue() external {
  uint c;
  // 나머지 칸들 비워놓으면 알아서 안 돼
  (,,c) = multipleReturns();
}
```

------

## Chapter 13. Bonus : Kitty Genes

- kitty가 좀비에 물렸으면, 좀비 새끼 고양이!
- cat-zombie임을 알 수 있는 feature를 추가하자!
- 그럼 zombie’s DNA에 special kitty code를 추가하장
- lesson 1에서, 16자리 수 중에 12자리만 쓴거 기억해? 마지막 2자리 숫자를 special characteristic에 쓰자!!
- cat-zombie는 DNA 마지막 2자리 수가 99라고 가정하자. 그래서 만약 특정 좀비가 좀비고양이로부터 생성됐으면, 좀비의 마지막 2자리를 99로 하자

### if문

- JS랑 같음

```solidity
function eatBLT(string memory sandwich) public {
  // Remember with strings, we have to compare their keccak256 hashes
  // to check equality
  if (keccak256(abi.encodePacked(sandwich)) == keccak256(abi.encodePacked("BLT"))) {
    eat();
  }
}
```

------

## Chapter 14: Wrapping it Up

- 배포할 떄, ZombieFeeding만 배포하면 된다.
  - ZombieFactory를 상속받고 있기 때문에 양쪽에서 public한 함수들은 모두 접근 가능하다

```jsx
var abi = /* abi generated by the compiler */
var ZombieFeedingContract = web3.eth.contract(abi)
var contractAddress = /* our contract address on Ethereum after deploying */
var ZombieFeeding = ZombieFeedingContract.at(contractAddress)

// Assuming we have our zombie's ID and the kitty ID we want to attack
let zombieId = 1;
let kittyId = 1;

// To get the CryptoKitty's image, we need to query their web API. This
// information isn't stored on the blockchain, just their webserver.
// If everything was stored on a blockchain, we wouldn't have to worry
// about the server going down, them changing their API, or the company 
// blocking us from loading their assets if they don't like our zombie game ;)
let apiUrl = "<https://api.cryptokitties.co/kitties/>" + kittyId
$.get(apiUrl, function(data) {
  let imgUrl = data.image_url
  // do something to display the image
})

// When the user clicks on a kitty:
$(".kittyImage").click(function(e) {
  // Call our contract's `feedOnKitty` method
  ZombieFeeding.feedOnKitty(zombieId, kittyId)
})

// Listen for a NewZombie event from our contract so we can display it:
ZombieFactory.NewZombie(function(error, result) {
  if (error) return
  // This function will display the zombie, like in lesson 1:
  generateZombie(result.zombieId, result.name, result.dna)
})
```