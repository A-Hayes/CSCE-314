/*****************************************
** File:    MerkleTree.java
** Project: CSCE 314 Project 1, Fall 2020
** Author:  Asa Hayes & Isabel Ramirez
** Date:    7 November, 2020
** Section: 502
** E-mail:  asahayes@tamu.edu + isabel.ramirez@tamu.edu
**
**   This file contains the declarations for the Merkle
** tree class.  The methods include getters for the
** right and left branches, methods for building the tree, 
** returning the hash root, verifying the existence of a node,
** and returning invalid nodes. Data members include a vector of nodes
** for the leaf nodes and the hash root.
**
***********************************************/
package project;
import java.util.ArrayList;

public class MerkleTree {
	
	private MerkleNode root;	// merkle root
	private ArrayList<MerkleNode> leaves;	// contains the tree's leaves
	
	
	// Default Constructor
	MerkleTree() {
		root = null;
	}
	
	
	//---------------------------------------------------------
	// Name: getHashRoot
	// Returns the hash root of the tree.
	//---------------------------------------------------------
	public int getHashRoot() { return root.hashValue; }
	
	
	//---------------------------------------------------------
	// Name: buildTree
	// PreCondition: MerkleTree must be empty.
	// PostCondition: Constructs the merkle tree from all the
	//                voters data.
	//---------------------------------------------------------
	public void buildTree(ArrayList<MerkleNode> voters) {
		ArrayList<MerkleNode> tempNodes = new ArrayList<MerkleNode>();
		// store the leaves in the tree leaves vector
		leaves = voters;
		
		// continue creating parent nodes as long as there are enough child nodes
		while ((voters.size() != 1) && (voters.size() != 0)) {
			
			// starting at height 0 of the tree, up to the root
			for (int i = 0; i < voters.size(); i = i+2) {
				if (i != voters.size()-1) { // there is a node to the right of this node
					 // calculate the hash of the new parent node from this node and the one to the right of it
					tempNodes.add(new ParentNode(voters.get(i), voters.get(i+1)));
				}
				else {	// there is no node to the right of this node; odd number leaves
					tempNodes.add(voters.get(i));
				}
			}
			
			// repeat the process of creating parent nodes for the next height level
			voters = tempNodes;
			tempNodes.clear();
		}
		
		// last remaining node is the root
		root = leaves.get(0);
	}
	
	
	//---------------------------------------------------------
	// Name: verification
	// PreCondition: none. 
	// PostCondition: Returns true if this person's data can be
	//                found within the tree (it is accurate/
	//                has not been manipulated)
	//---------------------------------------------------------
	public boolean verification(Person p) {
		// compute the hash of this person's data
		LeafNode temp = new LeafNode(p);
		int tempHash = temp.getHashValue();
		
		// check if the hash of this person's data is in one of the nodes of the tree
		for (MerkleNode leaf : leaves) {
			if (tempHash == leaf.hashValue) {
				return true;
			}
		}
		
		return false;	// hash not found in the tree
	}

	
	//---------------------------------------------------------
	// Name: getInvalidVoters
	// PreCondition: Merkle Tree must not be empty.
	// PostCondition: Returns a vector containing the leaf nodes
	//               that were constructed from invalid data (invalid votes).
	//---------------------------------------------------------
	public ArrayList<MerkleNode> getInvalidVoters(MerkleTree invalidTree) {
		ArrayList<MerkleNode> invalid = new ArrayList<MerkleNode>();
		LeafNode temp;
		
		// iterate through the leaves of the invalid tree and check if they exist in the valid tree
		for (MerkleNode leaf : invalidTree.leaves) {
			// cast to a LeafNode object to be able to access dataBlock (Person)
			temp = ((LeafNode) leaf);
			
			if (!verification(temp.getDataBlock())) {	// invalid voter identified
				invalid.add(temp);
			}
		}
		
		return invalid;
	}

}
