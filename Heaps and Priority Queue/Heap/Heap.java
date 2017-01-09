/**
 * Java implementation of a heap
 */
public class Heap{
  private static int left(int i){return i*2 + 1;}
  private static int right(int i){return i*2 + 2;}
  private static int parent(int i){return (i - 1)/ 2;}
  
  public static void maxHeapify(int[] array, int index){
    maxHeapify(array, index, array.length - 1);
  }
  public static void maxHeapify(int[] array, int index, int heapSize){
    int largest = index;
    if(left(index) <= heapSize && array[left(index)] > array[largest])
      largest = left(index);
    if(right(index) <= heapSize && array[right(index)] > array[largest])
      largest = right(index);
    if(largest != index){
      swap(array, largest, index);
      maxHeapify(array, largest, heapSize);
    }
  }
  
  public static void swap(int[] array, int firstIndex, int secondIndex){
    int tmp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = tmp;
  }
  
  public static void buildMaxHeap(int[] array){
    for(int i = (array.length / 2) - 1 ; i > -1; i--)
      maxHeapify(array, i);
  }
  
  public static void heapSort(int[] array){
    buildMaxHeap(array);
    int size = array.length - 1;
    for(int i = array.length - 1; i > 0; i--){
      swap(array, 0, i);
      maxHeapify(array, 0, --size);
    }      
  }
}