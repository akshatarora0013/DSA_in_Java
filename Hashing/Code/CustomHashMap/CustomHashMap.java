package Hashing.Code.CustomHashMap;

import java.util.LinkedList;

public class CustomHashMap<K , V>{
    class HTpair{
        K key;
        V value;
        HTpair(K key , V value){
            this.key = key;
            this.value = value;
        }

        // OverRiding some funcions
        // why are we overriding? because the Node in the linked list will contain address of the object of HTpair type but we want to
        // do operations on the key and value

        // overriding equals function to check if two HTpairs are equal or not
        // when we are gonna call equals function in linked list to find a node it's gonna call this function
        public boolean equals(Object obj) {
            HTpair pair = (HTpair) obj;
            return this.key.equals(pair.key);
        }

        // overriding toString Method as while displaying the element of the string we don't want to print the address we want to print key and value
        public String toString (){
            return "{ " + this.key + " - " + this.value + " }";
        }
    }

    // How many HTpairs it can have by default
    private static final int DEFAULT_CAPACITY = 10;
    // Number of HTpairs present in the HashMap
    private int size;

    //creating array of type linked list and linked list will contain data about HTpair
    private GenericLinkedList<HTpair>[] bucketArray;

    // constructor to initialize the array of linked list
    CustomHashMap(){
        this(DEFAULT_CAPACITY);
    }
    CustomHashMap(int capacity){
        this.bucketArray = (GenericLinkedList<HTpair>[]) new GenericLinkedList[capacity];
        this.size = 0;
    }

    // creating put function
    public void put(K key , V value){
        int indexOfArray = hashFunction(key);
        GenericLinkedList<HTpair> list = this.bucketArray[indexOfArray];

        HTpair newPair = new HTpair(key, value);

        if(list == null){
            list = new GenericLinkedList<HTpair>();
            list.insertLast(newPair);
            this.bucketArray[indexOfArray] = list;
            this.size++;
        }
        else{
            int indexOfLL = list.find(newPair);
            if(indexOfLL == -1){
                list.insertLast(newPair);
                this.size++;
            }
            else{
                HTpair pair = list.get(indexOfLL);
                pair.value = newPair.value;
            }
        }

        double loadFactor = (this.size*1.0)/this.bucketArray.length;
        if(loadFactor > 0.75){
            rehash();
        }
    }

    // creating hashFunction function
    private int hashFunction(K key){
        int hashCode = key.hashCode();
        hashCode = Math.abs(hashCode);
        return hashCode%(this.bucketArray.length);
    }

    // creating display finction
    public void displayMap(){
        for(GenericLinkedList<HTpair> list : this.bucketArray){
            if(list != null && !list.isEmpty()){
                list.display();
            }
            else{
                System.out.println("NULL ");
            }
        }
    }

    // creating get function
    public V get(K key){
        int indexOfArray = hashFunction(key);
        GenericLinkedList<HTpair> list = this.bucketArray[indexOfArray];
        if(list == null){
            return null;
        }
        HTpair pairToFind = new HTpair(key, null);
        int indexOfLL = list.find(pairToFind);
        if(indexOfLL == -1){
            return null;
        }
        HTpair pair = list.get(indexOfLL);
        return pair.value;
    }

    //creating remove function
    public V remove(K key){
        int indexOfArray = hashFunction(key);
        GenericLinkedList<HTpair> list = this.bucketArray[indexOfArray];
        if(list == null){
            return null;
        }
        HTpair pairToFind = new HTpair(key, null);
        int indexOfLL = list.find(pairToFind);
        if(indexOfLL == -1){
            return null;
        }
        HTpair pair = list.get(indexOfLL);
        list.delete(indexOfLL);
        this.size--;
        return pair.value;
    }

    // creating rehash function (only called when the load factor becomes greater than 0.75)
    private void rehash(){
        GenericLinkedList<HTpair>[] oldArray = this.bucketArray;
        this.bucketArray = (GenericLinkedList<HTpair>[]) new GenericLinkedList[2*oldArray.length] ;
        this.size = 0;
        for (GenericLinkedList<HTpair> list : oldArray){
            while(list != null && !list.isEmpty()){
                HTpair pair = list.deleteFirst();
                this.put(pair.key, pair.value);
            }
        }
    }
}
