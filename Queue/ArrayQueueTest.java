public class ArrayQueueTest extends MainTester{
  public static void main(String[] args){
    ArrayQueueTest tester = new ArrayQueueTest();
    
    
    ArrayQueue<String> queue = new ArrayQueue<String>();
    
    // Testing size()
    tester.testMethod(String.valueOf(queue.size()), "0");
    
    // Testing isEmpty()
    tester.testMethod(String.valueOf(queue.isEmpty()), "true");
    
    // Testing enqueue()
    queue.enqueue("Brandon Wayne Odiwuor");
    tester.testMethod(Integer.toString(queue.size()), "1");
    tester.testMethod(String.valueOf(queue.isEmpty()), "false");
    queue.enqueue("Becker Otieno");
    queue.enqueue("Hazel Joyce");
    queue.enqueue("Brayden Gweth");
    queue.enqueue("Jerdon Hawi");
    tester.testMethod(Integer.toString(queue.size()), "5");
    
    // Testing first()
    tester.testMethod(queue.first(), "Brandon Wayne Odiwuor");
    
    // Testing deuque()
    tester.testMethod(queue.dequeue(), "Brandon Wayne Odiwuor");
    tester.testMethod(queue.first(), "Becker Otieno");
    tester.testMethod(Integer.toString(queue.size()), "4");
  }
}