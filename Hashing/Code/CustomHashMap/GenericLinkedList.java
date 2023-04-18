package Hashing.Code.CustomHashMap;

import java.util.*;

public class GenericLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    public GenericLinkedList() {
        this.size = 0;
    }

    public boolean isEmpty() {
        if(head == null){
            return true;
        }
        return false;
    }

    private class Node{
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(T value){
        Node node = new Node(value , head);
        head = node;

        if(tail == null){
            tail = head;
        }
        size ++;
    }

    public void insertLast(T value){
        Node node = new Node(value);
        if (tail == null){
            insertFirst(value);
            return;
        }
        tail.next = node;
        tail = node;

        size ++;
    }

    public void insert(T value , int index){
        if(index == 0){
            insertFirst(value);
            return;
        }
        if (index == size){
            insertLast(value);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public T deleteFirst(){
        T value = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return value;
    }

    public T deleteLast(){
        if (size <= 1){
            return deleteFirst();
        }
        Node temp = head;
        for (int i = 1; i < size-1; i++) {
            temp = temp.next;
        }
        T value = tail.value;
        temp.next = null;
        tail = temp;
        size--;
        return value;
    }

    public T delete(int index){
        if (index == 0){
            return deleteFirst();
        }
        if (index == size-1){
            return deleteLast();
        }
        Node prev = head;
        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }
        T value = prev.next.value;
        prev.next = prev.next.next;
        return value;
    }

    public void reverse(){
        Node next = null;
        Node previous = null;
        Node current = head;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public T get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public int find(T value){
        int index = 0;
        Node node = head;
        while (node != null){
            if (node.value.equals(value)){
                return index;
            }
            index++;
            node = node.next;
        }
        return -1;
    }

}
