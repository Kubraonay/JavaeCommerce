package eCommerce.business.concretes;

import eCommerce.business.abstracts.AuthService;
import eCommerce.business.abstracts.UserService;
import eCommerce.core.utils.Utils;
import eCommerce.entities.concretes.LoginDto;
import eCommerce.entities.concretes.User;

public class AuthManager implements AuthService {
	private UserService userService;

	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void register(User user) {
		if (userValidate(user) && passwordValidate(user.getPassword()) && userExists(user.geteMail()) == false
				&& Utils.emailValidate(user.geteMail())) {
			userService.add(user);

		}
		System.out.println("Kayıt başarısız");
	}

	@Override
	public void verify(User user, String token) {
		if (user != null && token.length() > 20) {
			User exitsUser = userService.get(user.geteMail());
			exitsUser.setVerify(true);

			userService.update(exitsUser);
			System.out.println("Doğrulandı");

		}
		System.out.println("Doğrulanmadı");

	}

	@Override
	public boolean userExists(String eMail) {
		User user = userService.get(eMail);
		if (user == null) {

			return false;
		}

		else {
			System.out.println("Email mevcut." + eMail);
			return true;
		}
	}

	@Override
	public void login(LoginDto dto) {
		User user = userService.get(dto.geteMail());
		if (user != null && user.getPassword().equals(dto.getPassword())) {
			System.out.println("Başarıyla giriş yaptınız.");
		} else {
			System.out.println("Kullanıcı adı veya şifre yanlış.");
		}
	}

	public boolean userValidate(User user) {
		if (user != null && !user.getFirtsName().isEmpty() && !user.getLastName().isEmpty()
				&& !user.geteMail().isEmpty() && !user.getPassword().isEmpty()) {
			return true;

		}
		return false;
	}

	public boolean passwordValidate(String password) {
		if (password.length() >= 6) {
			return true;
		} else {
			System.out.println("Şifreniz en az 6 karakter olmalı");
			return false;
		}
	}
}
