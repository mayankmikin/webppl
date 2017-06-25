package com.studybro.services;

import java.util.ArrayList;
import java.util.List;

import com.studybro.model.ClassName;
import com.studybro.model.MenuItem;
import com.studybro.model.SubItem;

public interface MenuService 
{
	MenuItem add(String itemname);
	MenuItem find(String name);
	MenuItem delete(String name);
	MenuItem add(ArrayList<String> withsubitems);
	MenuItem addToalreadyItem(String parent,int pos, String itemtoadd);
	MenuItem save(MenuItem name);
	List<MenuItem>findall();
	MenuItem findById(Long id);
	MenuItem deleteSubItem(SubItem subnitemname,String menuitem);
}
