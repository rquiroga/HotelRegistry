/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelregistration;

import com.xmn.beans.Hotel;
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
        
        Hotel hotel = (Hotel) context.getBean("hotel");
        System.out.print("Nombre: " + hotel.getName() + ", Direccion: " + hotel.getAddress());
    }
    
}
