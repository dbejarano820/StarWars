/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Server.*;
import java.io.IOException;
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
    public Server server;
    
    
    public Player(String nombre, Server server){
        this.nombre  = nombre;
        gameReady = false;       
        tablero = new Casilla[15][15];  //row, fila ... y, x   (en pantalla es x,y)
        generateTablero();
        this.server = server;
        Dinero = server.Dinero;
        Acero = 0;
        misiles = 0;
        multi = 0;
        bombas = 0;
        combo = 0;
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
    
    public String comprarArmas(String tipo){
        
        String res = "";
        boolean encontrado = false;
        for(int i = 0; i < tablero.length;i++){
            for(int j = 0; j< tablero[i].length;j++){
                
                if(tablero[i][j].componente != null){
                    if(tablero[i][j].componente.getClass().getSimpleName().equals("Armeria")){
                        Armeria armeria = (Armeria)tablero[i][j].componente;
                        if(armeria.tipoArma.equals(tipo))
                            encontrado = true;
                    }
                }
            }
        }
        
        if(encontrado){
            if(tipo.equals("misil")){
                if(Acero > 500){
                    Acero-=500;
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
    
    public void comprarEstructura(String estructura, int x,int y, String direccion, int xC, int yC, String tipoArma){
        //Mundo
        if(estructura.equals("mundo") && Dinero > 12000){
            
            if(tablero[y][x].ID == 0 && tablero[y+1][x].ID == 0 && tablero[y][x+1].ID == 0 && tablero[y+1][x+1].ID == 0 ){
                Dinero -= 12000;
                
                tablero[y][x].ID = 1;
                tablero[y+1][x].ID = 1;
                tablero[y][x+1].ID = 1;
                tablero[y+1][x+1].ID = 1;
                Mundo mundo = new Mundo("Mundo",4,this);

                tablero[y][x].componente = mundo;
                tablero[y+1][x].componente = mundo;
                tablero[y][x+1].componente = mundo;
                tablero[y+1][x+1].componente = mundo;
                mundo.conectar(tablero[yC][xC].componente);
                
            }       
        }
        //Mina
        else if(estructura.equals("mina") && Dinero > 1000){
            if(direccion.equals("abajo")){
                if(tablero[y][x].ID == 0 && tablero[y+1][x].ID == 0){
                    Dinero -= 1000;
                    tablero[y][x].ID = 4;
                    tablero[y+1][x].ID = 4;
                    Mina mina = new Mina(server.velocidadMina,server.cantidadMina,"Mina",2,this);
                    tablero[y][x].componente = mina;
                    tablero[y+1][x].componente = mina;
                    mina.conectar(tablero[yC][xC].componente);
                    mina.start();
                }
            }
            else{
                if(tablero[y][x].ID == 0 && tablero[y][x+1].ID == 0){
                    Dinero -= 1000;
                    tablero[y][x].ID = 4;
                    tablero[y][x+1].ID = 4;
                    Mina mina = new Mina(server.velocidadMina,server.cantidadMina,"Mina",2,this);
                    tablero[y][x].componente = mina;
                    tablero[y][x+1].componente = mina;
                    mina.conectar(tablero[yC][xC].componente);
                    mina.start();
                }
            }
        }
        //Armeria
        else if(estructura.equals("armeria") && Dinero > 1500){
            
            if(direccion.equals("abajo")){
                if(tablero[y][x].ID == 0 && tablero[y+1][x].ID == 0){
                    Dinero -= 1500;
                    tablero[y][x].ID = 5;
                    tablero[y+1][x].ID = 5;
                    Armeria armeria = new Armeria("Armeria",2,this,tipoArma);
                    tablero[y][x].componente = armeria;
                    tablero[y+1][x].componente = armeria;
                    armeria.conectar(tablero[yC][xC].componente);
                }
            }
            else{
                if(tablero[y][x].ID == 0 && tablero[y][x+1].ID == 0){
                    Dinero -= 1500;
                    tablero[y][x].ID = 5;
                    tablero[y][x+1].ID = 5;
                    Armeria armeria = new Armeria("Armeria",2,this,tipoArma);
                    tablero[y][x].componente = armeria;
                    tablero[y][x+1].componente = armeria;
                    armeria.conectar(tablero[yC][xC].componente);
                }
            }  
        }
        //Mercado
        else if(estructura.equals("mercado") && Dinero > 2000){
            if(direccion.equals("abajo")){
                
                if(tablero[y][x].ID == 0 && tablero[y+1][x].ID == 0){
                    Dinero -= 2000;
                    tablero[y][x].ID = 3;
                    tablero[y+1][x].ID = 3;
                    Mercado mercado = new Mercado("Mercado",2,this);
                    tablero[y][x].componente = mercado;
                    tablero[y+1][x].componente = mercado;
                    mercado.conectar(tablero[yC][xC].componente);
                }
            }
            else{
                if(tablero[y][x].ID == 0 && tablero[y][x+1].ID == 0){
                    Dinero -= 2000;
                    tablero[y][x].ID = 3;
                    tablero[y][x+1].ID = 3;
                    Mercado mercado = new Mercado("Mercado",2,this);
                    tablero[y][x].componente = mercado;
                    tablero[y][x+1].componente = mercado;
                    mercado.conectar(tablero[yC][xC].componente);
                }
            }
        }
        //Templo
        else if(estructura.equals("templo") && Dinero > 2500){
            if(direccion.equals("abajo")){
                if(tablero[y][x].ID == 0 && tablero[y+1][x].ID == 0){
                    Dinero -= 2500;
                    tablero[y][x].ID = 6;
                    tablero[y+1][x].ID = 6;
                    Templo templo = new Templo("Templo",2,this);
                    tablero[y][x].componente = templo;
                    tablero[y+1][x].componente = templo;
                    templo.conectar(tablero[yC][xC].componente);
                    templo.start();
                }
            }
            else{
                if(tablero[y][x].ID == 0 && tablero[y][x+1].ID == 0){
                    Dinero -= 2500;
                    tablero[y][x].ID = 6;
                    tablero[y][x+1].ID = 6;
                    Templo templo = new Templo("Templo",2,this);
                    tablero[y][x].componente = templo;
                    tablero[y][x+1].componente = templo;
                    templo.conectar(tablero[yC][xC].componente);
                    templo.start();
                }
            } 
        }
        //Conector
        else if(estructura.equals("conector") && Dinero > 100){
            if(tablero[y][x].ID == 0){
                Dinero -= 100;
                tablero[y][x].ID = 2;
                Conector conector = new Conector("Conector",1,this);
                tablero[y][x].componente = conector;
                conector.conectar(tablero[yC][xC].componente);
            }
            
        }
    }
    
    public void setRevisados(){
        for(int i = 0; i < tablero.length;i++){
            for(int j = 0; j < tablero[i].length;j++){
                if(tablero[i][j].componente != null){
                   tablero[i][j].componente.revisado = false; 
                }
            }
        }
    }
    
    public boolean mercadoDisponible(){
        for(int i = 0; i < tablero.length;i++){
            for(int j = 0; j < tablero[i].length;j++){
                if(tablero[i][j].componente != null){
                   if(tablero[i][j].componente.getClass().getSimpleName().equals("Mercado") && tablero[i][j].componente.vida > 0)
                       return true;
                }
            }
        }
        return false;
    }
    
    public void setVisibilidad(){
        for(int i = 0; i < tablero.length;i++){
            for(int j = 0; j < tablero[i].length;j++){
                if(tablero[i][j].componente != null){
                    tablero[i][j].visible = tablero[i][j].componente.conectado();
                }
            }
        }
    }
    
    public void generateBlackHole(){
        int x1 = new Random().nextInt(15);
        int y1 = new Random().nextInt(15);
        int x2 = new Random().nextInt(15);
        int y2 = new Random().nextInt(15);
        tablero[y1][x1].componente = new HoyoNegro("Hoyo Negro",10,this);
        tablero[y2][x2].componente = new HoyoNegro("Hoyo Negro",10,this);
        tablero[y1][x1].ID = 7;
        tablero[y2][x2].ID = 7;
    }
}
