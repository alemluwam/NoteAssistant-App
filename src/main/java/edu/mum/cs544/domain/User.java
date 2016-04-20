/**
 * 
 */
package edu.mum.cs544.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * @author haftomtesfay & team
 *
 */
@Entity
public class User {
	@Id
	@GeneratedValue
	private Long userId;

	@NotNull
	@Column(columnDefinition = "varchar(32)")
	private String userName;

	@NotNull
	@Column(columnDefinition = "varchar(32)")
	private String password;

	@Column(columnDefinition = "varchar(20)")
	private String role;

	@OneToMany(mappedBy = "user")
	private List<Contact> contacts = new ArrayList<Contact>();

	@OneToMany(mappedBy = "user")
	private List<Section> sections = new ArrayList<Section>();

	public User() {

	}

	
	
	// GETTERS and SETTERS
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}


	// TO STRING
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
	
}
