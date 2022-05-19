/*****************************************
** File:    Person.java
** Project: CSCE 314 Project 1, Fall 2020
** Author:  Asa Hayes & Isabel Ramirez
** Date:    7 November, 2020
** Section: 502
** E-mail:  asahayes@tamu.edu + isabel.ramirez@tamu.edu
**
**   This file contains the declarations for the Person class. 
** This class will serve as a data block from which the Merkle Tree is 
** built. It will contain the private voter information. The methods 
** include getters and setters for the data members, and constructors
** for building the "Person" from data.
**
***********************************************/
package project;

public class Person {
	// data members represent a person's information stored in the county's system
	private String govID;
	private String fullName;
	private String address;
	private String partyAff;
	
	// Constructor using a person's information
	Person(String id, String name, String addr, String party) {
		govID = id;
		fullName = name;
		address = addr;
		partyAff = party;
	}
	
	// getters/setters for gov't id
	public String getGovID() { return govID; }
	public void setGovID(String govID) { this.govID = govID; }

	// getters/setters for full name
	public String getFullName() { return fullName; }
	public void setFullName(String fullName) { this.fullName = fullName; }

	// getters/setters for address
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
	
	// getters/setters for party affiliation
	public String getPartyAff() { return partyAff; }
	public void setPartyAff(String partyAff) { this.partyAff = partyAff; }

	
    //-------------------------------------------------------
	// Name: toString
	// PreCondition:  Person's data members must be set.
	// PostCondition: Used to display a person's information
	//				  if their vote was not valid.
	//---------------------------------------------------------
	@Override
	public String toString() {
		return "govID=" + govID + ", fullName=" + fullName + ", address=" + address + ", partyAff=" + partyAff;
	}

	
    //---------------------------------------------------------
    // Name: hashCode
    // PreCondition: Person's data members must be set.
    // PostCondition: Computes the hash by hashing each of the 
	// 				  data members. Used as an aid to compute the
	//				  hash of a leaf node.
    //---------------------------------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((govID == null) ? 0 : govID.hashCode());
		result = prime * result + ((partyAff == null) ? 0 : partyAff.hashCode());
		return result;
	}

	
    //---------------------------------------------------------
    // Name: equals
	// Used to aid the hashCode function of the Person class.
    //---------------------------------------------------------
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (govID == null) {
			if (other.govID != null)
				return false;
		} else if (!govID.equals(other.govID))
			return false;
		if (partyAff == null) {
			if (other.partyAff != null)
				return false;
		} else if (!partyAff.equals(other.partyAff))
			return false;
		return true;
	}

	
}
