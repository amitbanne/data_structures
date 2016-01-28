package circular_linkedlist;

public class CircularLinkedList {

	/* keeps track of the last inserted node. 
	 * The head node of the circular linked list 
	 * is always the next node of the last inserted node */
		private Node last;

	/* push() method adds node to the beginning of the list */	
	public void push(int data){
		Node newNode = new Node(data);
		// when there are no nodes in the list
		if(last == null){
			last = newNode;
			return;
		}
		// when there is only one node in the list
		if(last.next == null){
			last.next = newNode;
			newNode.next = last;
		}else{
		// when there are more than one node in the list	
			newNode.next = last.next;
			last.next = newNode;
		}
			last = newNode;
			
		}

	/* sortedInsert() method maintains the list in 
	 * the ascending sorted order.
	 * Whenever a new node is to be inserted,
	 * it will be inserted at its appropriate position */
	public void sortedInsert(int data){
		if(last == null)
			push(data);
		else if(last.next == null){
			Node newNode = new Node(data);
			if(data > last.data){
				newNode.next = last;
				last.next = newNode;
				last = newNode;
			}else{
				newNode.next = last;
				last.next = newNode;
			}

			return;
		}
		Node temp =  last.next;
		Node newNode = new Node(data);

		do{
			if(data < last.next.data){
				newNode.next = last.next;
				last.next = newNode;
				System.out.println(1);
				return;
			}else{
				if(data>temp.data && data <= temp.next.data){
					newNode.next = temp.next;
					temp.next = newNode;
					System.out.println(2);
					return;
				}else if(data > last.data){
					newNode.next = last.next;
					last.next = newNode;
					last = newNode;
					System.out.println(3);
					return;
				}else{
					temp = temp.next;
				}
			}
		}while(temp!=last);

	}

	/* printList() method prints the data of 
	 * all the nodes in the list */
	public void printList(){
		Node temp = last.next;
		
		do{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}while(temp!=last);
		System.out.print(temp.data+" ");
		

		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CircularLinkedList cList = new CircularLinkedList();

		
		cList.push(5);
		cList.push(8);
		cList.push(12);
		cList.push(14);
		
		

		cList.printList();

		System.out.println("Inserting 7");
		cList.sortedInsert(7);
		cList.printList();
		
		System.out.println("Inserting 15");
		cList.sortedInsert(15);
		cList.printList();
		
		System.out.println("Inserting 3");
		cList.sortedInsert(3);
		cList.printList();
		
		System.out.println("Inserting 8");
		cList.sortedInsert(8);
		cList.printList();

	}

}
