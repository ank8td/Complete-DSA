package com.doubly.linklist;
public class main {
    public static void main(String args[]){
        DoublyLinkedList dllist = new DoublyLinkedList();
        dllist.insertFirst(20);
        dllist.insertFirst(30);
        dllist.insertFirst(40);
        dllist.insertFirst(50);
        dllist.insertLast(99);
        dllist.insertAfter(50,105);
        dllist.display();
        dllist.displayReverse();
    }

}
