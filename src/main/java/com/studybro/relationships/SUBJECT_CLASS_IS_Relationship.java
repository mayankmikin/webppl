package com.studybro.relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.studybro.model.ClassOrSemName;
import com.studybro.model.Course;
import com.studybro.model.SubjectName;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "SUBJECT_CLASS_IS")
public class SUBJECT_CLASS_IS_Relationship {
	// this can be class 11 12 and any undergraduate

	@GraphId
	private Long id;

	@StartNode
	private SubjectName subjectName;
	
	@EndNode
	private ClassOrSemName classOrSemName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public SubjectName getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(SubjectName subjectName) {
		this.subjectName = subjectName;
	}

	public ClassOrSemName getClassOrSemName() {
		return classOrSemName;
	}

	public void setClassOrSemName(ClassOrSemName classOrSemName) {
		this.classOrSemName = classOrSemName;
	}

}
