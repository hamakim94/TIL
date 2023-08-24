## Bert4rec

요약

과거 행동을 통해 현재 다이나믹한 선호도를 측정(예측)

예전엔 Unidirectional,즉 한 방향으로만 했다

Unidirectional 단점

1. 한 방향만 보면 유저 행동 시퀸스들의 숨겨진 의미를 제한함

   (한 방향으로만 보기에는 안 보이는 외부 요인 때문에 안 좋다고~~~)

2. 실용적이지않은, 빡세게 순서로된? 시퀸스를 가정함( 양방향성 정보를 생각안함 )
   they often assume a rigidly ordered sequence which is not always practical.

![Unidirectional](C:\Users\mingy\OneDrive\바탕 화면\Unidirectional.PNG)

SASREC : 각 타임step에 따른 loss 모두 계산(t-1 samples 효과)

(과거 방식들은 한 방향만 봄)



* 양방향성 모델을 학습시키기 위해, 빈칸뚫기 방식을 통해 왼쪽,오른쪽 정보들을 활용함

  (Cloze Task)

* 한 epoch당 빈칸 뚫는걸 랜덤으로 할수 있어서 다양하게 학습이 가능

  * 단점: 최종 결과와 맞지 않을 수 있음 
    * 맨 마지막에 [mask]라는 토큰을 추가해서 문제 해결



# Bert4Rec

목표 : 과거 행동들을 통해 다음에 관심 가질 아이템을 추측해보겠다~~

## 모델 구조

모델 구조 : ![bert4rec](C:\Users\mingy\OneDrive\바탕 화면\bert4rec.PNG)Trm들이 각 위치별 정보를 공유함~

BIDIRECTIONAL : Masked 단어에서 Loss계산(매 에폭마다 랜덤하게 masiking nCk samples)

## Transformer Layer

1개의 TRM  : ![transformer](C:\Users\mingy\OneDrive\바탕 화면\transformer.PNG) -> L층으로 쌓을거야

크게 2가지 층이 있음

1. Multi-Head Self-Attention sub-layer

   ![img](https://cdn-images-1.medium.com/max/1600/1*9W5_CpuM3Iq09kOYyK9CeA.png)

   

   헤드가 여러개인 어텐션, 서로 다른 가중치 행렬을 이용해 각각 어텐션을 계산, 그리고 서로 연결한다

    Specifically, multi-head attention first linearly projects Hl into h subspaces, with different, learnable linear projections,s, and then apply h attention function in parallel to produce the output representations which are concatenated and once again projected:

2. Position-wise Feed-Forward Network

   마지막 어텐션 결과를 FFN을 통과시킴

   두 개의 Linear Transformations, Bert는 중간에 Gelu를 써서 음수를 소실시키지 않음

   

3. Stacking Transformer Layer

   attention layer들을 쌓아. 그러나 많이 할수록 너무 깊어져, 

   그래서 residual connection -> Dropout -> layer normalization(LN)-> 

   ​       LN(x + Dropout(sublayer(x))

## 3.4 Embedding Layer



- Positional Encoding을 사용하지 않고 대신 Position Embeddings를 사용

![img](https://user-images.githubusercontent.com/1250095/50039788-8e4e8a00-007b-11e9-9747-8e29fbbea0b3.png)

1. Token Embeddings :  아이템을 임베딩한거.!(그냥 1번 아이템은 784, 2번은 785 이런느낌)

2. Segment Embeddings : 문장의 기준이 아닌 한 유저의 sequential한 데이터니, 필요가 없다.(BERT와 차이)

3. Position Embeddings : 해당 아이템들의 위치만을 임베딩( 1번 아이템 -> 2번 아이템 -> 3번 아이템)

   

ex) 해삼 1, 멍개 2, 말미잘 3,  인절미 4, 강아지 간식 5 //// 내구매순서 : 말미잘 멍개 해삼

user 1 : 3 , 2 , 1



## 3.5 Output Layer

ms: P(v) = softmax GELU(h L t W P + b P )E ⊤ + b    ** GELU 써서 softmax 취해서 예측.



## 3.6 Model Learning -Training

기존 Unidirectional : 현재까지 자료를 토대로 다음 단계를 예측함

#### Cloze task(Masked Language Model) => GOOD

빈칸 채우기.

1 epoch => 전체 아이템 중 ρ 비율로 마스킹을 합니다( special token "[mask]")



Input: [v1,v2,v3,v4,v5] -----randomly mask ----> [v1, [mask]1 ,v3, [mask]2 ,v5] 

Labels: [mask]1 = v2, [mask]2 = v4

negative log-likelihood 공식 씀

장점 : 훈련시킬 때 표본을 많이 생성 가능함



## Test

목표 : sequential한 유저 기록을 갖고, 다음에 어떤걸 원해? => 예측의 대상

무적권 마스킹 하는게 아니라, 맨 마지막 아이템만 마스킹해서 맞추는 것도 훈련시킴



## Datasets

 Amazon Beauty

 Steam

 MovieLens( (ML-1m, ML-20m)

## 전처뤼

 Wang-Cheng Kang and Julian McAuley. [n. d.]. Self-Attentive Sequential Recommendation. In Proceedings of ICDM. 197–206.

Steffen Rendle, Christoph Freudenthaler, and Lars Schmidt-Thieme. 2010. Factorizing Personalized Markov Chains for Next-basket Recommendation. In Proceedings of WWW. ACM, New York, NY, USA, 811–820.,

Jiaxi Tang and Ke Wang. 2018. Personalized Top-N Sequential Recommendation via Convolutional Sequence Embedding. In Proceedings of WSDM. 565–573.

=> 해당 논문들 참고해서 내일 논의해보기



















































#####################################################################



## Encoder Block

![img](https://cdn-images-1.medium.com/max/1600/1*EblTBhM-9mOqYWMARk6ajQ.png)

논문 Base모델은 12개, Large모델은 24개로, 시퀸스 전체의 의미를 N(12,24)반복적으로 구축

-> 블록의 수가 많을수록 단어 사이에 복잡한 관계를 잘 포착할 수 있다

인코더 블록은 병렬처리가 아닌, 이전 출력값을 현재의 입력값으로 하는 RNN과 유사한 특징을 갖고

## Scaled Dot-Product Attention

![img](https://cdn-images-1.medium.com/max/1600/1*m-NRoagK_I5fFvBjjS7TZg.png)

 처음에는 임베딩의 fully-connected 결과, 이전 인코더 블록의 결과를 다음 인코더 블럭의 입력으로 사용한다

- Transformer는 

Q : 디코더의 히든 스테이트

K : 인코더의 히든 스테이트

V : K에 어텐션을 부여 받은 Normalized Weights

- Bert에서는 Q,K,V의 초기값이 모두 동일하며, 디코더를 쓰지도 않음(구성만 동일함)



=> Scaled_Dot_Product Attention을 여러번 계산한 결과들의 Concatenate임

















