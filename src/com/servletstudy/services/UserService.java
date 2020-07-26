package com.servletstudy.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.servletstudy.dbUtil.UserDAO;
import com.servletstudy.dbUtil.UserDAOManager;
import com.servletstudy.filters.AuthenticationFilter;
import com.servletstudy.objects.User;
	
@Path(value = "/userservice")
public class UserService {
	UserDAOManager daoManager = new UserDAOManager();
	
	UserDAO userDAO = daoManager.getUserDAOInstance(AuthenticationFilter.getServletContext());
	
	List<User> users= userDAO.getUsers();
	User user = null;
	
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getAllUsers() {
	
		users = userDAO.getUsers();
		return users;
	}
	
	@POST
	@Path("/createuser")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createUser(
			@FormParam("name") String name,
			@FormParam("lastname") String lastname,
			@FormParam("email") String email,
			@FormParam("profession") String profession,
			@Context HttpServletResponse response) {
		
//			userDAO.createUser(name,lastname,email,profession);
			this.users = new ArrayList<User>();
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
			try { File userFile = new File("UserDatabaseServlet.dat");
				FileOutputStream fos = new FileOutputStream(userFile);
				ObjectOutputStream bos = new ObjectOutputStream(fos);
				bos.writeObject(users);
				bos.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		
		
	}
	
	@PUT
	@Path("/edituser")
	public void editUser() {
		
			
			int id = 1;
			this.user = new User();
			user.setName("Bane");
			user.setLastname("sada");
			user.setEmail("email@.neli.com");
			user.setProfession("profesioanle");
			
			if(users.isEmpty()) {
				user.setId(id);
			}else {
				for(User u : users) {
					id = u.getId();
				}
				user.setId(id+1);
			}
			users.add(user);
			try { 
				File userFile = new File("C:\\Users\\osadk\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ServletStudyFilterTest\\UserDatabaseServlet.dat");
				FileOutputStream fos = new FileOutputStream(userFile);
				ObjectOutputStream bos = new ObjectOutputStream(fos);
				bos.writeObject(users);
				bos.flush();
				bos.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		
		
	}
}
