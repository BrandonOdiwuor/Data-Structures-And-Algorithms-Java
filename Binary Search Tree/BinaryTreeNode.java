public class BinaryTreeNode{
  private BinaryTreeNode parent;
  private BinaryTreeNode left;
  private BinaryTreeNode right;
  private String key;
  
  public BinaryTreeNode(String _key){key = _key;}
  
  public String getKey(){return key;}
  
  public void setKey(String _key){key = _key;}
  
  public BinaryTreeNode getParent(){return parent; }
  
  public void setParent(BinaryTreeNode _parent){parent = _parent;}
  
  public BinaryTreeNode getLeft(){return left;}
  
  public void setLeft(BinaryTreeNode _left){left = _left;}
  
  public BinaryTreeNode getRight(){return right;}
  
  public void setRight(BinaryTreeNode _right){right = _right;}
  
}