/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Request;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface RequestDAO {
    
    public ArrayList<Request> getRequests(String title,int id_Department,int pageIndex,int pageSize) throws Exception;
    
    public int count(String title, int id_Department) throws Exception;
    
    public Request getLatestRequest (int top) throws Exception;
    
    public Request getRequest(int id) throws Exception;
    
    public void updateRequest(int id,String status,String closeDate,boolean detail,String solution) throws Exception;
    
}
