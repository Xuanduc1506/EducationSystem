/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;

/**
 *
 * @author Admin
 */
public interface AccountDAO {
    public Account getAccount(String userName,String password) throws Exception;
}
