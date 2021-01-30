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
                else
                    refCliente.tableroEnemigo[row][col].refLabel.setBackground(Color.LIGHT_GRAY);

                if(refCliente.tableroEnemigo[row][col].visible == 1 || refCliente.tableroEnemigo[row][col].revelada == 1){
                
                    if(refCliente.tableroEnemigo[row][col].ID == 1)
                         refCliente.tableroEnemigo[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathMundo).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
           
                    else if(refCliente.tableroEnemigo[row][col].ID == 2)
                         refCliente.tableroEnemigo[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathConector).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));                             
            
                    else if(refCliente.tableroEnemigo[row][col].ID == 3)
                         refCliente.tableroEnemigo[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathMercado).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));               
                
                    else if(refCliente.tableroEnemigo[row][col].ID == 4)
                         refCliente.tableroEnemigo[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathMina).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));              

                    else if(refCliente.tableroEnemigo[row][col].ID == 5)
                         refCliente.tableroEnemigo[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathArmory).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));              
                
                    else if(refCliente.tableroEnemigo[row][col].ID == 6)
                         refCliente.tableroEnemigo[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathTemple).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));  
                      
                    else if(refCliente.tableroEnemigo[row][col].ID == 7)
                         refCliente.tableroEnemigo[row][col].refLabel.setIcon(new ImageIcon(new ImageIcon(pathHoyoNegro).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));                                              
                }
                else{
                    refCliente.tableroEnemigo[row][col].refLabel.setIcon(null);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanelPropio = new javax.swing.JPanel();
        jPanelEnemigos = new javax.swing.JPanel();
        lblfondo = new javax.swing.JLabel();
        lblfondo1 = new javax.swing.JLabel();

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
        btnRefreshEnemy.setBounds(1250, 20, 90, 40);

        btnNextPlayer.setText("Next");
        btnNextPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPlayerActionPerformed(evt);
            }
        });
        getContentPane().add(btnNextPlayer);
        btnNextPlayer.setBounds(1150, 20, 90, 40);
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
        lblAcero.setBounds(10, 330, 130, 40);

        lblPlayerName2.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayerName2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPlayerName2.setForeground(new java.awt.Color(204, 204, 0));
        lblPlayerName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerName2.setText("Acero:");
        lblPlayerName2.setOpaque(true);
        getContentPane().add(lblPlayerName2);
        lblPlayerName2.setBounds(10, 290, 130, 40);

        lblPlayerTurno.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayerTurno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPlayerTurno.setForeground(new java.awt.Color(0, 0, 0));
        lblPlayerTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerTurno.setOpaque(true);
        getContentPane().add(lblPlayerTurno);
        lblPlayerTurno.setBounds(670, 50, 130, 40);

        lblPlayerName4.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayerName4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPlayerName4.setForeground(new java.awt.Color(204, 204, 0));
        lblPlayerName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerName4.setText("Turno:");
        lblPlayerName4.setOpaque(true);
        getContentPane().add(lblPlayerName4);
        lblPlayerName4.setBounds(670, 10, 130, 40);

        lblDinero.setBackground(new java.awt.Color(255, 255, 255));
        lblDinero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDinero.setForeground(new java.awt.Color(0, 0, 0));
        lblDinero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDinero.setOpaque(true);
        getContentPane().add(lblDinero);
        lblDinero.setBounds(10, 250, 130, 40);

        lblPlayerName5.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayerName5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPlayerName5.setForeground(new java.awt.Color(204, 204, 0));
        lblPlayerName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerName5.setText("Dinero:");
        lblPlayerName5.setOpaque(true);
        getContentPane().add(lblPlayerName5);
        lblPlayerName5.setBounds(10, 210, 130, 40);

        lblPlayerEnemyName.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayerEnemyName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPlayerEnemyName.setForeground(new java.awt.Color(204, 204, 0));
        lblPlayerEnemyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerEnemyName.setText("Enemy name");
        lblPlayerEnemyName.setOpaque(true);
        getContentPane().add(lblPlayerEnemyName);
        lblPlayerEnemyName.setBounds(900, 20, 230, 40);

        lblPlayerName.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayerName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPlayerName.setForeground(new java.awt.Color(204, 204, 0));
        lblPlayerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerName.setText("Player name");
        lblPlayerName.setOpaque(true);
        getContentPane().add(lblPlayerName);
        lblPlayerName.setBounds(330, 20, 230, 40);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.Color.lightGray);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("2");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 170, 30, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.lightGray);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("0");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 110, 30, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.lightGray);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("1");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 140, 30, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.lightGray);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("3");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 200, 30, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.lightGray);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("4");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(180, 230, 30, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.lightGray);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("5");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(180, 260, 30, 30);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.lightGray);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("10");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(180, 410, 30, 30);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.lightGray);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("11");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(180, 440, 30, 30);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.lightGray);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("9");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(180, 380, 30, 30);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.lightGray);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("6");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(180, 290, 30, 30);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(java.awt.Color.lightGray);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("7");
        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(180, 320, 30, 30);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.lightGray);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("8");
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel12.setOpaque(true);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(180, 350, 30, 30);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(java.awt.Color.lightGray);
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("14");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel13.setOpaque(true);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(180, 530, 30, 30);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(java.awt.Color.lightGray);
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("12");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel14.setOpaque(true);
        getContentPane().add(jLabel14);
        jLabel14.setBounds(180, 470, 30, 30);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(java.awt.Color.lightGray);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("13");
        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel15.setOpaque(true);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(180, 500, 30, 30);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(java.awt.Color.lightGray);
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("0");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel16.setOpaque(true);
        getContentPane().add(jLabel16);
        jLabel16.setBounds(780, 110, 30, 30);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(java.awt.Color.lightGray);
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("1");
        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel17.setOpaque(true);
        getContentPane().add(jLabel17);
        jLabel17.setBounds(780, 140, 30, 30);

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(java.awt.Color.lightGray);
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("2");
        jLabel18.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel18.setOpaque(true);
        getContentPane().add(jLabel18);
        jLabel18.setBounds(780, 170, 30, 30);

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(java.awt.Color.lightGray);
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("3");
        jLabel19.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel19.setOpaque(true);
        getContentPane().add(jLabel19);
        jLabel19.setBounds(780, 200, 30, 30);

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(java.awt.Color.lightGray);
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("4");
        jLabel20.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel20.setOpaque(true);
        getContentPane().add(jLabel20);
        jLabel20.setBounds(780, 230, 30, 30);

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(java.awt.Color.lightGray);
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("5");
        jLabel21.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel21.setOpaque(true);
        getContentPane().add(jLabel21);
        jLabel21.setBounds(780, 260, 30, 30);

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(java.awt.Color.lightGray);
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("6");
        jLabel22.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel22.setOpaque(true);
        getContentPane().add(jLabel22);
        jLabel22.setBounds(780, 290, 30, 30);

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setForeground(java.awt.Color.lightGray);
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("7");
        jLabel23.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel23.setOpaque(true);
        getContentPane().add(jLabel23);
        jLabel23.setBounds(780, 320, 30, 30);

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setForeground(java.awt.Color.lightGray);
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("8");
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel24.setOpaque(true);
        getContentPane().add(jLabel24);
        jLabel24.setBounds(780, 350, 30, 30);

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setForeground(java.awt.Color.lightGray);
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("9");
        jLabel25.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel25.setOpaque(true);
        getContentPane().add(jLabel25);
        jLabel25.setBounds(780, 380, 30, 30);

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setForeground(java.awt.Color.lightGray);
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("10");
        jLabel26.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel26.setOpaque(true);
        getContentPane().add(jLabel26);
        jLabel26.setBounds(780, 410, 30, 30);

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setForeground(java.awt.Color.lightGray);
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("11");
        jLabel27.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel27.setOpaque(true);
        getContentPane().add(jLabel27);
        jLabel27.setBounds(780, 440, 30, 30);

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setForeground(java.awt.Color.lightGray);
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("12");
        jLabel28.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel28.setOpaque(true);
        getContentPane().add(jLabel28);
        jLabel28.setBounds(780, 470, 30, 30);

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setForeground(java.awt.Color.lightGray);
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("13");
        jLabel29.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel29.setOpaque(true);
        getContentPane().add(jLabel29);
        jLabel29.setBounds(780, 500, 30, 30);

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setForeground(java.awt.Color.lightGray);
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("14");
        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel30.setOpaque(true);
        getContentPane().add(jLabel30);
        jLabel30.setBounds(780, 530, 30, 30);

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel31.setForeground(java.awt.Color.lightGray);
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("0");
        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel31.setOpaque(true);
        getContentPane().add(jLabel31);
        jLabel31.setBounds(210, 80, 30, 30);

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel32.setForeground(java.awt.Color.lightGray);
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("1");
        jLabel32.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel32.setOpaque(true);
        getContentPane().add(jLabel32);
        jLabel32.setBounds(240, 80, 30, 30);

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel33.setForeground(java.awt.Color.lightGray);
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("2");
        jLabel33.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel33.setOpaque(true);
        getContentPane().add(jLabel33);
        jLabel33.setBounds(270, 80, 30, 30);

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel34.setForeground(java.awt.Color.lightGray);
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("3");
        jLabel34.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel34.setOpaque(true);
        getContentPane().add(jLabel34);
        jLabel34.setBounds(300, 80, 30, 30);

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setForeground(java.awt.Color.lightGray);
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("4");
        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel35.setOpaque(true);
        getContentPane().add(jLabel35);
        jLabel35.setBounds(330, 80, 30, 30);

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel36.setForeground(java.awt.Color.lightGray);
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("5");
        jLabel36.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel36.setOpaque(true);
        getContentPane().add(jLabel36);
        jLabel36.setBounds(360, 80, 30, 30);

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel37.setForeground(java.awt.Color.lightGray);
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("6");
        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel37.setOpaque(true);
        getContentPane().add(jLabel37);
        jLabel37.setBounds(390, 80, 30, 30);

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel38.setForeground(java.awt.Color.lightGray);
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("7");
        jLabel38.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel38.setOpaque(true);
        getContentPane().add(jLabel38);
        jLabel38.setBounds(420, 80, 30, 30);

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel39.setForeground(java.awt.Color.lightGray);
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("8");
        jLabel39.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel39.setOpaque(true);
        getContentPane().add(jLabel39);
        jLabel39.setBounds(450, 80, 30, 30);

        jLabel40.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel40.setForeground(java.awt.Color.lightGray);
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("9");
        jLabel40.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel40.setOpaque(true);
        getContentPane().add(jLabel40);
        jLabel40.setBounds(480, 80, 30, 30);

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel41.setForeground(java.awt.Color.lightGray);
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("10");
        jLabel41.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel41.setOpaque(true);
        getContentPane().add(jLabel41);
        jLabel41.setBounds(510, 80, 30, 30);

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel42.setForeground(java.awt.Color.lightGray);
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("11");
        jLabel42.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel42.setOpaque(true);
        getContentPane().add(jLabel42);
        jLabel42.setBounds(540, 80, 30, 30);

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel43.setForeground(java.awt.Color.lightGray);
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("12");
        jLabel43.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel43.setOpaque(true);
        getContentPane().add(jLabel43);
        jLabel43.setBounds(570, 80, 30, 30);

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel44.setForeground(java.awt.Color.lightGray);
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("13");
        jLabel44.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel44.setOpaque(true);
        getContentPane().add(jLabel44);
        jLabel44.setBounds(600, 80, 30, 30);

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel45.setForeground(java.awt.Color.lightGray);
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("14");
        jLabel45.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel45.setOpaque(true);
        getContentPane().add(jLabel45);
        jLabel45.setBounds(630, 80, 30, 30);

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel46.setForeground(java.awt.Color.lightGray);
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("0");
        jLabel46.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel46.setOpaque(true);
        getContentPane().add(jLabel46);
        jLabel46.setBounds(810, 80, 30, 30);

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel47.setForeground(java.awt.Color.lightGray);
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("1");
        jLabel47.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel47.setOpaque(true);
        getContentPane().add(jLabel47);
        jLabel47.setBounds(840, 80, 30, 30);

        jLabel48.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel48.setForeground(java.awt.Color.lightGray);
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("2");
        jLabel48.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel48.setOpaque(true);
        getContentPane().add(jLabel48);
        jLabel48.setBounds(870, 80, 30, 30);

        jLabel49.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel49.setForeground(java.awt.Color.lightGray);
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("3");
        jLabel49.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel49.setOpaque(true);
        getContentPane().add(jLabel49);
        jLabel49.setBounds(900, 80, 30, 30);

        jLabel50.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel50.setForeground(java.awt.Color.lightGray);
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("4");
        jLabel50.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel50.setOpaque(true);
        getContentPane().add(jLabel50);
        jLabel50.setBounds(930, 80, 30, 30);

        jLabel51.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel51.setForeground(java.awt.Color.lightGray);
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("5");
        jLabel51.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel51.setOpaque(true);
        getContentPane().add(jLabel51);
        jLabel51.setBounds(960, 80, 30, 30);

        jLabel52.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel52.setForeground(java.awt.Color.lightGray);
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("7");
        jLabel52.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel52.setOpaque(true);
        getContentPane().add(jLabel52);
        jLabel52.setBounds(1020, 80, 30, 30);

        jLabel53.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel53.setForeground(java.awt.Color.lightGray);
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("6");
        jLabel53.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel53.setOpaque(true);
        getContentPane().add(jLabel53);
        jLabel53.setBounds(990, 80, 30, 30);

        jLabel54.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel54.setForeground(java.awt.Color.lightGray);
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("8");
        jLabel54.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel54.setOpaque(true);
        getContentPane().add(jLabel54);
        jLabel54.setBounds(1050, 80, 30, 30);

        jLabel55.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel55.setForeground(java.awt.Color.lightGray);
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("9");
        jLabel55.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel55.setOpaque(true);
        getContentPane().add(jLabel55);
        jLabel55.setBounds(1080, 80, 30, 30);

        jLabel56.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel56.setForeground(java.awt.Color.lightGray);
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("10");
        jLabel56.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel56.setOpaque(true);
        getContentPane().add(jLabel56);
        jLabel56.setBounds(1110, 80, 30, 30);

        jLabel57.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel57.setForeground(java.awt.Color.lightGray);
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("11");
        jLabel57.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel57.setOpaque(true);
        getContentPane().add(jLabel57);
        jLabel57.setBounds(1140, 80, 30, 30);

        jLabel58.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel58.setForeground(java.awt.Color.lightGray);
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("12");
        jLabel58.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel58.setOpaque(true);
        getContentPane().add(jLabel58);
        jLabel58.setBounds(1170, 80, 30, 30);

        jLabel59.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel59.setForeground(java.awt.Color.lightGray);
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("13");
        jLabel59.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel59.setOpaque(true);
        getContentPane().add(jLabel59);
        jLabel59.setBounds(1200, 80, 30, 30);

        jLabel60.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel60.setForeground(java.awt.Color.lightGray);
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("14");
        jLabel60.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));
        jLabel60.setOpaque(true);
        getContentPane().add(jLabel60);
        jLabel60.setBounds(1230, 80, 30, 30);

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
        jPanelEnemigos.setBounds(810, 110, 450, 450);

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ClientFondo.jpg"))); // NOI18N
        lblfondo.setMaximumSize(new java.awt.Dimension(1345, 817));
        lblfondo.setMinimumSize(new java.awt.Dimension(1345, 817));
        getContentPane().add(lblfondo);
        lblfondo.setBounds(0, 0, 1440, 930);

        lblfondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ClientFondo.jpg"))); // NOI18N
        lblfondo1.setMaximumSize(new java.awt.Dimension(1345, 817));
        lblfondo1.setMinimumSize(new java.awt.Dimension(1345, 817));
        getContentPane().add(lblfondo1);
        lblfondo1.setBounds(0, 0, 1440, 930);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshEnemyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshEnemyActionPerformed
        
       try{ 
       refCliente.hiloPlayer.writer.writeInt(3);
       refCliente.hiloPlayer.writer.writeUTF(refCliente.nombre);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JLabel lblfondo1;
    private java.awt.TextArea txtAreaConsola;
    private java.awt.TextField txtFieldConsola;
    // End of variables declaration//GEN-END:variables
}
