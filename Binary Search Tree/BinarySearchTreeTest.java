public class BinarySearchTreeTest{
  public static void main(String[] args){
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    
    // Testing treeInsert() and size() functions
    binarySearchTree.treeInsert("Hazel");
    binarySearchTree.treeInsert("Becker");
    binarySearchTree.treeInsert("Brandon");   
     testMethod(Integer.toString(binarySearchTree.size()), "3");
    
    // Testing inorderWalk() function
    Object names[] = binarySearchTree.inorderWalk();
    for(int i = 0; i < names.length; i++)
      System.out.println(names[i]);
     
     // Testing search() function
     testMethod(String.valueOf(binarySearchTree.treeSearch("Brandon")), "true");
     
     // Testing treeDelete() function
     binarySearchTree.treeDelete("Brandon");
     testMethod(String.valueOf(binarySearchTree.treeSearch("Brandon")), "false");
     testMethod(Integer.toString(binarySearchTree.size()), "2");
     
     // Testing treeSuccessor() function
    //testMethod(binarySearchTree.treeSuccessor("Becker"), "Brandon");
    
    // Testing treePredecessor() function
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