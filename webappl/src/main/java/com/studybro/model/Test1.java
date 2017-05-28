package com.studybro.model;

import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Test1 
{
	@GraphId
	private Long id;
	
	String videoUrl;
	
	@Relationship(type="CLASS_IS", direction = Relationship.UNDIRECTED)
    private Set<TestRelationship> relates;
	
	
}
