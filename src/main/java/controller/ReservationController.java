package controller;

import beans.creneaux;
import beans.reservation;
import beans.salle;
import com.google.gson.Gson;
import service.ReservationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
                reservationService.delete(reservationService.findById(id).getId());
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
                double startDate = Double.parseDouble(request.getParameter("startDate"));
                double endDate = Double.parseDouble(request.getParameter("endDate"));
                int clientid = reservationService.createCreneaux(new creneaux(startDate,endDate));
                reservationService.create(new reservation(note,type, UserController.currentUser.getId(), clientid));
                response.setContentType("application/json");
                List<reservation> userList = reservationService.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(userList));
            }else if (request.getParameter("op").equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Object salle = request.getParameter("salle");
                reservation m = reservationService.findById(id);
                m.setSalle(((beans.salle) salle).getId());
                response.setContentType("application/json");
                reservationService.update(m);
                List<reservation> userList = reservationService.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(userList));

            }
        }else  {
            response.setContentType("application/json");
            List<reservation> userList = reservationService.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(userList));
        }
    }

}
