package com.studybro.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class MenuItem implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2449619512451683832L;

	@GraphId
	private Long id;
	
	private String name;
	
	private ArrayList<SubItem> subItems;
	
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

	public ArrayList<SubItem> getSubItems() {
		return subItems;
	}

	public void setSubItems(ArrayList<SubItem> subItems) {
		this.subItems = subItems;
	}

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuItem(Long id, String name, ArrayList<SubItem> subItems,
			String iconClass) {
		super();
		this.id = id;
		this.name = name;
		this.subItems = subItems;
		this.iconClass = iconClass;
	}

	
	
	
	
}
