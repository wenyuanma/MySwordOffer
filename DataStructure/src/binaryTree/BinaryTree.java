package binaryTree;

import java.util.Stack;

public class BinaryTree {
	Node root = null;
	public BinaryTree(){
		
	}
	public BinaryTree(int rootdata){
		root.data = rootdata;
	}
	
	class Node{
		int data;
		Node leftChild = null;
		Node rightChild = null;
	}
	
	public void preOrderRecursive(Node node){
		if(node == null){
			return;
		}
		System.out.println(node.data+ " , ");
		preOrderRecursive(node.leftChild);
		preOrderRecursive(node.rightChild);
		
	}
	public void preOrder(BinaryTree tree){
		if(tree == null){
			return;
		}
		Node current = tree.root;
		Stack<Node> nodesStack = new Stack<Node>();
		while(current!=null || !nodesStack.isEmpty()){
			while(current != null){		
				System.out.println(current.data + " , ");
				nodesStack.push(current);
				current = current.leftChild;
			}
			if(!nodesStack.isEmpty()){
				current = nodesStack.pop().rightChild;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
	}

}
