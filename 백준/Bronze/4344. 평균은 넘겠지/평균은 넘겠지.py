import sys

test_cnt = int(sys.stdin.readline())

for i in range(test_cnt):
    score = list(map(int, sys.stdin.readline().split()))
    sum = score[score[0]]
    for j in range(1, score[0]):
        sum+=score[j]
    avg = sum/score[0]
    cnt = 0
    for j in range(1, score[0]+1):
        if score[j]>avg:
            cnt+=1
    result = '{:.3f}%'.format(cnt/score[0]*100)
    print(result)