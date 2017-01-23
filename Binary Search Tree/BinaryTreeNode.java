public class BinaryTreeNode{
  private BinaryTreeNode parent;
  private BinaryTreeNode left;
  private BinaryTreeNode right;
  
  private BinaryTreeNode getParent(){return parent; }  
  
  private void setParent(BinaryTreeNode p){parent = p; }
  
  public BinaryTreeNode getLeft(){return left;}
  
  public void setLeft(BinaryTreeNode l){left = l;}
  
  public BinaryTreeNode getRight(){return right;}
  
  public void setRight(BinaryTreeNode r){right = r;}
  
}