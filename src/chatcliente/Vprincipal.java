package chatcliente;
//import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil;
import static java.lang.System.exit;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import us.sosia.video.stream.agent.*;
import servArch.*;

public class Vprincipal extends javax.swing.JFrame {
private String nombre, msg;
private int[][] matriz = new int[20][2];//tabla de jugadores
private String[] nombres = new String[20];
//Si estamos en nuestra misma maquina usamos localhost si no la ip de la maquina servidor   

public Cliente cliente;
public StreamServer ss;
public EnviaArch ea;

    public Vprincipal() {
        initComponents();
        /*System.out.println("no entra");
        cliente= new Cliente(peMsg);
        Thread hilo = new Thread(cliente);
        hilo.start();
        
        */
    }
    public Vprincipal(String nombre) {
            //System.out.println("ENTRA EN EL DE STRING");
            initComponents();
            this.nombre = nombre;
            //System.out.println(peMsg);
            cliente = new Cliente(peMsg,TabNombres,nombre);
            Thread hilo = new Thread(cliente);
            hilo.start();
            this.nombre = nombre;
            jLabel1.setText(nombre);
            jLabel1.setVisible(true);
            msg = "Listo";
            cliente.enviarMsg(msg);
            cliente.enviarMsg(this.nombre);
        }
    
    void setMatriz(int m[][]){
        matriz=m;
    }
    void setNombres(String n[]){
        nombres=n;
    }
    /*
    matriz=cliente.getMatriz();
    */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        peMsg = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txMsg = new javax.swing.JEditorPane();
        BotonEnviar = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        JScrollPane = new javax.swing.JScrollPane();
        RecibePuerto = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        BotonVideoChat = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabNombres = new javax.swing.JTable();
        BotonArchivos = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");

        peMsg.setEditable(false);
        peMsg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        peMsg.setContentType("text/html"); // NOI18N
        peMsg.setForeground(new java.awt.Color(255, 255, 255));
        peMsg.setSelectionColor(new java.awt.Color(204, 102, 0));
        jScrollPane1.setViewportView(peMsg);

