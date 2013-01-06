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

    // Retourne la liste des notifications d'un utilisateur donné
    public ArrayList<Notification> getAll(User userSession);
    // Retourne le nombre de notifications non lues d'un utilisateur donné
    public Integer countByProprio(User userSession);
    
}
