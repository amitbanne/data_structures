package linked_list;

public class LinkedList {
	// keeps track of the head of the linked list
	private Node head;

	/* push() method adds elements to the top of the linked list
	 * i.e. the newly added element becomes head of the linked list*/
	public void push(int data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	
	/* insertAfter() method inserts the new node after the specified Node */
	public void insertAfter(Node prevNode, int data) {

		if (prevNode == null) {
			System.out
					.println("Invalid previous node data. Skipping the process..");
		} else {
			Node newNode = new Node(data);
			if (prevNode.next == null) {
				prevNode.next = newNode;
				newNode.next = null;
			} else {
				newNode.next = prevNode.next;
				prevNode.next = newNode;
			}
		}
	}

	/* insertAtPosition() method inserts the new node at the specified position.
	 * If specified position is 2, the new node is added in such a way that 
	 * it will be the second node in the list*/
	public void insertAtPosition(int pos, int data) {
		Node newNode = new Node(data);

		if (pos == 1 || head == null) {
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = head;
			for (int i = 1; (i < (pos - 1)) && (temp != null); i++) {
				temp = temp.next;
			}
			if (temp != null) {
				newNode.next = temp.next;
				temp.next = newNode;
			} else {
				System.out.println("Cannot insert Node at position: " + pos);
			}
		}
	}

	/* deleteAtPosition() method deletes the node specified by its position*/
	public void deleteAtPosition(int pos) {

		if (pos == 1) {
			head = head.next;
		} else {
			Node temp = head;
			for (int i = 1; i < (pos - 1) && temp != null; i++) {
				temp = temp.next;
			}
			if (temp != null && temp.next != null) {
				temp.next = temp.next.next;
			} else {
				System.out.println("Invalid delete position..");
			}
		}
	}

	/* findLength() method finds the number of elements in the linked list.
	 * The length is calculated through iterative method*/
	public void findLength() {
		if (head == null) {
			System.out.println("Length: 0");
		} else {
			Node temp = head;
			int i = 1;
			for (; temp.next != null; i++) {
				temp = temp.next;
			}
			System.out.println("Length: " + i);
		}
	}

	/* findLengthByRecursion() method finds the number of elements in the 
	 * linked list through recursion */
	public int findLengthByRecursion(Node head) {
		if (head == null)
			return 0;
		else
			return 1 + findLengthByRecursion(head.next);
	}

	
	/* swapNodes() method swaps the positions of the specified nodes*/
	public void swapNodes(int data1, int data2) {
		System.out.println("Swapping nodes "+ data1+" and "+data2);
		
		if (head == null) {
			System.out.println("No nodes present");
		} else if (head.next == null)
			System.out.println("Only one node present.Cannot swap");
		else {
			Node firstSwap = null, secondSwap = null;
			Node temp;
			boolean firstDataFound, secondDataFound;
			if (head.data == data1) {
				firstSwap = head;
				firstDataFound = true;
				System.out.println("Found " + data1);
			} else {
				temp = head;
				
				while(temp != null && temp.next!=null && temp.next.data != data1)
					temp = temp.next;					

				if (temp != null && temp.next != null
						&& temp.next.data == data1) {
					firstSwap = temp;
					firstDataFound = true;
					System.out.println("Found " + data1);
				} else {
					System.out.println(data1
							+ " not found. Skipping the process");
					return;
				}

			}

			if (head.data == data2) {
				secondSwap = head;
				secondDataFound = true;
				System.out.println("Found " + data2);
			} else {
				temp = head;
				while(temp != null && temp.next!=null && temp.next.data != data2)
					temp = temp.next;

				if (temp != null && temp.next != null
						&& temp.next.data == data2) {
					secondSwap = temp;
					secondDataFound = true;
					System.out.println("Found " + data2);
				} else {
					System.out.println(data2
							+ " not found. Skipping the process");
					return;
				}

			}

			if (firstSwap == head  && head.data == data1) {
				Node temp1 = firstSwap;
				Node temp2 = secondSwap.next;

				Node nextTemp1 = temp1.next;
				Node nextTemp2 = temp2.next;

				firstSwap = temp2;
				firstSwap.next = nextTemp1;

				secondSwap.next = temp1;
				secondSwap.next.next = nextTemp2;

				head = firstSwap;

			} else if (secondSwap == head && head.data == data2) {
				Node temp1 = firstSwap.next;
				Node temp2 = secondSwap;

				Node nextTemp1 = temp1.next;
				Node nextTemp2 = temp2.next;

				firstSwap.next = temp2;
				firstSwap.next.next = nextTemp1;

				secondSwap = temp1;
				secondSwap.next = nextTemp2;

				head = secondSwap;
			} else {

				Node temp1 = firstSwap.next;
				Node temp2 = secondSwap.next;

				Node nextTemp1 = temp1.next;
				Node nextTemp2 = temp2.next;

				firstSwap.next = temp2;
				firstSwap.next.next = nextTemp1;

				secondSwap.next = temp1;
				secondSwap.next.next = nextTemp2;

			}
		}

	}
	
	/* reverseList() method reverses the order of elements
	 * in the linked list*/
	public void reverseList(){
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev =current;
			current = next;
		}
		head = prev;
	}

	
	/* mergeSortedLists() merges the two sorted lists*/
	public LinkedList mergeSortedLists(LinkedList list1, LinkedList list2){
		
		LinkedList mergedList = new LinkedList();
		Node temp1 = list1.head;
		Node temp2 = list2.head;
		
		while(temp1!=null && temp2!=null){
			
			if(temp1.data <=  temp2.data){
				mergedList.push(temp1.data);
				temp1 = temp1.next;
			}else{
				mergedList.push(temp2.data);
				temp2 = temp2.next;
			}
		}
		
		while(temp1!=null){
			mergedList.push(temp1.data);
			temp1 = temp1.next;
		}
		
		while(temp2!=null){
			mergedList.push(temp2.data);
			temp2 = temp2.next;
		}
		
		
		return mergedList;
	}
	
