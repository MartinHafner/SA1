package session;

import javax.ejb.Remote;

import model.Document;

@Remote
public interface DocumentManagerRemote extends Manager<Integer, Document>{

}
