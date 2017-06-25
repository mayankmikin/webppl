package com.studybro.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class ClassName 
{
	@GraphId
	private Long id;
	
	private String classname;
	// many to many mapping one subject can have many videos which are linked via classlevel(class 11 , class 12) 
	@Relationship(type="CLASS_IS", direction = Relationship.UNDIRECTED)
    private Set<VideoUrlNeo> videourls= new HashSet<VideoUrlNeo>();
	
	@Relationship(type="SUBJECT_IS", direction = Relationship.UNDIRECTED)
    private Set<SubjectName> subjects= new HashSet<SubjectName>();

	
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
	public Set<VideoUrlNeo> getVideourls() {
		return videourls;
	}
	public void setVideourls(Set<VideoUrlNeo> videourls) {
		this.videourls = videourls;
	}
	public Set<SubjectName> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<SubjectName> subjects) {
		this.subjects = subjects;
	}
	public ClassName(String classname) {
		super();
		this.classname = classname;
	}
	public ClassName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassName(Long id, String classname, Set<VideoUrlNeo> videourls,
			Set<SubjectName> subjects) {
		super();
		this.id = id;
		this.classname = classname;
		this.videourls = videourls;
		this.subjects = subjects;
	}
	
	
	
}
