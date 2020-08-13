class LinkedListNode {
    int data;
    LinkedListNode next, arb, prev;

    public LinkedListNode(int data) {
        this.data = data;
        this.arb = this.next = null;
    }
}
