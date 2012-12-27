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
import services.UserService;

/**
 *
 * @author Fares
 */
@Controller
public class UserController {
    @Autowired
	private UserService userService;	
	
	@RequestMapping(value="/membres.htm",method=RequestMethod.GET)
	protected ModelAndView indexProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
            ModelAndView mv = new ModelAndView("membres"); 
                
                mv.addObject("users",userService.getAllUsers());
                return mv;
        }
        
        @RequestMapping(value="/ajouter_ami.htm", method=RequestMethod.GET)
	  protected ModelAndView ajouterProcess( HttpServletRequest
	  request, HttpServletResponse response) throws Exception { 
		ModelAndView mv = new ModelAndView("resultat"); 
		String ami_id = request.getParameter("ami_id");
		HttpSession session=request.getSession(false); 
		User userSession = (User) session.getAttribute("user");
		mv.addObject("titre","Résultat de l'ajout d'un ami");
                User ami = userService.getUserById(Integer.parseInt(ami_id));
		if(userService.ajouterAmi(userSession, ami))
			mv.addObject("resultat","Demande d'amitié ajoutée avec succès");
		else
			mv.addObject("resultat", "Erreur");
		
	  	return mv; 
	  }
        
}
