package com.single.linklist;
public class main {
    public static void main(String args[]){
        SingleLinkList first = new SingleLinkList();
        SingleLinkList second = new SingleLinkList();
        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);
        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(7);
        SingleLinkList mergedList = SingleLinkList.merge(first,second);
        mergedList.display();


    }
}
