package com.studybro.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class SubItem 
{
	@GraphId
	private Long id;
	
	private String name;
	private String state;
	private String iconClass;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIconClass() {
		return iconClass;
	}
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
	public SubItem(Long id, String name, String state, String iconClass) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.iconClass = iconClass;
	}
	public SubItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
