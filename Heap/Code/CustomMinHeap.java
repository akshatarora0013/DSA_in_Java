package Heap.Code;

import java.util.*;

public class CustomMinHeap<T extends Comparable<T>> {
    private ArrayList<T> data = new ArrayList<>();

    public void add(T element){
        data.add(element);
        upheaify(data.size()-1);
    }

    private void upheaify(int childIndex){
        int parentIndex = (childIndex-1)/2;
        if(isLarger(data.get(childIndex), data.get(parentIndex)) > 0){
            swap(childIndex,parentIndex);
            upheaify(parentIndex);
        }
    }

    private void swap(int i, int j){
        T ith = data.get(i);
        T jth = data.get(j);
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

    public T remove(){
        swap(0, data.size()-1);
        T remove = this.data.remove(data.size()-1);
        downHeapify(0);
        return remove;
    }

    private void downHeapify(int parentIndex){
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        int minIndex = parentIndex;
        if(leftChildIndex < this.data.size() && isLarger(data.get(leftChildIndex) , data.get(minIndex)) > 0){
            minIndex = leftChildIndex;
        }
        if(rightChildIndex < this.data.size() && isLarger(data.get(rightChildIndex) , data.get(minIndex)) > 0){
            minIndex = rightChildIndex;
        }
        if(parentIndex != minIndex){
            swap(parentIndex, minIndex);
            downHeapify(minIndex);
        }
    }

    public T get(){
        return this.data.get(0);
    }

    public int isLarger(T t, T o){
        return t.compareTo(o);
    }
}
