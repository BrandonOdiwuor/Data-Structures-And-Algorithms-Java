public class BinarySearchTreeTest{
  public static void main(String[] args){
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    
    // Testing size() function
    testMethod(Integer.toString(binarySearchTree.size()), "0");
    
    // Testing isEmpty() function
    testMethod(String.valueOf(binarySearchTree.isEmpty()), "true");
    
    // Testing treeInsert() function
    binarySearchTree.treeInsert("Brandon");
    testMethod(Integer.toString(binarySearchTree.size()), "1");
    testMethod(String.valueOf(binarySearchTree.isEmpty()), "false");
    
    // Testing treeSearch() function
    testMethod(String.valueOf(binarySearchTree.treeSearch("Brandon")), "true");
    testMethod(String.valueOf(binarySearchTree.treeSearch("Wayne")), "false");
    
    // Adding more elements in the tree
    binarySearchTree.treeInsert("Brayden");
    binarySearchTree.treeInsert("Jerdon");
    binarySearchTree.treeInsert("Becker");
    binarySearchTree.treeInsert("Hazel");
    testMethod(Integer.toString(binarySearchTree.size()), "5");
    testMethod(String.valueOf(binarySearchTree.treeSearch("Hazel")), "true");
    
    // Testing treeMinimum() function
    testMethod(binarySearchTree.treeMinimum(), "Becker");
    
    // Testing treeMaximum() function
    testMethod(binarySearchTree.treeMaximum(), "Jerdon");
    
    // Testing treeSuccessor() function
    testMethod(binarySearchTree.treeSuccessor("Brandon"), "Brayden");
    
    // Testing treePredecessor() function
    testMethod(binarySearchTree.treePredecessor("Jerdon"), "Hazel");
    
    // Testing treeDelete()
    binarySearchTree.treeDelete("Brayden");
    testMethod(Integer.toString(binarySearchTree.size()), "4");
    testMethod(String.valueOf(binarySearchTree.treeSearch("Brayden")), "false");
    testMethod(binarySearchTree.treeSuccessor("Brandon"), "Hazel");
    
  }
  
  /* 
   * A simple test function that takes a function returns 
   * and compares it to what the function is to return
   */
  public static void testMethod(String returned, String expectedReturn){
    if(returned.equals(expectedReturn))
      System.out.println(" OK function returned: " + returned + " expected: " + expectedReturn);
    else
      System.out.println(" X function returned: " + returned + " expected: " + expectedReturn);    
  }
}