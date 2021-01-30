/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author XT
 */
public class HoyoNegro extends Componentes{

    public HoyoNegro(String nombre, int vida, Player owner) {
        super(nombre, vida, owner);
        this.conexiones = new ArrayList<Componentes>();
    }


    
    public String retornarAtaque(Player atacante){
        String res = "Por haber atacado a un agujero negro: \n";
        int x;
        int y;
        
        for(int i = 0; i <3;i++){
            x = new Random().nextInt(15);
            y = new Random().nextInt(15);
            res += Misil.atacar(atacante, atacante, x, y);
        }
        
        res+= "Fin del efecto del agujero negro \n";
        
        return res;
    }
    @Override//no se usa
    public String explotar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override//no se usa
    public void conectar(Componentes componente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//no se usa
    public String morir(Player atacante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override//no se usa
    public int conectado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
