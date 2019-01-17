package session;

import javax.ejb.Remote;

import exception.NoSuchRowException;
import model.User;

@Remote
public interface UserManagerRemote extends Manager<Integer, User> {
	public Boolean register(String name, String email, String passwort) throws NoSuchRowException;
	
	public int login(String email, String passwort);
}