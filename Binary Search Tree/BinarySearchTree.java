/**
 * Java implementatio of Binary Search Tree(Introduction to Algorithms)
 * @author Brandon Wayne Odiwuor
 */
public class BinarySearchTree{
  private Node root; // The root of the tree
  private int size; // Number of elements in the tree
  
  /**
   * Returns the number of elements stored in the Binary Search Tree
   * @return the number of elements stored in the Binary Search Tree
   */
  public int size(){return size;}
  
  /**
   * Returns a boolean indicating whether the Binary Search Tree is empty
   * @return true Binary Search Tree is empty, false otherwise
   */
  public boolean isEmpty(){return size() == 0;}
  
  /**
   * Adds a new item to the BinarySearchTree
   * @param key the item to be added to the binary search tree
   */
  public void treeInsert(String key){
    Node node = new Node(key);
    Node parentNode = null;
    Node currentNode = root;
    while(currentNode != null){
      parentNode = currentNode;
      if(currentNode.getKey().compareTo(key) < 0)
        currentNode = (Node) currentNode.getRight();
      else
        currentNode = (Node) currentNode.getLeft();
    }
    if(parentNode == null)
      root = node;
    else if(parentNode.getKey().compareTo(key) > 0){
      parentNode.setLeft(node);
      node.setParent(parentNode);
    }
    else{
      parentNode.setRight(node);
      node.setParent(parentNode);
    }      
    size++;
  }
  
  /**
   * Searches for a node with the key provided in the tree starting from
   * the node provided
   * @param node the node to start searching from
   * @param key the key being searched in the tree
   * @return the node with key provided, null if the no node has the key provided
   */
  private Node search(Node node, String key){
    if(node == null || node.getKey().compareTo(key) == 0)
      return node;
    else if(node.getKey().compareTo(key) > 0)
      return search((Node) node.getLeft(), key);
    else
      return search((Node) node.getRight(), key);
  }
  
  /**
   * Returns a boolean indicating whether there is a node in the tree
   * containing the key provided
   * @param key the key being searched in the tree
   * @return true there is a node in the tree containign the key provided
   */
  public boolean treeSearch(String key){
    boolean isFound = false;
    Node node = search(root, key);
    if(node != null)
      isFound = true;
    return isFound;
  }
  
  /**
   * Returns the node with the smallest key in the subtree rooted at the node provided
   * @param node the root of the subtree
   * @return the node with the smallest key in the subtree rooted at the node provided
   */
  private Node minimum(Node node){
    if(node.getLeft() != null)
      return minimum((Node) node.getLeft());
    else
      return node;
  }
  
  /**
   * With the help of minimim() returns the key contained in the smallest node in the tree
   * @return the key contained in the smallest node in the tree
   */
  public String treeMinimum(){
    if(size != 0)
      return minimum(root).getKey();
    else
      return null;
  }
  
  /**
   * Returns the node with the largest key in the subtree rooted at the node provided
   * @param node the root of the subtree
   * @return the node with the smallest key in the subtree rooted at the node provided
   */
  private Node maximum(Node node){
    if(node.getRight() != null)
      return maximum((Node) node.getRight());
    else
      return node;
  }
  
  /**
   * With the help of maximum() returns the key contained in the biggest node in the tree
   * @return the key contained in the largest node in the tree
   */
  public String treeMaximum(){
    if(size != 0)
      return maximum(root).getKey();
    else
      return null;
  }
  
  private Node successor(Node node){
    if(node.getRight() != null)
      return minimum((Node) node.getRight());
    Node parentNode = (Node) node.getParent();
    while(parentNode != null && node == parentNode.getRight()){
      node = parentNode;
      parentNode = (Node) parentNode.getParent();
    }
    return parentNode;
  }
  
  public String treeSuccessor(String key){
    Node node = search(root, key);
    if(node != null)
      return successor(node).getKey();
    else 
      return null;
  }
  
  private Node predecessor(Node node){
    if(node.getLeft() != null)
      return maximum((Node) node.getLeft());
    Node parentNode = (Node) node.getParent();
    while(parentNode != null && node == parentNode.getLeft()){
      node = parentNode;
      parentNode = (Node) parentNode.getParent();
    }
    return parentNode;
  }
  
  public String treePredecessor(String key){
    Node node = search(root, key);
    if(node != null)
      return predecessor(node).getKey();
    else 
      return null;
  }
  
  public void transplant(Node subtreeOneRoot, Node subtreeTwoRoot){
    if(subtreeOneRoot.getParent() == null)
      root = subtreeTwoRoot;
    else if(subtreeTwoRoot.getParent().getLeft() == subtreeOneRoot)
      subtreeOneRoot.getParent().setLeft(subtreeTwoRoot);
    else
      subtreeOneRoot.getParent().setRight(subtreeTwoRoot);
    if(subtreeTwoRoot != null)
      subtreeTwoRoot.setParent(subtreeOneRoot.getParent());
  }
  
  /**
   * Deletes a node from the tree
   * @param node the node to be deleted from the tree
   */
  public void delete(Node node){
    if(node.getLeft() == null)
      transplant(node, (Node) node.getRight());
    else if(node.getRight() == null)
      transplant(node, (Node) node.getLeft());
    else{
      Node successorNode = successor(node);
      if(node != (Node) successorNode.getParent()){
        transplant(successorNode, (Node) successorNode.getRight());
        successorNode.setRight(node.getRight());
        successorNode.getRight().setParent(successorNode);
      }
      transplant(node, successorNode);
      successorNode.setLeft(node.getLeft());
      successorNode.getLeft().setParent(successorNode);
    }
    size--;
  }
  
  /**
   * With the help of delete() function removes the node containing the key provided from the tree
   * @param key the key whose node is to be deleted from the tree
   */
  public void treeDelete(String key){
    Node node = search(root, key);
    if(node != null)
      delete(node);
  }
  
  /**
   * An inner class to keep information about binary search tree node
   */
  public static class Node extends BinaryTreeNode{
    public Node(String key){super(key);}
  }
}
