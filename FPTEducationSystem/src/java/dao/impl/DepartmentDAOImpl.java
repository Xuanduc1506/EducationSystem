/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.DBContext;
import dao.DepartmentDAO;
import entity.Department;
import entity.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DepartmentDAOImpl extends DBContext implements DepartmentDAO {

    int count = 0;

    @Override
    public ArrayList<Department> getDepartmentToday(String date, int pageIndex, int pageSize, boolean detail) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM Request r INNER JOIN Department d \n"
                + "on r.id_Department = d.id \n"
                + "WHERE r.dateCreated=? AND r.detail=?";
        try {
            Department department = new Department();
            department.setId(-1);
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            ps.setBoolean(2, detail);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (department.getId() != rs.getInt("id_Department")) {
                    department = new Department();
                    department.setId(rs.getInt("id_Department"));
                    department.setName(rs.getString("name"));
                    if (count < (pageIndex * pageSize) && count >= ((pageIndex - 1) * pageSize)) {
                        departments.add(department);
                    }
                    count++;
                }
                Request request = new Request();
                request.setId(rs.getInt("id"));
                request.setStudentID(rs.getInt("studentID"));
                request.setStudentName(rs.getString("studentName"));
                request.setDepartment(department);
                request.setDateCreated(date);
                request.setTitle(rs.getString("title"));
                request.setContent(rs.getString("content"));
                request.setStatus(rs.getString("status"));
                request.setCloseDatel(rs.getString("closeDate"));
                request.setDetail(detail);
                department.getRequests().add(request);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return departments;
    }
    int count2 = 0;

    @Override
    public ArrayList<Department> getDepartmentLastday(String date, int pageIndex, int pageSize, boolean detail) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM Request r INNER JOIN Department d \n"
                + "on r.id_Department = d.id \n"
                + "WHERE r.dateCreated!=? AND r.detail=?";
        try {
            Department department = new Department();
            department.setId(-1);
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            ps.setBoolean(2, detail);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (department.getId() != rs.getInt("id_Department")) {
                    department = new Department();
                    department.setId(rs.getInt("id_Department"));
                    department.setName(rs.getString("name"));
                    if (count2 < (pageIndex * pageSize) && count2 >= ((pageIndex - 1) * pageSize)) {
                        departments.add(department);
                    }
                    count2++;
                }
                Request request = new Request();
                request.setId(rs.getInt("id"));
                request.setStudentID(rs.getInt("studentID"));
                request.setStudentName(rs.getString("studentName"));
                request.setDepartment(department);
                request.setDateCreated(date);
                request.setTitle(rs.getString("title"));
                request.setContent(rs.getString("content"));
                request.setStatus(rs.getString("status"));
                request.setCloseDatel(rs.getString("closeDate"));
                request.setDetail(detail);
                department.getRequests().add(request);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return departments;
    }

    @Override
    public int count() throws Exception {
        if (count > count2) {
            return count;
        } else {
            return count2;
        }
    }

    @Override
    public ArrayList<Department> getAllDepartment() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM Department";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                departments.add(department);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return departments;
    }

}
