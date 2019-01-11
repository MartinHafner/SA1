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
import model.User;
import session.UserManagerRemote;

@Stateless
@Remote(UserManagerRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserManager implements UserManagerRemote, Serializable {

	private static final long serialVersionUID = -8883455753847861769L;
	
	@PersistenceContext(unitName = "das")
	private EntityManager manager;
	
	public UserManager(){}
	
	@Override
	public List<User> list() {
		final TypedQuery<User> query = this.manager.createQuery("select u from User u", User.class);
		return query.getResultList();
	}

	@Override
	public User findByPrimaryKey(Integer primaryKey) throws NoSuchRowException {
		final User user = this.manager.find(User.class, primaryKey);
		if(user == null) {
			throw new NoSuchRowException("Couldn´t find the User with Id: " + primaryKey);
		}
		return user;
	}

	@Override
	public void save(User entity) {
		final User x = this.manager.find(User.class, entity.getUserId());
		
		if(x != null) {
			this.manager.merge(entity);
		}
		else {
			this.manager.persist(entity);
		}
	}

	@Override
	public void delete(User entity) throws NoSuchRowException {
		final User x = this.manager.find(User.class, entity.getUserId());
		
		if(x != null) {
			throw new NoSuchRowException("Couldn´t find the User with Id: " + entity.getUserId());
		}
		else {
			this.manager.remove(entity);
		}
	}

	@Override
	public void checkout() {}


}
