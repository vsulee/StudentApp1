package com.studentapp1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentapp1.model.DAOService;
import com.studentapp1.model.DAOServiceImpl;


@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// we can call the view part
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//controller will read the model layer 
		
		  DAOService service = new DAOServiceImpl();
		  service.connectionDB();
		 boolean status= service.verifyCredentials(email, password);
		  if(status==true) {
		  }else {
			 request.setAttribute("error","invalid username/password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
		
		
	}

}
