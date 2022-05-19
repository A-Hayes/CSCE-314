/*****************************************
** File:    ParentNode.java
** Project: CSCE 314 Project 1, Fall 2020
** Author:  Asa Hayes & Isabel Ramirez
** Date:    7 November, 2020
** Section: 502
** E-mail:  asahayes@tamu.edu + isabel.ramirez@tamu.edu
**
** This file implements the ParentNode class derived from
** the MerkleNode super class. Parent nodes require the left
** and right children as data members as well as a method that
** enables concatenation of children hashes.
***********************************************/
package project;

public class ParentNode extends MerkleNode {
	
	// constructor using children nodes
	ParentNode(MerkleNode lt, MerkleNode rt) {
		left = lt;
		right = rt;
		hashValue = hashCode();
	}
	
	// getters for retrieving the left and right children nodes
  	public MerkleNode getLeftChild() { return this.left; }
  	public MerkleNode getRightChild() { return this.right; }
  
  	
  	// setters for the left and right children nodes
  	public void setLeftChild(MerkleNode lChild) { this.left = lChild; }
  	public void setRightChild(MerkleNode rChild) { this.right = rChild; }

  	
    //---------------------------------------------------------
    // Name: hashCode
    // PreCondition: Must have at least one child node.
    // PostCondition: Computes the hash value from the children(s)
    //                hash value(s). Hash is stored in the node.
    //---------------------------------------------------------
	@Override
	public int hashCode() {
		// concatenate children's hash values
		final StringBuilder concat = new StringBuilder();
		concat.append(left.getHashValue());
		concat.append(right.getHashValue());
		
		// calculate hash of concatenation
		final int prime = 31;
		int result = 1;
		result = prime * result + concat.hashCode();
		
		return result;
	}
  	
	
    //---------------------------------------------------------
    // Name: equals
	// Used to aid the hashCode function of the ParentNode class.
    //---------------------------------------------------------
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParentNode other = (ParentNode) obj;
		if (left == null) {
			if (other.left != null) {
				return false;
			}
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null) {
				return false;
			}
		} else if (!right.equals(other.right))
			return false;
		
		return true;
	}

  	
  	
}
