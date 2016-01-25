package linked_list;

public class ReverseAlternateNode {

	// keeps track of the head of the linked list
	Node head;

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

	
	/* reverseAlternate() method shifts the even index nodes to the end of the list.
	 * If input is 1->2->3->4->5->Null,
	 * output will be 1->3->5->2->4->Null */
	public void reverseAlternate() {
		Node temp = head;
		Node prev = null;
		Node cur = null;
		while (temp != null) {

			if (temp.next == null) {
				temp.next = prev;
				break;
			} else if (temp.next.next == null) {

				if (cur != null) {
					cur.next = temp.next;
					temp.next = prev;
					break;
				}

			} else {
				if (prev == null) {
					prev = temp.next;
					temp.next = prev.next;
					prev.next = null;
					//
					cur = prev;
				} else {
					Node x = temp.next;
					temp.next = x.next;
					cur.next = x;
					cur = cur.next;
					cur.next = null;
				}
				temp = temp.next;
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseAlternateNode list = new ReverseAlternateNode();
		 list.push(6);
		 list.push(5);
		 list.push(4);
		 list.push(3);
		 list.push(2);
		 list.push(1);

		list.printList();
		list.reverseAlternate();
		list.printList();

	}

}
