package com.studybro.model;

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
    
	@Relationship(type = "DESCRIPTION", direction=Relationship.UNDIRECTED)
    private Set<VideoDescription> description ;
    
/*    @Relationship(type = "SEGMENT_IS", direction = Relationship.UNDIRECTED)
    private SegmentName segments;*/
	
	@Relationship(type = "PLAYLISTS_VIDEOS_ARE", direction = Relationship.UNDIRECTED)
    private Set<Playlists> playlists;
	
	public Set<Playlists> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Set<Playlists> playlists) {
		this.playlists = playlists;
	}

	public Set<VideoDescription> getDescription() {
		return description;
	}

	public void setDescription(Set<VideoDescription> description) {
		this.description = description;
	}

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


	
	
}
