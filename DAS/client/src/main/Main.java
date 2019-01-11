package main;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.User;
import session.UserManagerRemote;

public class Main {


	public static final String USER_REMOTE
	= "ejb/UserManager!session.UserManagerRemote";

	public static void main(final String[] args) throws NamingException {
		final InitialContext context = new InitialContext();

		final UserManagerRemote userManager = (UserManagerRemote) context.lookup(USER_REMOTE);

		final List<User> users = userManager.list();

		for (final User u : users)
			System.out.println(u);

		userManager.checkout();

	}

}
