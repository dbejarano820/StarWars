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
        int res = 0;
        
        if(this.vida == 0){
            return 0;
        }
        
        for(int i = 0; i < conexiones.size(); i++){
            if(conexiones.get(i).getClass().getSimpleName().equals("Mundo") && conexiones.get(i).vida > 0){
                return 1;
            }
        }
        
        for(int i = 0; i < conexiones.size(); i++){
            res = res + conexiones.get(i).conectado();
        }
        if(res > 0)
            res = 1;
        
        return res;
    }

    @Override
    public void conectar(Componentes componente){
        if(componente.getClass().getSimpleName().equals("Conector")){
            this.conexiones.add(componente);
            componente.conexiones.add(this);
        }
        
    }
    
}
