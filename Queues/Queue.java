package queues;

/** Queue is implemented using a stack.
 * 
 * enQueue is adding a new member to the 
 * front of the queue
 * 
 * deQueue is removing the last element
 * from the queue i.e. element that was
 * added last to the queue
 * */

public class Queue {
	// keeps track of the elements in the queue
	Node stack;
	
	/* push() adds a new element to the underlying
	 * stack of the queue implementation */
	public void push(int data){
		Node newNode = new Node(data);
		if(stack == null){
			stack = newNode;
		}else{
			newNode.next = stack;
			stack = newNode;
		}
		
	}
	
	/* pop() removes the top element of the underlying
	 * stack of the queue implementation */
	public int pop(){
		
		int data = stack.data;
		stack = stack.next;
		return data;
	}
	
	
	/* enQueue() adds a new member to the queue.
	 * The new member is added to the front of the
	 * queue.
	 * 
	 * Internally, the new element is pushed to the
	 * underlying stack*/
	public void enQueue(int data){
		push(data);
	}
	
	
	/* deQueue() removes the last member of the queue.
	 * The last member is removed from the rear of the
	 * queue.
	 * 
	 * Internally, the last element is popped from the
	 * underlying stack through recursion and all
	 * the previous elements except the last are
	 * pushed to the queue in the same order */
	public int deQueue(Node head){
		
		int res;
		if(head.next == null){
			return pop();
		}else{
			int data = pop();
			res = deQueue(stack);
			push(data);
		}
		return res;
		
	}
	
	/* printQueue() prints data of all the elements
	 * in the queue. */
	public void printQueue(){
		
		if(stack ==null){
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Elements of queue");
		Node temp = stack; 
		
		while(temp.next != null){
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
		System.out.print(temp.data+" ");
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue queue = new Queue();
		queue.printQueue();
		queue.enQueue(5);
		queue.enQueue(9);
		queue.enQueue(14);
		
		queue.printQueue();
		
		int last = queue.deQueue(queue.stack);
		System.out.println("Dequeued Element: "+last);
		queue.printQueue();
		
	}

}
