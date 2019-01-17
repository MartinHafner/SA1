package session;

import javax.ejb.Remote;

import model.Booking;

@Remote
public interface BookingManagerRemote extends Manager<Integer, Booking>{

}