        txMsg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true));
        txMsg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(txMsg);

        BotonEnviar.setBackground(new java.awt.Color(0, 153, 255));
        BotonEnviar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotonEnviar.setForeground(new java.awt.Color(255, 255, 255));
        BotonEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat/Imag/send.png"))); // NOI18N
        BotonEnviar.setText("Enviar");
        BotonEnviar.setBorder(null);
        BotonEnviar.setBorderPainted(false);
        BotonEnviar.setContentAreaFilled(false);
        BotonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEnviarActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(0, 153, 255));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Privado");
        jCheckBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat/Imag/checkbox-blank-outline (1).png"))); // NOI18N
        jCheckBox1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/chat/Imag/checkbox-marked (1).png"))); // NOI18N
        jCheckBox1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/chat/Imag/checkbox-marked (1).png"))); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        RecibePuerto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true));
        RecibePuerto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JScrollPane.setViewportView(RecibePuerto);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        BotonVideoChat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonVideoChat.setForeground(new java.awt.Color(255, 255, 255));
        BotonVideoChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat/Imag/message-video.png"))); // NOI18N
        BotonVideoChat.setText("VideoChat");
        BotonVideoChat.setBorder(null);
        BotonVideoChat.setBorderPainted(false);
        BotonVideoChat.setContentAreaFilled(false);
        BotonVideoChat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonVideoChat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonVideoChat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonVideoChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVideoChatActionPerformed(evt);
            }
        });

        TabNombres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Puerto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabNombres.setOpaque(false);
        TabNombres.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jScrollPane3.setViewportView(TabNombres);
        if (TabNombres.getColumnModel().getColumnCount() > 0) {
            TabNombres.getColumnModel().getColumn(0).setResizable(false);
            TabNombres.getColumnModel().getColumn(1).setResizable(false);
        }

        BotonArchivos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonArchivos.setForeground(new java.awt.Color(255, 255, 255));
        BotonArchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat/Imag/attachment.png"))); // NOI18N
        BotonArchivos.setText("Enviar Archivos");
        BotonArchivos.setBorder(null);
        BotonArchivos.setBorderPainted(false);
        BotonArchivos.setContentAreaFilled(false);
        BotonArchivos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonArchivos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonArchivosActionPerformed(evt);
            }
        });

        BotonSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonSalir.setForeground(new java.awt.Color(255, 255, 255));
        BotonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat/Imag/exit-to-app.png"))); // NOI18N
        BotonSalir.setText("Salir");
        BotonSalir.setBorder(null);
        BotonSalir.setBorderPainted(false);
        BotonSalir.setContentAreaFilled(false);
        BotonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat/Imag/account-multiple.png"))); // NOI18N
        jLabel2.setText("Lista de Usuarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 9, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(BotonArchivos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BotonSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(BotonVideoChat)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonVideoChat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonArchivos)
                .addGap(43, 43, 43)
                .addComponent(BotonSalir)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BotonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void BotonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEnviarActionPerformed
        // TODO add your handling code here:

        if(jCheckBox1.isSelected()){//msje privado
            msg=RecibePuerto.getText();
            if(msg.equals("")){
                JOptionPane.showMessageDialog(null, "Necesita poner un puerto en el campo de a lado");
            }else{
                cliente.enviarMsg("privado");
                cliente.enviarMsg(msg);
                cliente.enviarMsg(nombre);
                msg = txMsg.getText();
                if(msg.equals("")){
                }else{
                    //Limpiamos el cuadro de texto del mensaje
                    txMsg.setText("");
                    //Utilizamos la funcion del cliente para enviar el mensaje
                    cliente.enviarMsg(msg);
                }

            }
        }else{
            cliente.enviarMsg("publico");
            cliente.enviarMsg(nombre);
            msg = txMsg.getText();
            if(msg.equals("")){
            }else{
                //Limpiamos el cuadro de texto del mensaje
                txMsg.setText("");
                //Utilizamos la funcion del cliente para enviar el mensaje
                cliente.enviarMsg(msg);
            }

        }

    }//GEN-LAST:event_BotonEnviarActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        // TODO add your handling code here:
        cliente.enviarMsg("publico");
        cliente.enviarMsg(nombre);
        cliente.enviarMsg("<strong> Usuario desconectado </strong>");
        exit(0);
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void BotonVideoChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVideoChatActionPerformed
        // TODO add your handling code here:
        int puertoChat =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese el puerto :"));
        ss = new StreamServer(puertoChat,nombre);
        /*Thread hilo = new Thread((Runnable) ss);
        hilo.start();*/
        
        //PROTOCOLO PARA ENVIAR EMNSAJE
        if(jCheckBox1.isSelected()){ //msje privado
             msg=RecibePuerto.getText();
            if(msg.equals("")){

                JOptionPane.showMessageDialog(null, "Necesita poner un puerto en el campo de a lado");
            }else{//privado-idpriv-camara-puerto
                cliente.enviarMsg("privado");
                cliente.enviarMsg(msg);
                cliente.enviarMsg("camara");
                cliente.enviarMsg("puertoChat");
            }
            
        }else{//publico-camara-puerto
            cliente.enviarMsg("publico");
            cliente.enviarMsg("camara");
            cliente.enviarMsg(Integer.toString(puertoChat));
        }
        
        
    }//GEN-LAST:event_BotonVideoChatActionPerformed

    private void BotonArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonArchivosActionPerformed
        // TODO add your handling code here:
        
        /*Thread hilo = new Thread((Runnable) ss);
        hilo.start();*/
        
        //PROTOCOLO PARA ENVIAR EMNSAJE
        if(jCheckBox1.isSelected()){//msje privado
             msg=RecibePuerto.getText();
            if(msg.equals("")){

                JOptionPane.showMessageDialog(null, "Necesita poner un puerto en el campo de a lado");
            }else{//privado-idpriv-archivoa
                cliente.enviarMsg("privado");
                cliente.enviarMsg(msg);
                cliente.enviarMsg("archivos");
                
                
            }
        }else{//publico-archivos
            cliente.enviarMsg("publico");
            cliente.enviarMsg("archivos");
            

        }
        
    try {
        sleep(500);
    } catch (InterruptedException ex) {
        Logger.getLogger(Vprincipal.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        ea= new EnviaArch();
        
        
    }//GEN-LAST:event_BotonArchivosActionPerformed

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
            java.util.logging.Logger.getLogger(Vprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vprincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Vprincipal().setVisible(true);
                
                
                
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonArchivos;
    private javax.swing.JButton BotonEnviar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JButton BotonVideoChat;
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JEditorPane RecibePuerto;
    private javax.swing.JTable TabNombres;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel1;
    private javax.swing.JEditorPane peMsg;
    private javax.swing.JEditorPane txMsg;
    // End of variables declaration//GEN-END:variables
}
