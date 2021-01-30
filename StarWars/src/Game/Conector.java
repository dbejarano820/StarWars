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
        this.revisado = false;
    }

    @Override
    public String explotar(){
        int x = -1;
        int y = -1;
        
        
        String res = "";
        for(int i = 0; i < owner.tablero.length;i++){
            for(int j  = 0; j< owner.tablero[i].length;j++){
                if(owner.tablero[i][j].componente == null || owner.tablero[i][j].componente.getClass().getSimpleName().equals("HoyoNegro"))
                    continue;
                
                if(owner.tablero[i][j].componente.equals(this)){
                    if(x == -1 && y == -1){
                        x = j;
                        y = i;
                    }
                    
                    else{
                        break;
                    }
                }
            }
            if(x != -1 && y != -1 ){
                break;
            }
        }
        double distanciaTmp;
     
        for(int i = 0; i < owner.tablero.length;i++){
            for(int j  = 0; j< owner.tablero[i].length;j++){
                distanciaTmp  = Math.sqrt(((x-j)*(x-j))+((y-i)*(y-i)));
                
                if(distanciaTmp <= 2 ){
                    if(owner.tablero[i][j].explotado == 0 && owner.tablero[i][j].componente != null){
                       owner.tablero[i][j].explotado = 1;
                       owner.tablero[i][j].componente.vida -= 1;
                       res += "La casilla ("+j+","+i+") fue afectada debido al radio de explosion de un conector ubicada en ("+x+","+y+") \n";
                       if(owner.tablero[i][j].componente.vida == 0){
                           res += owner.tablero[i][j].componente.explotar();
                       }
                    }
                }
            }
        }
        
        
        return res;
        
    }

   

    @Override
    public int conectado() {
        int res = 1;
        if(revisado){
            return 1;
        }
        revisado = true;
        
        if(this.vida == 0){
            return 1;
        }
        
        for(int i = 0; i < conexiones.size(); i++){
            if(conexiones.get(i).getClass().getSimpleName().equals("Mundo") && conexiones.get(i).vida > 0){
                return 0;
            }
        }
        
        for(int i = 0; i < conexiones.size(); i++){
            res = res * conexiones.get(i).conectado();
        }
        
        return res;

    }

    @Override
    public void conectar(Componentes componente){
        if(componente != null && !componente.getClass().getSimpleName().equals("Conector")){
            this.conexiones.add(componente);
            componente.conexiones.add(this);
            System.out.println("Se conecto"+this.nombre);
        }
        System.out.println("No se conecto"+this.nombre);
        
    }

    @Override
    public String morir(Player atacante) {
        return "El jugador "+atacante.nombre + " destruyo un conector de "+ this.owner.nombre+"\n";

    }
    
}
