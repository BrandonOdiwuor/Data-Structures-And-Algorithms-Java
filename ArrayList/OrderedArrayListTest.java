public class OrderedArrayListTest{
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
    OrderedArrayListTest tester = new OrderedArrayListTest();
    
    OrderedArrayList<Integer> arrayList = new OrderedArrayList<Integer>(2);
    
    // Testing size()
    tester.testMethod(String.valueOf(arrayList.size()), "0");
    
    /*
     * Testing insert() 
     * 
     * Inserting 1,2,3,4,5,6,7,8,9,10
     */
    
    arrayList.insert(new Integer(7));
    arrayList.insert(new Integer(4));
    arrayList.insert(new Integer(3));
    arrayList.insert(new Integer(2));
    arrayList.insert(new Integer(10));
    arrayList.insert(new Integer(5));
    arrayList.insert(new Integer(6));
    arrayList.insert(new Integer(1));
    arrayList.insert(new Integer(9));
    arrayList.insert(new Integer(8));
    
    
    tester.testMethod(String.valueOf(arrayList.size()), "10");
    
    // Testing find()
    tester.testMethod(String.valueOf(arrayList.find(1)), "0");
    tester.testMethod(String.valueOf(arrayList.find(10)), "9");
    tester.testMethod(String.valueOf(arrayList.find(5)), "4");
    
    
    // Testing remove()
    arrayList.remove(new Integer(1));
    tester.testMethod(String.valueOf(arrayList.size()), "9");
    tester.testMethod(String.valueOf(arrayList.find(2)), "0");
    tester.testMethod(String.valueOf(arrayList.find(10)), "8");
    tester.testMethod(String.valueOf(arrayList.find(5)), "3");
    
    // Testing get()
    tester.testMethod(String.valueOf(arrayList.get(0)), "2");
    tester.testMethod(String.valueOf(arrayList.get(8)), "10");
    tester.testMethod(String.valueOf(arrayList.get(3)), "5");
    
    // Testing display()
    System.out.println("\nItems in the list: ");
    arrayList.display();
    
  }
}