/*****************************************
** File:    LeafNode.java
** Project: CSCE 314 Project 1, Fall 2020
** Author:  Asa Hayes & Isabel Ramirez
** Date:    7 November, 2020
** Section: 502
** E-mail:  asahayes@tamu.edu + isabel.ramirez@tamu.edu
**
** This file implements the LeafNode class derived from
** the MerkleNode super class. Leaf nodes require data
** blocks to perform the hash function to determine the 
** hash value.
***********************************************/
package project;

public class LeafNode extends MerkleNode {
	
	private Person dataBlock; // each person's data is kept private and used for leaf's hash value
	
	// Constructor using a person's info (dataBlock)
	LeafNode(Person p) {
		dataBlock = p;
		hashValue = hashCode();
	}
	
	// setter for dataBlock (person's info)
	public void setDataBlock(Person toSet) {
		dataBlock = toSet;
		hashValue = hashCode();
	}
	
	// getter for dataBlock (person's info)
	public Person getDataBlock() { return dataBlock; }
	
	
    //---------------------------------------------------------
    // Name: hashCode
    // PreCondition: dataBlock must be set.
    // PostCondition: Calculates and sets hashValue from the data
    //                members of the dataBlock (person's information).
    //---------------------------------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataBlock == null) ? 0 : dataBlock.hashCode());
		return result;
	}

	
    //---------------------------------------------------------
    // Name: equals
	// Used to aid the hashCode function of the LeafNode class.
    //---------------------------------------------------------
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeafNode other = (LeafNode) obj;
		if (dataBlock == null) {
			if (other.dataBlock != null)
				return false;
		} else if (!dataBlock.equals(other.dataBlock))
			return false;
		return true;
	}

}
