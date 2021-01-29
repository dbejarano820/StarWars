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
public class Conector extends Componentes{

    public Conector(String nombre, int vida, Player owner) {
        super(nombre, vida, owner);
        this.conexiones = new ArrayList<Componentes>();
    }

    @Override
    public String explotar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public String morir(Player atacante) {
        return "El jugador "+atacante.nombre + " destruyo un conector de "+ this.owner.nombre;

    }
    
}
