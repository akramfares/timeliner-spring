/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.Status;
import DAO.User;
import DAO.UserDAO;
import java.util.ArrayList;

/**
 *
 * @author afares01
 */
public interface StatusService {
	
	public boolean ajouter(String contenu, User Proprio);

        public ArrayList<Status> getMur(User proprio);
	
}
