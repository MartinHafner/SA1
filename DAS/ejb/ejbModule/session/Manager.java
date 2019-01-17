package session;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;

import exception.NoSuchRowException;

@Remote
public interface Manager<K, E> {

	List<E> list();
	 
	E findByPrimaryKey(K primaryKey) throws NoSuchRowException;

	void save(E entity);

	void delete(E entity) throws NoSuchRowException;
	
	@Remove
	void checkout();

}
