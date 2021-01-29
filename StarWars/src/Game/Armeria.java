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
public class Armeria extends Componentes{
    String tipoArma;

    public Armeria(String nombre, int vida, Player owner, String tipoArma) {
        super(nombre, vida, owner);
        this.tipoArma = tipoArma;
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
        return "El jugador "+atacante.nombre + " destruyo una armeria de "+tipoArma+" de "+ this.owner.nombre;
    }
    
}
