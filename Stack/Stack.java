/**
 * A stack is an ADT where elements are added or removed 
 * according to the LAST IN, FIRST OUT(LIFO) priciple.
 * 
 * @author Brandon Wayne Odiwuor
 */
public interface Stack<E>{
  
  /**
   * Returns the numbers of items in the stack
   * @return number of items in the stack
   */
  int size();
  
  /**
   * Returns a boolean indicating whether the stack is empty
   * @return true stack is empty, false otherwise
   */
  boolean isEmpty();
  
  /**
   * Adds a new item to the stack
   * @param item  the element to be inserted
   */
  void push(E item);
  
  /**
   * Returns and removes the element at the top of the stack
   * @return element removed from the stack, null if the stack is empty
   */
  E pop();
  
  /**
   * Returns, but doesn't remove, the element on the top of the stack
   * @return last element on the stack, null if the stack is empty
   */
  E top();
}