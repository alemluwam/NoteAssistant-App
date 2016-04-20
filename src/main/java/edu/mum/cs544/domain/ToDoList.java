/**
 * 
 */
package edu.mum.cs544.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author haftomtesfay & team
 *
 */

@Entity
public class ToDoList {

	@Id @GeneratedValue
	private Long toDoListId;
	
	@NotNull
	@Column(columnDefinition = "varchar(128)")
	private String title;
	
	@Column(columnDefinition = "varchar(2048)")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate = new Date();
	
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	@Temporal(TemporalType.DATE)
	private Date remainderStartDate;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "sectionId")
	private Section section;
	
	public ToDoList() {
		
	}
	
	public Long getToDoListId() {
		return toDoListId;
	}
	public void setToDoListId(Long toDoListId) {
		this.toDoListId = toDoListId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getRemainderStartDate() {
		return remainderStartDate;
	}
	public void setRemainderStartDate(Date remainderStartDate) {
		this.remainderStartDate = remainderStartDate;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	
	
	
}
