/*****************************************
** File:    Driver.java
** Project: CSCE 314 Project 1, Fall 2020
** Author:  Asa Hayes & Isabel Ramirez
** Date:    7 November, 2020
** Section: 502
** E-mail:  asahayes@tamu.edu + isabel.ramirez@tamu.edu
**
**   This file contains the main driver program for Project 1.
** This project intends to make a simple demonstration of the capabilities of
** Merkle Tree, in the context of a voting verification system. The end product
** should take in an input from the user and create a Merkle tree, with each 
** data block being a piece of voter information. It will then be compared to 
** an existing (premade for purposes of the project) tree to verify that the 
** information is correct.
***********************************************/

/*
** This program is a simple Java implementation of Merkle Trees. The leaves are represented 
** by leafNode objects (derived from the merkleNode class). Each leaf contains a hash value 
** determined by applying a hash function to a block of data input. Non-leaf nodes within the 
** tree are represented by parentNode objects (also derived from the merkleNode class). These 
** nodes contain a hash value determined by applying a hash function to a concatenation of the 
** node's children. The merkleTree class creates the structure of the tree from these merkleNodes,
** with the root of the tree being the hash root.
**
** The application of our implementation is to ensure that crucial information in ballots (first 
** and last name, address, government ID, and candidates/propositions voted for) is not tampered 
** with from the time the ballot was cast to when the ballot is counted. At the time of counting,
** the ballot's information will be separated into data blocks and used to construct a merkle tree
** with a hash root that represents its data in a secure and concise way. This root will be compared
** to the hash root computed when the ballot was cast. Any inconsistencies between the two hash roots
** indicate that the ballot was tampered with. This method is not based on any legitimate existing 
** method for ballot verification; it is just a idea to demonstrate the functionality of the Merkle 
** Tree that came to us from the election this week.
*/

package project;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  System.out.println("TESTS FOR BUILDING TREE\n");
		  // data we will build test merkle tree from
		  Person p1 = new Person("ABC123",  "Jane Doe", "9876 Main St., Houston, TX 12345", "None");
		  Person p2 =  new Person("XYZ987",  "James Doe", "1234 City Dr., College Station, TX 45673", "None");
		  LeafNode l1 = new LeafNode(p1);
		  LeafNode l2 = new LeafNode(p2);

		  ArrayList<MerkleNode> lvs = new ArrayList<MerkleNode>();
		  lvs.add(l1);
		  lvs.add(l2);
		  
		  // Hash values must match
		  MerkleTree t1 = new MerkleTree();
		  t1.buildTree(lvs);
		  System.out.println("BuildTree computed hash: " + t1.getHashRoot());

		  
		  // VERIFICATION FUNCTION TESTS
		  Person p3 = new Person("aBc987", "JaNe DoEe", "9876 MaIn St., HOusTon, Tx 12345", "None");
		  System.out.println("Should be false: " + t1.verification(p3));
		  System.out.println("Should be true: " + t1.verification(p1));
		  System.out.println("Should be true: " + t1.verification(p2));
		  System.out.println("\n");
		  
		  
		  //Start of file I/O tests
		  //ONLY NEW CODE TO DEMO FOR LAST PRESENTATION, 
		  //ALL OTHER CODE SHOWN IN 1ST DEMONSTRATION
		  Scanner infile = null;
		  try
		  {
			  // file is inside package
			  infile = new Scanner(new FileReader("./src/project/voterRoll.txt")).useDelimiter("\\n");
		  }
		  catch (FileNotFoundException e)
		  {
			  System.out.println("File not found");
			  e.printStackTrace(); // prints error(s)
			  System.exit(0); // Exits entire program
		  }
		  
		  ArrayList<MerkleNode> voteRoll = new ArrayList<MerkleNode>();		// to store leafnodes of people who are registered to vote
			
		  do {
			  // collect each voter's info
			  String[] voteInfo = infile.next().split(", |,");
			  
			  // add voter to tree as leaf node
			  LeafNode tempVote = new LeafNode(new Person(voteInfo[0], voteInfo[1], voteInfo[2], voteInfo[3]));
			  voteRoll.add(tempVote);
		  } while (infile.hasNext());
		  infile.close();
		  

		  // build tree of registered voters
		  MerkleTree voteRollTree = new MerkleTree();
		  voteRollTree.buildTree(voteRoll);
		  
		  
		  
		  // COLLECTING INFO OF PEOPLE WHO VOTED
		  try
		  {
			// file is inside package
			infile = new Scanner(new FileReader("./src/project/actualVotes.txt")).useDelimiter("\\n");
		  }
		  catch (FileNotFoundException e)
		  {
			  System.out.println("File not found");
			  e.printStackTrace(); // prints error(s)
			  System.exit(0); // Exits entire program
		  }
			
		  ArrayList<MerkleNode> actualVote = new ArrayList<MerkleNode>();	// to store leafnodes of people who voted
			
		  do {
			  // collect each voter's info
			  String[] voteInfo = infile.next().split(", |,");
			
			  // add voter to tree as leaf node
			  LeafNode tempVote = new LeafNode(new Person(voteInfo[0], voteInfo[1], voteInfo[2], voteInfo[3]));
			  actualVote.add(tempVote);
		  } while (infile.hasNext());
		  infile.close();
		
		  
		  // build tree of people who voted
		  MerkleTree actualVoteTree = new MerkleTree();
		  actualVoteTree.buildTree(actualVote);
			
		  
		  System.out.println("Voter Roll Tree Hash: " + voteRollTree.getHashRoot());
		  System.out.println();
		  System.out.println("Hash Value mismatch: Invalid votes were detected!");
		  
		  
		  // retrieving invalid voters
		  ArrayList<MerkleNode> invalidVoters = voteRollTree.getInvalidVoters(actualVoteTree);
		  
		  // display each invalid voter using toString
		  System.out.println("\nVoters not in state record: ");
		  for(MerkleNode badVote : invalidVoters) {
			  System.out.println(((LeafNode) badVote).getDataBlock().toString());
		  }	
	}

}
