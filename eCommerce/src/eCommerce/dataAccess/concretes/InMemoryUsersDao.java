package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class InMemoryUsersDao implements UserDao {
	private List<User> users=new ArrayList<User>();
	
	public InMemoryUsersDao() {
		User user1=new User(1,"Merve","Tel","merve@gmail.com","125345",true);
		User user2=new User(2,"Hatice","Onay","hatice@gmail.com","567889",true);
		User user3=new User(3,"Ahmet","Ünlü","ahmet@gmail.com","014234",true);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
	}

	@Override
	public void add(User user) {
		System.out.println("Kaydedildi: " + user.geteMail());
		users.add(user);
	}

	@Override
	public void update(User user) {
		System.out.println("Güncellendi: " + user.geteMail());
	}

	@Override
	public void delete(User user) {
		System.out.println("Silindi: " + user.geteMail());
		
	}

	@Override
	public User get(String email) {
		
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
