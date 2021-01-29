/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;

/**
 *
 * @author XT
 */
public class Mina extends Componentes {

    public int velocidad;
    public int cantidad;

    public Mina(int velocidad, int cantidad, String nombre, int vida, Player owner) {
        super(nombre, vida, owner);
        this.velocidad = velocidad;
        this.cantidad = cantidad;
        this.conexiones = new ArrayList<Componentes>();
    }

    

    @Override
    public String explotar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String morir(Player atacante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean conectado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void conectar(Componentes componente) {
        
    }
    
}
