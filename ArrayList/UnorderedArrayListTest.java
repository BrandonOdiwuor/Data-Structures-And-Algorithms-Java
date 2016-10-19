public class UnorderedArrayListTest{
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
      UnorderedArrayListTest tester = new UnorderedArrayListTest();
      
      UnorderedArrayList<Integer> arrayList = new UnorderedArrayList<Integer>();
      
      // Testing size() 
      tester.testMethod(Integer.toString(arrayList.size()), "0");

      /* Testing add()
       *
       *Add 1,2,3,4,5,6 into the arrayList
       */
      arrayList.add(new Integer(1));
      arrayList.add(new Integer(2));
      arrayList.add(new Integer(3));
      arrayList.add(new Integer(4));
      arrayList.add(new Integer(5));
      arrayList.add(new Integer(6));
      tester.testMethod(Integer.toString(arrayList.size()), "6");

      // Testing find()
      tester.testMethod(Integer.toString(arrayList.find(1)), "0");
      tester.testMethod(Integer.toString(arrayList.find(6)), "5");

      // Testing get()
      tester.testMethod(Integer.toString(arrayList.get(4)), "5");
      tester.testMethod(Integer.toString(arrayList.get(2)), "3");

      // Testing remove()
      arrayList.remove(1);
      tester.testMethod(Integer.toString(arrayList.size()), "5");
      tester.testMethod(Integer.toString(arrayList.find(1)), "-1");
      tester.testMethod(Integer.toString(arrayList.find(2)), "0");

      // Testing display()
      arrayList.display();
    }
 }