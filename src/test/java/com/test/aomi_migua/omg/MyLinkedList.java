package com.test.aomi_migua.omg;
class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        ListNode current = linkedList.listNode;
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3

    }
    private  ListNode listNode;
    MyLinkedList(){
        listNode = null;
//        listNode = new ListNode();
    }


    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    public int get(int index) {
        ListNode current = listNode;
        try {
            for (int i = 0; i < index; i++) {
                if (current.next == null) {
                    return -1;
                } else {
                    current = current.next;
                }
            }
            if (current != null) {
                return current.val;
            } else {
                return -1;
            }
        }catch (Exception e){
            return -1;
        }
    }
    
    public void addAtHead(int val) {
        ListNode current = listNode;
        ListNode head = new ListNode(val);
        head.next = current;
        listNode = head;
    }
    
     private void addAtTail(int val) {
        ListNode current = listNode;
        while (current.next != null){
                current = current.next;
        }
        current.next = new ListNode(val);
    }

    public void addAtIndex(int index, int val) {
//        1-2-3   1,2
        if (index == 0){
            addAtHead(val);
            return;
        }
        ListNode current = listNode;
        for (int i = 0;i<index-1;i++){
            current = current.next;
        }
        if (current!=null){
            ListNode temp = new ListNode(val);
            temp.next = current.next;
            current.next = temp;
        }

    }
    
    public void deleteAtIndex(int index) {
//        1-3   1
        if (index == 0){
            //删除第一个元素
            listNode = listNode.next;
            return;
        }
        ListNode current = listNode;
        for (int i = 0;i<index-1;i++){
                current = current.next;
        }
        if (current.next != null && current.next.next != null) {
            current.next = current.next.next;
        }else {
            current.next = null;
        }
    }
}
