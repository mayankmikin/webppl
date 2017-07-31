package com.studybro.model;

import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity
public class ClassOrSemName {

	@GraphId
	private Long id;

	private String classname;
	
	// front relationship
	@Relationship(type = "CLASS_CHAPTER_UNIVERSITY_IS", direction = Relationship.UNDIRECTED)
	private Set<ChapterOrUniversity> chapteroruniversity;
	// back relationship
	@Relationship(type = "SUBJECT_CLASS_IS", direction = Relationship.UNDIRECTED)
	private Set<SubjectName> subnames; 

	public Set<ChapterOrUniversity> getChapteroruniversity() {
		return chapteroruniversity;
	}

	public void setChapteroruniversity(Set<ChapterOrUniversity> chapteroruniversity) {
		this.chapteroruniversity = chapteroruniversity;
	}

	public Set<SubjectName> getSubnames() {
		return subnames;
	}

	public void setSubnames(Set<SubjectName> subnames) {
		this.subnames = subnames;
	}

	public ClassOrSemName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassOrSemName(String classname) {
		super();
		this.classname = classname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", classname=" + classname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((classname == null) ? 0 : classname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassOrSemName other = (ClassOrSemName) obj;
		if (classname == null) {
			if (other.classname != null)
				return false;
		} else if (!classname.equals(other.classname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
