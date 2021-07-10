/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartmentDAO;
import dao.impl.DepartmentDAOImpl;
import date.DateTime;
import entity.Account;
import entity.Department;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class HomeController extends BaseAuthenticationController {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get date and time
        DateTime dateTime = new DateTime();
        String dateAndTime = dateTime.getDate();
        request.setAttribute("dateTime", dateAndTime);
        //get userName
        Account account = (Account) request.getSession().getAttribute("account");
        request.setAttribute("username", account.getUserName());
        try {
            DepartmentDAO departmentDAO = new DepartmentDAOImpl();
            String pre_pageIndex = request.getParameter("page");
            if (pre_pageIndex == null) {
                pre_pageIndex = "1";
            }
            
            int pageIndex = Integer.parseInt(pre_pageIndex);
            String date = java.time.LocalDate.now().toString();
            ArrayList<Department> departments = departmentDAO.getDepartmentToday(date, pageIndex, 3, false);
            ArrayList<Department> departmentsLastday = departmentDAO.getDepartmentLastday(date, pageIndex, 3, false);
            int numRecords = departmentDAO.count();
            int totalPage = (numRecords % 3 == 0)
                    ? numRecords / 3
                    : (numRecords / 3) + 1;
            
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("date", date);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("departments", departments);
            request.setAttribute("departmentsLastday", departmentsLastday);
            
            
            
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

        
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
