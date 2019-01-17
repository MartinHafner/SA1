package session;

import javax.ejb.Remote;

import model.Version;

@Remote
public interface VersionManagerRemote extends Manager<Integer, Version>{

}
