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
    private boolean pintado = false;

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
                        refPantalla.setNombreTurno(usuario);
                        refPantalla.pintarTurno(usuario);

                                           
                    break;
                    
                    case 2: // se agrega el msj a la consola solo de uno
                        msj = reader.readUTF();
                        refPantalla.addConsolaPropia(msj);
                    break;
              
                    
                    case 3: //para actualizar la matriz propia del cliente
                        
                        for(int row = 0; row < refCliente.tableroCliente.length; row++)
                            for(int col = 0; col < refCliente.tableroCliente[row].length; col++){
                            
                                int ID = reader.readInt();
                                int explotado = reader.readInt();
                                int visible = reader.readInt();
                                int revelada = reader.readInt();
                                
                                refCliente.tableroCliente[row][col].ID = ID;                          
                                refCliente.tableroCliente[row][col].explotado = explotado;
                                refCliente.tableroCliente[row][col].visible = visible;
                                refCliente.tableroCliente[row][col].revelada = revelada;
                            }    
                        
                    case 4: //para actualizar la matriz del enemigo en pantalla
                        
                          for(int row = 0; row < refCliente.tableroEnemigo.length; row++)
                            for(int col = 0; col < refCliente.tableroEnemigo[row].length; col++){
                            
                                int ID = reader.readInt();
                                int explotado = reader.readInt();
                                int visible = reader.readInt();
                                int revelada = reader.readInt();
                                
                                refCliente.tableroEnemigo[row][col].ID = ID;                          
                                refCliente.tableroEnemigo[row][col].explotado = explotado;
                                refCliente.tableroEnemigo[row][col].visible = visible;
                                refCliente.tableroEnemigo[row][col].revelada = revelada;
                            }  
                          
                          
                    case 5:
                        String playerNext = reader.readUTF();
                        refPantalla.pintarNextEnemy(playerNext);        
                        
                    break;
                      
                    }
                } catch (IOException ex) {
                        
                        }
                
         }
        }
}
    
    
