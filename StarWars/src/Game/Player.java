/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author PERSONAL
 */
public class Player {
   

    public String nombre;
    public boolean gameReady;;
    public int Dinero;
    public int Acero;
    public Casilla[][] tablero;
    
    
    public Player(String nombre){
        this.nombre  = nombre;
        gameReady = false;       
        tablero = new Casilla[15][15];  //row, fila ... y, x   (en pantalla es x,y)
        generateTablero();
    }


    public void generateTablero(){
        
        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++){
                tablero[row][col] = new Casilla();         
            } 
    }
  
    
    public void setDinero(int dinero){
        this.Dinero = dinero;
    }
    
    
}
