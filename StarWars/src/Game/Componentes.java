/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import javax.swing.JLabel;

/**
 *
 * @author PERSONAL
 */
public abstract class Componentes extends Thread{
    
    public String nombre;
    public int vida;
    public int costo;
    public JLabel refLabel;
    
    
    public Componentes(String nombre, int vida){
        this.nombre = nombre;
        this.vida = vida;
    }
    
    
    
    public JLabel generateLabel(){      // se utiliza para generar el reflabel de las casillas del cliente, el player no lo necesita
    JLabel newLabel = new JLabel();    
    newLabel.setForeground(new java.awt.Color(0, 0, 0));
    newLabel.setText("");
    newLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    newLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    newLabel.setOpaque(true);
    newLabel.setSize(30,30);
    newLabel.setLocation(0,0);
    this.refLabel = newLabel;
    return newLabel;
    }
}
