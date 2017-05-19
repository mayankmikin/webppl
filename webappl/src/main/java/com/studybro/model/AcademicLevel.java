package com.studybro.model;

import java.util.ArrayList;
import java.util.Collection;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "CLASS_IS")
public class AcademicLevel 
{
	// this can be class 11 12 and any undergraduate
	
	@GraphId
	private Long id;
	
	private String classname;
	
	private String  semester;

	private Collection<String> nameOfRelationship = new ArrayList<>();

	@StartNode
	private SubjectName subjectName;

	@EndNode
	private VideoUrlNeo videourl;
	
	public AcademicLevel() {

		// TODO Auto-generated constructor stub
	}

	public AcademicLevel(String classname, String semester) {
		super();
		this.classname = classname;
		this.semester = semester;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Collection<String> getNameOfRelationship() {
		return nameOfRelationship;
	}

	public void setNameOfRelationship(Collection<String> nameOfRelationship) {
		this.nameOfRelationship = nameOfRelationship;
	}

	public SubjectName getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(SubjectName subjectName) {
		this.subjectName = subjectName;
	}

	public VideoUrlNeo getVideourl() {
		return videourl;
	}

	public void setVideourl(VideoUrlNeo videourl) {
		this.videourl = videourl;
	}
	
	
	

}
