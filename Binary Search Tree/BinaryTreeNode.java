public class BinaryTreeNode< T extends Comparable<? super T> >{
  private BinaryTreeNode parent;
  private BinaryTreeNode left;
  private BinaryTreeNode right;
  public T key;
  
  public BinaryTreeNode getParent(){return parent; }  
  
  public void setParent(BinaryTreeNode p){parent = p; }
  
  public BinaryTreeNode getLeft(){return left;}
  
  public void setLeft(BinaryTreeNode l){left = l;}
  
  public BinaryTreeNode getRight(){return right;}
  
  public void setRight(BinaryTreeNode r){right = r;}
  
  public T getKey(){return key;}
  
  public void setKey(T k){key = k;}
  
}