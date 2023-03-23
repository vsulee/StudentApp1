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


@WebServlet("/newReg")
public class NewRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public NewRegistrationController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		
		DAOService service=new DAOServiceImpl();
		service.connectionDB();
		service.saveReg(name, city, email, mobile);
		
		request.setAttribute("msg","Record is saved");
		
		RequestDispatcher rd = request.getRequestDispatcher("new_registration.jsp");
		rd.forward(request, response);
		
		
}}