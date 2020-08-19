package queues;

public class Queue<E> {
	
	private static class Node<F> {
		// data fields
		private F data;
		private Node<F> next;
		
		// Constructors
		
		public Node(F data, Node<F> next) {
			super();
			this.data = data;
			this.next = next;
		}
		public Node(F data) {
			super();
			this.data = data;
			this.next = null;
		}
		
		
		
	}
	// date fields
	private Node<E> front;
	private Node<E> rear;
	private int size;
	
	// Constructor
	public Queue() {
		front=null;
		rear=null;
		size=0;
	}
	
	// Methods
	
	/**
	 * Adds a new element to the rear of the queue
	 * @param item to be added
	 * @return item that was added
	 */
	public E offer(E item) {
		Node<E> ans = new Node<E>(item);
		if(size == 0) {
			front = ans;
			rear = front;
		}
		else {
			rear.next = ans;
			rear = rear.next;
		}
		size++;
		return item;
	}
	
	/**
	 * Inspects the item at the front
	 * @return the element at the front
	 * @throws IllegalStateException if the queue is empty
	 */
	public E peek() {
		if(front != null) {
			return front.data;
		}
		else {
			throw new IllegalStateException("Queue is empty, no items at the head");
		}
	}
	
	/** 
	 * Inspects and removes the item at the front
	 * @return the item at the front
	 * @throws IllegalStateException if the queue is empty 
	 */
	public E poll() {
		if(front == null) {
			throw new IllegalStateException("Queue is empty");
		}
		else {
			Node<E> temp = front;
			front = front.next;
			size--;
			return temp.data;
			
		}
		
	}
	
	/**
	 * Size of the queue
	 * @return
	 */
	public int size() {
		return size;
	}
	
	public String toString() {
			
			StringBuilder s = new StringBuilder();
			Node<E> current = front;
			s.append("[");
			while (current!=null) {
				s.append(current.data.toString()+",");
				current = current.next;
			}
			s.append("]");
			return s.toString();
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		for(int i = 0; i<10;i++) {
			q.offer(i);
		}
		
		q.poll();
		
		System.out.println(q.toString());
		System.out.println(q.peek());
		System.out.println(q.toString());
		
		
	}

	public boolean is_empty() {
		return size == 0;
	}
	
}
