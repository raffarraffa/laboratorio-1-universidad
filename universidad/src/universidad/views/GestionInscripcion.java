/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.views;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidad.controllers.AlumnoData;
import universidad.controllers.InscripcionData;
import universidad.controllers.MateriaData;
import universidad.models.Alumno;
import universidad.models.Materia;

/**
 *
 * @author Ro
 */
public class GestionInscripcion extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
              
       private Alumno alumno = new Alumno();
       private Materia materia = new Materia();
       private AlumnoData alumnoD = new AlumnoData();
       private MateriaData materiaD = new MateriaData();
       private ArrayList<Materia>listadoMaterias = new ArrayList();
       private ArrayList<Materia>listadoMateriaNo = new ArrayList();
       private InscripcionData inscripcion = new InscripcionData();
       private DefaultTableModel modelo= new DefaultTableModel();
       private DefaultTableModel modelo2= new DefaultTableModel();
        
        String dni;
    
    
    
    
    public GestionInscripcion() {
       initComponents();
       this.setLocationRelativeTo(null);
        this.setTitle("Gestionar Inscripciones");
        columnas();
        //inicia la vista con los botones deshabilitados
        Desinscribir.setEnabled(false);
        Inscribir.setEnabled(false);
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/universidad/img/inscripcion.png")); // linea para accerder al recurso
        this.setIconImage(icono);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Desinscribir = new javax.swing.JButton();
        Inscribir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        Tdni = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        cursadas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        NoCursadas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        BSalir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BSalir.setText("Salir");
        BSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSalirActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Gestionar Inscripciones");
        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Universidad de La Punta", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", 2, 11))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Seleccione una materia para inscribir:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Materias en las que está inscripto:");

        Desinscribir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Desinscribir.setText("Desinscribir");
        Desinscribir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Desinscribir.setBorderPainted(false);
        Desinscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesinscribirActionPerformed(evt);
            }
        });

        Inscribir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Inscribir.setText("Inscribir");
        Inscribir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Inscribir.setBorderPainted(false);
        Inscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscribirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("DNI:");

        buscar.setBackground(new java.awt.Color(153, 153, 153));
        buscar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        buscar.setText("Buscar");
        buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buscar.setBorderPainted(false);
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        Tdni.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        cursadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        cursadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cursadasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cursadas);

        NoCursadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(NoCursadas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tdni, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addComponent(Desinscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Inscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BSalir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar)
                    .addComponent(Tdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(Desinscribir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(Inscribir)))
                .addGap(9, 9, 9)
                .addComponent(BSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
       
    public void columnas(){
        ArrayList<Object> columna= new ArrayList();
        columna.add("Id");
        columna.add("Nombre");
        columna.add("Año");    
        for (Object it : columna) {
            modelo.addColumn(it);
            modelo2.addColumn(it);
        }
        cursadas.setModel(modelo);
        NoCursadas.setModel(modelo2);
    }
    public void borrarFilas(){
        int a= modelo.getRowCount()-1;
        int b= modelo2.getRowCount()-1;

        for (int i=a; i>=0; i--) {
            modelo.removeRow(i);
            
        }
        for (int i=b; i>=0; i--) {
            modelo2.removeRow(i);
            
        }
    }
    
    public void cargarTabla(){
        borrarFilas();
        dni=Tdni.getText();
        
        try {
            alumno = (Alumno)alumnoD.selectAlumnoDni(dni);
            
        } catch (IOException ex) {
            Logger.getLogger(GestionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        //verifica si el alumno está en la lista
        if(alumno.getDni()==null)//no está
            {
                JOptionPane.showMessageDialog(null,"El alumno no está en la lista");
            }else{//sí está en la lista
                try {
                 //selecciona las materias que cursa y las que no cursa
                 listadoMaterias=inscripcion.selectMaterias(alumno,true);
                 listadoMateriaNo=inscripcion.selectMaterias(alumno,false);
             } catch (IOException ex) {
                 Logger.getLogger(GestionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
             } catch (SQLException ex) {
                 Logger.getLogger(GestionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
             }

                //carga de las tablas
               for (Materia listadoMateria : listadoMaterias) {
                    modelo.addRow(new Object[]{listadoMateria.getId_materia(),listadoMateria.getNombre(),listadoMateria.getAnio()});
                }
                    if (modelo.getRowCount() == 0) {
                         JOptionPane.showMessageDialog(null,"No se encontraron materias en las que este inscripto");
                         Desinscribir.setEnabled(false);
                    }else{
                        Desinscribir.setEnabled(true);
                    }

               for (Materia listadoMateria : listadoMateriaNo) {
                  // if(materia.isEstado()==true)
                    modelo2.addRow(new Object[]{listadoMateria.getId_materia(),listadoMateria.getNombre(),listadoMateria.getAnio()});
                    
                }
                    if (modelo2.getRowCount() == 0) {
                         JOptionPane.showMessageDialog(null,"No se encontraron materias sin inscribir");
                         Inscribir.setEnabled(false);
                    }
                    else{
                        Inscribir.setEnabled(true);
                    }
                        
            }
        
    }
    
    public void cargarInscripcion() throws IOException{
        
         try {
             
             alumno = (Alumno)alumnoD.selectAlumnoDni(dni);
         } catch (IOException ex) {
             Logger.getLogger(GestionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        int seleccion = NoCursadas.getSelectedRow();
        if(seleccion!= -1)
        {
            //recibe el nombre de la materia
            String nombre=(NoCursadas.getValueAt(seleccion,1).toString());
                try {
                    materia=materiaD.selectMateria(nombre);//selecciona la materia buscada por nombre
                } catch (IOException ex) {
                    Logger.getLogger(GestionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
                }
             
             //carga la inscripcion en la base de datos
             int validar =inscripcion.insertInscripcion(alumno, materia);
             
            if(validar==1)
             {
                JOptionPane.showMessageDialog(null,"Se inscribió a la materia " + materia.getNombre());
             }else{
                 JOptionPane.showMessageDialog(null,"No se pudo inscribir a la materia " + materia.getNombre());
             }
            cargarTabla();
        }else{
            JOptionPane.showMessageDialog(null,"No se seleccionó ninguna materia");
        }
        
        
    }
    
    public void desinscribir() throws IOException{
         try {
             alumno = (Alumno)alumnoD.selectAlumnoDni(dni);
         } catch (IOException ex) {
             Logger.getLogger(GestionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
         }
        int seleccion = cursadas.getSelectedRow();
        if(seleccion!= -1)
        {
            //recibe el nombre de la materia seleccionada
            String nombre=(cursadas.getValueAt(seleccion,1).toString());
             try {
                 materia=materiaD.selectMateria(nombre);//selecciona la materia buscada por nombre
             } catch (IOException ex) {
                 Logger.getLogger(GestionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             //elimina la inscripcion en la base de datos
             int validar= inscripcion.deleteInscripcion(alumno, materia);
             if(validar==1)
             {
                JOptionPane.showMessageDialog(null,"Se dio de baja la materia " + materia.getNombre());
             }else{
                 JOptionPane.showMessageDialog(null,"No se pudo dar de baja a la materia " + materia.getNombre());
             }
                 
            cargarTabla();
        }else{
            JOptionPane.showMessageDialog(null,"No se seleccionó ninguna materia ");
        }
        
    }
    
    
    
    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        Inscribir.setEnabled(false);
        Desinscribir.setEnabled(false);
        cargarTabla();

    }//GEN-LAST:event_buscarActionPerformed

    private void cursadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursadasMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cursadasMouseClicked

    private void InscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscribirActionPerformed
           try {
               // TODO add your handling code here:

               cargarInscripcion();
           } catch (IOException ex) {
               Logger.getLogger(GestionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
           }
        NoCursadas.clearSelection();

    }//GEN-LAST:event_InscribirActionPerformed

    private void DesinscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesinscribirActionPerformed
           try {
               // TODO add your handling code here:

               desinscribir();
           } catch (IOException ex) {
               Logger.getLogger(GestionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
           }
        cursadas.clearSelection();

    }//GEN-LAST:event_DesinscribirActionPerformed

    private void BSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Home ventana;
           try {
               ventana = new Home();
               ventana.setVisible(true);
           } catch (IOException ex) {
               Logger.getLogger(GestionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(GestionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }//GEN-LAST:event_BSalirActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BSalir;
    private javax.swing.JButton Desinscribir;
    private javax.swing.JButton Inscribir;
    private javax.swing.JTable NoCursadas;
    private javax.swing.JTextField Tdni;
    private javax.swing.JButton buscar;
    private javax.swing.JTable cursadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
