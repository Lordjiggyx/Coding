package Example2;



public class TestDoublyLinkedList {

    public static void main(String a[]){
        
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
        dll.insertHead(10);
        dll.insertHead(34);
        dll.insertTail(56);
        dll.insertTail(364);
        dll.iterateForward();
        dll.insert(-1, 25);
        dll.iterateForward();
        dll.remove(4);
        dll.iterateForward();
    }
    
}
