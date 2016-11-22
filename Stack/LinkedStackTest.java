public class LinkedStackTest extends MainTester{
  /**
   * A class for testing LinkedStack class
   */  
  public static void main(String[] args){
    LinkedStackTest tester = new LinkedStackTest();
    LinkedStack<String> stack = new LinkedStack<String>();
    
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