public class UnoderedSinglyLinkedListTest{
  
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
    UnoderedSinglyLinkedListTest tester = new UnoderedSinglyLinkedListTest();
    
    UnoderedSinglyLinkedList<String> studentsNameList = new UnoderedSinglyLinkedList<String>();
    
    // Testing size() function 
    tester.testMethod(String.valueOf(studentsNameList.size()), "0");
    
    // Testing the isEmpty() function
    tester.testMethod(String.valueOf(studentsNameList.isEmpty()), "true");
    
    // Testing the addFirst() function
    studentsNameList.addFirst("Wayne");
    studentsNameList.addFirst("Odiwuor");
    studentsNameList.addFirst("Brandon");
    tester.testMethod(studentsNameList.getFirst(), "Brandon");
    tester.testMethod(String.valueOf(studentsNameList.size()), "3");
    
    // Testign the getLast() function
    tester.testMethod(studentsNameList.getLast(), "Wayne");
    
    // Testing the addLast() function
    studentsNameList.addLast("Becker");
    tester.testMethod(studentsNameList.getLast(), "Becker");
    tester.testMethod(String.valueOf(studentsNameList.size()), "4");
    
    // Testing removeFirst()
    String removedName = studentsNameList.removeFist();
    tester.testMethod(removedName, "Brandon");
    tester.testMethod(studentsNameList.getFirst(), "Odiwuor");
    tester.testMethod(String.valueOf(studentsNameList.size()), "3");
    
  }
}