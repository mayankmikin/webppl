package com.studybro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studybro.model.SubjectName;
import com.studybro.services.SubjectService;
import com.studybro.services.VideoService;

@RestController
@CrossOrigin
@RequestMapping("/subject")
public class SubjectController 
{
	@Autowired
	SubjectService subservice;
	@Autowired
	VideoService videoservice;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createNewSubject(
			@RequestParam(value="subname", required=true) String subname
			)
	{
		subservice.create(subname);
		return "created subject"+subname;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<SubjectName> getallSubjetcList()
	{
		
		return subservice.findAll();
	}
	
	@RequestMapping(value = "/allnames", method = RequestMethod.GET)
	public List<SubjectName> getallSubjetcNames()
	{
		System.out.println(subservice.findAll());
		return subservice.findAll();
	}
	
	
	
/*	@RequestMapping(value = "/all/{subjectname}", method = RequestMethod.GET)
	public List<VideoUrlNeo> findALLVideosBySubjectName(
    @PathVariable(value="subjectname", required=true) String subname)
	{
		
		SubjectName sub=subservice.findBySubName(subname);
		if(sub==null)
		{
			System.out.println("no such subject exist");
		}
		
		List<AcademicLevel> alevelList=sub.getAlevel();
		List<VideoUrlNeo>allvideos=new ArrayList<VideoUrlNeo>();
		for(AcademicLevel al:alevelList)
		{
			allvideos.add(al.getVideourl());
		}
		return allvideos;
		
	}*/
	
}
