package stack;

public class ReverseStack {
	// keeps track of the top element of the stack
	StackNode top;

	/* push() adds a new element to the stack and
	 * the new element becomes the top of the stack */
	public void push(int data) {
		StackNode newNode = new StackNode(data);

		if (top == null)
			top = newNode;
		else {
			newNode.next = top;
			top = newNode;
		}

		System.out.println(data + " pushed into stack..");
	}

	/* pop() removes the element at the top of the stack */
	public int pop() {

		if (top == null) {
			System.out.println("No elements present in stack");
			return -1;
		}

		StackNode popped = top;
		top = top.next;
		return popped.data;
	}

	/* peek() returns the data of the top
	 * element of the stack */
	public int peek() {
		if (top == null) {
			System.out.println("No elements present");
			return -1;
		} else {
			return top.data;
		}

	}

	/* printStack() prints the data of all
	 * elements of the stack */
	public void printStack() {
		StackNode temp = top;
		if (top == null) {
			System.out.println("No elements present");
			return;
		}
		System.out.println("Elements present in stack:");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();

	}

	/* sortElements() sorts all the elements in the stack */
	public void sortElements(StackNode t) {

		if (this.top.next != null) {
			StackNode temp = new StackNode(pop());
			sortElements(this.top);
			insertSortedElements(temp);
		} else
			return;

	}

	/* insertSortedElements() inserts an element in the sorted stack
	 * The new element will be inserted in its appropriate position
	 * by popping the elements that are less than given element, 
	 * insert the new element and the insert all the 
	 * popped elements */
	public void insertSortedElements(StackNode n) {

		if (top == null){
			push(n.data);
			return;
		}
		else if (peek() <= n.data) {
			StackNode t = new StackNode(pop());
			insertSortedElements(n);
			if(top == null)
				push(n.data);
			push(t.data);

		} else {
			push(n.data);
		}
	}

	/* insertAtBottom() inserts an element 
	 * at the bottom of the stack  */
	public void insertAtBottom(StackNode n) {

		StackNode temp = top;
		while (temp.next != null)
			temp = temp.next;

		n.next = null;
		temp.next = n;

	}

	/* reverseStack() reverses the order of elements in the stack  */
	public void reverseStack(StackNode t) {

		if (this.top.next != null) {
			StackNode temp = new StackNode(pop());
			reverseStack(this.top);
			insertAtBottom(temp);
		} else
			return;

	}

	public static void main(String[] args) {

		ReverseStack rs = new ReverseStack();
		rs.push(4);
		rs.push(3);
		rs.push(2);
		rs.push(1);

		rs.printStack();
		System.out.println("Reversing elements");
		rs.reverseStack(rs.top);
		rs.printStack();

		// sort elements of stack
		System.out.println("********************************************");
		System.out.println("Sorting elements of stack:");

		ReverseStack rs2 = new ReverseStack();
		rs2.push(5);
		rs2.push(9);
		rs2.push(3);
		rs2.push(1);

		rs2.printStack();
		rs2.sortElements(rs2.top);
		System.out.println("Sorted :");
		rs2.printStack();
	}

}
