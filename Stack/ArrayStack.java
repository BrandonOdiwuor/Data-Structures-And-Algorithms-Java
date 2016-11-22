public class ArrayStack<E> implements Stack<E>{
  /**
    * Implementing Stack Abstract Data Type 
    * using an array as the underlying Storage
    */
  public static final int DEFAULT_CAPACITY = 1000;  // Default Stack Capacity
  private E[] data;                                 // Storage array
  private int topElementIndex = -1;                 // Index of the top element
  
  public ArrayStack(){
    this(DEFAULT_CAPACITY);
  }
  
  public ArrayStack(int capacity){
    data = (E[])new Object[capacity];
  }
  
  public int size(){
    /**
     * Time Complexity O(1)
     */
    return topElementIndex + 1;
  }
  
  public boolean isEmpty(){
    /**
     * Time Complexity O(1)
     */
    return size() == 0;
  }
  
  public E top(){
    /**
     * Time Complexity O(1)
     */
    if(isEmpty()) return null;
    return data[topElementIndex];
  }
  
  public E pop(){
    /**
     * Time Complexity O(1)
     */
    if(isEmpty()) return null;
    E element = data[topElementIndex];
    data[topElementIndex] = null;
    topElementIndex--;
    return element;
  }
  
  public void push(E element) throws IllegalStateException{
    /**
     * Time Complexity O(1)
     */
    if(size() < data.length)
      data[++topElementIndex] = element;
    else
      throw new IllegalStateException();
  }
}