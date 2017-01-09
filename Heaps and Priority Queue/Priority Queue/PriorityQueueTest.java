/**
 * Test class for the Priority Queue class
 */
public class PriorityQueueTest{
  public static void main(String[] args){
    PriorityQueue<String>  priority_queue = new PriorityQueue<String>();
    
    // Testing enqueue
    priority_queue.enqueue("Zola");
    priority_queue.enqueue("Zeetha");
    priority_queue.enqueue("Tarvek");
    priority_queue.enqueue("Agatha");
    priority_queue.enqueue("Lucrezia");
    priority_queue.enqueue("Gil");
    
    // Testing peek() function
    testMethod(priority_queue.peek(), "Agatha");
    
    // Testing dequeueMin() function
    testMethod(priority_queue.dequeueMin(), "Agatha");
    testMethod(priority_queue.peek(), "Gil");
    
    // Testing toString()
    testMethod(priority_queue.toString(), "[ Gil, Lucrezia, Zeetha, Zola, Tarvek]");
  }
  
  /* 
   * A simple test function that takes a function returns 
   * and compares it to what the function is to return
   */
  public static void testMethod(String returned, String expectedReturn){
    if(returned.equals(expectedReturn)){
      System.out.println(" OK function returned: " + returned + " expected: " + expectedReturn);
    }
    else{
      System.out.println(" X function returned: " + returned + " expected: " + expectedReturn);
    }
    
  }
}