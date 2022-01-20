package controller;

import beans.CalendarDTO;
import beans.creneaux;
import beans.reservation;
import beans.salle;
import com.google.gson.Gson;
import service.ReservationService;
import service.salleServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ReservationController", value = "/ReservationController")
public class ReservationController extends HttpServlet {
    ReservationService reservationService = new ReservationService();
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
                reservationService.delete(id);
                response.setContentType("application/json");
                List<reservation> userList = reservationService.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(userList));
            } else if (request.getParameter("op").equals("findById")) {
                int id = Integer.parseInt(request.getParameter("id"));
                response.setContentType("application/json");
                reservation user = reservationService.findById(id);
                Gson json = new Gson();
                response.getWriter().write(json.toJson(user));
            } else if (request.getParameter("op").equals("findMine")) {
                response.setContentType("application/json");
                List<reservation> user = reservationService.findByClientId(UserController.currentUser.getId());
                Gson json = new Gson();
                response.getWriter().write(json.toJson(user));
            } else if (request.getParameter("op").equals("add")) {
            	
                String note = request.getParameter("note");
                String type = request.getParameter("type");
                String salle = request.getParameter("salle");
                System.out.println(salle);

                Date startDate = new Date(request.getParameter("startDate").replace("-", "/")) ;
                Date endDate = new Date (request.getParameter("endDate").replace("-", "/"));
                System.out.println(startDate);
                
                
                if(startDate.compareTo(endDate) <0) {
                	reservationService.create(new reservation(note,type,salle, UserController.currentUser.getId(), startDate,endDate));
                    
                    response.setContentType("application/json");
                    List<reservation> userList = reservationService.findAll();
                    Gson json = new Gson();
                    response.getWriter().write(json.toJson(userList));
                }
                else {
                	response.setContentType("application/json");
                	
                	 Gson json = new Gson();
                     response.getWriter().write(json.toJson(true));
                }
                
                
            }else if (request.getParameter("op").equals("update")) {
            	salleServices salleService = new salleServices();
            	response.setContentType("application/json");
                int id = Integer.parseInt(request.getParameter("id"));
                String salle = request.getParameter("salle");
                reservation m = reservationService.findById(id);
                m.setSalle(salle);
                salle s = salleService.findByName(salle);
                s.setnReservation(s.getnReservation()+1);
                salleService.update(s);
                reservationService.update(m);
                List<reservation> userList = reservationService.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(userList));

            
        }else if (request.getParameter("op").equals("BNM")) {
            response.setContentType("application/json");
            List<CalendarDTO> calendarDTOS = reservationService.findBookingNByMonth();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(calendarDTOS));
            
        } 
        
        else  {
            response.setContentType("application/json");
            List<reservation> userList = reservationService.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(userList));
        }
            
    
        
    }
}
    
    
    
}