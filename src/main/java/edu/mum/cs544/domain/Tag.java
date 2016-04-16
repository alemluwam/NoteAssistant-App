/**
 * 
 */
package edu.mum.cs544.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author haftomtesfay
 *
 */
@Entity
public class Tag {
	@Id
	@GeneratedValue
	private Long tagId;
	private String tagName;

	@ManyToMany(mappedBy = "tags")
	private List<Note> notes = new ArrayList<Note>();

	public Tag() {
		super();
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
}
