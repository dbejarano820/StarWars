/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author XT
 */
public class Nave extends Thread{
    
    public static String revelar(Player victima,int x,int y){
        String res = "La nave visito la casilla ("+x+","+y+") del jugador "+victima.nombre+" y revelo un radio de 3 casillas";
        
        
        return res;
    }
    
}
