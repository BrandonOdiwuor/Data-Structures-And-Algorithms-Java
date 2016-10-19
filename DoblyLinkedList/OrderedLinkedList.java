public class OrderedLinkedList<T extends Comparable<? super T> >{
  
  public static class Node<T extends Comparable<? super T> >{
    /*
     * Nested Node class that stores reference to the object to be stored 
     * in the linked list and a reference to the next Node
     */
    private T element;
    private Node<T> next;
    private Node<T> previous;
    
    public Node(T e){
      element = e;
    }
    
    public void setNext(Node<T> n){
      next = n;
    }
    
    public void setPrevious(Node<T> prev){
      previous = prev;
    }
    
    public Node<T> getNext(){
      return next;
    }
    
    public Node<T> getPrevious(){
      return previous;
    }
    
    public T getElement(){
      return element;
    }
  }
  
  private Node<T> head;
  private Node<T> tail;
  private int size;
  
  
  public OrderedLinkedList(){
    head = new Node<T>(null);
    tail = new Node<T>(null);
    head.setNext(tail);
    tail.setPrevious(head);
    size = 0;
  }
  
  public void insert(T newItem){
    /*
     * Insering a new item into the list while maintaining the order
     */
    Node<T> newNode = new Node<T>(newItem);
    if(size() == 0){      
      newNode.setNext(head.getNext());
      head.setNext(newNode);
      newNode.getNext().setPrevious(newNode);
      newNode.setPrevious(head); 
    }
    else{
      Node<T> currentNode = head.getNext();
      while(currentNode.getElement().compareTo(newItem) <= 0 && currentNode != tail){
        currentNode = currentNode.getNext();
      }
      newNode.setNext(currentNode);
      currentNode.getPrevious().setNext(newNode);
      newNode.setPrevious(currentNode.getPrevious());
      newNode.getNext().setPrevious(newNode);
      
    }
    size++;
  }
  
  public int find(T item){
    /*
     * Returns the position of an element in the list
     */
    int i = 0;
    int index = -1;
    Node<T> currentNode = head.getNext();
    boolean found = false;
    while(found != true && currentNode != tail){
      if(currentNode.getElement().equals(item)){
        found = true;
        index = i;
      }
      currentNode = currentNode.getNext();
      i++;
    }
    return index;
  }
  
  public T get(int index) throws IndexOutOfBoundsException{
    /*
     * Returns the element at the index position in the list
     */
    if(index >= 0 && index < size()){
      int i = 0;
      Node<T> nodeToReturn = new Node<T>(null);
      Node<T> currentNode = head.getNext();
      boolean found = false;
      while(found != true && currentNode != tail){
        if(i == index){
          nodeToReturn = currentNode;
        }
        currentNode = currentNode.getNext();
        i++;
      }
      return nodeToReturn.getElement();
    }
    else{
      throw new IndexOutOfBoundsException();
    }
  }
  
  public void remove(T item){
    /*
     * Removes the item whose index is give from the list
     */
    if(find(item) != -1){
      Node<T> currentNode = head.getNext();
      boolean removed = false;
      while(removed != true && currentNode != tail){
        if(currentNode.getElement().equals(item)){
          currentNode.getPrevious().setNext(currentNode.getNext());
          currentNode.getNext().setPrevious(currentNode.getPrevious());
          removed = true;
          size--;
        }
        currentNode = currentNode.getNext();
      }
    }
  }
  
  public void display(){
    /*
     * Displays the content of the list
     */
    Node<T> currentNode = head.getNext();
    while(currentNode != tail){
      System.out.println("\t" + currentNode.getElement());
      currentNode = currentNode.getNext();
    }
  }
  
  public int size(){
    /*
     * Returns the number of elements in the linked list
     */
    return size;
  }
}