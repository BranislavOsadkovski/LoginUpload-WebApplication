package com.servletstudy.services;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.servletstudy.dbUtil.UserDAO;
import com.servletstudy.dbUtil.UserDAOManager;
import com.servletstudy.objects.User;
	
@Path(value = "/userservice")
public class UserService {
	
	private UserDAOManager daoManager = new UserDAOManager();
	private UserDAO userDAO = daoManager.getUserDAOInstance(); 
	private List<User> users= userDAO.getUsers();
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getAllUsers() {
	
		users = userDAO.getUsers();
		return users;
	}
	
	@POST
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createUser(
			@FormParam("name") String name,
			@FormParam("lastname") String lastname,
			@FormParam("email") String email,
			@FormParam("profession") String profession,
			@Context HttpServletResponse response) {
		
			userDAO.createUser(name,lastname,email,profession);
			
		return "<result> SUCCESS </result>";
	}
	
	@PUT
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String editUser(
			@FormParam("id") int id,
			@FormParam("name") String name,
			@FormParam("lastname") String lastname,
			@FormParam("email") String email,
			@FormParam("profession") String profession,
			@Context HttpServletResponse response) {
		
			userDAO.editUser(id,name,lastname,email,profession);
			return "<result> SUCCESS </result>";
	}
	@DELETE
	@Path("/users")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public String deleteUser(
			@FormParam("id") int id,
			@Context HttpServletResponse response) {
		
			userDAO.deleteUser(id);
			
			return "<result> SUCCESS </result>";
	}
	
	
    @OPTIONS
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
    public String getSupportedOperations(){
       return "<operations>GET, PUT, POST, DELETE</operations>";
    }
}
