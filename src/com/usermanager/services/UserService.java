//package com.usermanager.services;
//
//import java.util.List;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.FormParam;
//import javax.ws.rs.GET;
//import javax.ws.rs.OPTIONS;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
//
//import org.apache.log4j.Logger;
//
//import com.usermanager.dbUtil.UserDAO;
//import com.usermanager.dbUtil.UserDAOManager;
//import com.usermanager.objects.User;
//
//@Path(value = "/userservice")
//public class UserService {
//
//	final private static Logger logger = Logger.getLogger(UserService.class);
//	private UserDAOManager daoManager = new UserDAOManager();
//	private UserDAO userDAO = daoManager.getUserDAOInstance();
//	private List<User> users = userDAO.getUsers();
//
//	@GET
//	@Path("/users")
//	@Produces(MediaType.APPLICATION_XML)
//	public List<User> getAllUsers() {
//		logger.info("Getting all users");
//		users = userDAO.getUsers();					//GET ALL USERS
//		return users;
//	}
//
//	@POST
//	@Path("/users")
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces(MediaType.APPLICATION_XML)
//	public Response createUser(@FormParam("name") String name, @FormParam("lastname") String lastname,
//			@FormParam("email") String email, @FormParam("profession") String profession) {
//		
//		logger.info("Creating new user={ name:" + name + "" + lastname + "" + email + "" + profession + "}");
//
//		userDAO.createUser(name, lastname, email, profession);				//CREATE
//
//		return Response.status(Status.OK).build();
//
//	}
//
//	@PUT
//	@Path("/users")
//	@Produces(MediaType.APPLICATION_XML)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	public Response editUser(@FormParam("id") int id, @FormParam("name") String name,
//			@FormParam("lastname") String lastname, @FormParam("email") String email,
//			@FormParam("profession") String profession) {
//
//		logger.info("Editing user with id:" + id + " values={name:" + name + "" + lastname + "" + email + ""
//				+ profession + "}");
//
//		userDAO.editUser(id, name, lastname, email, profession);				//EDIT
//
//		return Response.status(Status.OK).build();
//	}
//
//	@DELETE
//	@Path("/users")
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces(MediaType.APPLICATION_XML)
//	public Response deleteUser(@FormParam("id") int id) {
//
//		logger.info("deleting user with id= " + id); 						//DELETE
//		userDAO.deleteUser(id);
//
//		return Response.status(Status.OK).build();
//	}
//
//	@OPTIONS
//	@Path("/users")
//	@Produces(MediaType.APPLICATION_XML)
//	public String getSupportedOperations() {
//		logger.info("Requesting options");
//		return "<operations>GET, PUT, POST, DELETE</operations>";
//	}
//}
