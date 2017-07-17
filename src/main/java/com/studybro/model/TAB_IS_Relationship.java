package com.studybro.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "TAB_IS")
public class TAB_IS_Relationship 
{
	// this can be class 11 12 and any undergraduate
	
	@GraphId
	private Long id;
	

	@EndNode
	private TabManager tabs;

	@StartNode
	private StateManager state;
	
}
