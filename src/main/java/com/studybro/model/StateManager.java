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
public class StateManager 
{
	@GraphId
	private Long id;
	/*state name will be the page name or state in angular app */
	private String statename;
	
	@Relationship(type="TAB_IS", direction = Relationship.UNDIRECTED)
    private Set<TabManager> tabs;
    private String mainheading;
    private String subheading;
    
	public Set<TabManager> getTabs() {
		return tabs;
	}

	public void setTabs(Set<TabManager> tabs) {
		this.tabs = tabs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public String getMainheading() {
		return mainheading;
	}

	public void setMainheading(String mainheading) {
		this.mainheading = mainheading;
	}

	public String getSubheading() {
		return subheading;
	}

	public void setSubheading(String subheading) {
		this.subheading = subheading;
	}

	


}
