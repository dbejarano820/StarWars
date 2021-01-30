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
        this.revisado = false;
    }
    
    
    
    

    @Override
    public String explotar(){
        int x1 = -1;
        int y1 = -1;
        int x2 = -1;
        int y2 = -1;
        int x3 = -1;
        int y3 = -1;
        int x4 = -1;
        int y4 = -1;
        
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
                    else if(x3 == -1 && y3 == -1){
                        x3 = j;
                        y3 = i;
                    }
                    else if(x4 == -1 && y4 == -1){
                        x4 = j;
                        y4 = i;
                    }
                    else{
                        break;
                    }
                }
            }
            if(x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1 && x3 != -1 && y3 != -1 && x4 != -1 && y4 != -1){
                break;
            }
        }
        double distanciaTmp1;
        double distanciaTmp2;
        double distanciaTmp3;
        double distanciaTmp4;
        for(int i = 0; i < owner.tablero.length;i++){
            for(int j  = 0; j< owner.tablero[i].length;j++){
                distanciaTmp1  = Math.sqrt(((x1-j)*(x1-j))+((y1-i)*(y1-i)));
                distanciaTmp2  = Math.sqrt(((x2-j)*(x2-j))+((y2-i)*(y2-i)));
                distanciaTmp3  = Math.sqrt(((x3-j)*(x3-j))+((y3-i)*(y3-i)));
                distanciaTmp4  = Math.sqrt(((x4-j)*(x4-j))+((y4-i)*(y4-i)));
                
                
                if(distanciaTmp1 <= 2 || distanciaTmp2 <= 2 || distanciaTmp3 <= 2 || distanciaTmp4 <= 2){
                    
                    if(owner.tablero[i][j].explotado == 0 && owner.tablero[i][j].componente != null){
                       owner.tablero[i][j].explotado = 1;
                       owner.tablero[i][j].componente.vida -= 1;
                       res += "La casilla ("+j+","+i+") fue afectada debido al radio de explosion de un mundo ubicada en ("+x1+","+y1+"), en ("+x2+","+y2+"), en ("+x3+","+y3+") y en ("+x4+","+y4+") \n";
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
    public String morir(Player atacante) {
        atacante.Dinero += 10000;
        return "El jugador "+atacante.nombre+" destruyo el mundo de "+this.owner.nombre+ " y gano 10000"+"\n";
    }

    @Override
    public int conectado() {
        return 0;
    }

    @Override
    public void conectar(Componentes componente){
        if(componente != null && componente.getClass().getSimpleName().equals("Conector")){
            this.conexiones.add(componente);
            componente.conexiones.add(this);
            System.out.println("Se conecto "+this.nombre);
        }
        System.out.println("No se conecto "+this.nombre);
        
    }
    
}
