## task-specific and static vectors. 2개 슴







These vectors were trained by Mikolov et
al. (2013) on 100 billion words of Google News,
and are publicly available.1

1. 우선 window size로 모든 문장을 사진찍어
2., 그리고 bias와 hyperbolictangent와 같은걸로 합성
3. n-h+1개의 featuremap 생성
4, 이걸 기반으로 max-overpull
5, 가장 높은 c 값을 -> 하나의 feature 생성?
6. 그래서 여러개의 window size를 통해 여러개 feature 생성

(근데, 2개의 채널, 훈련을 통해 vs 역전파)??

## 2.1 정규화

1. L2-norm

y = w · z + b

y = w · (z ◦ r) + b, ( r : )  

and r ∈ R,  is a ‘masking’ vector of Bernoulli random variables with probability p of being 1.

Gradients are backpropagated only through the
unmasked units.





# 나이브 베이지안 vs CNN이 최종 목표?

