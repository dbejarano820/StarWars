/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import Game.*;
import java.util.Random;

/**
 *
 * @author PERSONAL
 */
public class Server {

     PantallaServer refPantalla;
     public ArrayList<ThreadServer> conexiones;

     public ArrayList<Player> players;
     public ArrayList<Player> ordenPlayers;
     public int contadorDeConexiones;
     public int setAmountPlayers;
     private boolean running = true;
     private ServerSocket srv;
     private int turno = 0;
     private boolean gameStarted = false;
     public boolean allPlayersReady = false;

    public Server(PantallaServer refPantalla){
        
        this.refPantalla = refPantalla;
        players = new ArrayList<Player>();
        conexiones = new ArrayList<ThreadServer>();
        ordenPlayers = new ArrayList<Player>();   
    }
     
    public void startGame(){
        this.gameStarted = true;
    } 
    
    
    public Player buscarPlayer(String jugador){
        
        for(int i = 0; i<players.size(); i++){
            if(players.get(i).nombre.equals(jugador))
                return players.get(i);
        }
        return null;
    }
    
    public void generateOrder(){
        
        while(ordenPlayers.size()!= players.size()){
          int rando = (new Random()).nextInt(conexiones.size());
          Player playerTmp = players.get(rando);   
          if(!estaOrdenPlayer(playerTmp))
              ordenPlayers.add(playerTmp);
        }
    }
    
    public boolean estaOrdenPlayer(Player playerTmp){
        
        for(int i = 0; i < ordenPlayers.size(); i++){
            if(ordenPlayers.get(i).equals(playerTmp))
                return true;
        }
        return false;
    }
    
    
    public boolean areAllReady(){
        
        for(int i = 0; i<players.size(); i++){            
            if(!players.get(i).gameReady)
                return false;
        }
        
        generateOrder();
        allPlayersReady = true;
        return true;
    }
    
    public String getTurno(){
        
        return ordenPlayers.get(turno).nombre;
    }
    
    public String getNextTurno(){
        
        if(++turno >= ordenPlayers.size())
            turno = 0;
       
        return ordenPlayers.get(turno).nombre;
    }

    public void runServer(){
        contadorDeConexiones = 0;
        try{
            srv = new ServerSocket(35577);
            refPantalla.setTitle("SERVER");
            while (running){
                
                if(gameStarted)
                    refPantalla.addMessage("::Game has started!");
                else refPantalla.addMessage("::Awaiting connection....");
                Socket nuevaConexion = srv.accept();
                if (!gameStarted && contadorDeConexiones < setAmountPlayers){ 
                    contadorDeConexiones++;
                    refPantalla.increaseConnections();
                    refPantalla.addMessage(":Connection #" + contadorDeConexiones + " accepted!");

                    //nuevo trhead
                    ThreadServer newThread = new ThreadServer(nuevaConexion, this);
                    conexiones.add(newThread);
                    newThread.start();
                }
                else{
                    // OutputStream socket para poder hacer un writer
                    
                    refPantalla.addMessage(":Connection denied: game lobby is full!");
                }
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    
    }
   

}
