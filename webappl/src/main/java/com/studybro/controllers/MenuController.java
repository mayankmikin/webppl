package com.studybro.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studybro.model.MenuItem;
import com.studybro.model.SubItem;
import com.studybro.services.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController 
{
	@Autowired
	MenuService menuservice;
	
	public static final Logger logger = LoggerFactory.getLogger(LandingPageController.class);
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<MenuItem> createNewMenuItem(@RequestBody MenuItem menuitem )
	{
		logger.info("creating menu item list as ");
		MenuItem m=menuservice.find(menuitem.getName());
		if(m!=null)
		{
			return new ResponseEntity("MenuItem Already Existing",HttpStatus.CONFLICT);
		}
			ObjectMapper om= new ObjectMapper();
			try {
				System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(menuitem));
			} catch (Exception e) {
				e.printStackTrace();
			}
		menuservice.save(menuitem);
		return new ResponseEntity(menuitem, HttpStatus.OK);
	}

	@PostMapping(value="/addSubitemToMenuItem")
	public ResponseEntity<Void> addSubMenuItem(@RequestBody SubItem subitem,
			@RequestParam(value="menuitemname")String menuitemname) 		
	{
		MenuItem m=menuservice.find(menuitemname);
		if(m==null)
		{
		 return new ResponseEntity("No Menu Item Found by this name "+menuitemname, HttpStatus.NOT_FOUND);
		}
		else
		{
			List<SubItem>sblist=m.getSubItems();
			sblist.add(subitem);
			menuservice.save(m);
			return new ResponseEntity(m, HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/all")
	public ResponseEntity getAllMenu() 
	{
		logger.info("fetching all menu items");
		return new ResponseEntity(menuservice.findall(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteMenuItem(@PathVariable Long id) 
	{

		if (null == menuservice.findById(id)) 
		{
			return new ResponseEntity("No MenuItem found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(menuservice.delete(menuservice.findById(id).getName()), HttpStatus.OK);

	}
	@DeleteMapping("/deleteSubItem")
	public ResponseEntity deleteMenuItem(@RequestParam String subitemnames,@RequestParam String menuitemname) 
	{
		String subnames[]=subitemnames.split(",");
		MenuItem m=menuservice.find(menuitemname);
		for(String s:subnames)
		{
			for(SubItem si: m.getSubItems())
			{
				if(si.getName().equals(s))
				{
					
					menuservice.deleteSubItem(si, menuitemname);
				}
			}
			
		}
		
		return new ResponseEntity(m, HttpStatus.OK);

	}
}
