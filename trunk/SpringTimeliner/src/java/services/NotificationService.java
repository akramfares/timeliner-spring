/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.Notification;
import DAO.User;
import java.util.ArrayList;

/**
 *
 * @author Fares
 */
public interface NotificationService {

    public ArrayList<Notification> getAll(User userSession);

    public Integer countByProprio(User userSession);
    
}
