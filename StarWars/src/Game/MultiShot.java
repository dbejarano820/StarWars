/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.Random;



/**
 *
 * @author XT
 */
public class MultiShot {
    public static String atacar(Player atacante,Player victima, int x, int y){
        String res = "";
        
        if( victima.tablero[y][x].componente != null){
            if(victima.tablero[y][x].explotado == 0){
                
                victima.tablero[y][x].componente.vida -= 1;
                victima.tablero[y][x].explotado = 1;
                res += "La casilla ("+x+","+y+") de "+victima.nombre+" fue victima del MultiShot enviado por "+atacante.nombre+"\n";
                for(int i = 0; i < 4; i++){
                    int x1 = new Random().nextInt(15);
                    int y1 = new Random().nextInt(15);
                    if( victima.tablero[y1][x1].componente != null){
                        if(victima.tablero[y1][x1].explotado == 0){
                            victima.tablero[y1][x1].componente.vida -= 1;
                            victima.tablero[y1][x1].explotado = 1;
                            res += "La casilla ("+x1+","+y1+") de "+victima.nombre+" fue victima de las secuelas del MultiShot enviado por "+atacante.nombre+"\n";   
                        }
                        else{
                           res += "La casilla ("+x+","+y+") de "+victima.nombre+" no le afecto la secuela del MultiShot enviado por "+atacante.nombre+" porque ya estaba muerta\n"; 
                        }
                    }
                    else{
                        res += "La casilla ("+x+","+y+") de "+victima.nombre+" no le afecto la secuela del MultiShot enviado por "+atacante.nombre+" porque en esa zona no hay nada\n";
                    }
                }   
            }
            else{
                res += "La casilla ("+x+","+y+") de "+victima.nombre+" no le afecto el MultiShot enviado por "+atacante.nombre+" porque ya estaba muerta\n";
            }
        }
        else{
            res += "La casilla ("+x+","+y+") de "+victima.nombre+" no le afecto el MultiShot enviado por "+atacante.nombre+" porque en esa zona no hay nada\n";
        }
        return res;
    }
    
}
