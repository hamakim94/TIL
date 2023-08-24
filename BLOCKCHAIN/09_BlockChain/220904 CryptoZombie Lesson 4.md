# 220904 CryptoZombie Lesson 4



## Chapter 1. Payable

- 함수 제어자들
  - private : 컨트랙트 내부의 다른 함수들에서만 소유
  - internal : private와 유사, 해당 컨트랙트를 상속하는 다른 컨트랙트 사용 가능
  - external : 오직 컨트랙트 외부에서만 호출 가능
  - public : 내외부, 어디서든
- 상태 제어자(state Modifier)
  - view : 해당 함수를 실행해도 어떤 데이터도 저장/변경되지 않음
  - pure : 해당 함수도 어떤 데이터도 블록체인에 저장 X, 블록체인으로부터 어떤 데이터도 읽지 않음. (외부에서 불렀을 때 가스 소모 X)
- 제어자
  - onlyOwner 등

### Payable

- 함수를 실행하는 동시에 컨트랙트에 돈을 지불함

```solidity
contract OnlineStore {
  function buySomething() external payable {
    // 함수 실행에 0.001이더가 보내졌는지 확실히 하기 위해 확인:
    require(msg.value == 0.001 ether);
    // 보내졌다면, 함수를 호출한 자에게 디지털 아이템을 전달하기 위한 내용 구성:
    transferThing(msg.sender);
  }
}
```

web3

```solidity
// `OnlineStore`는 자네의 이더리움 상의 컨트랙트를 가리킨다고 가정하네:
OnlineStore.buySomething({from: web3.eth.defaultAccount, value: web3.utils.toWei(0.001)})
```

- 트랜잭션은 봉투, value는 금액

------

## Chapter 2. 출금(withdrawal)

- 주인인 경우만 돈 뽑을 수 있음

```solidity
contract GetPaid is Ownable {
  function withdraw() external onlyOwner {
    owner.transfer(this.balance);
  }
}
```

- 초과지불 돈돌려주기

```solidity
uint itemFee = 0.001 ether;
msg.sender.transfer(msg.value - itemFee);
```

- 판매자의 주소를 storage에 저장하고, 아이템을 구매하면 받은 요금 전달
  - seller.transfer(msg.value)

------

## Chapter 3~4. 좀비 전투(계약생성) ~ 난수

```solidity
// Generate a random number between 1 and 100:
uint randNonce = 0;
uint random = uint(keccak256(now, msg.sender, randNonce)) % 100;
randNonce++;
uint random2 = uint(keccak256(now, msg.sender, randNonce)) % 100;
```

- keccak256이 난수쓰기 좋대
- 숫자를 만들 떄 마다 randNonce를 ++ 해서 keccak256 해시 함수로 만들자

### 이더리움

- 컨트랙트 함수 실행 → 트랜잭션(네트워크의 노드 하나, 혹은 여러 노드에 실행 알림) → 네트워크 노드들은 여러 개의 트랜잭션을 모아 → “작업 증명”, 매우 복잡한 수학 문제를 먼저 풀기 위한 시도 → PoW가 되면 *블록*으로 네트워크에 배포
- 한 노드가 PoW 완료, 다른 노드들은 PoW 풀려는 시도를 멈추고 해당 노드가 보낸 트랜잭션 목록이 유효한걸 검증.
- 난수 만들기 어려움, oracle(이더리움 외부에서 데이터 받아오기) 을 통해 받아온다

------

## Chapter 5~13. 좀비 싸움, 리팩토링, 승리, 패배

- require 중복 → 높은 부모 contract 에서 modifer 하나 만들고 다 쓰렴!
- 구조체, 최대한 작게 데이터 가지고 있어(나중에 메모리 낭비 대박)
  - 함수 구현
  - 승리,패배를 기록하기 위한 struct 추가
  - 난수를 만들고, 70보다 작으면 승리(70%의 확률의 승리를 이렇게)
  - 승리시 winCount++
  - 패배시 loseCount++