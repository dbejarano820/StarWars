/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import Game.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PERSONAL
 */
public class ThreadServer extends Thread {
    
    private Socket socketRef;
    private DataInputStream reader;
    public DataOutputStream writer;
    public String nombre;
    private boolean running = true;
    public Server server;
    
    
    public ThreadServer(Socket socketRef, Server server) throws IOException {
      this.socketRef = socketRef;
      reader = new DataInputStream(socketRef.getInputStream());
      writer = new DataOutputStream(socketRef.getOutputStream());
      this.server = server;
  }        
   
   public void pasarTurno() throws IOException {
       
    String nextTurn = server.getNextTurno();
    for(int i = 0; i < server.conexiones.size(); i++){
      ThreadServer current = server.conexiones.get(i);
      current.writer.writeInt(1);
      current.writer.writeUTF(nextTurn);                 
     }           
   }
    
   
    public void run(){
        
        int instruccionID = 1;
        while(running){
            
            
            if(server.ordenPlayers.size() == 1){
                
                System.out.println("hay ganador");

                return;
            }
            
            try {
               instruccionID = reader.readInt(); //espera hasta recibir un entero
               String usuario = "";  //variable de usuario para utilizar en todos los casos
               Player jugadorTmp = null; //variable de player para utilizar en cualquier caso
               String msj = ""; //variable para utilizar a lo largo de los casos
               
               
               switch(instruccionID){
                   
                   case 1: //caso para agregar jugador a la lista
                       nombre = reader.readUTF();
                       server.players.add(new Player(nombre));
                       //add player to list of players del server           
                   break;
                   
                   case 2:
                       usuario = reader.readUTF();
                       String comando = reader.readUTF();
                       String[] comandos = comando.split("-");
                       
                       
                       if(comandos[0].equals("place")){  //comando para crear 1 de 3 heroes
                           jugadorTmp = server.buscarPlayer(usuario);
                           
                           if(jugadorTmp.gameReady){
                               writer.writeInt(2);
                               writer.writeUTF("ERROR. You have already completed your army!");
                               break;
                           }
                       }
               }               
            } catch (IOException ex){
                
             
            }
        } 
    }
    


}
