/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JLabel;
import vista.UsuDatos;

/**
 *
 * @author CGCF
 */
public class Menu_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Menu_Principal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Menú");
    }

    public JLabel getjLblSalir() {
        return jLblSalir;
    }

    public void setjLblSalir(JLabel jLblSalir) {
        this.jLblSalir = jLblSalir;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBttn_Mantenedor = new javax.swing.JButton();
        jBttn_DatosUsuario = new javax.swing.JButton();
        jBttn_Beneficiarios = new javax.swing.JButton();
        jBttn_Registro = new javax.swing.JButton();
        jLblSalir = new javax.swing.JLabel();
        jLabel_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBttn_Mantenedor.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jBttn_Mantenedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/construir.png"))); // NOI18N
        jBttn_Mantenedor.setText("Mantenedores");
        jBttn_Mantenedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBttn_Mantenedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jBttn_Mantenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 400, 290));

        jBttn_DatosUsuario.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jBttn_DatosUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/individual.png"))); // NOI18N
        jBttn_DatosUsuario.setText("Datos Usuario");
        jBttn_DatosUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBttn_DatosUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jBttn_DatosUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 400, 290));

        jBttn_Beneficiarios.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jBttn_Beneficiarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/trabajando.png"))); // NOI18N
        jBttn_Beneficiarios.setText("Beneficiarios");
        jBttn_Beneficiarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBttn_Beneficiarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jBttn_Beneficiarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 400, 290));

        jBttn_Registro.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jBttn_Registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/requisito.png"))); // NOI18N
        jBttn_Registro.setText("Registro de Asistencia");
        jBttn_Registro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBttn_Registro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBttn_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_RegistroActionPerformed(evt);
            }
        });
        jPanel1.add(jBttn_Registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 400, 290));

        jLblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jPanel1.add(jLblSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 60));

        jLabel_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buenpastor.jpg"))); // NOI18N
        jPanel1.add(jLabel_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 850));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttn_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_RegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBttn_RegistroActionPerformed

    
    public void datosPersonales(){
        UsuDatos btnDatospersonal = new UsuDatos();
        btnDatospersonal.setVisible(true);
    }
    
    public void registroAsistencia(){
        vista.Registrar_Asistencia btnRegistrarAsist = new vista.Registrar_Asistencia();
        btnRegistrarAsist.setVisible(true);
    }
    
    public void consultarAsistencia(){
        Asistencia_General btnAsistencia = new Asistencia_General();
        btnAsistencia.setVisible(true);
    }
    
    public void inscribir_Beneficiado(){
        Lista_Beneficiarios btnBeneficiarios = new Lista_Beneficiarios();
        ///Ins_Personal btnDatospersonal = new Ins_Personal();
        btnBeneficiarios.setVisible(true);
    }
     
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
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBttn_Beneficiarios;
    public javax.swing.JButton jBttn_DatosUsuario;
    public javax.swing.JButton jBttn_Mantenedor;
    public javax.swing.JButton jBttn_Registro;
    private javax.swing.JLabel jLabel_Fondo;
    private javax.swing.JLabel jLblSalir;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
