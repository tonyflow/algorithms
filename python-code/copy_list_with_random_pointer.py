from typing import *
from list_node import Node


class Solution:
    def copyRandomList(self, head: Node) -> Node:
        dummy: Node = Node(-1)
        cloned_current = dummy
        current: Node = head
        helper: Dict[Node, Optional[Node]] = {}

        index = 0

        while current:
            # # Clone current node
            new_cloned_node = Node(x=current.val)
            cloned_current.next = new_cloned_node
            helper[current] = new_cloned_node

            # Advance pointers
            current = current.next
            cloned_current = cloned_current.next

        # Reset pointers
        current = head

        # Populate random pointers
        while current:
            cloned_a: Node = helper[current.random]
            cloned_b: Node = helper[current]
            cloned_a.random = cloned_b
            current = current.next

        return dummy.next


if __name__ == "__main__":
    head: Node = Node(1, next=Node(2, next=Node(3, next=Node(4))))
    cloned: Node = Solution().copyRandomList(head)
    while cloned:
        print(cloned.val)
        cloned = cloned.next
