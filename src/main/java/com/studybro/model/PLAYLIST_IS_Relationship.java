package com.studybro.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "PLAYLIST_IS")
public class PLAYLIST_IS_Relationship {
	// this can be class 11 12 and any undergraduate

	@GraphId
	private Long id;

	@StartNode
	private Playlists className;

	@EndNode
	private VideoUrlNeo course;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Playlists getClassName() {
		return className;
	}

	public void setClassName(Playlists className) {
		this.className = className;
	}

	public VideoUrlNeo getCourse() {
		return course;
	}

	public void setCourse(VideoUrlNeo course) {
		this.course = course;
	}

	
}
