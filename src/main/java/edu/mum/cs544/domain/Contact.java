/**
 * 
 */
package edu.mum.cs544.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/**
 * @author haftomtesfay & team
 *
 */

@Entity
public class Contact {
	@Id
	@GeneratedValue
	private Long contactId;

	@NotNull
	@Column(columnDefinition = "varchar(80)")
	private String contactName;

	@Column(columnDefinition = "varchar(255)")
	private String address;

	@Column(columnDefinition = "varchar(32)")
	private String homePhone;

	@Column(columnDefinition = "varchar(32)")
	private String mobile;

	@Email
	@Column(columnDefinition = "varchar(80)")
	private String email;

	@Column(columnDefinition = "text(4000)")
	private String info;

	@ManyToOne(optional = false)
	@JoinColumn(name = "userId")	// field name will be [userId] instead of [user_userId]
	private User user;

	public Contact() {

	}

	// GETTERS & SETTERS
	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + "]";
	}
	
}
