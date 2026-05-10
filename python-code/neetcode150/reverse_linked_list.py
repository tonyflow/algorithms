from __future__ import annotations


class ListNode:
    def __int__(self, val: int, next_node: ListNode | None):
        self.val = val
        self.next: ListNode = next_node


def reverse_list(head: ListNode | None) -> ListNode | None:
    previous = None
    while head is not None:
        to_be = head.next
        head.next = previous
        previous = head
        head = to_be

    return previous
