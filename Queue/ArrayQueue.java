public class ArrayQueue<E> implements Queue<E>{
  public static final int DEFAULT_CAPACITY = 1000;
  public E[] data;
  public int firstElementIndex = 0;
  private int numberOfElements;
  
  public ArrayQueue(){
    this(DEFAULT_CAPACITY);
  }
  
  public ArrayQueue(int capacity){
    data = (E[]) new Object[capacity];
  }
  
  public int size(){
    return numberOfElements;
  }
  
  public boolean isEmpty(){
    return size() == 0;
  }
  
  public E first(){
    if(isEmpty()) return null;
    return data[firstElementIndex];
  }
  
  public E dequeue(){
    if(isEmpty()) return null;
    E answer = data[firstElementIndex];
    data[firstElementIndex] = null;
    firstElementIndex = (firstElementIndex + 1) % data.length;
    numberOfElements--;
    return answer;
  }
  
  public void enqueue(E element) throws IllegalStateException{
    if(numberOfElements == data.length) throw 
      new IllegalStateException("Queue is full");
    int available = (firstElementIndex + numberOfElements) % data.length;
    data[available] = element;
    numberOfElements++;
  }
}