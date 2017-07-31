package com.studybro.model;

import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity
public class SubjectName {

	@GraphId
	private Long id;

	private String subname;
	
	//back relationship
	@Relationship(type = "COURSE_SUBJECT_IS", direction = Relationship.UNDIRECTED)
	private Set<Course> course;
	
	//front relationship
	@Relationship(type = "SUBJECT_CLASS_IS", direction = Relationship.UNDIRECTED)
	private Set<ClassOrSemName> className;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	public Set<ClassOrSemName> getClassName() {
		return className;
	}

	public void setClassName(Set<ClassOrSemName> className) {
		this.className = className;
	}

	public SubjectName() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

}
