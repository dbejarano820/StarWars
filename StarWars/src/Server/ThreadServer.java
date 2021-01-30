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
   
    public void pintarNext(String player) throws IOException {
       
    for(int i = 0; i < server.conexiones.size(); i++){
      ThreadServer current = server.conexiones.get(i);
      current.writer.writeInt(5);
      current.writer.writeUTF(player);                 
     }           
   }
 
   public void mandarConsola(String msj) throws IOException {

        for(int i = 0; i < server.conexiones.size(); i++){
            ThreadServer current = server.conexiones.get(i);
            if(current.nombre.equals(server.players.get(i).nombre)){
                 current.writer.writeInt(4);
                 current.writer.writeUTF(msj);                 
              }  
        }  
   }
     public void mandarConsolaTodas(String msj) throws IOException {

        for(int i = 0; i < server.conexiones.size(); i++){
            ThreadServer current = server.conexiones.get(i);
            current.writer.writeInt(4);
            current.writer.writeUTF(msj);                 
               
        }  
   }  
   
   public void updateMatrizClientePropia() throws IOException{
       
     for(int i = 0; i < server.conexiones.size(); i++){
            ThreadServer current = server.conexiones.get(i);
            
            if(current.nombre.equals(server.players.get(i).nombre)){      
                current.writer.writeInt(3);
                
                
                  for(int row = 0; row < server.players.get(i).tablero.length; row++)
                    for(int col = 0; col < server.players.get(i).tablero[row].length; col++){
                        
                        current.writer.writeInt(server.players.get(i).tablero[row][col].ID);
                        current.writer.writeInt(server.players.get(i).tablero[row][col].ID);
                        current.writer.writeInt(server.players.get(i).tablero[row][col].ID);
                        current.writer.writeInt(server.players.get(i).tablero[row][col].ID);
                    }              
            }   
     }  
   }
   
   
 public void updateMatrizClienteEnemigo(String msj) throws IOException {
       
     Player playerTmp = server.buscarPlayer(msj);
       
     for(int i = 0; i < server.conexiones.size(); i++){
            ThreadServer current = server.conexiones.get(i);
            
            if(current.nombre.equals(server.players.get(i).nombre)){      
                current.writer.writeInt(4);            
                
                  for(int row = 0; row < server.players.get(i).tablero.length; row++)
                    for(int col = 0; col < server.players.get(i).tablero[row].length; col++){
                        
                        current.writer.writeInt(playerTmp.tablero[row][col].ID);
                        current.writer.writeInt(playerTmp.tablero[row][col].ID);
                        current.writer.writeInt(playerTmp.tablero[row][col].ID);
                        current.writer.writeInt(playerTmp.tablero[row][col].ID);
                    }              
            }   
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
               String componente = "";
               int x;
               int y;
               int xC;
               int yC;
               
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
                               writer.writeUTF("ERROR. You have already placed your starting componentes!");
                               break;
                           }
                           
                           if(comandos[1].equals("mundo")){
                               x = Integer.parseInt(comandos[3]);
                               y = Integer.parseInt(comandos[5]);
                               
                               Mundo mundo = new Mundo("mundo", 4, jugadorTmp);
                               jugadorTmp.tablero[y][x].componente = mundo;
                               jugadorTmp.tablero[y+1][x].componente = mundo;
                               jugadorTmp.tablero[y+1][x+1].componente = mundo;                             
                               jugadorTmp.tablero[y][x+1].componente = mundo;
                               jugadorTmp.tablero[y][x].ID = 1;
                               jugadorTmp.tablero[y+1][x].ID = 1;
                               jugadorTmp.tablero[y+1][x+1].ID = 1;                            
                               jugadorTmp.tablero[y][x+1].ID = 1; 
                               mandarConsola("Colocaste un mundo con exito!\n");
                               updateMatrizClientePropia();
                               break;
                           } 
                           else if(comandos[1].equals("conector")){
                               x = Integer.parseInt(comandos[3]);
                               y = Integer.parseInt(comandos[5]);
                               xC = Integer.parseInt(comandos[7]);
                               yC = Integer.parseInt(comandos[9]);
                               
                               Conector conector = new Conector("conector", 1, jugadorTmp);
                               jugadorTmp.tablero[y][x].componente = conector;
                               jugadorTmp.tablero[y][x].ID = 2;
                               conector.conectar(jugadorTmp.tablero[yC][xC].componente);
                               mandarConsola("Colocaste tu conector inicial con exito!\n");
                               updateMatrizClientePropia();                              
                               break;
                           }
                           else if(comandos[1].equals("market")){
                               x = Integer.parseInt(comandos[3]);
                               y = Integer.parseInt(comandos[5]);
                               xC = Integer.parseInt(comandos[7]);
                               yC = Integer.parseInt(comandos[9]);
                               
                               Mercado market = new Mercado("conector", 1, jugadorTmp);
                               jugadorTmp.tablero[y][x].componente = market;
                               jugadorTmp.tablero[y][x].ID = 3;
                               market.conectar(jugadorTmp.tablero[yC][xC].componente);
                               mandarConsola("Colocaste tu mercado inicial con exito!\n");
                               updateMatrizClientePropia();                              
                               break;                                 
                           }
                           
                       }
                       
                        
                       else if(comandos[0].equals("skip")){ //comando para saltarse su turno y no atacar
                         
                           if(server.getTurno().equals(usuario)){
                               
                                for(int i = 0; i < server.conexiones.size(); i++){
                                  ThreadServer current = server.conexiones.get(i);
                                  current.writer.writeInt(2);
                                  current.writer.writeUTF(">> " + usuario + " has skipped his turn!");                 
                                 }

                                pasarTurno();
                           }
                            else{
                               writer.writeInt(2);
                               writer.writeUTF("ERROR. It is not your turn!"); 
                           }    
                       }
                       else if(comandos[1].equals("chat")){
                           
                        msj = "(Chat) " + usuario + " > "+ comandos[1]; 

                        for(int i = 0; i < server.conexiones.size(); i++){
                            ThreadServer current = server.conexiones.get(i);
                            current.writer.writeInt(4);
                            current.writer.writeUTF(msj);                 
                        }                           
                           
                       }
                       else if(comandos[1].equals("market")){
                           
                       }
                        else if(comandos[1].equals("buy")){
                           
                       }                      
                        else if(comandos[1].equals("attack")){
                           
                       }                      
                        else if(comandos[1].equals("inventory")){
                           
                       }                      
                        else if(comandos[1].equals("info")){
                           
                       }    
                        else{ //si no hay ninguna entrada valida
                           writer.writeInt(2);
                           writer.writeUTF("ERROR. Invalid command!");
                       } 
                   break;
                   
                   case 3:
                       String enemigoDeseado = reader.readUTF();
                       updateMatrizClienteEnemigo(enemigoDeseado);
                      
                   break;
                   
                   case 4:
                       String next = server.getNextName();
                       if(!nombre.equals(next)){
                           pintarNext(next);
                       }
                       else{
                           String next1 = server.getNextName();
                           pintarNext(next);
                       }
                   break;
                   
               }               
            } catch (IOException ex){
                
             
            }
        } 
    }
    


}
