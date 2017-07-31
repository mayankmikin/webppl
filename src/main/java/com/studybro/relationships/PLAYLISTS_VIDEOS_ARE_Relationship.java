package com.studybro.relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.studybro.model.Course;
import com.studybro.model.Playlists;
import com.studybro.model.SubjectName;
import com.studybro.model.VideoUrlNeo;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "PLAYLISTS_VIDEOS_ARE")
public class PLAYLISTS_VIDEOS_ARE_Relationship {

	@GraphId
	private Long id;

	@StartNode
	private Playlists playslists;
	@EndNode
	private VideoUrlNeo videos;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Playlists getPlayslists() {
		return playslists;
	}
	public void setPlayslists(Playlists playslists) {
		this.playslists = playslists;
	}
	public VideoUrlNeo getVideos() {
		return videos;
	}
	public void setVideos(VideoUrlNeo videos) {
		this.videos = videos;
	}



}
