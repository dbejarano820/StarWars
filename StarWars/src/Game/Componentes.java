/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author PERSONAL
 */
public abstract class Componentes extends Thread{
    
    public String nombre;
    public int vida;
    public int costo;
    public Player owner;
    public int escudo;
    public ArrayList<Componentes> conexiones;
    
    
    public Componentes(String nombre, int vida, Player owner){
        this.nombre = nombre;
        this.vida = vida;
        this.owner = owner;
        this.conexiones = new ArrayList<Componentes>();
    }
    public abstract String explotar();
    public abstract String morir(Player atacante);
    public abstract boolean conectado();
    public abstract void conectar(Componentes componente);
    

}