	/* printList() method prints the data of the elements in the linked list*/
	public void printList() {
		Node temp = head;
		if (temp == null) {
			System.out.println("No elements present");
		} else {
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
		System.out.println();

	}

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.printList();
		list.findLength();
		System.out.println("Length By Recursion: "
				+ list.findLengthByRecursion(list.head));
		list.push(5);
		list.findLength();
		System.out.println("Length By Recursion: "
				+ list.findLengthByRecursion(list.head));
		list.push(15);
		list.push(35);
		list.printList();

		System.out.println("Insert 7 at pos 1:");
		list.insertAtPosition(1, 7);
		list.printList();

		System.out.println("Insert 6 at position 3:");
		list.insertAtPosition(3, 6);
		list.printList();

		System.out.println("Insert 12 at position 2:");
		list.insertAtPosition(2, 12);
		list.printList();

		System.out.println("Insert 17 at position 7:");
		list.insertAtPosition(7, 17);
		list.printList();

		System.out.println("Insert 23 at position 10:");
		list.insertAtPosition(10, 23);
		list.printList();

		System.out.println("Delete position 1:");
		list.deleteAtPosition(1);
		list.printList();

		System.out.println("Delete position 3:");
		list.deleteAtPosition(3);
		list.printList();

		System.out.println("Delete position 8:");
		list.deleteAtPosition(8);
		list.printList();

		list.findLength();

		System.out.println("Length By Recursion: "
				+ list.findLengthByRecursion(list.head));
		
		list.printList();
		list.swapNodes(15, 17);
		list.printList();

		list.swapNodes(12, 17);
		list.printList();

		list.swapNodes(35, 5);
		list.printList();
		
		list.reverseList();
		list.printList();
		
		/* merging sorted lists*/
		LinkedList list1 = new LinkedList();
		list1.push(25);
		list1.push(15);
		list1.push(5);
		
		LinkedList list2 = new LinkedList();
		list2.push(23);
		list2.push(14);
		list2.push(8);
		
		LinkedList merged = list.mergeSortedLists(list1, list2);
		
		System.out.println("Merging two lists");
		System.out.println("\n \n");
		list1.printList();
		list2.printList();
		merged.reverseList();
		merged.printList();
		
		
	}

}
