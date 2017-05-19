package com.studybro.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studybro.model.AcademicLevel;
import com.studybro.model.SubjectName;
import com.studybro.model.VideoUrlNeo;
import com.studybro.services.VideoService;

@RestController
@RequestMapping("/landing")
public class LandingPageController 
{
	@Autowired
	VideoService videoservice;
	
	public static final Logger logger = LoggerFactory.getLogger(LandingPageController.class);
	
	@RequestMapping(value = "/video", method = RequestMethod.GET)
	public List<VideoUrlNeo>getVideoUrl() {
		logger.info("Fetching Video urls");
		//VideoUrl v=videoservice.findOne("FIRSTONE");
		//logger.info("url is "+v.getUrl_name());
		//return v.getUrl_name();
		return videoservice.findAll();
	}
	
	@RequestMapping(value = "/video/create", method = RequestMethod.POST)
	public String createVideoUrl(@RequestParam(value="videourl", required=true) String videourl,
			@RequestParam(value="videoname", required=true) String videoname,
			@RequestParam(value="subjectname", required=true) String subname,
			@RequestParam(value="classname", required=true) String classname,
			@RequestParam(value="semester", required=true) String semester) 
	{
		logger.info("saving Video urls");

		videoservice.create(new VideoUrlNeo(videourl, videoname,new SubjectName(subname),new AcademicLevel(classname, semester)));
		
		return  "created" ;
	}

}
