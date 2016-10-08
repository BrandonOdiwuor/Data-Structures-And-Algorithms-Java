import java.util.NoSuchElementException;

public class UnorderedDoblyLinkedList<E>{
  public static class Node<E>{
    /*
     * Nested Node class that stores reference to the object to be stored 
     * in the linked list and a reference to the next Node
     */
    private E element;
    private Node<E> next;
    private Node<E> previous;
    
    public Node(E e){
      element = e;
    }
    
    public void setNext(Node<E> n){
      next = n;
    }
    
    public void setPrevious(Node<E> prev){
      previous = prev;
    }
    
    public Node<E> getNext(){
      return next;
    }
    
    public Node<E> getPrevious(){
      return previous;
    }
    
    public E getElement(){
      return element;
    }
  }
  
  private Node<E> head;
  private Node<E> tail;
  private int size;
  
  public UnorderedDoblyLinkedList(){
    head = new Node<E>(null);
    tail = new Node<E>(null);
    head.setNext(tail);
    tail.setPrevious(head);
    size = 0;
  }
  
  public int size(){
    /*
     * Returns the number of elements in the linked list
     *
     *Time Complexity O(1)
     */
    return size;
  }
  
  public boolean isEmpty(){
    /*
     * Returns a boolean indication whether the list is empty
     *
     * TimeComplexity O(1)
     */
    return size == 0;
  }
  
  
  public void addFirst(E element){
    /*
     * Adds an element to the front of the list
     *
     * Time Complexity O(1)
     */
    Node<E> newNode = new Node<E>(element);
    newNode.setNext(head.getNext());
    head.setNext(newNode);
    newNode.getNext().setPrevious(newNode);
    newNode.setPrevious(head);    
    size++;
  }
  
  public E getFirst(){
    /*
     * Returns the first element in the list
     *
     * Time Complexity O(1)
     */
    return head.getNext().getElement();
  }
  
  public void addLast(E element){
    /*
     * Adds a new element to the end of the list
     *
     * Time Complexity O(1)
     */
    Node<E> newNode = new Node<E>(element);
    newNode.setNext(tail);
    tail.getPrevious().setNext(newNode);
    newNode.setPrevious(tail.getPrevious());
    tail.setPrevious(newNode);
    size++;
  }
  
  public E getLast(){
    /*
     * Returns the last element in the list
     *
     * Time Complexity O(1)
     */
    return tail.getPrevious().getElement();
  }
  
  public E removeFirst() throws NoSuchElementException{
    /*
     * Removes and returns the first element in the list
     * Thows NoSuchElementException if the list is empty
     * 
     * Time Complexity O(1)
     */
    if(size == 0)
      throw new NoSuchElementException();
    else{
      E removedElement = head.getNext().getElement();
      head.setNext(head.getNext().getNext());
      head.getNext().setPrevious(head);
      size--;
      return removedElement;
    }
  }
  
  public E removeLast() throws NoSuchElementException{
    /*
     * Removes and returns the last element in the list
     * Thows NoSuchElementException if the list is empty
     * 
     * Time Complexity O(1)
     */
    if(size==0)
      throw new NoSuchElementException();
    else{
      E removedElement = tail.getPrevious().getElement();
      tail.setPrevious(tail.getPrevious().getPrevious());
      tail.getPrevious().setNext(tail);
      size--;
      return removedElement;
    }
  }
  
  
  
  
  
  
  
}