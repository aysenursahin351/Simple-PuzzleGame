
public class Node {
	private String data;
	private Node next;
	private int number;

	public int getNumber() {
		return number;
	}

	public Node() {
		super();
	}

	public void setNumber(int number, String data) {
		this.number = number;
		this.data = data;
	}

	public Node(int number, Node next, Node prev) {
		this.number = number;
		this.next = next;
		this.prev = prev;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	private Node prev;

	Node(String d) {
		data = d;
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
