/**
 * 
 */
package edu.mum.cs544.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * @author haftomtesfay & team
 *
 */
@Entity
public class Section {

	@Id
	@GeneratedValue
	private Long sectionId;

	@NotNull
	@Column(columnDefinition = "varchar(60)")
	private String sectionName;

	@Column(columnDefinition = "varchar(20)")
	private String theme;

	@OneToMany(mappedBy = "section", fetch=FetchType.EAGER)
	private List<Note> notes = new ArrayList<Note>();

	@OneToMany(mappedBy = "section", fetch=FetchType.EAGER)
	private List<ToDoList> toDoLists = new ArrayList<ToDoList>();

	@ManyToOne
	@JoinColumn(name = "userId") 	// field name will be [userId] instead of [user_userId] in Section Table
	private User user;

	public Section() {

	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<ToDoList> getToDoLists() {
		return toDoLists;
	}

	public void setToDoLists(List<ToDoList> toDoLists) {
		this.toDoLists = toDoLists;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String toString(){
		
		return sectionName;
	}
	
}
