import sys

sys.setrecursionlimit(10**6)

house_num = int(sys.stdin.readline());
price_list = []
min_price_list = []
for i in range(house_num):
    price_list.append(list(map(int, sys.stdin.readline().split())))
    min_price_list.append([0,0,0])

min_price_list[0] = price_list[0];

def paint_cost(line, color):
    if line==0:
        return min_price_list[line][color];
    elif min_price_list[line][color] !=0:
        return min_price_list[line][color];
    else:
        formal_price = []
        for i in range(3):
            if i==color:
                continue;
            else:
                formal_price.append(paint_cost(line-1, i));
        minimum = min(formal_price)
        min_price_list[line][color] = minimum + price_list[line][color]
        return min_price_list[line][color];
        
cal_list=[]
for i in range(3):
    cal_list.append(paint_cost(house_num-1, i));
print(min(cal_list))