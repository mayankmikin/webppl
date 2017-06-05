package com.studybro.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studybro.model.VideoUrlNeo;
import com.studybro.services.VideoService;

@Controller
@RequestMapping("/video")
public class VideoOperationsController 
{
	@Autowired
	VideoService videoservice;
	
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

}
