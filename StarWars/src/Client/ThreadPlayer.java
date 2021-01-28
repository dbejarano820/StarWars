/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author PERSONAL
 */
public class ThreadPlayer extends Thread {
    
   
    private Socket socketRef;
    public Cliente refCliente;
    public DataInputStream reader; 
    public DataOutputStream writer;
    private boolean running = true;
    private PantallaCliente refPantalla;

    public ThreadPlayer(Socket socketRef, PantallaCliente refPantalla, Cliente refCliente) throws IOException {
        this.socketRef = socketRef;
        this.refCliente = refCliente;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        this.refPantalla = refPantalla;
    }
        
    public void run (){
        
        int instruccionId = 1;
        while (running){
            try {
                String usuario = "";
                String msj = "";
                instruccionId = reader.readInt(); // esperar hasta que reciba un entero
                
                switch (instruccionId){
                    case 1: // recibe el turno del jugador que le toca
                        usuario = reader.readUTF(); 
                    //    refPantalla.setNombreTurno(usuario);
                    //    refPantalla.pintarTurno(usuario);
                   //    refPantalla.colorMatriz();
                        
                        
                    break;
                    
                    case 2: // recibe el usuario y el msj del comando invalido/respuesta de la consola
                        msj = reader.readUTF();
                    }
                } catch (IOException ex) {
                        
                        }
                
         }
        }
}
    
    
