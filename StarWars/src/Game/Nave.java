/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Server.*;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XT
 */
public class Nave extends Thread{
    int x;
    int y;
    Player victima;
    ThreadServer hilo;

    public Nave(int x, int y, Player victima, ThreadServer hilo) {
        this.x = x;
        this.y = y;
        this.victima = victima;
        this.hilo = hilo;
    }
    
    
    public static String revelar(Player victima,int x,int y) throws InterruptedException{
        
        String res = "La nave visito la casilla ("+x+","+y+") del jugador "+victima.nombre+" y revelo un radio de 3 casillas";
        sleep(90000);
        System.out.println("ya salio");
        for(int i = 0; i < victima.tablero.length;i++){
            for(int j = 0; j < victima.tablero[i].length;j++){
                double distancia = Math.sqrt(((x-j)*(x-j))+((y-i)*(y-i)));
                if(distancia <= 3){
                    victima.tablero[i][j].revelada = 1;
                }
            }
        }
        
        
        return res;
    }
    @Override
    public void run(){
        String res = "La nave visito la casilla ("+x+","+y+") del jugador "+victima.nombre+" y revelo un radio de 3 casillas";
        try {
            sleep(90000);
            
            
            for(int i = 0; i < victima.tablero.length;i++){
                for(int j = 0; j < victima.tablero[i].length;j++){
                    double distancia = Math.sqrt(((x-j)*(x-j))+((y-i)*(y-i)));
                    
                    if(distancia <= 3){
                        victima.tablero[i][j].revelada = 1;
                    }
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Nave.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            hilo.mandarConsolaTodas(res);
        } catch (IOException ex) {
            Logger.getLogger(Nave.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
