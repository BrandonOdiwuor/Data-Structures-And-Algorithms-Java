public interface Queue<E>{
  /**
   * Queue is An ADT where elements are added or removed 
   * accortding to FIRST IN, FIRST OUT(FIFO) principle
   */
  
  /**
   * Returns the number elements in the queue
   * @return number of elements in the queue
   */
  public int size();
  
  /**
   * Returns a boolean indicating whether a queue is empty
   * @boolean true  is the queue  is empty(), false otherwise
   */
  public boolean isEmpty();
  
  /**
   * Returns and removes the first element in the queue
   * @return element removed from the queue, null if the queue is empty
   */
  public E dequeue();
  
  /**
   * Returns but does not remove the first element from the stack
   * @return first element in the queue, null if the queue is empty
   */
  public E first();
  
  public void enqueue(E element);
}