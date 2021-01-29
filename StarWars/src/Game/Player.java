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
    public boolean gameReady;
    public int Dinero;
    public int Acero;
    public int misiles;
    public int multi;
    public int bombas;
    public int combo;
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
    public String comprar(String tipo){
        String res = "";
        boolean encontrado = false;
        for(int i = 0; i < tablero.length;i++){
            for(int j = 0; j< tablero[i].length;j++){
                
                if(tablero[i][j].componente.getClass().getSimpleName().equals("Armeria")){
                    Armeria armeria = (Armeria)tablero[i][j].componente;
                    if(armeria.tipoArma.equals(tipo))
                        encontrado = true;
                }
            }
        }
        if(encontrado){
            if(tipo.equals("misil")){
                if(Acero > 500){
                    misiles++;
                    res+= "El jugador "+nombre+" compró un misil";
                }
                else{
                    res += "El jugador "+nombre+" no compró un misil porque no posee acero suficiente";
                }
                
            }
            else if(tipo.equals("multishot")){
                if(Acero > 1000){
                    multi++;
                    res+= "El jugador "+nombre+" compró un Multi Shot";
                }
                else{
                    res += "El jugador "+nombre+" no compró un Multi Shot porque no posee acero suficiente";
                }
                
            }
            else if(tipo.equals("bomba")){
                if(Acero > 2000){
                    bombas++;
                    res+= "El jugador "+nombre+" compró una bomba";
                }
                else{
                    res += "El jugador "+nombre+" no compró una bomba porque no posee acero suficiente";
                }
                
            }
            else if(tipo.equals("comboshot")){
                if(Acero > 5000){
                    combo++;
                    res+= "El jugador "+nombre+" compró un ComboShot";
                }
                else{
                    res += "El jugador "+nombre+" no compró un ComboShot porque no posee acero suficiente";
                }
                
            }
            
        }
        else{
            res += "El jugador "+nombre+" no posee una armeria para poder crear "+tipo;
        }
        
        
        return res;
    }
    
    
}
