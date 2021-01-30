/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static java.lang.Thread.sleep;

/**
 *
 * @author XT
 */
public class Nave {
    
    public static String revelar(Player victima,int x,int y) throws InterruptedException{
        
        String res = "La nave visito la casilla ("+x+","+y+") del jugador "+victima.nombre+" y revelo un radio de 3 casillas";
        sleep(90000);
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
    
}
