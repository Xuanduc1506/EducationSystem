/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Department;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface DepartmentDAO {
    public ArrayList<Department> getDepartmentToday(String date,int pageIndex,int pageSize,boolean detail) throws Exception;
    
    public ArrayList<Department> getDepartmentLastday(String date,int pageIndex,int pageSize,boolean detail) throws Exception;
    
    public int count() throws Exception;
    
    public ArrayList<Department> getAllDepartment() throws Exception;
}
