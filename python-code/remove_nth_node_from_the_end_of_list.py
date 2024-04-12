from typing import *
from list_node import *


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy: ListNode = ListNode(-1)
        dummy.next = head
        a: ListNode = head
        b: ListNode = head
        for _ in range(n + 1):
            b = b.next
            print(f'Value for b is {b.val}')

        print('Removing')
        while b:
            a = a.next
            b = b.next
            if b:
                print(f'Value for b is {b.val}')
            print(f'Value for a is {a.val}')

        a.next = a.next.next

        return dummy.next


if __name__ == '__main__':
    result: ListNode = Solution().removeNthFromEnd(
        ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6)))))), 3)
    while result:
        print(result.val)
        result = result.next
