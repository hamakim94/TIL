# 그럼 새로만들 함수는 일단 token과 nodes를 받아야겠다..

token = ['딸기', '바나나', '사과', '딸기','파인애플']
nodes = ['바나나', '사과', '파인애플', '딸기']
vocab = nodes

vocab2idx = { nodes[i] : i for i in range(len(nodes))}
idx2vocab = { i : nodes[i] for i in range(len(nodes))}

import numpy as np
import math

vocab_len = len(vocab)
# 이제 여기서 하나하나씩 가야함
# 일단 그 사이즈 받지

# 토큰별로 그래프 edge를 Matrix 형태로 생성
weighted_edge = np.zeros((vocab_len, vocab_len)) # 4*4
# 각 토큰 노드별로 스코어 1로 초기화
score = np.ones((vocab_len))
# coocurrence를 판단하기 위한 window 사이즈 설정
window_size = 2
covered_coocurrences = []
# weighted_edge 구현

# 일단 window_start라는 변수를 받을거야
for window_start in range(len(token) - window_size + 1):
    window = token[window_start : (window_start + window_size)]
    for i in range(window_size):
        for j in range(i+1, window_size):
            if (window[i] in vocab2idx.keys()) and (window[j] in vocab2idx.keys()):
                index_i = window_start + i
                index_j = window_start + j

                if [index_i, index_j] not in covered_coocurrences:
                    weighted_edge[vocab2idx[window[i]]][vocab2idx[window[j]]] = 1
                    weighted_edge[vocab2idx[window[j]]][vocab2idx[window[i]]] = 1
                    covered_coocurrences.append([index_i, index_j])

for i in range(len(vocab)):
    sumi = weighted_edge[i].sum()
    weighted_edge[i] = weighted_edge[i]/sumi if sumi > 0 else 0


MAX_ITER = 50
threshold = 0.00001
d = 0.85
for num in range(MAX_ITER):
    prev_score = np.copy(score)

    for i in range(len(vocab)):
        summation = 0
        for j in range(len(vocab)):
            if weighted_edge[j][i] != 0:
                summation += weighted_edge[j][i] * score[j]
            score[i] = (1 - d) + d*(summation)
    
        if np.sum(np.fabs(score - prev_score)) <= threshold:
             break


n = 2
print('top {}'.format(n))
for i in np.argsort(score)[::-1][:n]:
    print( '{} : {}'.format( idx2vocab[i], score[i]))


