package dll;


public class Dllq<T> {
	DLNode<T> head;
	DLNode<T> tail;

	class DLNode<T> {

		String data;
		DLNode<T> next;
		DLNode<T> prev;

		public DLNode(String data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}

	void enqueueAtHead(String s) {
		// Create new node and add data
		DLNode<T> nodeToAdd = new DLNode<>(s);

		// Make next of new node head, and tail null
		nodeToAdd.next = head;
		nodeToAdd.prev = null;

		// Update prev of head to new node
		if (head != null) {
			head.prev = nodeToAdd;
		}

		// Move head pointer to new node
		head = nodeToAdd;
	}

	void enqueueBefore(DLNode<T> nextNode, String data) {

		// Create the new node
		DLNode<T> newNode = new DLNode<>(data);

		// Connecting prev of new node to prev of next node
		newNode.prev = nextNode.prev;

		// Connecting prev of next node to new node
		nextNode.prev = newNode;

		// Connecting next of new node to next node
		newNode.next = nextNode;

		// Confirm if new node is added at the head
		if (newNode.prev != null) {
			newNode.prev.next = newNode;
		} else {
			head = newNode;
		}
	}

	void enqueueAfter(DLNode<T> prevNode, String data) {

		// Create new node to add
		DLNode<T> newNode = new DLNode<>(data);

		// Connect the next of new node as next of prev node
		newNode.next = prevNode.next;

		// Connect next of prev node as new node
		prevNode.next = newNode;

		// Connect prev of new node as prev node
		newNode.prev = prevNode;

		// Change prev of new node next
		if (newNode.next != null) {
			newNode.next.prev = newNode;
		}
	}

	void enqueueAtTail(String data) {

		// Create new node to append
		DLNode<T> newNode = new DLNode<>(data);

		// Temporary node to transfer the tail
		DLNode<T> lastNode = head;

		// New node will be the tail, so next is made null
		newNode.next = null;

		// If the queue is empty, the new node will be the head
		if (head == null) {
			newNode.prev = null;
			head = newNode;
			return;
		}

		// Otherwise, traverse all the nodes till the tail
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}

		// Connect next of last node to new node
		lastNode.next = newNode;

		// Connect last node as previous of the new node
		newNode.prev = lastNode;
	}

	void printQueue() {

		DLNode<T> node = head;
		StringBuilder sb = new StringBuilder();

		while (node != null) {
			sb.append(node.data + "\n");
			node = node.next;
		}
		System.out.println(sb.toString());

	}

	public static void main(String[] args) {

		Dllq<String> queue = new Dllq<>();

		queue.enqueueAtHead("Rafael");
		queue.enqueueAtHead("Munima");
		queue.enqueueAtHead("Colin");
		queue.enqueueAtTail("Pasha");

		queue.printQueue();
		
		queue.enqueueAfter(queue.head, "Jason");

		queue.printQueue();
		
		queue.enqueueBefore(queue.head, "Anmol");
	
		queue.printQueue();

	}
}
