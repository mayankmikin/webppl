package com.studybro.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "COURSE_IS")
public class COURSE_IS_Relationship {

	@GraphId
	private Long id;

	@StartNode
	private Course course;
	@EndNode
	private Playlists playlists;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Playlists getPlaylists() {
		return playlists;
	}
	public void setPlaylists(Playlists playlists) {
		this.playlists = playlists;
	}

	

}
