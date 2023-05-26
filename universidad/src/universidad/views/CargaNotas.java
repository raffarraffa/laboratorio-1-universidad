/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.views;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import universidad.controllers.AlumnoData;
import universidad.controllers.InscripcionData;
import universidad.controllers.MateriaData;
import universidad.models.Alumno;
import universidad.models.Materia;

/**
 *
 * @author Ro
 */
public class CargaNotas extends javax.swing.JFrame {

    /**
     * Creates new form CargaNotas
     */
    
    private Materia materia = new Materia() ;
    private Alumno alumno= new Alumno();
    private AlumnoData alumnoD= new AlumnoData();
    private InscripcionData inscripcionD= new InscripcionData();
    private MateriaData materiaD= new MateriaData();
    private ArrayList<Materia> lMateria= new ArrayList();
    
     
    
    public CargaNotas() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TDNI = new javax.swing.JTextField();
        jBuscar = new javax.swing.JButton();
        comboMaterias = new javax.swing.JComboBox<>();
        jNota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jAgregarNota = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de notas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("DNI:");

        TDNI.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TDNIActionPerformed(evt);
            }
        });

        jBuscar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jBuscar.setText("Buscar");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });

        comboMaterias.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        comboMaterias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMateriasActionPerformed(evt);
            }
        });

        jNota.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("NOTA:");

        jAgregarNota.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jAgregarNota.setText("Agregar");
        jAgregarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarNotaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Seleccione la materia:");

        jSalir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jSalir.setText("Salir");
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSalir)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jNota)
                                .addComponent(TDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(47, 47, 47)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBuscar)
                                .addComponent(jAgregarNota)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBuscar)
                    .addComponent(jLabel2))
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(comboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jAgregarNota))
                .addGap(51, 51, 51)
                .addComponent(jSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TDNIActionPerformed

    private void comboMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMateriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMateriasActionPerformed

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
        try {
            // TODO add your handling code here:
            inciarCombo();
        } catch (IOException ex) {
            Logger.getLogger(CargaNotas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CargaNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBuscarActionPerformed

    private void jAgregarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarNotaActionPerformed
        try {
            // TODO add your handling code here:
            agregarNota();
        } catch (IOException ex) {
            Logger.getLogger(CargaNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jAgregarNotaActionPerformed

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jSalirActionPerformed

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
            java.util.logging.Logger.getLogger(CargaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaNotas().setVisible(true);
            }
        });
    }
    //combo
    public void inciarCombo() throws IOException, SQLException{
        
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();
        comboMaterias.setModel(comboBox);
        
        String dni=TDNI.getText().toString();
        alumno=alumnoD.selectAlumnoDni(dni);
        
        lMateria=inscripcionD.selectMaterias(alumno,true);
        for (Materia listaMateria : lMateria) {
            comboBox.addElement(listaMateria.getNombre());
        }
        
    }
    
    public void agregarNota() throws IOException{
        
        materia= materiaD.selectMateria((String)comboMaterias.getSelectedItem());
        double nota= Double.parseDouble(jNota.getText());
        String dni=TDNI.getText().toString();
        alumno=alumnoD.selectAlumnoDni(dni);
        inscripcionD.updateNota(alumno, materia, nota);
        JOptionPane.showMessageDialog(null,"Nota agregada con éxito");
        jNota.setText(null);
        
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TDNI;
    private javax.swing.JComboBox<String> comboMaterias;
    private javax.swing.JButton jAgregarNota;
    private javax.swing.JButton jBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jNota;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jSalir;
    // End of variables declaration//GEN-END:variables
}
