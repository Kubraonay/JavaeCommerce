package eCommerce.business.concretes;

import java.util.List;

import eCommerce.business.abstracts.UserService;
import eCommerce.core.EmailSErvice;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao;
	private EmailSErvice emailService;
	public UserManager(UserDao userdao,EmailSErvice eMailSErvice) {
		super();
		this.userDao = userdao;
	}

	@Override
	public void add(User user) {

		userDao.add(user);

	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);

	}

	@Override
	public User get(String email) {

		return userDao.get(email);
	}

	@Override
	public List<User> getAll() {

		return userDao.getAll();
	}

	public EmailSErvice getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailSErvice emailService) {
		this.emailService = emailService;
	}

	@Override
	public void add(String email) {
		// TODO Auto-generated method stub
		
	}

}
