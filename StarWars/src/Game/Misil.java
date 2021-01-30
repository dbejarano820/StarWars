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
public class Misil {
    
    public static String atacar(Player atacante,Player victima, int x, int y){
        String res = "";
        if( victima.tablero[y][x].componente != null){
            if(victima.tablero[y][x].explotado == 0){
                if(victima.tablero[y][x].componente.escudo > 0){
                    victima.tablero[y][x].componente.escudo--;
                    res += "La casilla ("+x+","+y+") de "+victima.nombre+" no fue victima del misil enviado por "+atacante.nombre+" debido a que poseia un escudo\n";
                }
                else{
                    victima.tablero[y][x].componente.vida -= 1;
                    victima.tablero[y][x].explotado = 1;
                    res += "La casilla ("+x+","+y+") de "+victima.nombre+" fue victima del misil enviado por "+atacante.nombre+"\n";
                }
            }
            else{
                res += "La casilla ("+x+","+y+") de "+victima.nombre+" no le afecto el misil enviado por "+atacante.nombre+" porque ya estaba muerta\n";
            }
        }
        else{
            res += "La casilla ("+x+","+y+") de "+victima.nombre+" no le afecto el misil enviado por "+atacante.nombre+" porque en esa zona no hay nada\n";
        }
        
        return res;
    }
    
}
