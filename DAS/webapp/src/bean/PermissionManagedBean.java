package bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Permission;
import session.PermissionManagerRemote;


@SessionScoped
@ManagedBean(name="permissionBean")
public class PermissionManagedBean implements Serializable{

	private static final long serialVersionUID = -2228932520478950724L;

	private static final String EJB_NAME_PERMISSION
	= "java:global/ejb/PermissionManager!session.PermissionManagerRemote";

	@EJB(mappedName=EJB_NAME_PERMISSION)
	private PermissionManagerRemote manager;


	public List<Permission> list() {
		return this.manager.list();
	}
}
