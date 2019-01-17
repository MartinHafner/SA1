package manager;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import exception.NoSuchRowException;
import model.Document;
import session.DocumentManagerRemote;

@Stateless
@Remote(DocumentManagerRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DocumentManager implements DocumentManagerRemote, Serializable{

	private static final long serialVersionUID = 1949660024387500205L;
	
	@PersistenceContext(unitName = "das")
	private EntityManager manager;
	

	@Override
	public void checkout() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Document> list() {
		final TypedQuery<Document> query = this.manager.createQuery("select d from Document d", Document.class);
		return query.getResultList();
	}


	@Override
	public Document findByPrimaryKey(Integer primaryKey) throws NoSuchRowException {
		final Document document = this.manager.find(Document.class, primaryKey);
		if (document == null) {
			throw new NoSuchRowException("Couldn´t find the Document with Id: " + primaryKey);
		}
		return document;
	}


	@Override
	public void save(Document entity) {
		final Document x = this.manager.find(Document.class, entity.getDocumentId());

		if (x != null) {
			this.manager.merge(entity);
		} else {
			this.manager.persist(entity);
		}
		
	}


	@Override
	public void delete(Document entity) throws NoSuchRowException {
		final Document x = this.manager.find(Document.class, entity.getDocumentId());

		if (x != null) {
			throw new NoSuchRowException("Couldn´t find the Document with Id: " + entity.getDocumentId());
		} else {
			this.manager.remove(entity);
		}
	}

}
