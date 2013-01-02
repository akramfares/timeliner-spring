/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.Notification;
import DAO.NotificationDAO;
import DAO.User;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fares
 */
@Service("NotificationService")
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    public NotificationDAO notification;
    
    @Override
    public ArrayList<Notification> getAll(User proprio) {
        return notification.getAllByProprio(proprio);
    }

    @Override
    public Integer countByProprio(User userSession) {
        return notification.countAllByProprio(userSession);
    }
 
}
