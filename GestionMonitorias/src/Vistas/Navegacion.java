/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Vistas.Estudiantes.AgregarEstudiante;
import Vistas.Estudiantes.EliminarEstudiante;
import Vistas.Estudiantes.VerEstudiantes;
import Vistas.Monitorias.AgregarMonitoria;
import Vistas.Monitorias.EliminarMonitoria;
import Vistas.Monitorias.VerMonitorias;
import Vistas.Profesores.EliminarProfesor;
import Vistas.Profesores.IngresarProfesor;
import Vistas.Profesores.VerProfesores;
import Vistas.Resenas.AgregarResena;
import Vistas.Resenas.EliminarResena;
import Vistas.Resenas.VerResenas;
import modelos.Universidad;

/**
 *
 * @author farid
 */
public class Navegacion extends javax.swing.JFrame {

    private Universidad uni;

    /**
     * Creates new form Navegacion
     */
    public Navegacion(Universidad uni) {
        initComponents();
        this.uni = uni;
        label_fullname.setText(uni.getUsuarioActual().getFullName());
        label_role.setText(uni.getUsuarioActual().getRole());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_username = new javax.swing.JLabel();
        label_fullname = new javax.swing.JLabel();
        label_role = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btn_agregarEstudiante = new javax.swing.JMenuItem();
        btn_eliminarEstudiante = new javax.swing.JMenuItem();
        btn_verEstudiantes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btn_agregarProfesor = new javax.swing.JMenuItem();
        btn_eliminarProfesor = new javax.swing.JMenuItem();
        btn_verProfesor = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        btn_agregarResena = new javax.swing.JMenuItem();
        btn_eliminarResena = new javax.swing.JMenuItem();
        btn_verResenas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        btn_agregarMonitoria = new javax.swing.JMenuItem();
        btn_eliminarMonitoria = new javax.swing.JMenuItem();
        btn_verMonitorias = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_username.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_username.setText("¡Bienvenido!");

        label_fullname.setText(" ");

        label_role.setText(" ");

        jLabel1.setText("Tu rol es:");

        jMenu1.setText("Estudiantes");

        btn_agregarEstudiante.setText("Agregar");
        btn_agregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarEstudianteActionPerformed(evt);
            }
        });
        jMenu1.add(btn_agregarEstudiante);

        btn_eliminarEstudiante.setText("Eliminar");
        btn_eliminarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarEstudianteActionPerformed(evt);
            }
        });
        jMenu1.add(btn_eliminarEstudiante);

        btn_verEstudiantes.setText("Ver");
        btn_verEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verEstudiantesActionPerformed(evt);
            }
        });
        jMenu1.add(btn_verEstudiantes);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Profesores");

        btn_agregarProfesor.setText("Agregar");
        btn_agregarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarProfesorActionPerformed(evt);
            }
        });
        jMenu2.add(btn_agregarProfesor);

        btn_eliminarProfesor.setText("Eliminar");
        btn_eliminarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarProfesorActionPerformed(evt);
            }
        });
        jMenu2.add(btn_eliminarProfesor);

        btn_verProfesor.setText("Ver");
        btn_verProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verProfesorActionPerformed(evt);
            }
        });
        jMenu2.add(btn_verProfesor);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Cursos");

        jMenuItem7.setText("Agregar");
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Eliminar");
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Ver");
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Resenas");

        btn_agregarResena.setText("Agregar");
        btn_agregarResena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarResenaActionPerformed(evt);
            }
        });
        jMenu4.add(btn_agregarResena);

        btn_eliminarResena.setText("Eliminar");
        btn_eliminarResena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarResenaActionPerformed(evt);
            }
        });
        jMenu4.add(btn_eliminarResena);

        btn_verResenas.setText("Ver");
        btn_verResenas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verResenasActionPerformed(evt);
            }
        });
        jMenu4.add(btn_verResenas);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Materias");

        jMenuItem13.setText("Agregar");
        jMenu5.add(jMenuItem13);

        jMenuItem14.setText("Eliminar");
        jMenu5.add(jMenuItem14);

        jMenuItem15.setText("Ver");
        jMenu5.add(jMenuItem15);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Monitorias");

        btn_agregarMonitoria.setText("Agregar");
        btn_agregarMonitoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarMonitoriaActionPerformed(evt);
            }
        });
        jMenu6.add(btn_agregarMonitoria);

        btn_eliminarMonitoria.setText("Eliminar");
        btn_eliminarMonitoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarMonitoriaActionPerformed(evt);
            }
        });
        jMenu6.add(btn_eliminarMonitoria);

        btn_verMonitorias.setText("Ver");
        btn_verMonitorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verMonitoriasActionPerformed(evt);
            }
        });
        jMenu6.add(btn_verMonitorias);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Acerca de");
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_username, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addComponent(label_fullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_role, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_fullname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_role)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarEstudianteActionPerformed
        AgregarEstudiante AE = new AgregarEstudiante(this.uni);
        AE.setVisible(true);
    }//GEN-LAST:event_btn_agregarEstudianteActionPerformed

    private void btn_eliminarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarEstudianteActionPerformed
        EliminarEstudiante EE = new EliminarEstudiante(uni);
        EE.setVisible(true);
    }//GEN-LAST:event_btn_eliminarEstudianteActionPerformed

    private void btn_verEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verEstudiantesActionPerformed
        VerEstudiantes VE = new VerEstudiantes(uni);
        VE.setVisible(true);
    }//GEN-LAST:event_btn_verEstudiantesActionPerformed

    private void btn_agregarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarProfesorActionPerformed
        IngresarProfesor IP = new IngresarProfesor(uni);
        IP.setVisible(true);
    }//GEN-LAST:event_btn_agregarProfesorActionPerformed

    private void btn_eliminarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarProfesorActionPerformed
        EliminarProfesor EP = new EliminarProfesor(uni);
        EP.setVisible(true);
    }//GEN-LAST:event_btn_eliminarProfesorActionPerformed

    private void btn_verProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verProfesorActionPerformed
        VerProfesores VP = new VerProfesores(uni);
        VP.setVisible(true);
    }//GEN-LAST:event_btn_verProfesorActionPerformed

    private void btn_agregarResenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarResenaActionPerformed
        AgregarResena AR = new AgregarResena(uni);
        AR.setVisible(true);
    }//GEN-LAST:event_btn_agregarResenaActionPerformed

    private void btn_eliminarResenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarResenaActionPerformed
        EliminarResena ER = new EliminarResena(uni);
        ER.setVisible(true);
    }//GEN-LAST:event_btn_eliminarResenaActionPerformed

    private void btn_verResenasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verResenasActionPerformed
        VerResenas VR = new VerResenas(uni);
        VR.setVisible(true);
    }//GEN-LAST:event_btn_verResenasActionPerformed

    private void btn_agregarMonitoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarMonitoriaActionPerformed
        AgregarMonitoria AM = new AgregarMonitoria(uni);
        AM.setVisible(true);
    }//GEN-LAST:event_btn_agregarMonitoriaActionPerformed

    private void btn_eliminarMonitoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarMonitoriaActionPerformed
        EliminarMonitoria EM = new EliminarMonitoria(uni);
        EM.setVisible(true);
    }//GEN-LAST:event_btn_eliminarMonitoriaActionPerformed

    private void btn_verMonitoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verMonitoriasActionPerformed
        VerMonitorias VM = new VerMonitorias(uni);
        VM.setVisible(true);
    }//GEN-LAST:event_btn_verMonitoriasActionPerformed

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
            java.util.logging.Logger.getLogger(Navegacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Navegacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Navegacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Navegacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Navegacion(uni).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btn_agregarEstudiante;
    private javax.swing.JMenuItem btn_agregarMonitoria;
    private javax.swing.JMenuItem btn_agregarProfesor;
    private javax.swing.JMenuItem btn_agregarResena;
    private javax.swing.JMenuItem btn_eliminarEstudiante;
    private javax.swing.JMenuItem btn_eliminarMonitoria;
    private javax.swing.JMenuItem btn_eliminarProfesor;
    private javax.swing.JMenuItem btn_eliminarResena;
    private javax.swing.JMenuItem btn_verEstudiantes;
    private javax.swing.JMenuItem btn_verMonitorias;
    private javax.swing.JMenuItem btn_verProfesor;
    private javax.swing.JMenuItem btn_verResenas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JLabel label_fullname;
    private javax.swing.JLabel label_role;
    private javax.swing.JLabel label_username;
    // End of variables declaration//GEN-END:variables
}
