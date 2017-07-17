package com.studybro.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "CLASS_IS")
public class CLASS_IS_Relationship 
{
	// this can be class 11 12 and any undergraduate
	
	@GraphId
	private Long id;
	
	private String classname;
	
	private String  semester;


	@EndNode
	private ClassName className;

	@StartNode
	private VideoUrlNeo videourl;
	
	public CLASS_IS_Relationship() {

		// TODO Auto-generated constructor stub
	}

	public CLASS_IS_Relationship(String classname, String semester) {
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

	public ClassName getClassName() {
		return className;
	}

	public void setClassName(ClassName className) {
		this.className = className;
	}

	public VideoUrlNeo getVideourl() {
		return videourl;
	}

	public void setVideourl(VideoUrlNeo videourl) {
		this.videourl = videourl;
	}
	
	
	

}
