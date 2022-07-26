package com.circular.linklist;
public class main {
    public static void main(String[] args) {
        CircularLinkedList clist = new CircularLinkedList();
        clist.insert(10);
        clist.insert(20);
        clist.insert(30);
        clist.insert(40);
        clist.display();
        clist.delete(20);
        clist.display();
    }
}
