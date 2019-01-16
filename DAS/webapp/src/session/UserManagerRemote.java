package session;

import javax.ejb.Remote;

import model.User;

@Remote
public interface UserManagerRemote extends Manager<Integer, User> {

}