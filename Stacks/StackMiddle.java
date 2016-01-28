package stack;

public class StackMiddle {

	// keeps track of top of the stack
	private DoublyStackNode top;
	// keeps track of middle element of the stack
	private DoublyStackNode middle;
	// keeps track number of elements in the stack
	private int count;
	
	/* push() adds a new element to the stack and
	 * the new element becomes the top of the stack */
	public void push(int data){
		DoublyStackNode newNode =  new DoublyStackNode(data);
		
		if(top==null){
			top = newNode;
			count = 1;
			middle = newNode;
		}
		else{
			newNode.next =  top;
			top.prev = newNode;
			top = newNode;
			count++;
			if(count%2 != 0)
				middle = middle.prev;
			
		}
		
	}
	
	/* findMiddle() returns data of the middle 
	 * element of the stack */
	public void findMiddle(){
		if(top!=null)
		System.out.println("Middle: "+middle.data);
	}
	
	/* pop() removes the element at the top of the stack */
	public int pop(){
		
		if(top == null){
			System.out.println("No elements present in stack");
			return -1;
		}
		
		DoublyStackNode popped = top;
		top = top.next;
		count--;
		
		if(top != null)
		top.prev = null; 
		
		if(count%2  == 0)
			middle = middle.next;
		
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
	
	/* printStack() prints the data of all
	 * elements of the stack */
	public void printStack(){
		DoublyStackNode temp = top;
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
	
	/* isStackEmpty() determines if the stack is empty.
	 * If top of the stack points to null, then stack is empty.
	 * Otherwise, stack is not empty. */
	public boolean isStackEmpty(){
		return (top == null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackMiddle sm = new StackMiddle();
		sm.push(1);
		sm.push(2);
		sm.push(3);
		
		sm.printStack();
		sm.findMiddle();
		
		sm.push(4);
		sm.printStack();
		sm.findMiddle();
		
		sm.push(5);
		sm.printStack();
		sm.findMiddle();
		
		sm.pop();
		sm.printStack();
		sm.findMiddle();
		
		sm.push(6);
		sm.printStack();
		sm.findMiddle();
		
		sm.pop();
		sm.printStack();
		sm.findMiddle();
	}

}
