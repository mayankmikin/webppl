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
public class SubjectName 
{
	@GraphId
	private Long id;
	
	private String subname;
	// many to many mapping one subject can have many videos which are linked via classlevel(class 11 , class 12) 
	@Relationship(type="SUBJECT_IS", direction = Relationship.UNDIRECTED)
    private Set<VideoUrlNeo> videourls= new HashSet<VideoUrlNeo>();

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

	

	public void setId(Long id) {
		this.id = id;
	}

	public Set<VideoUrlNeo> getVideourls() {
		return videourls;
	}

	public void setVideourls(Set<VideoUrlNeo> videourls) {
		this.videourls = videourls;
	}

	

	
	
	
	
}
