package sllstack;

import static java.lang.System.exit;

public class SllStack {

	public static void main(String[] args) {
		StackUsingLL stack = new StackUsingLL();
		
		stack.addNode("Munima");
		stack.addNode("Rafael");
		stack.addNode("Colin");
		stack.addNode("Pasha");
		stack.addNode("Anmol");
		
		stack.printStack();
		
		System.out.printf("\nThe top of the stack is: %s ", stack.peek());
		
		System.out.println("\nPrint before pop");
		stack.printStack();
		stack.pop();
		System.out.println("\nPrint after pop");
		stack.printStack();
		stack.pop();
		System.out.println("\nPrint after pop");
		stack.printStack();

		System.out.printf("\nThe top of the stack is: %s ", stack.peek());
	}

}

class StackUsingLL {
	private class Node {
		String data;
		Node link;
	}

	Node top;

	public StackUsingLL() {
		this.top = null;
	}

	public void addNode(String s) {
		Node temp = new Node();

		if (temp == null) {
			System.out.print("Stack overflow");
			return;
		}

		temp.data = s;

		temp.link = top;

		top = temp;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public String peek() {
		if (!isEmpty()) {
			return top.data;
		} else {
			return "This stack is empty";
		}
	}

	public void pop() {
		if(top == null) {
			System.out.println("Stack is empty");
			return;
		}
		
		top = (top).link;
	}
	
	public void printStack() {
		if( top == null) {
			System.out.println("Stack is empty");
			exit(1);
		} else {
		Node temp = top;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
		
	}
}
}
