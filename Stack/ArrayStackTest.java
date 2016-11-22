public class ArrayStackTest extends MainTester{
  /**
   * A class for testing Array Stack class
   */
  
  
  public static void main(String[] args){
    ArrayStackTest tester = new ArrayStackTest();
    ArrayStack<String> stack = new ArrayStack<String>(100);
    
    // Testing size() on an empty stack
    tester.testMethod(Integer.toString(stack.size()), "0");
    
    // Testing isEmpty() on an empty stack
    tester.testMethod(String.valueOf(stack.isEmpty()), "true");
    
    // Testing push()
    stack.push("Brandon Wayne Odiwuor");
    tester.testMethod(Integer.toString(stack.size()), "1");
    tester.testMethod(String.valueOf(stack.isEmpty()), "false");
    stack.push("Becker Otieno");
    stack.push("Hazel Joyce");
    stack.push("Brayden Gweth");
    stack.push("Jerdon Hawi");
    
    // Testing top
    tester.testMethod(stack.top(), "Jerdon Hawi");
    
    // Testing pop()
    tester.testMethod(Integer.toString(stack.size()), "5");
    tester.testMethod(stack.pop(), "Jerdon Hawi");
    tester.testMethod(Integer.toString(stack.size()), "4");
    tester.testMethod(stack.top(), "Brayden Gweth");
  }
}