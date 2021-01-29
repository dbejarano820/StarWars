/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;

/**
 *
 * @author PERSONAL
 */
public class Mundo extends Componentes {

    public Mundo(String nombre, int vida, Player owner) {
        super(nombre, vida, owner);
        this.conexiones = new ArrayList<Componentes>();
    }
    
    
    
    

    @Override
    public String explotar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public String morir(Player atacante) {
        atacante.Dinero += 10000;
        return "El jugador "+atacante.nombre+" destruyo el mundo de "+this.owner.nombre+ " y gano 10000";
    }

    @Override
    public int conectado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void conectar(Componentes componente) {
        this.conexiones.add(componente);
        componente.conexiones.add(this);
    }
    
}
