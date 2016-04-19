/**
 * 
 */
package edu.mum.cs544.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

/**
 * @author haftomtesfay & team
 *
 */

@Entity
public class Note {
	@Id
	@GeneratedValue
	private Long noteId;

	@NotNull
	@Column(columnDefinition = "varchar(80)")
	private String title;
	
	@NotNull
	@Column(columnDefinition = "varchar(4048)")
	private String content;
	
	@Column(columnDefinition = "varchar(128)")
	private String remark;
	
	@URL
	@Column(columnDefinition = "varchar(128)")
	private String link;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "sectionId")
	private Section section;
	
	@ManyToMany
	@JoinTable(name = "Note_Tag", joinColumns = @JoinColumn(name = "noteId"), inverseJoinColumns = @JoinColumn(name = "tagId"))
	private List<Tag> tags = new ArrayList<Tag>();
	
	public Note() {
		
	}

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	
	
}
