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
public class Mercado extends Componentes {

    public Mercado(String nombre, int vida, Player owner) {
        super(nombre, vida, owner);
        this.conexiones = new ArrayList<Componentes>();
        this.revisado = false;
    }

    @Override
    public String explotar(){
        int x1 = -1;
        int y1 = -1;
        int x2 = -1;
        int y2 = -1;
        
        String res = "";
        for(int i = 0; i < owner.tablero.length;i++){
            for(int j  = 0; j< owner.tablero[i].length;j++){
                if(owner.tablero[i][j].componente == null || owner.tablero[i][j].componente.getClass().getSimpleName().equals("HoyoNegro"))
                    continue;
                
                if(owner.tablero[i][j].componente.equals(this)){
                    if(x1 == -1 && y1 == -1){
                        x1 = j;
                        y1 = i;
                    }
                    else if(x2 == -1 && y2 == -1){
                        x2 = j;
                        y2 = i;
                    }
                    else{
                        break;
                    }
                }
            }
            if(x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1){
                break;
            }
        }
        double distanciaTmp1;
        double distanciaTmp2;
        for(int i = 0; i < owner.tablero.length;i++){
            for(int j  = 0; j< owner.tablero[i].length;j++){
                distanciaTmp1  = Math.sqrt(((x1-j)*(x1-j))+((y1-i)*(y1-i)));
                distanciaTmp2  = Math.sqrt(((x2-j)*(x2-j))+((y2-i)*(y2-i)));
                if(distanciaTmp1 <= 2 || distanciaTmp2 <= 2){
                    if(owner.tablero[i][j].explotado == 0 && owner.tablero[i][j].componente != null){
                       owner.tablero[i][j].explotado = 1;
                       owner.tablero[i][j].componente.vida -= 1;
                       res += "La casilla ("+j+","+i+") fue afectada debido al radio de explosion de una mercado ubicada en ("+x1+","+y1+") y en ("+x2+","+y2+") \n";
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
    public String comprar(){
        String res = "";
        return res;
    }

    @Override
    public void conectar(Componentes componente){
        if(componente != null && componente.getClass().getSimpleName().equals("Conector")){
            this.conexiones.add(componente);
            componente.conexiones.add(this);
            System.out.println("Se conecto"+this.nombre);
        }
        System.out.println("NO se conecto"+this.nombre);
        
    }

    @Override
    public String morir(Player atacante) {
        return "El jugador "+atacante.nombre + " destruyo una estructura de "+ this.owner.nombre+"\n";
    }
    
    
}
