class MyLinkedList {

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private class Node{
        private int val;
        private Node next;
        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public MyLinkedList() {
        this.size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        int i = 0;
        Node curr = head;
        while(i < index && curr != null){
            curr = curr.next;
            i++;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node n = new Node(val);
        if(head == null){
            head = n;
            tail = n;
            size++;
            return;
        }
        n.val = val;
        n.next = head;
        head = n;
        size++;
    }
    
    public void addAtTail(int val) {
        if(tail == null){
            addAtHead(val);
            return;
        }
        Node n = new Node(val);
        tail.next = n;
        tail = n;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }

        Node temp = head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }

        Node n = new Node(val);
        n.next = temp.next;
        temp.next = n;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }

        if(index == 0){
            head = head.next;
            size--;

            // List became empty
            if(size == 0){
                tail = null;
            }
            return;
        }
        Node temp = head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
        // If deleting the last node
        if(temp.next == tail){
            tail = temp;
        }
        // Remove target
        temp.next = temp.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */