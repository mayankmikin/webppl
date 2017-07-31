package com.studybro.relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.studybro.model.ChapterOrUniversity;
import com.studybro.model.Playlists;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "CHAP_PLAYLIST_IS")
public class CHAP_PLAYLIST_IS_Relationship {
	// this can be class 11 12 and any undergraduate

	@GraphId
	private Long id;

	@StartNode
	private ChapterOrUniversity CHAPORUNIVERSITY;

	@EndNode
	private Playlists playlists;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ChapterOrUniversity getCHAPORUNIVERSITY() {
		return CHAPORUNIVERSITY;
	}

	public void setCHAPORUNIVERSITY(ChapterOrUniversity cHAPORUNIVERSITY) {
		CHAPORUNIVERSITY = cHAPORUNIVERSITY;
	}

	public Playlists getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Playlists playlists) {
		this.playlists = playlists;
	}

	
}
