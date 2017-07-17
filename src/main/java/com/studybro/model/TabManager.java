package com.studybro.model;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class TabManager 
{
	@GraphId
	private Long id;
	/*state name will be the page name or state in angular app */
	private String tabname;
	
	@Relationship(type="TAB_IS", direction = Relationship.UNDIRECTED)
	private StateManager state;
	
	/*icontext is mapped with <p> tag in html*/
	private String icontext;
	/*heading is mapped with <h3> tag in html*/
	private String heading;
	/*description will have contents of videos and chapter names*/
	private String Description;
	/*urlList consists of Chapters or Subjects of a semester  */
	private List<String> urlList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTabname() {
		return tabname;
	}
	public void setTabname(String tabname) {
		this.tabname = tabname;
	}
	public String getIcontext() {
		return icontext;
	}
	public void setIcontext(String icontext) {
		this.icontext = icontext;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public List<String> getUrlList() {
		return urlList;
	}
	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}
	public StateManager getState() {
		return state;
	}
	public void setState(StateManager state) {
		this.state = state;
	}
	
	
	
	
}
