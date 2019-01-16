package bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.User;
import session.UserManagerRemote;

@SessionScoped
@ManagedBean(name="userBean")
public class UserManagedBean implements Serializable {
	private static final long serialVersionUID = -5872343355923192032L;

	private static final String EJB_NAME
	= "java:global/ejb/UserManager!session.UserManagerRemote";

	@EJB(mappedName=EJB_NAME)
	private UserManagerRemote manager;


	public List<User> list() {
		return this.manager.list();
	}

}
