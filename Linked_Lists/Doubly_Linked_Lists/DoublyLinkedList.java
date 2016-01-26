package doublylinkedlist;

public class DoublyLinkedList {
	// refers head node of the doubly linked list
	private Node head;
	
	/* push() method adds node to the beginning of the list */
	public void push(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			return;
		}
		
		head.prev = newNode;
		newNode.next = head;
		head = newNode;
	}
	
	/* insertAfterNode() adds the new node after the specified node */
	public void insertAfterNode(Node prevNode, int data){
		if(prevNode == null){
			System.out.println("Invalid previous node information");
			return;
		}
		
		Node newNode = new Node(data);
		newNode.next = prevNode.next;
		newNode.prev = prevNode;
		prevNode.next = newNode;
		
	}
	
	/* insertBeforeNode() adds the new node before the specified node */
	public void insertBeforeNode(Node nextNode, int data){
		if(nextNode == null){
			System.out.println("Invalid previous node information");
			return;
		}
		
		Node newNode = new Node(data);
		newNode.prev = nextNode.prev;
		newNode.next = nextNode;
		
		if(nextNode == head)
			head = newNode;
		
		nextNode.prev = newNode;
		
		
	}
	
	/* insertNodeAtEnd() method adds the new node to the tail of the 
	 * doubly linked list.
	 * 
	 * The new node becomes the tail of the list */
	public void insertNodeAtEnd(int data){
		Node newNode = new Node(data);;
		if(head==null){
			head = newNode;
			return;
		}
		
		Node temp =head;
		while(temp.next!=null){
			temp =temp.next;
		}
		
		temp.next = newNode;
		newNode.prev = temp;		
	}
	
	/* deleteHeadNode() deletes the head node of the doubly linked list.
	 * Accordingly, head of the list is updated */
	public void deleteHeadNode(){
		head = head.next;
		if(head != null)
			head.prev = null;
	}
	
	/* deleteTailNode() deletes the tail of the doubly linked list*/
	public void deleteTailNode(){
		Node temp = head;
		if(head == null){
			System.out.println("No nodes present");
			return;
		}
		while(temp.next.next!= null){
			temp =temp.next;
		}
		temp.next = null;
	}
	
	/* deleteNode() deletes the specified node*/
	public void deleteNode(int data){
		Node temp = head;
		
		while(temp!=null && temp.data != data){
			temp = temp.next;
		}
		
		if(temp == null){
			System.out.println(data+" not present");
			return;
		}
		
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
			
	}
	
	
	/* reverseList() method reverses the order of entire doubly linked list */
	public void reverseList(){
		Node temp = head;
		
		while(temp.next != null){
			Node t = temp.next;
			temp.next = temp.prev;
			temp.prev =t;
			temp = t;
		}
		
		temp.next = temp.prev;
		temp.prev = null;
		head = temp;
	}
	
	/* swapNodes() method swaps the positions of the two
	 * specified nodes */
	public void swapNodes(int data1, int data2){
		Node temp = head;
		Node firstNode = null, secondNode = null;
		while(temp!=null && temp.data != data1){
			temp = temp.next;
		}
		if(temp ==null){
			System.out.println(data1 +" not found. Skipping...");
			return;
		}else{
			firstNode = temp;
		}
		
		temp = head;
		while(temp!=null && temp.data != data2){
			temp = temp.next;
		}
		if(temp ==null){
			System.out.println(data2 +" not found. Skipping...");
			return;
		}else{
			secondNode = temp;
		}
	
		temp = new Node(secondNode.data);
		temp.next = secondNode.next;
		temp.prev = secondNode.prev;
		
		if(firstNode == head){
			
			secondNode.prev = firstNode.prev;
			secondNode.next = firstNode.next;
			
			firstNode.next.prev = secondNode;
			head = secondNode;
			
			firstNode.next = temp.next;
			firstNode.prev = temp.prev;
			temp.prev.next = firstNode;
			
			if(temp.next != null)
				temp.next.prev = firstNode;
			
		}else if(secondNode == head){
			
			secondNode.prev = firstNode.prev;
			secondNode.next = firstNode.next;
			
			firstNode.prev.next = secondNode;
			if(firstNode.next !=null)
				firstNode.next.prev = secondNode;
			
			firstNode.next = temp.next;
			firstNode.prev = temp.prev;
			temp.next.prev = firstNode;
			head = firstNode;		
		}else{
			secondNode.prev = firstNode.prev;
			secondNode.next = firstNode.next;
			
			firstNode.prev.next = secondNode;
			if(firstNode.next !=null)
				firstNode.next.prev = secondNode;
			
			firstNode.next = temp.next;
			firstNode.prev = temp.prev;
			
			temp.prev.next = firstNode;			
			if(temp.next != null)
				temp.next.prev = firstNode;
		}
		
	}
	
	/* findLengthOfList() method computes the count of nodes in the
	 * doubly linked list through iterative procedure */
	public int findLengthOfList(){
		
		int length = 0;
		
		Node temp = head;
		
		while(temp!= null){
			length++;
			temp = temp.next;
		}
		
		return length;
		
	}
	
	/* findLengthOfListByRecursion() method computes the count 
	 * of nodes in the doubly linked list through recursion */
	public int findLengthOfListByRecursion(Node t){
		
		if(t==null)
			return 0;
		else
			return 1+ findLengthOfListByRecursion(t.next);
	}
	
	
	/* printList() method prints the data of nodes of the list*/
	public void printList(){
		
		Node temp=head;
		while(temp != null){
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
		System.out.println("\n");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedList dlist = new DoublyLinkedList();
		
		System.out.println("Pushing data:");
		dlist.push(5);
		dlist.push(12);
		dlist.push(17);
		
		dlist.printList();
		
		System.out.println("Inserting 24 at end:");
		dlist.insertNodeAtEnd(24);
		dlist.printList();
		
		dlist.push(21);
		dlist.push(27);
		dlist.printList();
		System.out.println("Deleting head node");
		dlist.deleteHeadNode();
		dlist.printList();
		
		System.out.println("Deleting tail node");
		dlist.deleteTailNode();
		dlist.printList();
		
		System.out.println("Deleting 13");
		dlist.deleteNode(13);
		dlist.printList();
		
		System.out.println("Deleting 12");
		dlist.deleteNode(12);
		dlist.printList();
		

		dlist.push(13);
		dlist.push(9);
		dlist.push(4);
		dlist.printList();
		System.out.println("Reversing list");
		dlist.reverseList();
		dlist.printList();
		
		System.out.println("Swapping 17 and 9");
		dlist.swapNodes(17,9);
		dlist.printList();
		
		System.out.println("Swapping 5 and 13");
		dlist.swapNodes(5,13);
		dlist.printList();
		
		System.out.println("Swapping 5 and 13");
		dlist.swapNodes(5,13);
		dlist.printList();
		
		System.out.println("Length of list: ");
		System.out.println("Iterative method: "+ dlist.findLengthOfList());
		System.out.println("Recursive method: "+ dlist.findLengthOfListByRecursion(dlist.head));
	}

}
