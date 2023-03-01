/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dal.Account;
import dal.DBContext;

import java.sql.SQLException;

/**
 *
 * @author macbookair
 */
public class AccountDAO extends DBContext {

    public Account getAccountByUsernameAndPassword(String username,
            String password) {
        ArrayList<Account> cc = new AccountDAO().getAllAccountt();
        for (Account x : cc) {

            if (username.equals(x.getUsername()) && password.equals(x.getPassword())) {
                Account account = new Account();
                account.setUsername(username);
                account.setPassword(password);
                return account;
            }

        }

        return null;
    }

    public ArrayList<Account> getAllAccountt() {

        ArrayList<Account> cc = new ArrayList<>();

        try {
            String sql = "Select * from Account";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account x = new Account(rs.getString("username"), rs.getString("password"));
                cc.add(x);

            }
        } catch (Exception e) {
        }
        return cc;
    }
    public void insertAccount(String username, String password) throws SQLException {

        String sql = "INSERT INTO Account VALUES (?, ?,0)";
        try {
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1, username);
           ps.setString(2, password);
           ps.executeUpdate();
           
        }catch (Exception E) {
            
        }

    }
    
    public Account checkAcountExist(String username) {
        
        try {
            String sql = "Select * from Account where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account x = new Account(rs.getString("username"), rs.getString("password"));
                return x;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new AccountDAO().getAllAccountt());
 //       System.out.println(new AccountDAO().getAccountByUsernameAndPassword("Mod", "Mod"));

    }

}
