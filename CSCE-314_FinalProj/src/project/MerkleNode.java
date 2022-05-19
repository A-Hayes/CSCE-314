/*****************************************
** File:    MerkleNode.java
** Project: CSCE 314 Project 1, Fall 2020
** Author:  Asa Hayes & Isabel Ramirez
** Date:    7 November, 2020
** Section: 502
** E-mail:  asahayes@tamu.edu + isabel.ramirez@tamu.edu
**
**   This file defines the abstract class MerkleNode
** which allows for the creation of nodes to compose the tree. 
***********************************************/
package project;

public abstract class MerkleNode {
	
	protected int hashValue;	// hash value of node
	MerkleNode left;	// left child of node
	MerkleNode right;	// right child of node
	
    //---------------------------------------------------------
    // Name: getHashValue
    // Returns the hash value of the nodes.
    //---------------------------------------------------------
	public int getHashValue() { return hashValue; }
	
	
    //---------------------------------------------------------
    // Name: hashCode (abstract)
    // This is an abstract function required to be implemented
    // by the subclasses to determine the hash value of each node.
    //---------------------------------------------------------
	public abstract int hashCode();

}
