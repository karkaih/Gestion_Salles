package controller;

import beans.salle;
import com.google.gson.Gson;
import service.salleServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
                 String name = request.getParameter("name");
                 String capacity = request.getParameter("capacity");
                 String type = request.getParameter("type");
                 salleServices.create(new salle(name, capacity, type,0));
                 response.setContentType("application/json");
                 List<salle> userList = salleServices.findAll();
                 Gson json = new Gson();
                 response.getWriter().write(json.toJson(userList));
             }else if (request.getParameter("op").equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String capacity = request.getParameter("capacity");
                String type = request.getParameter("type");
                salle m = salleServices.findById(id);
                m.setName(name);
                m.setCapacity(capacity);
                m.setType(type);
                response.setContentType("application/json");
                salleServices.update(m);
                List<salle> userList = salleServices.findAll();
                Gson json = new Gson();
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

            }
        }else  {
            response.setContentType("application/json");
            List<salle> userList = salleServices.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(userList));
        }
    }

}
