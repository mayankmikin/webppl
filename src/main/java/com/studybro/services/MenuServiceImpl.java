package com.studybro.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studybro.model.ClassName;
import com.studybro.model.MenuItem;
import com.studybro.model.SubItem;
import com.studybro.repositories.MenuRepository;

@Service("menuservice")
public class MenuServiceImpl implements MenuService 
{
	@Autowired
	MenuRepository repo;

	@Override
	public MenuItem add(String itemname) {
		
		return null;
	}

	
	@Override
	public MenuItem delete(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuItem add(ArrayList<String> withsubitems) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuItem addToalreadyItem(String parent, int pos, String itemtoadd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuItem find(String name) {
		// TODO Auto-generated method stub
		List<MenuItem>milist= (List<MenuItem>) repo.findAll();
		for(MenuItem mi :milist)
		{
			if(name.equals(mi.getName()))
			{
				return mi;
			}
		}
		return null;
	}


	@Override
	public MenuItem save(MenuItem name) 
	{
		// TODO Auto-generated method stub
		return repo.save(name);
	}


	@Override
	public List<MenuItem> findall() {
		// TODO Auto-generated method stub
		return (List<MenuItem>) repo.findAll();
	}


	@Override
	public MenuItem findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findOne(id);
	}


	@Override
	public MenuItem deleteSubItem(SubItem subnitemname, String menuitem) {
		// TODO Auto-generated method stub
		MenuItem m =find(menuitem);
		List<SubItem>sublist=m.getSubItems();
		sublist.remove(subnitemname);
		return repo.save(m);
	}


	

	
}
