package eCommerce.core.googleEmail;

import eCommerce.core.EmailSErvice;
import eCommerce.googlemail.GoogleMailManager;

public class GoogleMailManagerAdapter implements EmailSErvice {
	private GoogleMailManager googleMailManager;
	public GoogleMailManagerAdapter() {
		super();
		this.googleMailManager = new GoogleMailManager();
	}

	@Override
	public void send(String eMail, String message) {
		googleMailManager.send(eMail, message);

	}

}
