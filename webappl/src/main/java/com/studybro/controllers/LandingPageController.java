package com.studybro.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studybro.model.ClassName;
import com.studybro.model.SubjectName;
import com.studybro.model.VideoUrlNeo;
import com.studybro.services.ClassService;
import com.studybro.services.SubjectService;
import com.studybro.services.VideoService;
//@CrossOrigin(origins = "http://studybro.000webhostapp.com", maxAge = 3600)
@RestController
@RequestMapping("/landing")
public class LandingPageController 
{
	@Autowired
	VideoService videoservice;
	
	@Autowired
	SubjectService subservice;
	@Autowired
	ClassService classervice;
	
	public static final Logger logger = LoggerFactory.getLogger(LandingPageController.class);
	
	@RequestMapping(value = "/video", method = RequestMethod.GET)
	public List<VideoUrlNeo>getVideoUrl() {
		logger.info("Fetching Video urls");
		//VideoUrl v=videoservice.findOne("FIRSTONE");
		//logger.info("url is "+v.getUrl_name());
		//return v.getUrl_name();
		return videoservice.findAll();
	}
	
	
	@RequestMapping(value = "/videolibrary", method = RequestMethod.GET)
	public List<VideoUrlNeo>getVideoLibrary(@RequestParam(value="subjectname", required=true) String subname) 
	{
		logger.info("Fetching Video library");
		//VideoUrl v=videoservice.findOne("FIRSTONE");
		//logger.info("url is "+v.getUrl_name());
		//return v.getUrl_name();
		return videoservice.findAllBySubjectName(subname);
	}
	
	@RequestMapping(value = "/video/create", method = RequestMethod.POST)
	public String createVideoUrl(@RequestParam(value="videourl", required=true) String videourl,
			@RequestParam(value="videoname", required=true) String videoname,
			@RequestParam(value="subjectname", required=true) String subname,
			@RequestParam(value="classname", required=true) String classname,
			@RequestParam(value="semester", required=true) String semester) 
	{
		logger.info("saving Video urls");

		//videoservice.create(new VideoUrlNeo(videourl, videoname,new SubjectName(subname),new AcademicLevel(classname, semester)));
		SubjectName sub=subservice.findBySubName(subname);
		ClassName cls=classervice.findBySubName(classname);
		VideoUrlNeo oldVid=videoservice.findByname(videoname);
		if(oldVid!=null)
		{
			System.out.println("video already exist");
			return "video already exist by this name";
		}
		
		VideoUrlNeo vl=new VideoUrlNeo();
		vl.setUrl_name(videourl);
		vl.setVideo_name(videoname);
		if(sub==null)
		{
			
			sub=subservice.create(subname);
		}
		if(cls==null)
		{
			cls=classervice.create(classname);
		}
		// save subject with video and vice versa
		// save subjectname in video
		vl.getSubname().add(sub);
		// save classname in video
		vl.getClassname().add(cls);
		
		// now save subject in class
		cls.getSubjects().add(sub);
		
		sub.getVideourls().add(vl);
		// 
		
		// vl=videoservice.create(vl);
		subservice.createwithrelationship(sub);
		
		
		return  "created a video"+vl.getId()+vl.getVideo_name() ;
	}

}
