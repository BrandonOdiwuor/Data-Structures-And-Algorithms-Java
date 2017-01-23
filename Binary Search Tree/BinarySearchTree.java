public class BinarySearchTree{
  private Node root;
  
  public Node treeMinimum(Node node){
    if(node.getLeft() != null)
      treeMinimum((Node) node.getLeft());
    return node;
  }
  
  public Node treeMaximum(Node node){
    if(node.getRight() != null)
      treeMaximum((Node) node.getRight());
    return node;                
  }
  
  public Node treeSuccessor(Node node){
    
  }
  
  public static class Node extends BinaryTreeNode{}
}