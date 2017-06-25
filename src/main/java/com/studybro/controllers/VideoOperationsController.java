package com.studybro.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studybro.model.ClassName;
import com.studybro.model.SubjectName;
import com.studybro.model.VideoDescription;
import com.studybro.model.VideoEntity;
import com.studybro.model.VideoUrlNeo;
import com.studybro.services.ClassService;
import com.studybro.services.SubjectService;
import com.studybro.services.VideoService;

@RestController
@CrossOrigin
@RequestMapping("/video")
public class VideoOperationsController 
{
	@Autowired
	VideoService videoservice;
	@Autowired
	SubjectService subservice;
	@Autowired
	ClassService classervice;
	
	public static final Logger logger = LoggerFactory.getLogger(VideoOperationsController.class);
	
	@RequestMapping(value = "/findbyclass", method = RequestMethod.GET)
	public List<VideoUrlNeo> createNewSubject(
			@RequestParam(value="classname", required=true) String classname
			)
	{
		List<VideoUrlNeo>vdlist= videoservice.findAllByClassName(classname);
		System.out.println("List of videos are");
		System.out.println(Arrays.deepToString(vdlist.toArray()));
		
		for(VideoUrlNeo v:vdlist)
		{
			System.out.println(v.getVideo_name());
			System.out.println(v.getUrl_name());
		}
		
		return vdlist;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public VideoUrlNeo createVideoUrl(@RequestBody VideoEntity vid) 
	{
		logger.info("saving Video urls");

		//videoservice.create(new VideoUrlNeo(videourl, videoname,new SubjectName(subname),new AcademicLevel(classname, semester)));
		SubjectName sub=subservice.findBySubName(vid.getSubjectname());
		ClassName cls=classervice.findByClassName(vid.getClassname());
		VideoUrlNeo oldVid=videoservice.findByname(vid.getVideoname());
		if(oldVid!=null)
		{
			System.out.println("video already exist");
			return oldVid;
		}
		
		VideoUrlNeo vl=new VideoUrlNeo();
		vl.setUrl_name(vid.getVideourl());
		vl.setVideo_name(vid.getVideoname());
		// now saving video description
				VideoDescription description=new VideoDescription(vid.getPrice_status(), vid.getHeadline(), vid.getReview_counts(), vid.getRatings());
				vl.getDescription().add(description);
				
		if(sub==null)
		{
			
			sub=subservice.create(vid.getSubjectname());
		}
		if(cls==null)
		{
			cls=classervice.create(vid.getClassname());
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
		
		
		
		return  vl ;
	}
	
	@RequestMapping(value = "/getDesc", method = RequestMethod.GET)
	public Set<VideoDescription> getVideoDescription(
			@RequestParam(value="id", required=true) Long id
			)
	{
		VideoUrlNeo vd=videoservice.findById(id);
		return vd.getDescription();
	}

}
