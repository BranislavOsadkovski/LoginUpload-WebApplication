package com.servletstudy.dbUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


import com.servletstudy.filters.AuthenticationFilter;
import com.servletstudy.objects.User;

public class UserDAO {
	
	private List<User> users=null;
	private File userFile = null;
	private User user;
	
	public UserDAO() {
		this.userFile = new File(AuthenticationFilter.getServletContext().getRealPath("")+File.separator+"UserDatabaseServlet.dat");
	}
	
	public List<User> getUsers(){
		
		try (FileInputStream fis =  new FileInputStream(userFile);
				ObjectInputStream ois = new ObjectInputStream(fis); )
		{
			this.users=(List<User>)ois.readObject();
			ois.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void createUser(String name,String lastname,String email,String profession) {

		int id = 1;
		this.user = new User();
		user.setName(name);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setProfession(profession);
		
		if(users.isEmpty()) {
			user.setId(id);
		}else {
			for(User u : users) {
				id = u.getId();
			}
			user.setId(id+1);
		}
		users.add(user);
		
		try (FileOutputStream fos = new FileOutputStream(this.userFile);
			ObjectOutputStream bos = new ObjectOutputStream(fos); )
		{ 			
			bos.writeObject(users);
			bos.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}

	public void editUser(int id,String name, String lastname, String email, String profession) {
		
		
		if(users.isEmpty()) {
				// throw new UserNotFoundException
		}else {
			for(User u : users) {
				if(u.getId()==id) {
					//Commit changes 
					u.setName(name);
					u.setLastname(lastname);
					u.setEmail(email);
					u.setProfession(profession);
					
				}
			}
		}		
		try (FileOutputStream fos = new FileOutputStream(this.userFile);
			ObjectOutputStream bos = new ObjectOutputStream(fos); )
		{ 			
			bos.writeObject(users);
			bos.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
public void deleteUser(int id) {
		
		if(users.isEmpty()) {
				// throw new UserNotFoundException
		}else {
			for(User u : users) {
				if(id==u.getId()) {
					users.remove(u);
				}
			}
		}		
		try (FileOutputStream fos = new FileOutputStream(this.userFile);
			ObjectOutputStream bos = new ObjectOutputStream(fos); )
		{ 			
			bos.writeObject(users);
			bos.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
