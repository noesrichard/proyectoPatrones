/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.libreria.app;

import com.libreria.app.paneles.PanelUsuarios;
import com.libreria.catalogo.repositorio.MySQLRepoFactory;
import com.libreria.catalogo.repositorio.RepoFactory;
import com.libreria.catalogo.servicios.ServiciosFactory;

/**
 *
 * @author carri
 */
public class Main extends javax.swing.JFrame {

    MySQLRepoFactory fabricaRepositorios;
    ServiciosFactory fabricaServicios;
    /**
     * Creates new form Main
     */
    public Main() {
        fabricaRepositorios = new MySQLRepoFactory();
        fabricaServicios = new ServiciosFactory(fabricaRepositorios);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelAutores1 = new com.libreria.app.paneles.PanelAutores(fabricaServicios.getServicio(ServiciosFactory.AUTOR));
        panelCategorias1 = new com.libreria.app.paneles.PanelCategorias(fabricaServicios.getServicio(ServiciosFactory.CATEGORIA));
        panelLibros1 = new com.libreria.app.paneles.PanelLibros(fabricaServicios.getServicio(ServiciosFactory.LIBRO));
        panelInventario1 = new com.libreria.app.paneles.PanelInventario(fabricaServicios.getServicio(ServiciosFactory.INVENTARIO));
        panelUsuarios2 = new com.libreria.app.paneles.PanelUsuarios(fabricaServicios.getServicio(ServiciosFactory.USUARIO));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addTab("Autores", panelAutores1);
        jTabbedPane1.addTab("Categorías", panelCategorias1);
        jTabbedPane1.addTab("Libros", panelLibros1);
        jTabbedPane1.addTab("Inventario", panelInventario1);
        jTabbedPane1.addTab("Usuarios", panelUsuarios2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.libreria.app.paneles.PanelAutores panelAutores1;
    private com.libreria.app.paneles.PanelCategorias panelCategorias1;
    private com.libreria.app.paneles.PanelInventario panelInventario1;
    private com.libreria.app.paneles.PanelLibros panelLibros1;
    private com.libreria.app.paneles.PanelUsuarios panelUsuarios2;
    // End of variables declaration//GEN-END:variables
}
