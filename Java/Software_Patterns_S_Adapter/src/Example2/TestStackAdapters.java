package Example2;

public class TestStackAdapters {

    public static void main(String a[]){
        
    	//TEST BOTH CLASSES
        MyStack<Integer> stack = new DLLStackClassAdapter<Integer>();
        stack.push(10);
        stack.push(34);
        stack.push(56);
        stack.push(364);
        stack.displayContents();
        stack.pop();
        stack.displayContents();
        stack.push(28);
        stack.displayContents();
        stack.top();
        stack.displayContents();
        
        stack = new DLLStackObjectAdapter<Integer>();
        stack.push(10);
        stack.push(34);
        stack.push(56);
        stack.push(364);
        stack.displayContents();
        stack.pop();
        stack.displayContents();
        stack.push(28);
        stack.displayContents();
        stack.top();
        stack.displayContents();
        
    }

}
