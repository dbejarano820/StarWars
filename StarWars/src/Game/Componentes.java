/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import javax.swing.JLabel;

/**
 *
 * @author PERSONAL
 */
public abstract class Componentes extends Thread{
    
    public String nombre;
    public int vida;
    public int costo;
    
    
    public Componentes(String nombre, int vida){
        this.nombre = nombre;
        this.vida = vida;
    }
    
    
    

}
