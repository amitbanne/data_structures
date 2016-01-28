package stack;

public class Stack {

	// keeps track of the top element of the stack
	private StackNode top;
	
	
	/* push() adds a new element to the stack and
	 * the new element becomes the top of the stack */
	public void push(int data){
		StackNode newNode =  new StackNode(data);
		
		if(top==null)
			top = newNode;
		else{
			newNode.next =  top;
			top = newNode;
		}
		
		System.out.println(data+" pushed into stack..");
	}
	
	/* pop() removes the element at the top of the stack */
	public int pop(){
		
		if(top == null){
			System.out.println("No elements present in stack");
			return -1;
		}
		
		StackNode popped = top;
		top = top.next;
		return popped.data;
	}
	
	
	/* peek() returns the data of the top
	 * element of the stack */
	public int peek(){
		if(top == null){
			System.out.println("No elements present");
			return -1;		
		}else{
			return top.data;
		}
			
	}
	
	/* isStackEmpty() determines if the stack is empty.
	 * If top of the stack points to null, then stack is empty.
	 * Otherwise, stack is not empty. */
	public boolean isStackEmpty(){
		return (top == null);
	}
	
	/* printStack() prints the data of all
	 * elements of the stack */
	public void printStack(){
		StackNode temp = top;
		if(top==null){
			System.out.println("No elements present");
			return;
		}
		System.out.println("\nElements present in stack:");
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack stack = new Stack();
		stack.push(5);
		stack.push(17);
		stack.push(30);
		
		stack.printStack();
		System.out.println("Top of the stack: "+stack.peek());
		
		System.out.println(stack.pop()+" popped from stack");
		stack.printStack();
		
	}

}
