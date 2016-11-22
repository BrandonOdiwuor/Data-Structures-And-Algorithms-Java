public class MainTester{
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
}