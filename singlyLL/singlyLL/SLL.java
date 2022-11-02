package singlyLL;

public class SLL {

	// member of the singly linked list
	Node head;

	// constructor to create a new singly linked list
	public SLL(Node head) {
		this.head = head;
	}

	void addToEnd(String data) {
		Node n = new Node(data);

		if (head == null) {
			head = n;
		} else {
			Node current = head;
			while (current.next != null) {// end of the list
				current = current.next;
			}
			current.next = n;
		}
	}

	void addToStart(String data) {
		Node n = new Node(data);

		if (head != null) {
			n.next = head;
			head = n;
		}
	}

	void addAfterNode(String insertAfter, String data) {
		Node current = head;

		while (current != null) {
			if (current.data == insertAfter) {
				Node n = new Node(data);
				n.next = current.next;
				current.next = n;
				break;
			}
			current = current.next;
		}
	}

	Node deleteLast() {
		Node current = head;
		if (current == null || current.next == null) {
			head = null;
			return current;
		}
		Node nextNode = current.next;
		while (current.next != null) {
			if (nextNode.next == null) {
				current.next = null;
			}
			current = nextNode;
			nextNode = nextNode.next;
		}
		return current;
	}

	Node deleteFirst() {
		if (head != null) {
			Node toDelete = head;
			head = head.next;
			return toDelete;
		}
		return null;
	}

	Node deleteAfter(String deleteAfter) {
		Node current = head;
		Node nodeToDelete = null;
		while(current != null) {
			if(current.data == deleteAfter && current.next != null) {
				nodeToDelete = current.next;
				current.next = nodeToDelete.next;
				break;
			}
		current = current.next;
		}
		return nodeToDelete;
	}

	void printList() {
		Node current = head;
		StringBuilder sb = new StringBuilder();
		
		while(current != null) {
			sb.append(current.data + "\n");
			current = current.next;
		}
		System.out.println(sb.toString());
	}
	
	public String toString(Node t) {
		return t.getData();
	}
	
	static class Node {

		// Members of the node
		String data;
		Node next;

		// constructor to create new node
		Node(String data) {
			this.data = data;
			next = null;
		}

		
		public String getData() {
			return data;
		}


		public void setData(String data) {
			this.data = data;
		}


		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	
	}

	public static void main(String[] args) {

		
		SLL list = new SLL(new Node("Juanito"));
		
		list.addToStart("Rafa");
		list.addToEnd("Hugo");
		list.addToEnd("Paco");
		list.addToEnd("Luis");
		list.addAfterNode("Rafa", "Daisy");
		list.deleteAfter("Paco");
		list.printList();
	}

}
