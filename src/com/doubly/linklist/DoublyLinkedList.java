package com.doubly.linklist;

import com.single.linklist.SingleLinkList;

public class DoublyLinkedList {
    private Node head;
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }
    public void insertLast(int val){
        Node node = new Node(val);
        node.next = null;
        Node temp = head;
        if(head == null){
            node.prev = null;
            head = node;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }
    public Node findNode(int val){
        Node node = head;
        while(node !=null){
            if(node.value==val){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public void insertAfter(int after, int val){
        Node afterNode = findNode(after);
        if(afterNode == null){
            System.out.println("Node doesnt exist");
            return;
        }
        Node node = new Node(val);
        node.next = afterNode.next;
        afterNode.next = node;
        node.prev = afterNode;
        if(node.next != null){
            node.next.prev = node;
        }
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public void displayReverse(){
        Node temp = head;
        Node last = null;
        while(temp != null){
            last = temp;
            temp = temp.next;
        }
        while(last != null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }


    private class Node{
        int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
