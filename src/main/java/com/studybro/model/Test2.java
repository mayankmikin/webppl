package com.studybro.model;

import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Test2 
{
	@GraphId
	private Long id;
	
	String className;
	
	@Relationship(type="CLASS_IS", direction = Relationship.INCOMING)
    private Set<TestRelationship> relates;
	
}
