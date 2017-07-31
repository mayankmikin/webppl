package com.studybro.model;

import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity
public class Course {

	@GraphId
	private Long id;

	private String courseName;
	
	@Relationship(type="COURSE_SUBJECT_IS", direction = Relationship.UNDIRECTED)
	private Set<SubjectName> subjects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<SubjectName> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<SubjectName> subjects) {
		this.subjects = subjects;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
