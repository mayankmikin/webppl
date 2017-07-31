package com.studybro.model;

import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity
public class Playlists {

	@GraphId
	private Long id;
	
	private String playlistname;
	// front relationship
	@Relationship(type = "PLAYLISTS_VIDEOS_ARE", direction = Relationship.UNDIRECTED)
	private Set<VideoUrlNeo> videos;
	
	//back relationship
	@Relationship(type = "CHAP_PLAYLIST_IS", direction = Relationship.UNDIRECTED)
	private Set<ChapterOrUniversity> chaporuniversity;
	
	
	
	public Set<VideoUrlNeo> getVideos() {
		return videos;
	}


	public void setVideos(Set<VideoUrlNeo> videos) {
		this.videos = videos;
	}


	public Set<ChapterOrUniversity> getChaporuniversity() {
		return chaporuniversity;
	}


	public void setChaporuniversity(Set<ChapterOrUniversity> chaporuniversity) {
		this.chaporuniversity = chaporuniversity;
	}


	public Playlists(String playlistname) {
		super();
		this.playlistname = playlistname;
	}


	public String getPlaylistname() {
		return playlistname;
	}



	@Override
	public String toString() {
		return "Playlists [id=" + id + ", playlistname=" + playlistname + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((playlistname == null) ? 0 : playlistname.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlists other = (Playlists) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (playlistname == null) {
			if (other.playlistname != null)
				return false;
		} else if (!playlistname.equals(other.playlistname))
			return false;
		return true;
	}



	public void setPlaylistname(String playlistname) {
		this.playlistname = playlistname;
	}



	public Playlists() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	

}
