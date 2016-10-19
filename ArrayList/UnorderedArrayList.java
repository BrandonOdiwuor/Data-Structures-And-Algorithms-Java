public class UnorderedArrayList< T extends Comparable<? super T> >{
  public static final int CAPACITY = 100;;
  private T[] array;
  private int numItems;
  int currentPosition;
  
  public UnorderedArrayList(int initialSetCapacity){
     array = (T[]) new Comparable[initialSetCapacity];
    numItems = 0;
    currentPosition = 0;
  }
  
  public  UnorderedArrayList(){
     this(CAPACITY); 
  }
  
  public void add(T newItem){
      /*
       * Adds a new item to the list
       *
       * Time Complexity O(1)
       */
       if(size() == array.length)
           expandArray();
       array[currentPosition] = newItem;
       currentPosition++;
       numItems++;
  }
  
  public int find(T item){
      /*
       * Returns the index of the item provided in the list
       *
       * Time Complexity O(N)
       */
      int index = -1;
      for(int i = 0; i < size(); i++){
          if(array[i].equals(item))
              index = i;
      }
      return index;
  }
  
  public T get(int index) throws IndexOutOfBoundsException{
    /*
     * Returns the item at the index position in the list
     *
     * Time Complexity O(1)
     */
    if(index >= 0 && index < numItems){
      return array[index];
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
        array[i] = array[i+1];
      numItems--;
    }
  }
  
  public void display(){
    /*
     * Displays the content of the list
     *
     * Time Complexity O(N)
     */
    System.out.println("\n ArrayList contets: ");
    for(int i = 0; i < numItems; i++){
      System.out.println("\t" + array[i]);
    }
  }
  
  public int size(){
      /*
       * Returns the number of items in the list
       *
       * Time Complexity O(1)
       */
      return numItems;
  }
  
  private void expandArray(){
      /*
       * Doubles the size of the storage array
       *
       * Time Complexity O(N)
       */
      T[] newArray = (T[]) new Comparable[size() * 2];
      for(int i = 0; i < array.length; i++)
          newArray[i] = array[i];
      array = newArray;
  }
  
}