package Heap.Code;

public class CustomHeapMain {
    public static void main(String[] args) {
        CustomMinHeap heap = new CustomMinHeap();
        heap.add(10);
        heap.add(5);
        heap.add(8);
        heap.add(9);
        heap.add(1);

        heap.display();

        heap.remove();
        heap.display();

        System.out.println(heap.get());
    }
}
