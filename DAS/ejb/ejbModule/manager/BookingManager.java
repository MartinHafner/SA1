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
import model.Booking;
import model.Document;
import session.BookingManagerRemote;
import session.DocumentManagerRemote;


@Stateless
@Remote(BookingManagerRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BookingManager implements BookingManagerRemote, Serializable{

	private static final long serialVersionUID = -2639512102947965412L;
	
	@PersistenceContext(unitName = "das")
	private EntityManager manager;
	
	@Override
	public List<Booking> list() {
		final TypedQuery<Booking> query = this.manager.createQuery("select b from Booking b", Booking.class);
		return query.getResultList();
	}

	@Override
	public Booking findByPrimaryKey(Integer primaryKey) throws NoSuchRowException {
		final Booking booking = this.manager.find(Booking.class, primaryKey);
		if (booking == null) {
			throw new NoSuchRowException("Couldn´t find the Document with Id: " + primaryKey);
		}
		return booking;
	}

	@Override
	public void save(Booking entity) {
		final Booking x = this.manager.find(Booking.class, entity.getBookingId());

		if (x != null) {
			this.manager.merge(entity);
		} else {
			this.manager.persist(entity);
		}
		
	}

	@Override
	public void delete(Booking entity) throws NoSuchRowException {
		final Booking x = this.manager.find(Booking.class, entity.getBookingId());

		if (x != null) {
			throw new NoSuchRowException("Couldn´t find the Booking with Id: " + entity.getBookingId());
		} else {
			this.manager.remove(entity);
		}
		
	}

	@Override
	public void checkout() {
		// TODO Auto-generated method stub
		
	}

}
