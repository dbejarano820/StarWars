/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;


import Game.Casilla;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author PERSONAL
 */
public class PantallaCliente extends javax.swing.JFrame {

    
    public Cliente refCliente;
    String nombreTurno;
    String pathMundo = "C:\\Users\\PERSONAL\\OneDrive\\Documents\\GitHub\\StarWars\\StarWars\\src\\Images\\Planet.png";
    String pathConector = "C:\\Users\\PERSONAL\\OneDrive\\Documents\\GitHub\\StarWars\\StarWars\\src\\Images\\Connector.png";
    String pathMercado = "C:\\Users\\PERSONAL\\OneDrive\\Documents\\GitHub\\StarWars\\StarWars\\src\\Images\\Market.png";
    String pathMina = "C:\\Users\\PERSONAL\\OneDrive\\Documents\\GitHub\\StarWars\\StarWars\\src\\Images\\Mina.png";
    String pathArmory = "C:\\Users\\PERSONAL\\OneDrive\\Documents\\GitHub\\StarWars\\StarWars\\src\\Images\\Armory.png";
    String pathTemple = "C:\\Users\\PERSONAL\\OneDrive\\Documents\\GitHub\\StarWars\\StarWars\\src\\Images\\Temple.png";
    String pathHoyoNegro = "C:\\Users\\PERSONAL\\OneDrive\\Documents\\GitHub\\StarWars\\StarWars\\src\\Images\\HoyoNegro.png";

    public PantallaCliente() {
        initComponents();
        nombreTurno = ""; 
    }
    
   public void setCliente(Cliente refCliente){
        this.refCliente = refCliente;
    }
    
    public void setNombreTurno(String player){
        this.nombreTurno = player;
    }
    
    public void pintarDinero(int Dinero, int acero){
        lblDinero.setText(Dinero + "");
        lblAcero.setText(acero + "");
    }
    
    public void pintarTurno(String player){
        this.nombreTurno = player;
        lblPlayerTurno.setText(player);
    }
    
    public void pintarNextEnemy(String player){
        lblPlayerEnemyName.setText(player);
    }
    
    public void addConsolaPropia(String msj){
        txtAreaConsola.append(msj);
    }
    
    public void addConsolaGlobal(String msj){
        txtAreaConsola.append(msj);
    }
    
    
    public void generarTableroPropio(){
        
        lblPlayerName.setText(refCliente.nombre);
        
        for(int row = 0; row < refCliente.tableroCliente.length; row++){  //refCliente.tableroCliente.length
            for(int col = 0; col < refCliente.tableroCliente[row].length; col++){ //refCliente.tableroCliente[row].length
                refCliente.tableroCliente[row][col] = new Casilla();  
                JLabel labelTmp = refCliente.tableroCliente[row][col].generateLabel();
                this.jPanelPropio.add(labelTmp);
                labelTmp.setLocation(((col*30)), ((row*30))); 
            }
        }
    }    
    
