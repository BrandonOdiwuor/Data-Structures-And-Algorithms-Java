import java.util.ArrayList;
/**
 * Java implementation of Binary Search Tree(Introduction to algorithm)
 * @author Brandon Wayne Odiwuor
 */
public class BinarySearchTree{
  private Node root;
  private int size;
  
  public int size(){return size;}
  
  public boolean isEmpty(){return size() == 0;} 
  
  /**
   * Adds a new item into the binary search tree
   * @param key the new item to be added into the tree
   */
  public void treeInsert(String key){
    Node newNode = new Node(key); // The node containing the key to be insterted into the tree
    Node currentNode = root;
    Node parentNode = null;
    while(currentNode != null){
      parentNode = currentNode;
      if(newNode.getKey().compareTo(currentNode.getKey()) < 0)
        currentNode = (Node) currentNode.getLeft();
      else
        currentNode = (Node) currentNode.getRight();
    }
    newNode.setParent(parentNode);
    if(parentNode == null)
      root = newNode;
    else if(newNode.getKey().compareTo(parentNode.getKey()) < 0)
      parentNode.setLeft(newNode);
    else
      parentNode.setRight(newNode);
    size++;
  }
  
  /**
   * Returns the node containing the smallest key starting from the node provided
   * @param node the node to start querrying from
   * @return the node containing smallest key starting from the node given
   */
  public Node treeMinimum(Node node){
    if(node.getLeft() != null)
      treeMinimum((Node) node.getLeft());
    return node;
  }
  
  /**
   * Returns the node containing the largest key starting from the node provided
   * @param node the node to start querrying from
   * @return the largest containing key starting from the node given
   */
  public Node treeMaximum(Node node){
    if(node.getRight() != null)
      treeMaximum((Node) node.getRight());
    return node;                
  }
  
  /**
   * 
   */
  public String treeSuccessor(String key){
    Node node = search(root, key);
    Node successor = _treeSuccessor(node);
    if(node != null && successor != null )
      return successor.getKey();
    else
      return null;
  } 
 
  /**
   * 
   */
  private Node _treeSuccessor(Node node){
    if(node.getRight() != null)
      return treeMinimum((Node) node.getRight());
    Node parentNode = (Node) node.getParent();
    while(parentNode != null && node == parentNode.getRight()){
      node = parentNode;
      parentNode = (Node) parentNode.getParent();
    }
    return parentNode;
  }
  
  
  private Node treePredecessor(Node node){
    if(node.getLeft() != null)
      return treeMaximum((Node) node.getLeft());
    Node parentNode = (Node) node.getParent();
    while(parentNode != null && node == parentNode.getLeft()){
      node = parentNode;
      parentNode = (Node) parentNode.getParent();
    }
    return parentNode;
  }
  
  /**
   * 
   */
  private void inorderWalk(Node node, ArrayList<String> elements){
    if(node != null){
      inorderWalk((Node) node.getLeft(), elements);
      elements.add(node.getKey());
      inorderWalk((Node) node.getRight(), elements);
    }    
  }
  
  /**
   * 
   */
  public Object[] inorderWalk(){
    ArrayList<String> elements = new ArrayList<>();
    inorderWalk(root, elements);
    return elements.toArray();
  }
  
  /**
   * 
   */
  private Node search(Node node, String key){
    if(node == null || node.getKey().equals(key))
      return node;
    if(key.compareTo(node.getKey()) < 0)
      return search((Node) node.getLeft(), key);
    else
      return search((Node) node.getRight(), key);
  }
  
  /**
   * 
   */
  public boolean treeSearch(String key){
    boolean isFound = false;
    if(search(root, key) != null)
      isFound = true;
    return isFound;
  }
  
  /**
   * 
   */
  public void transplant(Node node, Node newNode){
    if(node.getParent() == null)
      root = newNode;
    else if(node == node.getParent().getLeft())
      node.getParent().setLeft(newNode);
    else
      node.getParent().setRight(newNode);
    if(newNode != null)
      newNode.setParent(node.getParent());
  }
  
  /**
   * 
   */
  private void treeDelete(Node node){
    if(node.getLeft() == null)
      transplant(node, (Node) node.getRight());
    else if(node.getRight() == null)
      transplant(node, (Node) node.getLeft());
    else{
      Node successor = _treeSuccessor(node);
      transplant(node, successor);
      if(node.getRight() != successor){
        transplant(successor, (Node) successor.getRight());
        successor.setRight(node.getRight());
        successor.getRight().setParent(successor);
      }
      successor.setLeft(node.getLeft());
      successor.getLeft().setParent(successor);
    }
    size--;
  }
  
  /**
   * 
   */
  public void treeDelete(String key){
    Node node = search(root, key);
    if(node != null)
      treeDelete(node);
  }
  
  /**
   * 
   */
  public static class Node extends BinaryTreeNode{
    public Node(String key){super(key);}
  }
}