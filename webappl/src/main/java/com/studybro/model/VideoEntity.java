package com.studybro.model;

public class VideoEntity 
{
	private String videourl;
	private String videoname;
	private String subjectname;
	private String classname;
	private String semester;
	private String price_status;
	
	private String headline;
	
	private Integer review_counts;
	
	private Integer ratings;
	public String getVideourl() {
		return videourl;
	}
	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
	public String getVideoname() {
		return videoname;
	}
	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	
	
	public String getPrice_status() {
		return price_status;
	}
	public void setPrice_status(String price_status) {
		this.price_status = price_status;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public Integer getReview_counts() {
		return review_counts;
	}
	public void setReview_counts(Integer review_counts) {
		this.review_counts = review_counts;
	}
	public Integer getRatings() {
		return ratings;
	}
	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}
	public VideoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoEntity(String videourl, String videoname, String subjectname,
			String classname, String semester, String price_status,
			String headline, Integer review_counts, Integer ratings) {
		super();
		this.videourl = videourl;
		this.videoname = videoname;
		this.subjectname = subjectname;
		this.classname = classname;
		this.semester = semester;
		this.price_status = price_status;
		this.headline = headline;
		this.review_counts = review_counts;
		this.ratings = ratings;
	}
	
	
	
}