    public void generarTableroEnemigo(){

        for(int row = 0; row < refCliente.tableroEnemigo.length; row++){  //refCliente.tableroCliente.length
            for(int col = 0; col < refCliente.tableroEnemigo[row].length; col++){ //refCliente.tableroCliente[row].length
                refCliente.tableroEnemigo[row][col] = new Casilla();  
                JLabel labelTmp = refCliente.tableroEnemigo[row][col].generateLabel();
                this.jPanelEnemigos.add(labelTmp);
                labelTmp.setLocation(((col*30)), ((row*30))); 
            }
        }
    }     
    
    
    public void updateTableroPropio(){
        
         for(int row = 0; row < refCliente.tableroCliente.length; row++)
            for(int col = 0; col < refCliente.tableroCliente[row].length; col++){
                
                if(refCliente.tableroCliente[row][col].ID == 1){
                    refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathMundo).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
                    if(refCliente.tableroCliente[row][col].explotado == 1)
                        refCliente.tableroCliente[row][col].refLabel.setBackground(Color.red);    
                }
                else if(refCliente.tableroCliente[row][col].ID == 2){
                     refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathConector).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
                    if(refCliente.tableroCliente[row][col].explotado == 1)
                        refCliente.tableroCliente[row][col].refLabel.setBackground(Color.red);                     
                }
                 else if(refCliente.tableroCliente[row][col].ID == 3){
                     refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathMercado).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
                    if(refCliente.tableroCliente[row][col].explotado == 1)
                        refCliente.tableroCliente[row][col].refLabel.setBackground(Color.red);                     
                }               
                else if(refCliente.tableroCliente[row][col].ID == 4){
                    refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathMina).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
                    if(refCliente.tableroCliente[row][col].explotado == 1)
                        refCliente.tableroCliente[row][col].refLabel.setBackground(Color.red);                      
                }
                else if(refCliente.tableroCliente[row][col].ID == 5){
                    refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathArmory).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
                    if(refCliente.tableroCliente[row][col].explotado == 1)
                        refCliente.tableroCliente[row][col].refLabel.setBackground(Color.red);                      
                }
                else if(refCliente.tableroCliente[row][col].ID == 6){
                     refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathTemple).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
                    if(refCliente.tableroCliente[row][col].explotado == 1)
                        refCliente.tableroCliente[row][col].refLabel.setBackground(Color.red);                     
                }
                else if(refCliente.tableroCliente[row][col].ID == 7){
                     refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathHoyoNegro).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));                  
                }                
            }       
    }
    
     public void updateTableroEnemigo(){
        
         for(int row = 0; row < refCliente.tableroEnemigo.length; row++)
            for(int col = 0; col < refCliente.tableroEnemigo[row].length; col++){
 
                if(refCliente.tableroEnemigo[row][col].explotado == 1)
                        refCliente.tableroEnemigo[row][col].refLabel.setBackground(Color.red);

                if(refCliente.tableroEnemigo[row][col].visible == 1 || refCliente.tableroEnemigo[row][col].revelada == 1){
                
                    if(refCliente.tableroEnemigo[row][col].ID == 1)
                         refCliente.tableroEnemigo[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathMundo).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
           
                    else if(refCliente.tableroEnemigo[row][col].ID == 2)
                         refCliente.tableroEnemigo[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathConector).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));                             
            
                    else if(refCliente.tableroEnemigo[row][col].ID == 3)
                         refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathMercado).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));               
                
                    else if(refCliente.tableroCliente[row][col].ID == 4)
                         refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathMina).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));              

                    else if(refCliente.tableroCliente[row][col].ID == 5)
                         refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathArmory).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));              
                
                    else if(refCliente.tableroCliente[row][col].ID == 6)
                         refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathTemple).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));  
                      
                    else if(refCliente.tableroCliente[row][col].ID == 7)
                         refCliente.tableroCliente[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathHoyoNegro).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));                                              
                }         
            }                       
    }       
      


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRefreshEnemy = new javax.swing.JButton();
        btnNextPlayer = new javax.swing.JButton();
        txtAreaConsola = new java.awt.TextArea();
        txtFieldConsola = new java.awt.TextField();
        btnSend = new javax.swing.JButton();
        lblAcero = new javax.swing.JLabel();
        lblPlayerName2 = new javax.swing.JLabel();
        lblPlayerTurno = new javax.swing.JLabel();
        lblPlayerName4 = new javax.swing.JLabel();
        lblDinero = new javax.swing.JLabel();
        lblPlayerName5 = new javax.swing.JLabel();
        lblPlayerEnemyName = new javax.swing.JLabel();
        lblPlayerName = new javax.swing.JLabel();
        jPanelPropio = new javax.swing.JPanel();
        jPanelEnemigos = new javax.swing.JPanel();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1440, 950));
        setPreferredSize(new java.awt.Dimension(1444, 950));
        getContentPane().setLayout(null);

        btnRefreshEnemy.setText("Refresh");
        btnRefreshEnemy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshEnemyActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefreshEnemy);
        btnRefreshEnemy.setBounds(1250, 50, 90, 40);

        btnNextPlayer.setText("Next");
        btnNextPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPlayerActionPerformed(evt);
            }
        });
        getContentPane().add(btnNextPlayer);
        btnNextPlayer.setBounds(1150, 50, 90, 40);
        getContentPane().add(txtAreaConsola);
        txtAreaConsola.setBounds(140, 580, 1150, 290);
        getContentPane().add(txtFieldConsola);
        txtFieldConsola.setBounds(140, 870, 1080, 30);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        getContentPane().add(btnSend);
        btnSend.setBounds(1220, 870, 73, 30);

        lblAcero.setBackground(new java.awt.Color(255, 255, 255));
        lblAcero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblAcero.setForeground(new java.awt.Color(0, 0, 0));
        lblAcero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAcero.setOpaque(true);
        getContentPane().add(lblAcero);
        lblAcero.setBounds(40, 330, 130, 40);

        lblPlayerName2.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayerName2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPlayerName2.setForeground(new java.awt.Color(204, 204, 0));
        lblPlayerName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerName2.setText("Acero:");
        lblPlayerName2.setOpaque(true);
        getContentPane().add(lblPlayerName2);
        lblPlayerName2.setBounds(40, 290, 130, 40);

        lblPlayerTurno.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayerTurno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPlayerTurno.setForeground(new java.awt.Color(0, 0, 0));
        lblPlayerTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerTurno.setOpaque(true);
        getContentPane().add(lblPlayerTurno);
        lblPlayerTurno.setBounds(660, 50, 130, 40);

        lblPlayerName4.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayerName4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPlayerName4.setForeground(new java.awt.Color(204, 204, 0));
        lblPlayerName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerName4.setText("Turno:");
        lblPlayerName4.setOpaque(true);
        getContentPane().add(lblPlayerName4);
        lblPlayerName4.setBounds(660, 10, 130, 40);

        lblDinero.setBackground(new java.awt.Color(255, 255, 255));
        lblDinero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDinero.setForeground(new java.awt.Color(0, 0, 0));
        lblDinero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDinero.setOpaque(true);
        getContentPane().add(lblDinero);
        lblDinero.setBounds(40, 250, 130, 40);

        lblPlayerName5.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayerName5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPlayerName5.setForeground(new java.awt.Color(204, 204, 0));
        lblPlayerName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerName5.setText("Dinero:");
        lblPlayerName5.setOpaque(true);
        getContentPane().add(lblPlayerName5);
        lblPlayerName5.setBounds(40, 210, 130, 40);

        lblPlayerEnemyName.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayerEnemyName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPlayerEnemyName.setForeground(new java.awt.Color(204, 204, 0));
        lblPlayerEnemyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerEnemyName.setText("Enemy name");
        lblPlayerEnemyName.setOpaque(true);
        getContentPane().add(lblPlayerEnemyName);
        lblPlayerEnemyName.setBounds(900, 50, 230, 40);

        lblPlayerName.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayerName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPlayerName.setForeground(new java.awt.Color(204, 204, 0));
        lblPlayerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerName.setText("Player name");
        lblPlayerName.setOpaque(true);
        getContentPane().add(lblPlayerName);
        lblPlayerName.setBounds(330, 50, 230, 40);

        jPanelPropio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanelPropio.setOpaque(false);

        javax.swing.GroupLayout jPanelPropioLayout = new javax.swing.GroupLayout(jPanelPropio);
        jPanelPropio.setLayout(jPanelPropioLayout);
        jPanelPropioLayout.setHorizontalGroup(
            jPanelPropioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        jPanelPropioLayout.setVerticalGroup(
            jPanelPropioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelPropio);
        jPanelPropio.setBounds(210, 110, 450, 450);

        jPanelEnemigos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanelEnemigos.setOpaque(false);

        javax.swing.GroupLayout jPanelEnemigosLayout = new javax.swing.GroupLayout(jPanelEnemigos);
        jPanelEnemigos.setLayout(jPanelEnemigosLayout);
        jPanelEnemigosLayout.setHorizontalGroup(
            jPanelEnemigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        jPanelEnemigosLayout.setVerticalGroup(
            jPanelEnemigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelEnemigos);
        jPanelEnemigos.setBounds(790, 110, 450, 450);

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ClientFondo.jpg"))); // NOI18N
        lblfondo.setMaximumSize(new java.awt.Dimension(1345, 817));
        lblfondo.setMinimumSize(new java.awt.Dimension(1345, 817));
        getContentPane().add(lblfondo);
        lblfondo.setBounds(0, 0, 1440, 930);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshEnemyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshEnemyActionPerformed
        
       try{ 
       refCliente.hiloPlayer.writer.writeInt(3);
       refCliente.hiloPlayer.writer.writeUTF(lblPlayerEnemyName.getText());
       
       } catch (IOException ex){
           
       }
        
    }//GEN-LAST:event_btnRefreshEnemyActionPerformed

    private void btnNextPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextPlayerActionPerformed
     
        try{
         refCliente.hiloPlayer.writer.writeInt(4);
        } catch (IOException ex){
            
        }
        
    }//GEN-LAST:event_btnNextPlayerActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        
         try{
            
            txtAreaConsola.append(txtFieldConsola.getText() + "\n");
            refCliente.hiloPlayer.writer.writeInt(2);
            refCliente.hiloPlayer.writer.writeUTF(refCliente.nombre);
            refCliente.hiloPlayer.writer.writeUTF(txtFieldConsola.getText());
            txtFieldConsola.setText("");
            
        } catch (IOException ex){
            
        }   
        
    }//GEN-LAST:event_btnSendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNextPlayer;
    private javax.swing.JButton btnRefreshEnemy;
    private javax.swing.JButton btnSend;
    private javax.swing.JPanel jPanelEnemigos;
    private javax.swing.JPanel jPanelPropio;
    private javax.swing.JLabel lblAcero;
    private javax.swing.JLabel lblDinero;
    private javax.swing.JLabel lblPlayerEnemyName;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblPlayerName2;
    private javax.swing.JLabel lblPlayerName4;
    private javax.swing.JLabel lblPlayerName5;
    private javax.swing.JLabel lblPlayerTurno;
    private javax.swing.JLabel lblfondo;
    private java.awt.TextArea txtAreaConsola;
    private java.awt.TextField txtFieldConsola;
    // End of variables declaration//GEN-END:variables
}
