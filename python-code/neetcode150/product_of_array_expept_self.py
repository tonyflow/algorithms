def brute_force(nums: list[int]) -> list[int]:
    length_of_nums: int = len(nums)
    results: list[int] = []
    for i in range(length_of_nums):
        product_for_i: int = 1
        for j in range(length_of_nums):
            if i != j:
                product_for_i *= nums[j]
        results.append(product_for_i)

    return results


def product(nums: list[int]) -> list[int]:
    """Examples

    Edge cases:
    * If there are more than 1 zeros in the nums array we can return an array of
    zeros. This is because when we remove element at index i, we will still have at
    least on other zero element that will make the rest of the product zero.

    [1,2,3,4,5]
    rp = 120
    res = [120,60,40,30,24]

    [1,-1,5,6]
    rp = -30
    res = [-30,30,-6,-5]

    [2,0,4,5]
    rp = 40
    res = [20, 40, 10, 8]

    [1,0,5,9,-1]
    rp = -45
    res=[0,-45,0,0,0]

    [1,0,0,9,-1]
    """
    running_product: int = 1

    # Compute running product
    number_of_zeros: int = 0
    for num in nums:
        if num == 0:
            number_of_zeros += 1
            continue
        else:
            running_product *= num

    if number_of_zeros > 1:
        return [0] * len(nums)

    # Compute product of array without current element
    results: list[int] = []
    for number in nums:
        if number == 0:
            results.append(running_product)
        else:
            results.append(running_product / number if number_of_zeros == 0 else 0)

    return results


def prefix_and_suffix(nums: list[int]) -> list[int]:
    """Examples

    The prefix handles everything before the index
    The suffix handles everything after the index
    prefix[i] = the product of all elements BEFORE i
    suffix[i] = the product of all elements AFTER i

    * [-1, 0, 1, 2, 3]
    """
    length_of_nums: int = len(nums)

    prefix: list[int] = [0] * length_of_nums
    suffix: list[int] = [0] * length_of_nums
    results: list[int] = [0] * length_of_nums

    # Initialize first element of prefix. There's nothing in the array before 0. So
    # the product can only be one
    prefix[0] = 1
    for i in range(1, length_of_nums):
        prefix[i] = prefix[i - 1] * nums[i - 1]

    # [-1, ]

    # Initialize the last element of suffix. There's nothing in the array after
    # length_of_nums so the product can only be one
    # start = one before the end since we have already initialized the end
    # end = -1 since the end is exclusive and we want to also populate index at 0
    suffix[length_of_nums - 1] = 1
    for i in range(length_of_nums - 2, -1, -1):
        suffix[i] = suffix[i + 1] * nums[i + 1]

    for i in range(0, length_of_nums):
        results[i] = prefix[i] * suffix[i]

    return results

def prefix_and_suffix_optimal(nums: list[int]) -> list[int]:
    """Examples
    
    We can get the same results with just two additional variables prefix and suffix
    [1,2,3,4]

    prefix[i-1]*nums[i-1]
    [1,1*1,1*2,2*3] = [1,1,2,6]

    suffix[i+1]*nums[i+1]
    [2*12,3*4,1*4,1] = [24,12,4,1]

    results = [1*24,1*12,2*4,1*3] = [24, 12, 8, 6]

    []
    []
    """
    length_of_nums:int = len(nums)
    results = [0]*length_of_nums

    prefix = 1

    for i in range(length_of_nums):
        results[i] = prefix
        prefix*=nums[i]

    suffix = 1
    for i in range(length_of_nums-1,-1,-1):
        results[i]*=suffix
        suffix*=nums[i]

    return results



if __name__ == "__main__":
    print(prefix_and_suffix_optimal([1, 2, 4, 6]))
    print(prefix_and_suffix([1, 2, 4, 6]))
