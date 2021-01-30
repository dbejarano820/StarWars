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
    private boolean mundoInicio = false;
    private boolean conectorInicio = false;
    private boolean marketInicio = false;
    
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
   
 
   public void mandarConsola(String msj) throws IOException {

        writer.writeInt(2);
        writer.writeUTF(msj + "\n");                  
   }
     public void mandarConsolaTodas(String msj) throws IOException {

        for(int i = 0; i < server.conexiones.size(); i++){
            ThreadServer current = server.conexiones.get(i);
            current.writer.writeInt(2);
            current.writer.writeUTF(">> " + msj + "\n");                 
               
        }  
   }  
     
     
   public void updateDinero() throws IOException {
       
       for(int i = 0; i < server.conexiones.size(); i++){
            ThreadServer current = server.conexiones.get(i);
            
            if(current.nombre.equals(server.players.get(i).nombre)){      
                current.writer.writeInt(6);
                current.writer.writeInt(server.players.get(i).Dinero);
                current.writer.writeInt(server.players.get(i).Acero);
            }   
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
                        current.writer.writeInt(server.players.get(i).tablero[row][col].explotado);
                        current.writer.writeInt(server.players.get(i).tablero[row][col].visible);
                        current.writer.writeInt(server.players.get(i).tablero[row][col].revelada);
                    }              
            }   
     }  
   }
   
   
 public void updateMatrizClienteEnemigo(String playerEnemigo, String playerSolicitante) throws IOException {
       
     Player playerTmp = server.buscarPlayer(playerEnemigo);
     Player jugadorSolicitante = server.buscarPlayer(playerSolicitante);
       
     for(int i = 0; i < server.conexiones.size(); i++){
            ThreadServer current = server.conexiones.get(i);
            
            if(current.nombre.equals(jugadorSolicitante.nombre)){      
                current.writer.writeInt(4);            
                
                  for(int row = 0; row < server.players.get(i).tablero.length; row++)
                    for(int col = 0; col < server.players.get(i).tablero[row].length; col++){
                        
                        current.writer.writeInt(playerTmp.tablero[row][col].ID);
                        current.writer.writeInt(playerTmp.tablero[row][col].explotado);
                        current.writer.writeInt(playerTmp.tablero[row][col].visible);
                        current.writer.writeInt(playerTmp.tablero[row][col].revelada);
                    }
                break;
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
                       server.players.add(new Player(nombre, server));
                       server.buscarPlayer(nombre).generateBlackHole();
                       updateMatrizClientePropia();
                       updateDinero();
                       //add player to list of players del server           
                   break;
                   
                   case 2:
                       usuario = reader.readUTF();
                       String comando = reader.readUTF();
                       String[] comandos = comando.split("-");            
                       jugadorTmp = server.buscarPlayer(usuario);
                        
                       if(comandos[0].equals("place")){  //comando para crear 1 de 3 heroes

                           
                           if(jugadorTmp.gameReady){
                               writer.writeInt(2);
                               writer.writeUTF("ERROR. You have already placed your starting componentes!");
                               break;
                           }
                           
                           if(comandos[1].equals("mundo") && !mundoInicio){
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
                               mandarConsola("Colocaste tu mundo inicial con exito!\n");
                               mundoInicio = true;
                               updateMatrizClientePropia();
                               break;
                           } 
                           else if(comandos[1].equals("conector") && !conectorInicio){
                               x = Integer.parseInt(comandos[3]);
                               y = Integer.parseInt(comandos[5]);
                               xC = Integer.parseInt(comandos[8]);
                               yC = Integer.parseInt(comandos[10]);
                               
                               Conector conector = new Conector("conector", 1, jugadorTmp);
                               jugadorTmp.tablero[y][x].componente = conector;
                               jugadorTmp.tablero[y][x].ID = 2;
                               conector.conectar(jugadorTmp.tablero[yC][xC].componente);
                               mandarConsola("Colocaste tu conector inicial con exito!\n");
                               conectorInicio = true;
                               updateMatrizClientePropia();                              
                               break;
                           }
                           else if(comandos[1].equals("mercado")){
                               x = Integer.parseInt(comandos[3]);
                               y = Integer.parseInt(comandos[5]);
                               xC = Integer.parseInt(comandos[8]);
                               yC = Integer.parseInt(comandos[10]);
                               
                               Mercado market = new Mercado("mercado", 1, jugadorTmp);
                               jugadorTmp.tablero[y][x].componente = market;
                               jugadorTmp.tablero[y][x+1].componente = market;
                               jugadorTmp.tablero[y][x].ID = 3;
                               jugadorTmp.tablero[y][x+1].ID = 3;
                               market.conectar(jugadorTmp.tablero[yC][xC].componente);
                               mandarConsola("Colocaste tu mercado inicial con exito!\n");
                               marketInicio = true;
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
                        else if(comandos[0].equals("chat")){
                           
                        msj = "(Chat) " + usuario + " > "+ comandos[1]; 

                           mandarConsolaTodas(msj);
                           
                       }
                        else if(comandos[0].equals("mercado")){
   
                           if(jugadorTmp.mercadoDisponible()){
             
                              String mercadoDecision = comandos[1];
                           
                              if(mercadoDecision.equals("vender")){
                               
                                if(comandos[2].equals("tienda")){
                                   
                                   String articulo = comandos[3];
                                   
                                   if(articulo.equals("acero") && jugadorTmp.Acero > 1000){
                                       jugadorTmp.Acero -= 1000;
                                       jugadorTmp.Dinero += 1000;
                                       mandarConsola("El trato fue efectivo!");
                                   }
                                   else if(articulo.equals("misil") && jugadorTmp.misiles > 0){
                                       jugadorTmp.misiles -= 1;
                                       jugadorTmp.Dinero += 400;
                                       mandarConsola("El trato fue efectivo!");
                                   }
                                    else if(articulo.equals("bomba") && jugadorTmp.bombas > 0){
                                       jugadorTmp.bombas -= 1;
                                       jugadorTmp.Dinero += 1900;
                                       mandarConsola("El trato fue efectivo!");
                                   }
                                   else if(articulo.equals("multishot") && jugadorTmp.multi > 0){
                                       jugadorTmp.multi -= 1;
                                       jugadorTmp.Dinero += 900;
                                       mandarConsola("El trato fue efectivo!");
                                   }                                   
                                   else if(articulo.equals("comboshot") && jugadorTmp.combo > 0){
                                       jugadorTmp.combo -= 1;
                                       jugadorTmp.Dinero += 4900;
                                       mandarConsola("El trato fue efectivo!");
                                   }                                   
                                   else{
                                       mandarConsola("No es posible llevar a cabo el trato!");
                                   }
                                   
                               }
                                else{
                                   Player jugadorTmp2 = server.buscarPlayer(comandos[2]);
                                   server.tradeItem = comandos[3];
                                   server.tradeItemQuantity = Integer.parseInt(comandos[4]);
                                   server.tradePrice = Integer.parseInt(comandos[5]);
                                   server.tradeOwner = jugadorTmp;
                                   
                                   for(int i = 0; i < server.conexiones.size(); i++){
                                       if(server.conexiones.get(i).nombre.equals(jugadorTmp2.nombre)){
                                           ThreadServer current = server.conexiones.get(i);
                                           current.writer.writeInt(7);
                                           current.writer.writeUTF(jugadorTmp.nombre + " le ofrece " + server.tradeItemQuantity + server.tradeItem + " a cambio de $" + server.tradePrice);
                                           break;
                                       }
                                   }
                                }          
                           }
                              else if(mercadoDecision.equals("comprar")){
                                  
                                if(comandos[2].equals("tienda")){
                                    
                                    String articulo = comandos[3];
                                   
                                   if(articulo.equals("acero") && jugadorTmp.Dinero > 1000){
                                       jugadorTmp.Acero += 1000;
                                       jugadorTmp.Dinero -= 1000;
                                       mandarConsola("El trato fue efectivo!");
                                   }
                                   else if(articulo.equals("misil") && jugadorTmp.Dinero > 500){
                                       jugadorTmp.misiles += 1;
                                       jugadorTmp.Dinero -= 500;
                                       mandarConsola("El trato fue efectivo!");
                                   }
                                    else if(articulo.equals("bomba") && jugadorTmp.Dinero > 2000){
                                       jugadorTmp.bombas += 1;
                                       jugadorTmp.Dinero -= 2000;
                                       mandarConsola("El trato fue efectivo!");
                                   }
                                   else if(articulo.equals("multishot") && jugadorTmp.Dinero > 1000){
                                       jugadorTmp.multi += 1;
                                       jugadorTmp.Dinero -= 1000;
                                       mandarConsola("El trato fue efectivo!");
                                   }                                   
                                   else if(articulo.equals("comboshot") && jugadorTmp.Dinero> 5000){
                                       jugadorTmp.combo += 1;
                                       jugadorTmp.Dinero -= 5000;
                                       mandarConsola("El trato fue efectivo!");
                                   }                                   
                                   else{
                                       mandarConsola("No es posible llevar a cabo el trato!");
                                   }                                    
                                }
                              }
                        }
                       }
                        else if(comandos[0].equals("buy")){   //
                        if(!server.areAllReady() || server.getTurno().equals(usuario)){  
                            componente = comandos[1];
                            x = Integer.parseInt(comandos[3]);
                            y = Integer.parseInt(comandos[5]);
                            
                            if(componente.equals("mundo")){
                                xC = Integer.parseInt(comandos[8]);
                                yC = Integer.parseInt(comandos[10]);                            
                                jugadorTmp.comprarEstructura(componente, x, y, "nada", xC, yC, "nada");
                            }
                            else if(componente.equals("conector")){
                                xC = Integer.parseInt(comandos[8]);
                                yC = Integer.parseInt(comandos[10]);                            
                                jugadorTmp.comprarEstructura(componente, x, y, "nada", xC, yC, "nada");                               
                            }
                            else if(componente.equals("armeria")){
                                String arma = comandos[6];
                                String dirrecion = comandos[7];
                                xC = Integer.parseInt(comandos[10]);
                                yC = Integer.parseInt(comandos[12]);
                                jugadorTmp.comprarEstructura(componente, x, y, dirrecion, xC, yC, arma);
                            }
                            else{//buy-componente-x-1-y-1-direccion-conectar-xc-1--yc-1
                                String dirrecion = comandos[6];
                                xC = Integer.parseInt(comandos[9]);
                                yC = Integer.parseInt(comandos[11]);
                                jugadorTmp.comprarEstructura(componente, x, y, dirrecion, xC, yC, "nada");                               
                                
                            }
                            jugadorTmp.setVisibilidad();
                            jugadorTmp.setRevisados();
                            updateMatrizClientePropia();
                            updateDinero();
                        }         
                       }                      
                        else if(comandos[0].equals("attack")){
                            
                            if(server.getTurno().equals(usuario)){
                                Player jugadorTarget = server.buscarPlayer(comandos[1]);
                                String arma = comandos[2];
                                x = Integer.parseInt(comandos[4]);
                                y = Integer.parseInt(comandos[6]);
                                
                                if(arma.equals("misil")){
                                    if(jugadorTmp.misiles > 0){
                                    mandarConsolaTodas(Misil.atacar(jugadorTmp, jugadorTarget, x, y));
                                    jugadorTmp.misiles--;
                                    }
                                    else{
                                        mandarConsola("No tienes suficientes misiles para atacar!");
                                    }
                                }
                                else if(arma.equals("bomba")){
                                    int x2 = Integer.parseInt(comandos[8]);
                                    int y2 = Integer.parseInt(comandos[10]);
                                    int x3 = Integer.parseInt(comandos[12]);
                                    int y3 = Integer.parseInt(comandos[14]);
                                    
                                    if(jugadorTmp.bombas > 0){
                                    mandarConsolaTodas(Bomba.atacar(jugadorTmp, jugadorTarget, x, y));
                                    mandarConsolaTodas(Bomba.atacar(jugadorTmp, jugadorTarget, x2, y2));
                                    mandarConsolaTodas(Bomba.atacar(jugadorTmp, jugadorTarget, x3, y3));
                                    jugadorTmp.bombas--;
                                    }
                                    else
                                        mandarConsola("No tienes suficientes bombas para atacar!");
                                }
                                else if(arma.equals("multishot")){
                                    if(jugadorTmp.multi > 0){
                                    mandarConsolaTodas(MultiShot.atacar(jugadorTmp, jugadorTarget, x, y));
                                    jugadorTmp.multi--;
                                    }
                                    else
                                        mandarConsola("No tienes suficientes multishots para atacar!");
                                }
                                else if(arma.equals("comboshot")){
                                    if(jugadorTmp.combo > 0){
                                        int x2 = Integer.parseInt(comandos[8]);
                                        int y2 = Integer.parseInt(comandos[10]);
                                        int x3 = Integer.parseInt(comandos[12]);
                                        int y3 = Integer.parseInt(comandos[14]);
                                        int x4 = Integer.parseInt(comandos[16]);
                                        int y4 = Integer.parseInt(comandos[18]);
                                        int x5 = Integer.parseInt(comandos[20]);
                                        int y5 = Integer.parseInt(comandos[22]);
                                        int x6 = Integer.parseInt(comandos[24]);
                                        int y6 = Integer.parseInt(comandos[26]);
                                        int x7 = Integer.parseInt(comandos[28]);
                                        int y7 = Integer.parseInt(comandos[30]);
                                        int x8 = Integer.parseInt(comandos[32]);
                                        int y8 = Integer.parseInt(comandos[34]);
                                        int x9 = Integer.parseInt(comandos[36]);
                                        int y9 = Integer.parseInt(comandos[38]);
                                        int x10 = Integer.parseInt(comandos[40]);
                                        int y10 = Integer.parseInt(comandos[42]);
                                        mandarConsolaTodas(jugadorTmp.nombre + " ha lanzado un ComboShot hacia " + jugadorTarget.nombre + " !!!");
                                        mandarConsolaTodas(Misil.atacar(jugadorTmp, jugadorTarget, x, y));
                                        mandarConsolaTodas(Misil.atacar(jugadorTmp, jugadorTarget, x2, y2));
                                        mandarConsolaTodas(Misil.atacar(jugadorTmp, jugadorTarget, x3, y3));
                                        mandarConsolaTodas(Misil.atacar(jugadorTmp, jugadorTarget, x4, y4));
                                        mandarConsolaTodas(Misil.atacar(jugadorTmp, jugadorTarget, x5, y5));
                                        mandarConsolaTodas(Misil.atacar(jugadorTmp, jugadorTarget, x6, y6));
                                        mandarConsolaTodas(Misil.atacar(jugadorTmp, jugadorTarget, x7, y7));
                                        mandarConsolaTodas(Misil.atacar(jugadorTmp, jugadorTarget, x8, y8));
                                        mandarConsolaTodas(Misil.atacar(jugadorTmp, jugadorTarget, x9, y9));
                                        mandarConsolaTodas(Misil.atacar(jugadorTmp, jugadorTarget, x10, y10));
                                        jugadorTmp.combo--;
                                    }
                                    else if(arma.equals("nave")){
                                        if(jugadorTmp.nave > 0 ){
                                            mandarConsolaTodas(Nave.revelar(jugadorTarget, x, y));
                                        }
                                    }
                                    else
                                        mandarConsola("No tienes suficientes comboshots para atacar!");
                                }
                            jugadorTarget.setVisibilidad();
                            jugadorTarget.setRevisados();
                            jugadorTmp.setVisibilidad();
                            jugadorTmp.setRevisados();
                            updateMatrizClientePropia();
                            updateDinero();  
                            pasarTurno();
                                
                            }
                            else
                                mandarConsola("No es tu turno!!");
                       }         
                        
                        else if(comandos[0].equals("start")){    //comando para start game
                           jugadorTmp = server.buscarPlayer(usuario);
                           if(!mundoInicio || !conectorInicio || !marketInicio){
                               mandarConsola("ERROR: You haven't place your initial components");
                           }
                           else{
                               jugadorTmp.gameReady = true;     
                           }
                           if(server.areAllReady()){
                               mandarConsolaTodas("The game has officially started!");
                                for(int i = 0; i < server.conexiones.size(); i++){
                                    ThreadServer current = server.conexiones.get(i);
                                    current.writer.writeInt(1);
                                    current.writer.writeUTF(server.ordenPlayers.get(0).nombre);                 
                                }
                           }
                       } 
                        
                        else if(comandos[0].equals("inventory")){
                           String inventory = "";
                           inventory += " \n  Armas en bodega: \n Misiles: " + jugadorTmp.misiles + "\n Multishots: " + jugadorTmp.multi + "\n Bombas: " + jugadorTmp.bombas
                                   + "\n Comboshots:" + jugadorTmp.combo;  
                            
                           mandarConsola(inventory);
                           
                       }  
                        else if(comandos[0].equals("trade")){
                            
                            if(comandos[1].equals("accept")){
                                if(jugadorTmp.Dinero < server.tradePrice)
                                    break;
                                
                                jugadorTmp.Dinero -= server.tradePrice;
                                server.tradeOwner.Dinero += server.tradePrice;
                                
                                   if(server.tradeItem.equals("acero")){
                                       jugadorTmp.Acero += server.tradeItemQuantity;
                                       server.tradeOwner.Acero -= server.tradeItemQuantity;
                                       mandarConsolaTodas("Unt trato entre " + server.tradeOwner.nombre + " y " + jugadorTmp.nombre + " fue efectivo!");
                                   }
                                   else if(server.tradeItem.equals("misil")){
                                       jugadorTmp.misiles += server.tradeItemQuantity;
                                       server.tradeOwner.misiles -= server.tradeItemQuantity;
                                       mandarConsolaTodas("Unt trato entre " + server.tradeOwner.nombre + " y " + jugadorTmp.nombre + " fue efectivo!");
                                   }
                                   else if(server.tradeItem.equals("bomba")){
                                       jugadorTmp.bombas += server.tradeItemQuantity;
                                       server.tradeOwner.bombas -= server.tradeItemQuantity;
                                       mandarConsolaTodas("Unt trato entre " + server.tradeOwner.nombre + " y " + jugadorTmp.nombre + " fue efectivo!");
                                   }
                                   else if(server.tradeItem.equals("multishot")){
                                       jugadorTmp.multi += server.tradeItemQuantity;
                                       server.tradeOwner.multi -= server.tradeItemQuantity;
                                       mandarConsolaTodas("Unt trato entre " + server.tradeOwner.nombre + " y " + jugadorTmp.nombre + " fue efectivo!");
                                   }                                   
                                   else if(server.tradeItem.equals("combo")){
                                       jugadorTmp.combo += server.tradeItemQuantity;
                                       server.tradeOwner.combo -= server.tradeItemQuantity;
                                       mandarConsolaTodas("Unt trato entre " + server.tradeOwner.nombre + " y " + jugadorTmp.nombre + " fue efectivo!");
                                   }                             
                            }
                            else if(comandos[1].equals("deny")){
                                
                                mandarConsolaTodas("Unt trato entre " + server.tradeOwner.nombre + " y " + jugadorTmp.nombre + " no se llevó a cabo!!");
                                
                            }
                        }
                        
                        else if(comandos[0].equals("armeria")){
                            
                           String arma = comandos[1];
                           mandarConsola(jugadorTmp.comprarArmas(arma)); 
                        }
                        else if(comandos[0].equals("info")){
                            String res = "";
                            if(comandos[1].equals("componentes")){
                               res += "\n    Precios de componentes:\n Mundo: $12000\n Conector: $100\n Mercado: $2000\n Mina: $1000\n Armeria: $1500\n Templo: $2500\n"; 
                                mandarConsola(res);
                            }
                            else if(comandos[1].equals("armario")){
                               res += "\n    Precios de armas disponibles:\n Misil: 500kg acero\n Multi-shot: 1000kg acero\n Bomba: 2000kg acero\n Combo-shot: 5000kg acero";
                                mandarConsola(res);
                            }   
                            else if(comandos[1].equals("mercado")){
                                res += "\n    Precios fijos del mercado: \n\n  El mercado de te compra:\n 1000kg acero se compra por $1000 \n 1 misil se compra por $400\n 1 Multishot se compra por $900\n 1 Bomba se compra por $1900\n 1 Comboshot se compra por $4900\n\n"
                                        + "  El mercado te vende:\n 1000kg de acero por $1000\n 1 Misil por $500\n 1 Multishot por $1000\n 1 Bomba por $2000\n 1 Comboshot por $5000";
                                mandarConsola(res);
                            }                             
                       }    
                        else{ //si no hay ninguna entrada valida
                           writer.writeInt(2);
                           writer.writeUTF("ERROR. Invalid command!");
                       } 
                   break;
                   
                   case 3:
                       String jugadorSolicitante = reader.readUTF();
                       String enemigoDeseado = reader.readUTF();
                       updateMatrizClienteEnemigo(enemigoDeseado, jugadorSolicitante);
                      
                   break;
                   
                   case 4:
                       String next = server.getNextName();
                       if(!nombre.equals(next)){
                           writer.writeInt(5);
                           writer.writeUTF(next);
                       }
                       else{
                           String next1 = server.getNextName();
                           writer.writeInt(5);
                           writer.writeUTF(next1);
                       }
                   break;
                   
               }               
            } catch (IOException ex){
                
             
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    


}
