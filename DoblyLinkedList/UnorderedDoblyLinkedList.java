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
    return size;
  }
  
  public boolean isEmpty(){
    return size == 0;
  }
  
  
  public void addFirst(E element){
    Node<E> newNode = new Node<E>(element);
    newNode.setNext(head.getNext());
    head.setNext(newNode);
    newNode.getNext().setPrevious(newNode);
    newNode.setPrevious(head);    
    size++;
  }
  
  public void addLast(E element){
    Node<E> newNode = new Node<E>(element);
    newNode.setNext(tail);
    tail.getPrevious().setNext(newNode);
    newNode.setPrevious(tail.getPrevious());
    tail.setPrevious(newNode);
  }
  
  public Node<E> removeFirst() throws NoSuchElementException{
    if(size == 0)
      throw new NoSuchElementException();
    else{
      return head;
    }
  }
  
  
  
  
  
  
  
}