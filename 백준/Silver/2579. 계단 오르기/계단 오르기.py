import sys

stair_num = int(sys.stdin.readline());

stair_score = []; #1행은 1칸 이동, 2행은 2칸 이동

for i in range(stair_num):
    stair_score.append(int(sys.stdin.readline()));

sum_stair = [];

for i in range(stair_num):
    if i == 0:
        sum_stair.append([stair_score[0], stair_score[0]])
    elif i == 1:
        sum_stair.append([stair_score[0]+stair_score[1], stair_score[1]])
    else:
        sum_stair.append([sum_stair[i-1][1]+stair_score[i], max(sum_stair[i-2][0], sum_stair[i-2][1]) + stair_score[i]]);
        
    
print(max(sum_stair[stair_num-1][0], sum_stair[stair_num-1][1]));