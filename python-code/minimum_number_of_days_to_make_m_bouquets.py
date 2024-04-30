from typing import List


class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        def can_make_m_bouquets(days_candidate: int) -> bool:
            """
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

            """
            bloomed_indices: List[int] = []
            for i in range(len(bloomDay)):
                if bloomDay[i] <= days_candidate:
                    bloomed_indices.append(i)

            # Check how many bouquets we can make by checking how many groups
            # of adjacent flowers we have
            number_of_bouquets: int = 0
            number_of_adjacent_bloomed: int = 1
            if k == 1:
                number_of_bouquets = len(bloomed_indices)
            else:
                for i in range(len(bloomed_indices) - 1):
                    if bloomed_indices[i] + 1 == bloomed_indices[i]:
                        number_of_adjacent_bloomed += 1
                        if number_of_adjacent_bloomed == k:
                            number_of_bouquets += 1
                    else:
                        number_of_adjacent_bloomed = 1

            return number_of_bouquets >= m

        if m * k < len(bloomDay):
            return -1

        left, right = 1, len(bloomDay)
        while left < right:
            middle: int = left + (right - left) // 2
            if can_make_m_bouquets(middle):
                right = middle
            else:
                left = middle + 1
        return -1
