public class OrderedLinkedListTest{
  /*
   * Tester class for the OrderedLinkedList class
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
    OrderedLinkedListTest tester = new OrderedLinkedListTest();
    
    OrderedLinkedList<String> list = new OrderedLinkedList<String>();
    
    
    // Testing size()
    tester.testMethod(String.valueOf(list.size()), "0");
    
    /*
     * Testing insert() 
     * 
     * inserting "Brandon", "Odiwior", "Tom", "Wayne", Yatch into the list
     */    
    list.insert("Yatch");
    list.insert("Brandon");
    list.insert("Wayne");
    list.insert("Odiwuor");
    list.insert("Tom");
    tester.testMethod(String.valueOf(list.size()), "5");
    
    // Testing find()
    tester.testMethod(String.valueOf(list.find("Brandon")), "0");
    tester.testMethod(String.valueOf(list.find("Tom")), "2");
    tester.testMethod(String.valueOf(list.find("Yatch")), "4");
    
    // Testing get()
    tester.testMethod(list.get(0), "Brandon");
    tester.testMethod(list.get(4), "Yatch");
    tester.testMethod(list.get(1), "Odiwuor");
    
    // Testing remove()
    list.remove("Brandon");
    tester.testMethod(String.valueOf(list.size()), "4");
    tester.testMethod(String.valueOf(list.find("Odiwuor")), "0");
    tester.testMethod(String.valueOf(list.find("Yatch")), "3");
    tester.testMethod(String.valueOf(list.find("Brandon")), "-1");
    
    // Testing display()
    System.out.println("\nItems in the list: ");
    list.display();
    
  }
}