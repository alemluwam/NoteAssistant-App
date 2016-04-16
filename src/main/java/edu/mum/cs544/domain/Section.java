/**
 * 
 */
package edu.mum.cs544.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * @author haftomtesfay
 *
 */
@Entity
public class Section {

	@Id @GeneratedValue
	private Long sectionId;
	@NotNull
	private String sectionName;
	private String theme;
	@OneToMany
	@JoinColumn(name="noteId")
	private List<Note> notes = new ArrayList<Note>();
	@OneToMany
	@JoinColumn(name="toDoListId")
	private List<ToDoList> toDoLists = new ArrayList<ToDoList>();
	public Section() {
		super();
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
	
}
