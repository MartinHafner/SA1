package bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Version;
import session.VersionManagerRemote;


@SessionScoped
@ManagedBean(name="versionBean")
public class VersionManagedBean implements Serializable{

	private static final long serialVersionUID = 2289750844950096410L;

	private static final String EJB_NAME_VERSION
	= "java:global/ejb/VersionManager!session.VersionManagerRemote";

	@EJB(mappedName=EJB_NAME_VERSION)
	private VersionManagerRemote manager;


	public List<Version> list() {
		return this.manager.list();
	}
}
