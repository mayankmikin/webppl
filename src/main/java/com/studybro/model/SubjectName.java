package com.studybro.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class SubjectName 
{
	@GraphId
	private Long id;
	
	private String subname;
	
	private VideoUrlNeo videolink;

	public SubjectName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubjectName(String subname) {
		super();
		this.subname = subname;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((subname == null) ? 0 : subname.hashCode());
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
		SubjectName other = (SubjectName) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (subname == null) {
			if (other.subname != null)
				return false;
		} else if (!subname.equals(other.subname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubjectName [id=" + id + ", subname=" + subname + "]";
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
