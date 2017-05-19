package com.studybro.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class VideoUrlNeo 
{
	@GraphId
	private Long id;

    private String url_name;
 
    private String video_name;
    
    @Relationship(type = "subject_is", direction=Relationship.UNDIRECTED)
    private SubjectName subname;
    @Relationship(type = "academic_level_is", direction=Relationship.UNDIRECTED)
    private AcademicLevel alevel;
    
	public VideoUrlNeo() {

		// TODO Auto-generated constructor stub
	}

	
	public VideoUrlNeo(String url_name, String video_name, SubjectName subname,
			AcademicLevel alevel) {
		super();
		this.url_name = url_name;
		this.video_name = video_name;
		this.subname = subname;
		this.alevel = alevel;
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

	public SubjectName getSubname() {
		return subname;
	}

	public void setSubname(SubjectName subname) {
		this.subname = subname;
	}

	public AcademicLevel getAlevel() {
		return alevel;
	}

	public void setAlevel(AcademicLevel alevel) {
		this.alevel = alevel;
	}

    

}
