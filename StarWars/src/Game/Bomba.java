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
public class Bomba {
    
    public static String atacar(Player atacante,Player victima, int x, int y){
        String res = "";
        int direccion = new Random().nextInt(2);
        if(direccion == 0){
            if(victima.tablero[y][x].componente != null){
                if(victima.tablero[y][x].componente.getClass().getSimpleName().equals("HoyoNegro")){
                    HoyoNegro hoyo = (HoyoNegro)victima.tablero[y][x].componente;
                    return hoyo.retornarAtaque(atacante);
                }
                if(victima.tablero[y][x].explotado == 0){
                    if(victima.tablero[y][x].componente.escudo > 0){
                        victima.tablero[y][x].componente.escudo--;
                        res += "La casilla ("+x+","+y+") de "+victima.nombre+" resistio el ataque de una bomba enviada por "+atacante.nombre+" debido a que posee un escudo\n";
                    }
                    else{
                        victima.tablero[y][x].componente.vida -= 1;
                        victima.tablero[y][x].explotado = 1;
                        res += "La casilla ("+x+","+y+") de "+victima.nombre+" fue victima de una bomba enviada por "+atacante.nombre+"\n";
                        if(victima.tablero[y][x].componente.vida == 0){
                            res += victima.tablero[y][x].componente.morir(atacante);
                            res += victima.tablero[y][x].componente.explotar();
                        }
                    }
                    
                }
                else{
                    res += "La casilla ("+x+","+y+") de "+victima.nombre+" no fue victima de una bomba enviada por "+atacante.nombre+" porque ya estaba muerta\n";
                }
                
            }
            else{
                res += "La casilla ("+x+","+y+") de "+victima.nombre+" no fue victima de una bomba enviada por "+atacante.nombre+" porque no habia nada \n";
            }
            if(y<14){
                y++;
                if(victima.tablero[y][x].componente != null){
                    if(victima.tablero[y][x].explotado == 0){
                        if(victima.tablero[y][x].componente.escudo > 0){
                            victima.tablero[y][x].componente.escudo--;
                            res += "La casilla ("+x+","+y+") de "+victima.nombre+" resistio el ataque de una bomba enviada por "+atacante.nombre+" debido a que posee un escudo\n";
                        }
                        else{
                            victima.tablero[y][x].componente.vida -= 1;
                            victima.tablero[y][x].explotado = 1;
                            res += "La casilla ("+x+","+y+") de "+victima.nombre+" fue victima de una bomba enviada por "+atacante.nombre+"\n";
                            if(victima.tablero[y][x].componente.vida == 0){
                                res += victima.tablero[y][x].componente.morir(atacante);
                                res += victima.tablero[y][x].componente.explotar();
                            }
                        }

                    }
                    else{
                        res += "La casilla ("+x+","+y+") de "+victima.nombre+" no fue victima de una bomba enviada por "+atacante.nombre+" porque ya estaba muerta\n";
                    }

                }
                else{
                    res += "La casilla ("+x+","+y+") de "+victima.nombre+" no fue victima de una bomba enviada por "+atacante.nombre+" porque no habia nada \n";
                }
            }
        }
        else{
            if(victima.tablero[y][x].componente != null){
                if(victima.tablero[y][x].explotado == 0){
                    if(victima.tablero[y][x].componente.escudo > 0){
                        victima.tablero[y][x].componente.escudo--;
                        res += "La casilla ("+x+","+y+") de "+victima.nombre+" resistio el ataque de una bomba enviada por "+atacante.nombre+" debido a que posee un escudo\n";
                    }
                    else{
                        victima.tablero[y][x].componente.vida -= 1;
                        victima.tablero[y][x].explotado = 1;
                        res += "La casilla ("+x+","+y+") de "+victima.nombre+" fue victima de una bomba enviada por "+atacante.nombre+"\n";
                        if(victima.tablero[y][x].componente.vida == 0){
                            res += victima.tablero[y][x].componente.morir(atacante);
                            res += victima.tablero[y][x].componente.explotar();
                        }
                    }

                }
                
            }
            else{
                res += "La casilla ("+x+","+y+") de "+victima.nombre+" no fue victima de una bomba enviada por "+atacante.nombre+" porque no habia nada \n";
            }
            if(x<14){
                x++;
                if(victima.tablero[y][x].componente != null){
                    if(victima.tablero[y][x].explotado == 0){
                        if(victima.tablero[y][x].componente.escudo > 0){
                            victima.tablero[y][x].componente.escudo--;
                            res += "La casilla ("+x+","+y+") de "+victima.nombre+" resistio el ataque de una bomba enviada por "+atacante.nombre+" debido a que posee un escudo\n";
                        }
                        else{
                            victima.tablero[y][x].componente.vida -= 1;
                            victima.tablero[y][x].explotado = 1;
                            res += "La casilla ("+x+","+y+") de "+victima.nombre+" fue victima de una bomba enviada por "+atacante.nombre+"\n";
                            if(victima.tablero[y][x].componente.vida == 0){
                                res += victima.tablero[y][x].componente.morir(atacante);
                                res += victima.tablero[y][x].componente.explotar();
                            }
                        }

                    }
                    else{
                        res += "La casilla ("+x+","+y+") de "+victima.nombre+" no fue victima de una bomba enviada por "+atacante.nombre+" porque ya estaba muerta\n";
                    }

                }
                else{
                    res += "La casilla ("+x+","+y+") de "+victima.nombre+" no fue victima de una bomba enviada por "+atacante.nombre+" porque no habia nada \n";
                }
            } 
        }
        return res;
    }
}
