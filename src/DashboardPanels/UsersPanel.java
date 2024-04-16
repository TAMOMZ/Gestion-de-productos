/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DashboardPanels;

import App.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class UsersPanel extends javax.swing.JPanel {

 // Objeto de conexión a la base de datos
    ConexionSQL cc = new ConexionSQL();
    Connection con = (Connection) cc.conexion();
    
    //Constructor de la clase UsersPanel.
    public UsersPanel() {
        initComponents();
        mostrarDatos();
    }

    
    public void insertarDatos(){
        
        
        try{
            
            String SQL="insert into users (Nombre,Apellido,Teléfono,`Correo electrónico`,Usuario,Password) values (?,?,?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setString(1,tfnombre.getText());
            pst.setString(2,tfapellido.getText());
            pst.setString(3,tfnumero.getText());
            pst.setString(4,tfcorreo.getText());
            pst.setString(5,tfusuario.getText());
            pst.setString(6, tfpass.getText());
            
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Usuario agregado exitosamente");
                    
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"El producto no se ha agragado" + e.getMessage());
            
        }
    }
    
    public void ActualizarDatos(){
        
        
        try{
            
            String SQL="update users set Nombre=?,Apellido=?,Teléfono=?,`Correo electrónico`=?,Usuario=?,Password=? where Nombre=?";
            
            
            int filaSeleccionada = tbusers.getSelectedRow();
            String dao = (String) tbusers.getValueAt(filaSeleccionada, 0);
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setString(1,tfnombre.getText());
            pst.setString(2,tfapellido.getText());
            pst.setString(3,tfnumero.getText());
            pst.setString(4,tfcorreo.getText());
            pst.setString(5,tfusuario.getText());
            pst.setString(6,tfpass.getText());
            
            
            pst.setString(7,dao);
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Usuario editado exitosamente");
                    
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"El Usuario no se ha editado correctamente " + e.getMessage());
            
        }
    }    
    
    public void Eliminar(){
        
        int filaSeleccionada = tbusers.getSelectedRow();
        
        try {
            String SQL = "DELETE FROM users WHERE Nombre='" + tbusers.getValueAt(filaSeleccionada, 0) + "'";
            
            
            Statement st=con.createStatement();
            
            int n=st.executeUpdate(SQL);
            
            if (n>=0) {
                
                JOptionPane.showMessageDialog(null, "EL usuario ha sido eliminado correctamente");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar "+ e.getMessage());
        }
    }
    
    public void LimpiarCampos(){
        
        tfnombre.setText("");
        tfapellido.setText("");
        tfnumero.setText("");
        tfcorreo.setText("");
        tfusuario.setText("");
        tfpass.setText("");
        
    }
    
    public void mostrarDatos(){
        
        
        String[] titulos = {"Nombre","Apellido","Teléfono","Correo electrónico","Usuario","Password"};
        String[] registros = new String[6];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "Select * from users";
        
        try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {
                
            registros[0] = rs.getString("Nombre");
            registros[1] = rs.getString("Apellido");
            registros[2] = rs.getString("Teléfono");
            registros[3] = rs.getString("Correo electrónico");
            registros[4] = rs.getString("Usuario");
            registros[5] = rs.getString("Password");
            
            modelo.addRow(registros);
                
            }
            
            tbusers.setModel(modelo);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos" + e.getMessage());
        }
    }

    public void BuscarDatos(String valor){
        
        
        String[] titulos = {"Nombre","Apellido","Teléfono","Correo electrónico","Usuario"};
        String[] registros = new String[4];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "Select * from users where Nombre like '%"+valor+"%'";
        
        try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {
                
            registros[0] = rs.getString("Nombre");
            registros[1] = rs.getString("Apellido");
            registros[2] = rs.getString("Teléfono");
            registros[3] = rs.getString("Correo electrónico");
            registros[3] = rs.getString("Usuario");
            
            modelo.addRow(registros);
                
            }
            
            tbusers.setModel(modelo);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar los datos" + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbusers = new javax.swing.JTable();
        btnsearch = new javax.swing.JLabel();
        tfsearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfusuario = new javax.swing.JTextField();
        tfnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfapellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfnumero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfcorreo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btndelete = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfpass = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(870, 275));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbusers.setBackground(new java.awt.Color(255, 255, 255));
        tbusers.setForeground(new java.awt.Color(0, 0, 0));
        tbusers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido	", "Teléfono", "Correo electrónico	", "Usuario"
            }
        ));
        tbusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbusersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbusers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 56, 854, 216));

        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/magnifying-glass.png"))); // NOI18N
        jPanel1.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 40, -1));

        tfsearch.setBackground(new java.awt.Color(255, 255, 255));
        tfsearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfsearch.setText("Search");
        tfsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfsearchKeyReleased(evt);
            }
        });
        jPanel1.add(tfsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 287, 36));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 280));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 90, 30));

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 30));

        tfusuario.setBackground(new java.awt.Color(255, 255, 255));
        tfusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfusuarioActionPerformed(evt);
            }
        });
        jPanel2.add(tfusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 230, 30));

        tfnombre.setBackground(new java.awt.Color(255, 255, 255));
        tfnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnombreActionPerformed(evt);
            }
        });
        jPanel2.add(tfnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 230, 30));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 60, 30));

        tfapellido.setBackground(new java.awt.Color(255, 255, 255));
        tfapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfapellidoActionPerformed(evt);
            }
        });
        jPanel2.add(tfapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 230, 30));

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Teléfono:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 60, 30));

        tfnumero.setBackground(new java.awt.Color(255, 255, 255));
        tfnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnumeroActionPerformed(evt);
            }
        });
        jPanel2.add(tfnumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 230, 30));

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Correo electrónico:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 30));

        tfcorreo.setBackground(new java.awt.Color(255, 255, 255));
        tfcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcorreoActionPerformed(evt);
            }
        });
        jPanel2.add(tfcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 230, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btndelete.setBackground(new java.awt.Color(153, 0, 0));
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 130, 40));

        btnclear.setBackground(new java.awt.Color(153, 255, 204));
        btnclear.setForeground(new java.awt.Color(255, 255, 255));
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        jPanel3.add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 40));

        btnadd.setBackground(new java.awt.Color(204, 204, 0));
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel3.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 130, 40));

        btnupdate.setBackground(new java.awt.Color(51, 102, 255));
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 130, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 190, 250));

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Usuario:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 70, 30));

        tfpass.setBackground(new java.awt.Color(255, 255, 255));
        tfpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfpassActionPerformed(evt);
            }
        });
        jPanel2.add(tfpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 230, 30));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 870, 270));
    }// </editor-fold>//GEN-END:initComponents

    private void tfusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfusuarioActionPerformed

    private void tfnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnombreActionPerformed

    private void tfapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfapellidoActionPerformed

    private void tfnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnumeroActionPerformed

    private void tfcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfcorreoActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        Eliminar();
        LimpiarCampos();
        mostrarDatos();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        LimpiarCampos();
        mostrarDatos();
        
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        insertarDatos();
        LimpiarCampos();
        mostrarDatos();
        
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        ActualizarDatos();
        LimpiarCampos();
        mostrarDatos();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void tfpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfpassActionPerformed

    private void tfsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfsearchKeyReleased
        BuscarDatos(tfsearch.getText());
    }//GEN-LAST:event_tfsearchKeyReleased

    private void tbusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbusersMouseClicked
        int filaSeleccionada = tbusers.rowAtPoint(evt.getPoint());
        
        tfnombre.setText(tbusers.getValueAt(filaSeleccionada,0).toString());
        tfapellido.setText(tbusers.getValueAt(filaSeleccionada,1).toString());
        tfnumero.setText(tbusers.getValueAt(filaSeleccionada,2).toString());
        tfcorreo.setText(tbusers.getValueAt(filaSeleccionada,3).toString());
        tfusuario.setText(tbusers.getValueAt(filaSeleccionada,4).toString());
        tfpass.setText(tbusers.getValueAt(filaSeleccionada,5).toString());
    }//GEN-LAST:event_tbusersMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JLabel btnsearch;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbusers;
    private javax.swing.JTextField tfapellido;
    private javax.swing.JTextField tfcorreo;
    private javax.swing.JTextField tfnombre;
    private javax.swing.JTextField tfnumero;
    private javax.swing.JTextField tfpass;
    private javax.swing.JTextField tfsearch;
    private javax.swing.JTextField tfusuario;
    // End of variables declaration//GEN-END:variables
}
