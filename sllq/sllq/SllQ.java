package sllq;

class QNode<T> {
	String data;
	QNode<T> next;

	public QNode(String data) {
		this.data = data;
		next = null;
	}
}

public class SllQ<T> {

	int size;
	QNode<T> front;
	QNode<T> rear;

	public SllQ() {
		front = null;
		rear = null;
		
	}

	// Method to add a new node to the single linked queue
	void enqueue(String data) {
		// Create the new node to add
		QNode<T> temp = new QNode<T>(data);

		// Confirm the queue single linked is empty, new node is front and rear
		if (rear == null) {
			front = temp;
			rear = temp;
			size++;
			return;
		}

		// If single linked queue is not empty, add new node at the end. amd change rear
		rear.next = temp;
		rear = temp;
		size++;
	}

	// Method to remove node from single linked queue
	QNode<T> dequeue() {
		if(front == null ) {
			return null;
		}
		
		//Store current front and transfer front one node ahead
		QNode<T> temp = front;
		front = front.next;
		size--;
		
		//If front becomes null, change rear to null (emptying queue)
		if(front == null) {
			rear = null;
		}
		return temp;
	}
	
	public static void main(String[] args) {
		
		SllQ<String> queue = new SllQ<>();
		
		queue.enqueue("Rafa");
		queue.enqueue("Jason");
		queue.enqueue("Colin");
		queue.enqueue("Pasha");
		queue.enqueue("Nathan");
		
		System.out.println("I am front " + queue.front.data + " My size is " + queue.size);
		System.out.println("I am rear " + queue.rear.data );
		queue.dequeue();
		System.out.println("I am front " + queue.front.data + " My size is " + queue.size);
		queue.dequeue();
		System.out.println("I am front " + queue.front.data + " My size is " + queue.size);
		queue.dequeue();
		System.out.println("I am front " + queue.front.data + " My size is " + queue.size);
		queue.dequeue();
		System.out.println("I am front " + queue.front.data + " My size is " + queue.size);
	}
	
	
}
