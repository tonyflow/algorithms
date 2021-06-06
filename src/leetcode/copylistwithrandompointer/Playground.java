package leetcode.copylistwithrandompointer;

public class Playground {

    public static void main(String[] args) {
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        CopyListWithRandomPointer.Node head = new CopyListWithRandomPointer.Node(7);
        CopyListWithRandomPointer.Node second = new CopyListWithRandomPointer.Node(13);
        CopyListWithRandomPointer.Node third = new CopyListWithRandomPointer.Node(11);
        CopyListWithRandomPointer.Node forth = new CopyListWithRandomPointer.Node(10);
        CopyListWithRandomPointer.Node fifth = new CopyListWithRandomPointer.Node(1);
        head.next = second;
        head.random = null;
        second.next = third;
        second.random = head;
        third.next = forth;
        third.random = fifth;
        forth.next = fifth;
        forth.random = third;
        fifth.next = null;
        fifth.random = head;

        copyListWithRandomPointer.copyRandomList(head);
    }
}
