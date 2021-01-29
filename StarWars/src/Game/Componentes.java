/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author PERSONAL
 */
public abstract class Componentes {
    
    public String nombre;
    public int vida;
    
    
    public Componentes(String nombre, int vida){
        this.nombre = nombre;
        this.vida = vida;
    }
    
}
