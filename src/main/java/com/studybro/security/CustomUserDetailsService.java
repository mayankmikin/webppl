package com.studybro.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.studybro.model.Roles;
import com.studybro.model.User;
import com.studybro.services.UserService;
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService 
{
		
	@Autowired
    private UserService userService;
     
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String emailid)
            throws UsernameNotFoundException {
        User user = userService.getUserByEmailID(emailid);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Email id  not found"); 
        }
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
                 user.getAccountStatus().equals("D"), true, true, true, getGrantedAuthorities(user));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(Roles roles : user.getRoles()){
            System.out.println("UserRoles : "+roles.getRolename()+" "+roles.getAccesstype());
            authorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRolename()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }

}
