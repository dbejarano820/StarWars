/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;


import java.net.Socket;
import javax.swing.JOptionPane;
import Game.*;
import javax.swing.JLabel;



public class Cliente {
    
    
    Socket socketRef;
    public PantallaCliente refPantalla;
    public ThreadPlayer hiloPlayer;  
    boolean gameready;
    public String nombre;
    public Casilla[][] tableroCliente;
    public Casilla[][] tableroEnemigo;
    
    public Cliente(PantallaCliente refPantalla){
        this.refPantalla = refPantalla;
        tableroCliente = new Casilla[15][15];
        tableroEnemigo = new Casilla[15][15];
    }
    
    
    public void conectar(){

    try{

        socketRef = new Socket("localhost", 35577);

        hiloPlayer = new ThreadPlayer(socketRef, refPantalla, this);
        hiloPlayer.start();
        String nombreTmp = JOptionPane.showInputDialog("Enter your name:");
        this.nombre = nombreTmp;
        refPantalla.setTitle(nombre + " --- Star Wars");
        refPantalla.setCliente(this);
        hiloPlayer.writer.writeInt(1); //instruccion para el switch del thraed servidor
        hiloPlayer.writer.writeUTF(nombre); //instruccion para el switch del thraed servidor


    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }   
}
    
    
    
}
