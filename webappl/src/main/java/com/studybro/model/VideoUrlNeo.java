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
public class VideoUrlNeo 
{
	@GraphId
	private Long id;

    private String url_name;
 
    private String video_name;
    
    // many to many mapping one video url can be present inside many subjects
    @Relationship(type = "CLASS_IS", direction=Relationship.UNDIRECTED)
    private Set<ClassName> classname = new HashSet<ClassName>();
    @Relationship(type = "SUBJECT_IS", direction=Relationship.UNDIRECTED)
    private Set<SubjectName> subname = new HashSet<SubjectName>();
    
	public VideoUrlNeo() {

		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl_name() {
		return url_name;
	}

	public void setUrl_name(String url_name) {
		this.url_name = url_name;
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}



	

	public Set<ClassName> getClassname() {
		return classname;
	}

	public void setClassname(Set<ClassName> classname) {
		this.classname = classname;
	}

	public Set<SubjectName> getSubname() {
		return subname;
	}

	public void setSubname(Set<SubjectName> subname) {
		this.subname = subname;
	}

	
	
}
