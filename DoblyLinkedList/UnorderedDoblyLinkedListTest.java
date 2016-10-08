import java.util.NoSuchElementException;

public class UnorderedDoblyLinkedListTest{
  /*
   * Class for testing UnorderedDoublyLinkedList class
   */
  
  public void testMethod(String returned, String expectedReturn){
    /* 
     * A simple test function that takes a function returns 
     * and compares it to what the function is to return
     */
    if(returned.equals(expectedReturn)){
      System.out.println(" OK function returned: " + returned + " expected: " + expectedReturn);
    }
    else{
      System.out.println(" X function returned: " + returned + " expected: " + expectedReturn);
    }
    
  }
  public static void main(String[] args){
    UnorderedDoblyLinkedListTest tester = new UnorderedDoblyLinkedListTest();
    
    UnorderedDoblyLinkedList<Integer> integerList = new UnorderedDoblyLinkedList<Integer>();
    
    // Testing size()
    tester.testMethod(String.valueOf(integerList.size()), "0");
    
    //Testing isEmpty()
    tester.testMethod(String.valueOf(integerList.isEmpty()), "true");
    
    // Testing addFirst()
    integerList.addFirst(new Integer(1));
    tester.testMethod(String.valueOf(integerList.size()), "1");
    tester.testMethod(String.valueOf(integerList.isEmpty()), "false");
    
    // Testing getFirst()
    integerList.addFirst(new Integer(2));
    integerList.addFirst(new Integer(3));
    integerList.addFirst(new Integer(4));
    tester.testMethod(String.valueOf(integerList.getFirst()), "4");
    tester.testMethod(String.valueOf(integerList.size()), "4");
    
    // Testing removeFirst()
    Integer remove;
    try{
      remove = integerList.removeFirst();        
      tester.testMethod(String.valueOf(remove), "4");
      tester.testMethod(String.valueOf(integerList.size()), "3");
      tester.testMethod(String.valueOf(integerList.getFirst()), "3");
    }catch(NoSuchElementException ex){
      ex.printStackTrace();
    }
    
    // Testing getLast()
    tester.testMethod(String.valueOf(integerList.getLast()), "1");
    
    // Testing addLast()
    integerList.addLast(new Integer(5));
    tester.testMethod(String.valueOf(integerList.size()), "4");
    tester.testMethod(String.valueOf(integerList.getLast()), "5");
    
    // Testing removeLast()
    tester.testMethod(String.valueOf(integerList.removeLast()), "5");
    tester.testMethod(String.valueOf(integerList.size()), "3");
    tester.testMethod(String.valueOf(integerList.getLast()), "1");
    
    
    
    
    
  }
}