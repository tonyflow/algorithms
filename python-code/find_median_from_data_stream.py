import heapq



class MedianFinder:
    """
    There are some edge cases that this code does not cover
    TODO: Review this code
    """
    def __init__(self):
        self.left_pq = []
        self.right_pq = []

    def addNum(self, num: int) -> None:
        if not self.left_pq and not self.right_pq:
            heapq.heappush(self.left_pq, num)
        elif self.left_pq and num > self.left_pq[-1]:
            heapq.heappush(self.right_pq, num)
        elif self.right_pq and num < self.right_pq[0]:
            heapq.heappush(self.left_pq, num)
        elif self.left_pq and self.right_pq:
            if len(self.left_pq) == len(self.right_pq):
                heapq.heappush(self.right_pq, num)
            else:
                # in this case the right pq should always be longer
                popped_from_right: int = heapq.heappop(self.right_pq)
                heapq.heappush(self.left_pq, popped_from_right)
                heapq.heappush(self.right_pq, num)

    # both are non-empty

    def findMedian(self) -> float:
        if (len(self.left_pq) + len(self.right_pq)) % 2 == 0:
            return (self.left_pq[-1] + self.right_pq[0]) / 2
        else:
            return self.right_pq[0]


if __name__ == '__main__':
    median_finder: MedianFinder = MedianFinder()
    median_finder.addNum(1)
    median_finder.addNum(2)
    print(median_finder.findMedian())
    median_finder.addNum(3)
    print(median_finder.findMedian())
