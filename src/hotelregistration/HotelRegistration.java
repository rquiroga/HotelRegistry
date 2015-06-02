/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelregistration;

import com.xmn.beans.Hotel;
import com.xmn.controller.HotelDao;
import com.xmn.db.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Ximena
 */
public class HotelRegistration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("beans.xml");

        DBConnection dbCon = new DBConnection();
        dbCon.getConnetion();

        try {
            
            Statement st = dbCon.getConnetion().createStatement();
            ResultSet rs = st.executeQuery("SELECT NAME, ADDRESS FROM HOTEL");            
            Hotel hotel = (Hotel) context.getBean("hotel");
            while (rs.next()) {
                hotel.setName(rs.getString("name"));
                hotel.setAddress(rs.getString("address"));
                System.out.println("1. Nombre: " + hotel.getName() + ", Direccion: " + hotel.getAddress());
            }
            
            HotelDao hotelDao = (HotelDao) context.getBean("hotelDao");       
            Hotel hotel1 = hotelDao.findHotel("Moon");
            
            Hotel hotel2 = new Hotel();
            hotel2.setName("Jupiter");
            hotel2.setAddress("Jupiter");
            hotelDao.insertHotel(hotel2);
            
            System.out.println("2. Nombre: " + hotel1.getName() + ", Direccion: " + hotel1.getAddress());
            
        } catch (SQLException ex) {
            Logger.getLogger(HotelRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
