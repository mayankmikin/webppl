package com.studybro.relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.studybro.model.ChapterOrUniversity;
import com.studybro.model.ClassOrSemName;
import com.studybro.model.Course;
import com.studybro.model.Playlists;
import com.studybro.model.SubjectName;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "CLASS_CHAPTER_UNIVERSITY_IS")
public class CLASS_CHAPTER_UNIVERSITY_IS_Relationship {

	@GraphId
	private Long id;

	@StartNode
	private ClassOrSemName classorsemname;
	
	@EndNode
	private ChapterOrUniversity chapteroruniversity;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ClassOrSemName getClassorsemname() {
		return classorsemname;
	}
	public void setClassorsemname(ClassOrSemName classorsemname) {
		this.classorsemname = classorsemname;
	}
	public ChapterOrUniversity getChapteroruniversity() {
		return chapteroruniversity;
	}
	public void setChapteroruniversity(ChapterOrUniversity chapteroruniversity) {
		this.chapteroruniversity = chapteroruniversity;
	}
	

}
