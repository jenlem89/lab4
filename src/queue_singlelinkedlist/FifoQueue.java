package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		if(last == null){
			last = new QueueNode<>(e);
			last.next = last;
			size++;
			return true;
		}else{
			QueueNode<E> tempNode = new QueueNode<>(e);
			tempNode.next = last.next;
			last.next = tempNode;
			last = tempNode;
			size++;
			return true;
		}
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return this.size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if(last != null){
			return last.next.element;
		}
		return null;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		QueueNode<E> firstNode;
		if(last == null){ //Tom lista
			return null;
		}
		if(last.next == last){ //Ett objekt
			firstNode = last; 
			last = null;
			size--;
			return firstNode.element;
		}else{ //Fler objekt
			firstNode = last.next;
			last.next = last.next.next;
			size--;
			return firstNode.element;
		}
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return null;
	}
	
	private static class QueueNode<E> {
		E element;	//refererar till elementet
		QueueNode<E> next;	//refererar till efterföljande nod
		
		//konstruktor 
		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
