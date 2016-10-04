public class UnoderedSinglyLinkedList<E>{
  public Node<E> head = null;
  public Node<E> tail = null;
  public int size;
  
  public static class Node<E>{
    /*
     * Nested Node class that stores reference to the object to be stored 
     * in the linked list and a reference to the next Node
     */
    private E element;
    private Node<E> next;
    
    public Node(E e){
      element = e;
    }
    
    public void setNext(Node<E> n){
      next = n;
    }
    
    public Node<E> getNext(){
      return next;
    }
    
    public E getElement(){
      return element;
    }
  }
  
  
  public E getFirst(){
    /*
     * Returns the fist element stored in the linked list
     * 
     * Time complexity O(1)
     */
    if(size == 0) return null;
    return head.getElement();
  }
  public E getLast(){
    /*
     * Returns the last element stored in the linked list
     * 
     * Time complexity O(1)
     */
    if(size == 0) return null;
    return tail.getElement();
  }
  public int size(){
    /* Returns the size of the linked list
     * 
     * Time complexity O(1)
     */
    return size;
  }
  
  public boolean isEmpty(){
    /* Returns a boolean indicating whether the linked list is empty 
     * 
     * Time complexity O(1)
     */
    return size == 0;
  }
  
  public void addFirst(E e){
    /*
     * Adds a new element to the front of the linked list
     * 
     * Time complexity O(1)
     */
    Node<E> newest = new Node<E>(e);
    newest.setNext(head);
    head.setNext(newest);
    size += 1;
  }
  
  public void addLast(E e){
    /*
     * Adds a new element to the end of the linked list
     * 
     * Time complexity O(1)
     */
    Node<E> newest = new Node<E>(e);
    tail.setNext(newest);
    newest.setNext(null);
    size += 1;
  }
  
  public E removeFist(){
    /*
     * Removes and returns the first elemnt in the link list
     * 
     * Time complexity O(1)
     */
    if(size == 0) return null;
    E fHead = head.getElement();
    head = head.getNext();
    size -= 1;
    if(size == 0) tail = null;
    return fHead;
  }
}