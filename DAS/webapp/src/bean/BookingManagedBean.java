package bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Booking;
import session.BookingManagerRemote;

@SessionScoped
@ManagedBean(name="bookingBean")
public class BookingManagedBean implements Serializable {

	private static final long serialVersionUID = 434975800844709467L;

	private static final String EJB_NAME_BOOKING
	= "java:global/ejb/BookingManager!session.BookingManagerRemote";

	@EJB(mappedName=EJB_NAME_BOOKING)
	private BookingManagerRemote manager;


	public List<Booking> list() {
		return this.manager.list();
	}
}
