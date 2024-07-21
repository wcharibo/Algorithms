from collections import Counter
def solution(want, number, discount):
    answer = 0

    buy = {want[i]: number[i] for i in range(0, len(want))}

    for i in range(0, len(discount) - 9):
        counter = Counter(discount[i:i+10])

        for k, v in buy.items():
            if(k not in counter or v > counter[k]):
                break
        else:
            answer += 1

    return answer