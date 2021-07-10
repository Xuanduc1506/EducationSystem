/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RequestDAO;
import dao.impl.RequestDAOImpl;
import date.DateTime;
import entity.Account;
import entity.Request;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class SolveController extends BaseAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //get date and time
            DateTime dateTime = new DateTime();
            String dateAndTime = dateTime.getDate();
            request.setAttribute("dateTime", dateAndTime);

            Account account = (Account) request.getSession().getAttribute("account");
            request.setAttribute("username", account.getUserName());
            RequestDAO requestDAO = new RequestDAOImpl();
            Request req;
            String preId = request.getParameter("id");
            if (preId == null) {
                req = requestDAO.getLatestRequest(1);
            } else {
                int id = Integer.parseInt(preId);
                req = requestDAO.getRequest(id);
            }
            String nowDate = java.time.LocalDate.now().toString();
            request.setAttribute("req", req);
            request.setAttribute("nowDate", nowDate);
            request.getRequestDispatcher("Solve.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String status = request.getParameter("state");
            //get date and time
            DateTime dateTime = new DateTime();
            String dateAndTime = dateTime.getDate();
            request.setAttribute("dateTime", dateAndTime);
            if (status == null) {

                String message = "Please choose the state";
                request.setAttribute("message", message);
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            } else {
                int id = Integer.parseInt(request.getParameter("id"));
                String nowDate = java.time.LocalDate.now().toString();
                String solution = request.getParameter("solution");
                RequestDAO requestDAO = new RequestDAOImpl();
                requestDAO.updateRequest(id, status, nowDate, true, solution);
                HomeController homeController = new HomeController();
                homeController.doGet(request, response);
//                request.getRequestDispatcher("Home.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

    }

}
