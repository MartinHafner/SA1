package bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import exception.NoSuchRowException;
import model.User;
import session.UserManagerRemote;

@SessionScoped
@ManagedBean(name="userBean")
public class UserManagedBean implements Serializable {
	private static final long serialVersionUID = -5872343355923192032L;

	private static final String EJB_NAME_USER
	= "java:global/ejb/UserManager!session.UserManagerRemote";

	@EJB(mappedName=EJB_NAME_USER)
	private UserManagerRemote manager;
	
	public String loginEmail;
	public String loginPassword;
	

	public List<User> list() {
		return this.manager.list();
	}
	
	public int login() {
		return this.manager.login(loginEmail, loginPassword);
	}
	
	public Boolean register(String name, String email, String passwort) throws NoSuchRowException{
		return this.manager.register(name, email, passwort);
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
}
