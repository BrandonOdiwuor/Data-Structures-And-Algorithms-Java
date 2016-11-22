public class LinkedStack<E> implements Stack<E>{
  /**
   * Implementation of Stack Abstract Data Type
   * using Unordered Signly linked list as underlying storage
   */
   UnoderedSinglyLinkedList<E> list =  new UnoderedSinglyLinkedList<E>();
   
   public int size(){
     /* 
     * Time complexity O(1)
     */
     return list.size();
   }
   
   public boolean isEmpty(){
     /* 
     * Time complexity O(1)
     */
     return size() == 0;
   }
   
   public E top(){
     /* 
     * Time complexity O(1)
     */
     return list.getFirst();
   }
   
   public E pop(){
     /* 
     * Time complexity O(1)
     */
     return list.removeFirst();
   }
   
   public void push(E element){
     /* 
     * Time complexity O(1)
     */
     list.addFirst(element);
   }
}