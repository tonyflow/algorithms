def max_profit(prices: list[int]) -> int:
    # If the numbers are only descending then there's not profitable transaction
    # can_be_profitable:bool = False
    n: int = len(prices)
    # for i in range(1,n-1):
    #     if prices[i]>prices[i-1]:
    #         can_be_profitable = True
    #         break

    # if not can_be_profitable:
    #     return 0

    max_profit: int = 0
    buying_date: int = 0
    selling_date: int = 1
    while selling_date < n:
        if prices[buying_date] < prices[selling_date]:
            max_profit = max(max_profit, prices[selling_date] - prices[buying_date])
        else:
            # we found a cheaper buying price move the buying date there
            buying_date = selling_date

        selling_date += 1

    return max_profit

    """Check what can be the largest diff.

    [10,4,3,2,12,6]
    
    Brute: Check price at index i and all prices after it and get the max
    
    """


if __name__ == "__main__":
    pass
