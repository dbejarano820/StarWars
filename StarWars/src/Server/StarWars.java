/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author PERSONAL
 */
public class StarWars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PantallaServer pantalla = new PantallaServer();
        Server srv = new Server(pantalla);
        pantalla.setVisible(true);
        pantalla.setServer(srv);
        srv.runServer();  
        
    }
    
}
