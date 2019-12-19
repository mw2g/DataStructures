package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		// TODO: Implement this method
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element The element to add
	 */
	public boolean add(E element) throws NullPointerException {
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev.next = newNode;
		tail.prev = newNode;
		size++;
		// TODO: Implement this method
		return true;
	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size || size == 0) {

			throw new IndexOutOfBoundsException();
		}
		LLNode<E> select = head;
		for (int i = 0; i < size; i++) {
			select = select.next;
			if (i == index) {
				return select.data;
			}
		}
		// TODO: Implement this method.
		throw new IndexOutOfBoundsException();
	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The     index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element) {
		
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}

		LLNode<E> insertNode = head;
		LLNode<E> newNode = new LLNode<E>(element);

		if (index == size) {
			
			tail.prev.next = newNode;
			newNode.next = tail;
			newNode.prev = tail.prev;
			tail.prev = newNode;
			 
		}else {
			

		for (int i = 0; i < size; i++) {
			insertNode = insertNode.next;
			if (i == index) {
				break;
			}
		}

		newNode.next = insertNode;
		newNode.prev = insertNode.prev;
		insertNode.prev.next = newNode;
		insertNode.prev = newNode;
		}
		size++;
	}

	/** Return the size of the list */
	public int size() {
		int size = 0;
		LLNode<E> node = head;
		while (node != tail) {
			node = node.next;
			size++;
		}
		// TODO: Implement this method
		return size - 1;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> removeNode = head;

		for (int i = 0; i < size; i++) {
			removeNode = removeNode.next;
			if (i == index) {
				break;
			}
		}

		removeNode.prev.next = removeNode.next;
		removeNode.next.prev = removeNode.prev;
		size--;
		return removeNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index   The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}

		LLNode<E> setNode = head;
		E replacedElement;
		for (int i = 0; i < size; i++) {
			setNode = setNode.next;
			if (i == index) {
				break;
			}
		}

		replacedElement = setNode.data;
		setNode.data = element;

		return replacedElement;
	}
}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
