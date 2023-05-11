def warOfNumbers(nums):
    # result = [evenTotal, oddTotal]
    result = [0,0]
    for num in nums:
        if num % 2 == 0:
            result[0] += num
        else:
            result[1] += num
    return result;


if __name__ == '__main__':
    promptInputOne = [1, 2, 3, 4, 5, 6];
    promptInputTwo = [-1, -2, -3, -4, -5, -6];
    custom = [0, 1, 3, 5] # edge case where a number is 0, it should be added to evenTotal.

    print(warOfNumbers(promptInputOne))
    print(warOfNumbers(promptInputTwo))
    print(warOfNumbers(custom))

