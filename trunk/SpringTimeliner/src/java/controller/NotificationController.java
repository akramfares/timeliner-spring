/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.NotificationService;
import services.UserService;

/**
 *
 * @author Fares
 */
@Controller
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    
    @RequestMapping(value="/notifications.htm",method=RequestMethod.GET)
    protected ModelAndView indexProcess( HttpServletRequest
      request, HttpServletResponse response) throws Exception { 
        HttpSession session=request.getSession(false); 
	User userSession = (User) session.getAttribute("user");
        ModelAndView mv = new ModelAndView("notifications"); 
        mv.addObject("notifications",notificationService.getAll(userSession));
        return mv;
    }
}
