package fr.epita.core.datamodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Identity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDENTITIES_ID")
	private long id;
	
	@Column(name="IDENTITIES_UID")
	private String uid;
	
	@Column(name="IDENTITIES_DISPLAYNAME")
	private String displayName;
	
	@Column(name="IDENTITIES_EMAIL")
	private String email;
	
	
	 /**
	 * Default constructor
	 */
	public Identity() {
		
	}
	
	
	/**
	 * @param uid
	 * @param displayName
	 * @param email
	 */
	public Identity(String uid, String displayName, String email) {
		this.uid = uid;
		this.displayName = displayName;
		this.email = email;
	}
	
	
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Identity [uid=" + uid + ", displayName=" + displayName + ", email=" + email + "]";
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	

}