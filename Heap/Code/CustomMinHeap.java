package Heap.Code;

import java.util.*;

public class CustomMinHeap {
    private ArrayList<Integer> data = new ArrayList<>();

    public void add(int element){
        data.add(element);
        upheaify(data.size()-1);
    }

    private void upheaify(int childIndex){
        int parentIndex = (childIndex-1)/2;
        if(data.get(childIndex) < data.get(parentIndex)){
            swap(childIndex,parentIndex);
            upheaify(parentIndex);
        }
    }

    private void swap(int i, int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i, jth);
        data.set(j, ith);
    }

    public void display(){
        System.out.println(data);
    }

    public int size(){
        return data.size();
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public int remove(){
        swap(0, data.size()-1);
        int remove = this.data.remove(data.size()-1);
        downHeapify(0);
        return remove;
    }

    private void downHeapify(int parentIndex){
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        int minIndex = parentIndex;
        if(leftChildIndex < this.data.size() && data.get(minIndex) > data.get(leftChildIndex)){
            minIndex = leftChildIndex;
        }
        if(rightChildIndex < this.data.size() && data.get(minIndex) > data.get(rightChildIndex)){
            minIndex = rightChildIndex;
        }
        if(parentIndex != minIndex){
            swap(parentIndex, minIndex);
            downHeapify(minIndex);
        }
    }

    public int get(){
        return this.data.get(0);
    }
}
