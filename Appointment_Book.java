/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment_book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moises
 */
public class Appointment_Book {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/appointmentbook");
            //view view = new view();
            //view.setVisible(true);
            Calenderview cview = new Calenderview();
            cview.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Appointment_Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
