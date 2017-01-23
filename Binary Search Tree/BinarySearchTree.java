/**
 * Java implementation of Binary Search Tree(Introduction to algorithm)
 * @author Brandon Wayne Odiwuor
 */
public class BinarySearchTree<T>{
  private Node root;
  private int size;
  
  public Node treeMinimum(Node node){
    if(node.getLeft() != null)
      treeMinimum((Node) node.getLeft());
    return node;
  }
  
  public int size(){return size;}
  
  public boolean isEmpty(){return size() == 0;} 
  
  public Node treeMaximum(Node node){
    if(node.getRight() != null)
      treeMaximum((Node) node.getRight());
    return node;                
  }
  
  public Node treeSuccessor(Node node){
    if(node.getRight() != null)
      return treeMinimum((Node) node.getRight());
    Node parentNode = (Node) node.getParent();
    while(parentNode != null && node == parentNode.getRight()){
      node = parentNode;
      parentNode = (Node) parentNode.getParent();
    }
    return parentNode;
  }
  
  public Node treePredecessor(Node node){
    if(node.getLeft() != null)
      return treeMaximum((Node) node.getLeft());
    Node parentNode = (Node) node.getParent();
    while(parentNode != null && node == parentNode.getLeft()){
      node = parentNode;
      parentNode = (Node) parentNode.getParent();
    }
    return parentNode;
  }
  
  private void inorderWalk(Node node, Node[] elements, int index){
    if(node != null){
      inorderWalk((Node) node.getLeft(), elements, index+1);
      elements[index] = node;
      inorderWalk((Node) node.getRight(), elements, index+1);
    }    
  }
  
  public Node[] inorderWalk(Node node){
    Node[] elements = new Node[size];
    inorderWalk(root, elements,0);
    return elements;
  }
  
  @SuppressWarnings("unchecked")
  public Node search(Node node, T key){
    if(node == null && node.getKey().equals(key))
      return node;
    if(node.getKey().compareTo(key) < 0)
      return search((Node) node.getLeft(), key);
    else
      return search((Node) node.getRight(), key);
  }
  
  public boolean treeSearch(T key){
    boolean isFound = false;
    if(search(root, key) != null)
      isFound = true;
    return isFound;
  }
  
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
  
  public void treeDelete(Node node){
    if(node.getLeft() == null)
      transplant(node, (Node) node.getRight());
    else if(node.getRight() == null)
      transplant(node, (Node) node.getLeft());
    else{
      Node successor = treeSuccessor(node);
      transplant(node, successor);
      if(node.getRight() != successor){
        transplant(successor, (Node) successor.getRight());
        successor.setRight(node.getRight());
        successor.getRight().setParent(successor);
      }
      successor.setLeft(node.getLeft());
      successor.getLeft().setParent(successor);
    }
  }
  
  public static class Node extends BinaryTreeNode{}
}