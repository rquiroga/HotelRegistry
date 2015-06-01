/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xmn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rosa Quiroga
 */
public class DBConnection {
    
    private Connection connection;

    public Connection getConnetion () {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:hoteldb", "system", "hoteldb");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (connection == null) {
            System.out.println("connection in null");
        }
        else {
            System.out.println("connection in ON");
        }
        
        return connection;
    }
}
