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
import model.Permission;
import model.Version;
import session.VersionManagerRemote;

@Stateless
@Remote(VersionManagerRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class VersionManager implements VersionManagerRemote, Serializable{

	private static final long serialVersionUID = -4261627324166152351L;

	@PersistenceContext(unitName = "das")
	private EntityManager manager;
	
	@Override
	public List<Version> list() {
		final TypedQuery<Version> query = this.manager.createQuery("select v from Version v", Version.class);
		return query.getResultList();
	}

	@Override
	public Version findByPrimaryKey(Integer primaryKey) throws NoSuchRowException {
		final Version version = this.manager.find(Version.class, primaryKey);
		if (version == null) {
			throw new NoSuchRowException("Couldn´t find the Version with Id: " + primaryKey);
		}
		return version;
	}

	@Override
	public void save(Version entity) {
		final Version x = this.manager.find(Version.class, entity.getVersionId());

		if (x != null) {
			this.manager.merge(entity);
		} else {
			this.manager.persist(entity);
		}
	}

	@Override
	public void delete(Version entity) throws NoSuchRowException {
		final Version x = this.manager.find(Version.class, entity.getVersionId());

		if (x != null) {
			throw new NoSuchRowException("Couldn´t find the Version with Id: " + entity.getVersionId());
		} else {
			this.manager.remove(entity);
		}	
	}

	@Override
	public void checkout() {
		// TODO Auto-generated method stub
		
	}

}
