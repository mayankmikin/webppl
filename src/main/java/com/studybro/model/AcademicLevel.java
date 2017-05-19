package com.studybro.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class AcademicLevel 
{
	// this can be class 11 12 and any undergraduate
	
	@GraphId
	private Long id;
	
	private String classname;
	
	private String  semester;

	private VideoUrlNeo videolink;
	
	public AcademicLevel() {
		super();
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

	public VideoUrlNeo getVideolink() {
		return videolink;
	}

	public void setVideolink(VideoUrlNeo videolink) {
		this.videolink = videolink;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
