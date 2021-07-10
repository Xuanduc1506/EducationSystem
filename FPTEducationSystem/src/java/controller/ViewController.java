/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartmentDAO;
import dao.RequestDAO;
import dao.impl.DepartmentDAOImpl;
import dao.impl.RequestDAOImpl;
import date.DateTime;
import entity.Account;
import entity.Department;
import entity.Request;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ViewController extends BaseAuthenticationController {

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
            RequestDAO requestDAO = new RequestDAOImpl();
            ArrayList<Department> departments = departmentDAO.getAllDepartment();
            String preDepartmentID = request.getParameter("id_Department");
            String title = request.getParameter("title");
            if (preDepartmentID == null) {
                preDepartmentID = "0";
            }
            if(title==null){
                title="";
            }
            String pre_pageIndex = request.getParameter("page");
            if (pre_pageIndex == null) {
                pre_pageIndex = "1";
            }
            
            
            int pageIndex = Integer.parseInt(pre_pageIndex);
            int id_Department = Integer.parseInt(preDepartmentID);
            int numRecords = requestDAO.count(title.trim(),id_Department);
            int totalPage = (numRecords % 3 == 0)
                    ? numRecords / 3
                    : (numRecords / 3) + 1;
            ArrayList<Request> requests = requestDAO.getRequests(title.trim(), id_Department,pageIndex,3);
            request.setAttribute("departments", departments);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("id_Department", id_Department);
            request.setAttribute("requests", requests);
            request.setAttribute("title", title.trim());
            request.getRequestDispatcher("View.jsp").forward(request, response);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
