public class OrderedArrayList< T extends Comparable<? super T> >{
  private T[] sortedArray;
  private int numItems;
  
  public static final int DEFAULT_SIZE = 40;
  
  public OrderedArrayList(){
    /*
     * Creating a new array list with default size
     */
    this(DEFAULT_SIZE);
  }
  
  public OrderedArrayList(int size){
    /*
     * Creating a new array list with predefined size
     */
    sortedArray = (T[]) new Comparable[size];
  }
  
  public void insert(T newItem){
    /*
     * Insering a new item into the list while maintaining the order
     *
     * Time Complexity O(N)
     */
    if(numItems == sortedArray.length)
      expandArrayAndShiftElements();
    int i = 0;
    while(i < numItems && sortedArray[i].compareTo(newItem) <= 0){
      i++;
    }
    for(int j = numItems; j > i; j--){
      sortedArray[j] = sortedArray[j-1];
    }
    sortedArray[i] = newItem;
    numItems++;
  }
  
  public int find(T item){
    /*
     * Returns the position of an element in the list,
     * returns -1 if the object is not present in the list
     *
     * Time Complexity O(N)
     */
    int indexOfObject = -1;
    for(int i = 0; i < numItems; i++){
      if(sortedArray[i].equals(item))
        indexOfObject = i;
    }
    return indexOfObject;
  }
  
  public T get(int index) throws IndexOutOfBoundsException{
    /*
     * Returns the item at the index position in the list
     *
     * Time Complexity O(1)
     */
    if(index >= 0 && index < numItems){
      return sortedArray[index];
    }
    else{
      throw new IndexOutOfBoundsException();
    }
  }
  
  public void remove(T item){
    /*
     * Removes the item whose index is give from the list
     *
     * Time Complexity O(N)
     */
    int index = find(item);
    if(index != -1){
      for(int i = index; i < numItems - 1; i++)
        sortedArray[i] = sortedArray[i+1];
      numItems--;
    }
  }
  
  public void display(){
    /*
     * Displays the content of the list
     *
     * Time Complexity O(N)
     */
    for(int i = 0; i < numItems; i++){
      System.out.println(sortedArray[i]);
    }
  }
  
  public int size(){
    /*
     * Returns the size of the list
     *
     * Time Complexity O(1)
     */
    return numItems;
  }
  
  public void expandArrayAndShiftElements(){
    /*
     * Expands the array size by 2
     *
     * Time Complexity O(N)
     */
    T[] newSortedArray = (T[]) new Comparable[size() * 2];
    for(int i = 0; i < size(); i++){
      newSortedArray[i] = sortedArray[i];
    }
    sortedArray = newSortedArray;
  }
  
}