package eCommerce;

import eCommerce.business.concretes.AuthManager;
import eCommerce.business.concretes.UserManager;
import eCommerce.core.amazonEmail.AmazonMailManagerAdapter;
import eCommerce.core.googleEmail.GoogleMailManagerAdapter;
import eCommerce.dataAccess.concretes.InMemoryUsersDao;
import eCommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User enes=new User(4,"Enes","Çakmak","enes@gmail.com","135670",true);
		
		User merve=new User(1,"Hilmi","Sezen","hilmi@gmail.com","453218",false);

		InMemoryUsersDao inMemoryUserDao = new InMemoryUsersDao();
		GoogleMailManagerAdapter googleMailManagerAdapter = new GoogleMailManagerAdapter();
		AmazonMailManagerAdapter amazonMailManagerAdapter = new  AmazonMailManagerAdapter();	
	
	AuthManager authManager =new AuthManager(new UserManager(inMemoryUserDao, googleMailManagerAdapter));
	
	authManager.register(enes);
	UserManager userManager = new UserManager(inMemoryUserDao, amazonMailManagerAdapter);
	
	userManager.getAll();
	;		
}}

