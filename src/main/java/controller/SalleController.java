package controller;

import beans.salle;
import beans.user;

import com.google.gson.Gson;

import service.ReservationService;
import service.salleServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.Console;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SalleController", value = "/SalleController")
public class SalleController extends HttpServlet {
	
    salleServices salleServices = new salleServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        if (request.getParameter("op") != null) {
        	if (request.getParameter("op").equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                salleServices.delete(salleServices.findById(id).getId());
                response.setContentType("application/json");
                List<salle> userList = salleServices.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(userList));
            } else if (request.getParameter("op").equals("findById")) {
                int id = Integer.parseInt(request.getParameter("id"));
                response.setContentType("application/json");
                salle user = salleServices.findById(id);
                Gson json = new Gson();
                response.getWriter().write(json.toJson(user));
            } else if (request.getParameter("op").equals("add")) {
            	Boolean sBoolean=false;
                 String name = request.getParameter("name");
                 String capacity = request.getParameter("capacity");
                 String type = request.getParameter("type");
                
                 response.setContentType("application/json");
                 List<salle> userList = salleServices.findAll();
                 Gson json = new Gson();
                 
                 for(salle s : userList) {
                	 if(s.getName().equals(name)) {
                		sBoolean = true ;
                	 }
                 }
                 
                if(sBoolean) {
                	System.out.println("Hada deja kayn");
                	response.getWriter().write(json.toJson(true));
                }else {
                	System.out.println("nadi makaynch");
                	 salleServices.create(new salle(name, capacity, type,0));
                	response.getWriter().write(json.toJson(userList));
                }
                 
                 
             }else if (request.getParameter("op").equals("update")) {
            		Boolean sBoolean=false;
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String capacity = request.getParameter("capacity");
                String type = request.getParameter("type");
                
                salle m = salleServices.findById(id);
                
                m.setName(name);
                m.setCapacity(capacity);
                m.setType(type);
                response.setContentType("application/json");
                List<salle> userList = salleServices.findAll();
                Gson json = new Gson();
                
                
                
                	
                	salleServices.update(m);
                    response.getWriter().write(json.toJson(userList));
               
                
                
                
            }else if (request.getParameter("op").equals("reserveSalle")) {
                int id = Integer.parseInt(request.getParameter("id"));
                salle m = salleServices.findById(id);
                m.setnReservation(m.getnReservation()+1);
                response.setContentType("application/json");
                salleServices.update(m);
                List<salle> userList = salleServices.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(userList));

            }else if (request.getParameter("op").equals("getMostBooked")) {
                salle m = salleServices.findByNumberReservation();
                response.setContentType("application/json");
                Gson json = new Gson();
                response.getWriter().write(json.toJson(m));

            }else if (request.getParameter("op").equals("getMostBooked")) {
                salle m = salleServices.findByNumberReservation();
                response.setContentType("application/json");
                Gson json = new Gson();
                response.getWriter().write(json.toJson(m));

            }else if (request.getParameter("op").equals("FindAvailable")) {
            	
            	ReservationService rs = new  ReservationService();
            	 response.setContentType("application/json");
                 List<salle> userList = rs.findAvailable();
                 for(salle user : userList) {
                	 System.out.println(user.getId());
                		
                 }
                 Gson json = new Gson();
                 response.getWriter().write(json.toJson(userList));

            }
        	
        }
        else  {
        	
            response.setContentType("application/json");
            List<salle> userList = salleServices.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(userList));
        
        }
        
    }

}
