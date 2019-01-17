package session;

import javax.ejb.Remote;

import model.Permission;

@Remote
public interface PermissionManagerRemote extends Manager<Integer, Permission>{

}
