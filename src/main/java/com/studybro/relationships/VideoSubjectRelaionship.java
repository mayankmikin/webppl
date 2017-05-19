package com.studybro.relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.studybro.model.SubjectName;
import com.studybro.model.VideoUrlNeo;

@RelationshipEntity(type="subject_is")
public class VideoSubjectRelaionship 
{
    @GraphId   
    private Long relationshipId;
    
    @Property  private String url_name;
    
    @StartNode
    private SubjectName subname;
    @EndNode
    private VideoUrlNeo urllink;
	public Long getRelationshipId() {
		return relationshipId;
	}
	public void setRelationshipId(Long relationshipId) {
		this.relationshipId = relationshipId;
	}
	public String getUrl_name() {
		return url_name;
	}
	public void setUrl_name(String url_name) {
		this.url_name = url_name;
	}
	public SubjectName getSubname() {
		return subname;
	}
	public void setSubname(SubjectName subname) {
		this.subname = subname;
	}
	public VideoUrlNeo getUrllink() {
		return urllink;
	}
	public void setUrllink(VideoUrlNeo urllink) {
		this.urllink = urllink;
	}
	public VideoSubjectRelaionship() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
