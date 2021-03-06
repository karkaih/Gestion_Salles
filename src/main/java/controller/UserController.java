package controller;

import beans.salle;
import beans.user;
import com.google.gson.Gson;
import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import service.userService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.crypto.Data;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "UserController", value = "/UserController")

public class UserController extends HttpServlet {
    private userService  userService= new userService();
    public static HttpSession session;
    public static user currentUser;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
   
    	
    
        if (request.getParameter("op") != null  ) {
        	
        	
            if (request.getParameter("op").equals("createAccount")) {
            	Boolean sBoolean=false;
                response.setContentType("application/json");
                String email = request.getParameter("email");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String fullName = request.getParameter("fullname");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String level = request.getParameter("level");
                
                Gson json = new Gson();
                
                user u = new user(fullName,username,password,email,city,state,level);
                

                  
                response.setContentType("application/json");
                
              
                
                List<user> userList = userService.findAll();
                
             //   response.getWriter().write(json.toJson(userList1));
                	 
                for(user s : userList) {
               	 if(s.getUsername().equals(username)) {
               		sBoolean = true ;
               	 }
                }
                
               if(sBoolean) {
            	   
               	System.out.println("Hada deja kayn");
               	
               	response.getWriter().write(json.toJson(true));
               	
               }
               else {
            	   
               	System.out.println("nadi makaynch");
               	userService.create(u);
                List<user> userList1 = userService.findAll2();
               	response.getWriter().write(json.toJson(userList1));
               }
                
                
            }else if (request.getParameter("op").equals("delete")) {
            
                int id = Integer.parseInt(request.getParameter("id"));
                userService.delete(id);
                response.setContentType("application/json");
                List<user> userList = userService.findAll2();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(userList));
                
            } else if (request.getParameter("op").equals("findById")) {
                int id = Integer.parseInt(request.getParameter("id"));
                response.setContentType("application/json");
                user user = userService.findById(id);
                Gson json = new Gson();
                response.getWriter().write(json.toJson(user));
                
            } else if (request.getParameter("op").equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String email = request.getParameter("email");
                String username = request.getParameter("username");
                String fullName = request.getParameter("fullName");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String level = request.getParameter("level");
                user m = userService.findById(id);
                m.setUsername(username);
                m.setEmail(email);
                m.setCity(city);
                m.setState(state);
                m.setFullName(fullName);
                m.setLevel(level);
                userService.update(m);
                response.setContentType("application/json");
                List<user> userList = userService.findAll2();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(userList));

            }else if(request.getParameter("op").equals("logout")){
                response.setContentType("application/json");
                HttpSession session = request.getSession();
                session.invalidate();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(true));
            }else if(request.getParameter("op").equals("add")){
                response.setContentType("application/json");
                String email = request.getParameter("email");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String fullName = request.getParameter("fullName");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                Gson json = new Gson();
                user u = new user(fullName, username,password,null,email,city,state);
                boolean v=userService.create(u);
                response.getWriter().write(json.toJson(v));
            }else if(request.getParameter("op").equals("resetPass")){
                boolean v =false;
                response.setContentType("application/json");
                String email = request.getParameter("email");
                List<user> userList= userService.findAll();
                Gson json = new Gson();
                for(user u : userList)
                    if(u.getEmail().toLowerCase(Locale.ROOT).contains(email.toLowerCase(Locale.ROOT)))
                        v= userService.sendEmailRest(email,u.getId());
                response.getWriter().write(json.toJson(v));
            }else 
            	if(request.getParameter("op").equals("login") && request.getParameter("username") != null && request.getParameter("password")!=null)
            {
            		
                response.setContentType("application/json");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                List<user> userList= userService.findAll();
                Gson json = new Gson();
                
                for(user u : userList) {
                	 if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                		
                        currentUser=u;
                        session = request.getSession();
                        session.setAttribute("login", u);
                        
                        response.getWriter().write(json.toJson(u));
                    }
                }
                   
            }
        }else {
        	
            response.setContentType("application/json");
            List<user> userList = userService.findAll2();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(userList));
        }
        
    }
}
