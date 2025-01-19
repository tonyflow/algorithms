from typing import List


class Solution:
    """
    Interesting post on binary search for solution space search
    https://leetcode.com/problems/koko-eating-bananas/solutions/769702/python-clear-explanation-powerful-ultimate-binary-search-template-solved-many-problems

     [1,1,3,3,2,2,4,4],2
            bloomed_indices = [0,1,4,5]
            for i in [0,3):
                i = 0
                    bi[0] = 0
                    bi[1] = 1
                    bi[0] + 1 = bi[1]
                    adjacent = 2
                    nob = 1
                i = 1
                    bi[1] = 1
                    bi[2] = 4
                    bi[1] + 1 != bi[2]
                    adjacent = 1
                i = 2
                    bi[2] = 4
                    bi[3] = 5
                    bi[4] + 1 = bi[5]

            [1,1],1
            for i in [0,1):
                i = 0
                    bi[0] = 0
                    bi[1] = 1
                    bi[0] + 1 = bi[1]

    A bouquet needs k adjacent flowers
    We want to make m bouquets

    """

    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        def can_make_m_bouquets_effective(days_candidate: int) -> bool:
            bouquets, flowers = 0, 0
            for bd in bloomDay:
                if bd > days_candidate:
                    flowers = 0
                else:
                    bouquets = (flowers + 1) // k
                    flowers = (flowers + 1) % k
            return bouquets >= m

        def can_make_m_bouquets(days_candidate: int) -> bool:
            bloomed_indices: List[int] = []
            for i in range(len(bloomDay)):
                if bloomDay[i] <= days_candidate:
                    bloomed_indices.append(i)

            print(f"List of bloomed indices at {days_candidate} is {bloomed_indices}")

            # Check how many bouquets we can make by checking how many groups
            # of adjacent flowers we have
            number_of_bouquets: int = 0
            if k == 1:
                number_of_bouquets = len(bloomed_indices)
            else:
                for index in bloomed_indices:
                    can_create_bouquet = True
                    for extender in range(1, k):
                        print(f"Checking position {index + extender}")
                        if index + extender not in bloomed_indices:
                            print(
                                f"Starting from position {index}, adjacent position {index + extender} "
                                f"has not bloomed so we cannot proceed further"
                            )
                            can_create_bouquet = False
                            break
                        else:
                            bloomed_indices.remove(index + extender)
                            print(f"Remaining indices {bloomed_indices}")

                    if can_create_bouquet:
                        number_of_bouquets += 1

            print(
                f"Number of bouquets we can create with available days {days_candidate} is {number_of_bouquets}"
            )
            return number_of_bouquets >= m

        if m * k > len(bloomDay):
            return -1

        left, right = 1, max(bloomDay)
        while left < right:
            middle: int = left + (right - left) // 2
            # if can_make_m_bouquets(middle):
            if can_make_m_bouquets_effective(middle):
                right = middle
            else:
                left = middle + 1

        return left


if __name__ == "__main__":
    solution = Solution()
    # print(solution.minDays(bloomDay=[1, 10, 3, 10, 2], m=3, k=1))
    # print(solution.minDays(bloomDay=[1, 10, 3, 10, 2], m=3, k=2))
    # print(solution.minDays(bloomDay=[7, 7, 7, 7, 12, 7, 7], m=2, k=3))
    print(solution.minDays(bloomDay=[1, 10, 2, 9, 3, 8, 4, 7, 5, 6], m=4, k=2))
