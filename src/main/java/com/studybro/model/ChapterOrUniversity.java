package com.studybro.model;

import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity
public class ChapterOrUniversity 
{
	@GraphId
	private Long id;
	
	private String chapter_universityName;
	
	// front relationship
	@Relationship(type = "CHAP_PLAYLIST_IS", direction = Relationship.UNDIRECTED)
	private Set<Playlists>playlists;
	
	// back relationship
	@Relationship(type = "CLASS_CHAPTER_UNIVERSITY_IS", direction = Relationship.UNDIRECTED)
	private Set<ClassOrSemName> classorsemname;
	
	public String getChapter_universityName() {
		return chapter_universityName;
	}
	public void setChapter_universityName(String chapter_universityName) {
		this.chapter_universityName = chapter_universityName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Playlists> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(Set<Playlists> playlists) {
		this.playlists = playlists;
	}
	public Set<ClassOrSemName> getClassorsemname() {
		return classorsemname;
	}
	public void setClassorsemname(Set<ClassOrSemName> classorsemname) {
		this.classorsemname = classorsemname;
	}
	
}
