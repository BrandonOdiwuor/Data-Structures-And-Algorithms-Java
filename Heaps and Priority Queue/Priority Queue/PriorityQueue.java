/**
 * Java implementation of Priority Queue Abstract Data Type using 
 * Minimum Binary Heap data structure
 */
public class PriorityQueue< T extends Comparable<? super T> >{
  private T[] heap_array; // Internal storage structure for the heap
  private int heap_size; // Number of items in the heap
  private static int DEFAULT_CAPACITY = 50; // Default capacity of the heap_array
  
  @SuppressWarnings("unchecked")
  public PriorityQueue(){
    heap_array = (T[]) new  Comparable[DEFAULT_CAPACITY];
    heap_size = 0;
  }
  
  /**
   * Returns the number of elements in the queue
   * @return the number of elements in the priority queue
   */
  public int size(){
    return heap_size;
  }
  
  /**
   * Returns a boolean indicating whether the priority queue is empty
   * @return true the queue is empty, false otherwise
   */
  public boolean isEmpty(){
    return size() == 0;
  }
  
  /**
   * Adds a new item into the queue
   * @param element the item to be inserted into the queue
   */
  public void enqueue(T element){
    if(heap_size == heap_array.length)
      expandHeapArray();
    heap_array[heap_size] = element;
    int index = heap_size;
    heap_array[index] = element;
    while(index > 0 && heap_array[parent(index)].compareTo(heap_array[index]) > 0){
      swap(parent(index), index);
      index = parent(index);
    }
    heap_size++;
  }
  
  /**
   * Returns but does not remove the item with the minimum priority from the queue
   * @return the element with the smallest priority in the queue
   */
  public T peek(){
    return heap_array[0];
  }
  
  /**
   * Returns and removes the item with the smalles priority from the queue
   * @return the item with the smallest priority from the queue
   */
  public T dequeueMin(){
    T minElement = peek();
    heap_array[0] = heap_array[heap_size -1];
    heap_array[heap_size - 1] = null;
    heap_size--;
    minHeapify(0);
    return minElement;
  }
  
  /**
   * Helps rearrange nodes so that the minimum heap property can be maintained
   * @param index the index that violates the minimum-heap property
   */
  public void minHeapify(int index){
    int smallest = index;
    int left = left(index);
    int right = right(index);
    if(left <= heap_size - 1 && heap_array[left].compareTo(heap_array[smallest]) < 0)
      smallest = left(index);
    if(right <= heap_size - 1 && heap_array[right].compareTo(heap_array[smallest]) < 0)
      smallest = right(index);
    if(smallest != index){
      swap(smallest, index);
      minHeapify(smallest);
    }
  }
  
  /**
   * Swaps item at first_index with item on secpnd_index
   */
  public void swap(int first_index, int second_index){
    T tmp = heap_array[first_index];
    heap_array[first_index] = heap_array[second_index];
   heap_array[second_index] = tmp;
  }
  
  /**
   * Doubles the size of heap_array when its full
   */
  @SuppressWarnings("unchecked")
  private void expandHeapArray(){
    T[] new_array = (T[]) new  Comparable[heap_array.length * 2];
    for(int i = 0; i < heap_array.length; i++)
      new_array[i] = heap_array[i];
    heap_array = new_array;
  }
  
  /**
   * Returns a string representation of the priority queue
   * @return a string representation of the priority queue
   */
  public String toString(){
    String priorityQueue = "[ ";
    for(int i = 0; i < heap_size; i++){
      if(i == heap_size - 1)
        priorityQueue += heap_array[i] + "]";
      else
        priorityQueue += heap_array[i] + ", ";
    }
    return priorityQueue;
  }
  
  // Returns the index of the left child of the node positioned at the index provided
  private int left(int i){return i*2 + 1;}
  
   // Returns the index of the right child of the node positioned at the index provided
  private int right(int i){return i*2 + 2;}
  
   // Returns the index of the parent of the node positioned at the index provided
  private int parent(int i){return (i - 1)/ 2;}
}