package com.single.linklist;
public class SingleLinkList {
    private Node head;
    private Node tail;
    private int size;
    public SingleLinkList() {
        this.size = 0;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void insertAtIndex(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;
    }
    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }else{
            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size++;
        }
    }
    public void display(){
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }
    public int deleteFirst(){
        int value = head.value;
        head = head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return value;
    }
    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secondLast = getReferenceOfNode(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }
    public int deleteAtIndex(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node prev = getReferenceOfNode(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }
    public Node getReferenceOfNode(int index){
        Node node = head;
        for(int i=0;i<index;i++){
            node = node.next;
        }
        return node;
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
    /*Insert into linked list using Recursive call */
    public void insertByRec(int val,int index){
        head = insertByRec(val,index,head);
    }
    public Node insertByRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        node.next = insertByRec(val,index-1,node.next);
        return node;
    }

    /*Remove duplicate from the shorted list*/
    public void removeDuplicate(){
        Node node = head;
        while(node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    /*Merge two sorted linked list into a single sorted linked list */
    public static  SingleLinkList merge(SingleLinkList first, SingleLinkList second){
        Node f = first.head;
        Node s = second.head;

        SingleLinkList ans = new SingleLinkList();
        while(f!=null && s!=null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            }else{
                ans.insertLast(s.value);
                s=s.next;
            }
        }
        while (f!=null){
            ans.insertLast(f.value);
            f=f.next;
        }
        while(s!=null){
            ans.insertLast(s.value);
            s=s.next;
        }
        return ans;
    }
/*This method used to check wheather there is cycle persent into the linked list or not*/
    public boolean hasCycle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast!=null && slow!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public int cycleLength(Node head){
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                // calculate length
                Node temp = slow;
                int len = 0;
                do{
                    temp = temp.next;
                    len++;
                }while(temp!=slow);
                return len;
            }
        }
        return 0;
    }
/*This is the methd used to find the starting node of the cycle.*/
    public Node findTheStartNodeOfCycle(Node head){
        int len = 0;
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                len = cycleLength(slow);
                break;
            }
        }
        if(len==0){
            return null;
        }
        // find the start node
        Node f = head;
        Node s = head;
        while(len>0){
            s = s.next;
            len--;
        }
        // keep moving both pointer forward and they will meet at cycle start.
         while(f!=s){
             f = f.next;
             s = s.next;
         }
         return s;

    }

    public boolean isHappy(int n){
        int slow = n;
        int fast = n;
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);
        if(slow ==1){
            return true;
        }
        return false;

    }
    private int findSquare(int number){
        int ans = 0;
        while(number > 0){
            int rem = number%10;
            ans += rem * rem;
            number = number/10;
        }
        return ans;
    }

    /*find the middle of the linked list*/
    public Node middleNode(){
        Node s = head;
        Node f = head;
        while(f !=null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    /*Reverse of linked list using recursion*/

    private void reverse(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    /*In place reversal of linked list*/

    public Node reverseInPlace(Node head){
        if(head == null){
            return head;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        head = prev;
        return head;
    }

    private class Node{
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
