/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xmn.controller.implementation;

import com.xmn.beans.Hotel;
import com.xmn.controller.HotelDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Ximena
 */
public class HotelDaoImp implements HotelDao {

    private DataSource dataSource;

    @Override
    public Hotel findHotel(String name) {

        String sql = "SELECT NAME, ADDRESS FROM HOTEL WHERE NAME = ?";
        Hotel hotel = null;
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                hotel = new Hotel();
                hotel.setName(rs.getString("NAME"));
                hotel.setAddress(rs.getString("ADDRESS"));
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(HotelDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelDaoImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return hotel;
    }

    @Override
    public void insertHotel(Hotel hotel) {
        String sql = "INSERT INTO HOTEL(NAME, ADDRESS) VALUES (?, ?)";
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, hotel.getName());
            ps.setString(2, hotel.getAddress());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(HotelDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HotelDaoImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
