import sys

house_num = int(sys.stdin.readline())
cost_list=[]
for i in range(house_num):
    cost_list.append(list(map(int, sys.stdin.readline().split())))

for i in range(1, len(cost_list)):
    cost_list[i][0]=min(cost_list[i-1][1], cost_list[i-1][2]) + cost_list[i][0]
    cost_list[i][1]=min(cost_list[i-1][0], cost_list[i-1][2]) + cost_list[i][1]
    cost_list[i][2]=min(cost_list[i-1][0], cost_list[i-1][1]) + cost_list[i][2]
    
print(min(cost_list[house_num-1]))