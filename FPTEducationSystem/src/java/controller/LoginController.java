/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.impl.AccountDAOImpl;
import date.DateTime;
import entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DateTime dateTime = new DateTime();
        String dateAndTime = dateTime.getDate();
        request.setAttribute("dateTime", dateAndTime);
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DateTime dateTime = new DateTime();
            String dateAndTime = dateTime.getDate();
            request.setAttribute("dateTime", dateAndTime);
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            AccountDAO accountDAO = new AccountDAOImpl();
            Account account = accountDAO.getAccount(userName, password);
            if (account.getUserName() == null) {
                String message = "Invalid username or password";
                request.setAttribute("message", message);
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("account", account);
                String message = "Login successfully";
                request.setAttribute("message", message);
                request.setAttribute("username", account.getUserName());
                response.sendRedirect("Home");
            }
        } catch (Exception e) {
            DateTime dateTime = new DateTime();
            String dateAndTime = dateTime.getDate();
            request.setAttribute("dateTime", dateAndTime);
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
