public class BinaryTreeNode{
  private BinaryTreeNode parent;
  private BinaryTreeNode left;
  private BinaryTreeNode right;
  public String key;
  
  public BinaryTreeNode(String _key){key = _key;}
  
  public BinaryTreeNode getParent(){return parent; }  
  
  public void setParent(BinaryTreeNode p){parent = p; }
  
  public BinaryTreeNode getLeft(){return left;}
  
  public void setLeft(BinaryTreeNode l){left = l;}
  
  public BinaryTreeNode getRight(){return right;}
  
  public void setRight(BinaryTreeNode r){right = r;}
  
  public String getKey(){return key;}
  
  public void setKey(String k){key = k;}
  
}