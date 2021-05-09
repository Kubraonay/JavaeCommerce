package eCommerce.core.amazonEmail;

import eCommerce.amazonEmail.AmazonEmailManager;
import eCommerce.core.EmailSErvice;

public class AmazonMailManagerAdapter implements EmailSErvice {
private AmazonEmailManager amazonMailManager;

	public AmazonMailManagerAdapter() {
	super();
	this.amazonMailManager = new AmazonEmailManager();
}

	@Override
	public void send(String eMail, String message) {
		amazonMailManager.send(eMail, message);
		
	}

}
