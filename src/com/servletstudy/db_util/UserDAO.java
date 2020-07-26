package com.servletstudy.db_util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.servletstudy.objects.User;

public class UserDAO {

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		List<User> users = null;
		try {
		File file = new File("UserDatabase.dat");
		if(!file.exists()) {
			User user= new  User(1,"Branislav","Osadkovski");
			User user1= new  User(1,"Branislav","Osadkovski");
			User user2= new  User(1,"Branislav","Osadkovski");
			users = new ArrayList<User>();
			users.add(user);users.add(user1);users.add(user2);
			saveUserList(users);
		} else {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			users = (List<User>) ois.readObject();
			ois.close();
		}
		}catch(IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}

	private void saveUserList(List<User> users) {
		try {
			File file = new File("UserDatabase.dat");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream bos = new ObjectOutputStream(fos);
			bos.writeObject(users);
			bos.close();
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
