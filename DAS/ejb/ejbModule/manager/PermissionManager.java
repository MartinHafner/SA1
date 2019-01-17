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
import session.PermissionManagerRemote;


@Stateless
@Remote(PermissionManagerRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PermissionManager implements PermissionManagerRemote, Serializable{

	private static final long serialVersionUID = 3316759507950749553L;

	@PersistenceContext(unitName = "das")
	private EntityManager manager;

	@Override
	public List<Permission> list() {
		final TypedQuery<Permission> query = this.manager.createQuery("select p from Permission p", Permission.class);
		return query.getResultList();
	}

	@Override
	public Permission findByPrimaryKey(Integer primaryKey) throws NoSuchRowException {
		final Permission permission = this.manager.find(Permission.class, primaryKey);
		if (permission == null) {
			throw new NoSuchRowException("Couldn´t find the Permission with Id: " + primaryKey);
		}
		return permission;
	}

	@Override
	public void save(Permission entity) {
		final Permission x = this.manager.find(Permission.class, entity.getPermissionId());

		if (x != null) {
			this.manager.merge(entity);
		} else {
			this.manager.persist(entity);
		}
	}

	@Override
	public void delete(Permission entity) throws NoSuchRowException {
		final Permission x = this.manager.find(Permission.class, entity.getPermissionId());

		if (x != null) {
			throw new NoSuchRowException("Couldn´t find the Permission with Id: " + entity.getPermissionId());
		} else {
			this.manager.remove(entity);
		}	
	}

	@Override
	public void checkout() {
		// TODO Auto-generated method stub
		
	}

}
