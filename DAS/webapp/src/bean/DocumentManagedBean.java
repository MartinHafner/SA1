package bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Document;
import session.DocumentManagerRemote;

@SessionScoped
@ManagedBean(name="documentBean")
public class DocumentManagedBean implements Serializable{

	private static final long serialVersionUID = 8231873473783288720L;

	private static final String EJB_NAME
	= "java:global/ejb/DocumentManager!session.DocumentManagerRemote";

	@EJB(mappedName=EJB_NAME)
	private DocumentManagerRemote manager;


	public List<Document> list() {
		return this.manager.list();
	}
}
