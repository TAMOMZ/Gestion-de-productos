
package DashboardPanels;


import App.ConexionSQL;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ProductsPanel extends javax.swing.JPanel {

    // Instancia de la clase de conexión a la base de datos
    ConexionSQL cc = new ConexionSQL();
    Connection con = (Connection) cc.conexion();
    
    // Declarar conexión a la base de datos
    private Connection conexion;
    
    public ProductsPanel() {
        initComponents();
        mostrarDatos();
    }
    
    // Método para insertar nuevos datos de productos en la base de datos
    public void insertarDatos(){
        
        
        try{
            
            String SQL="insert into productos (Nombre,Marca,Categoría,Precio) values (?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setString(1,tfnombre.getText());
            pst.setString(2,tfmarca.getText());
            pst.setString(3,tfcategoria.getText());
            pst.setString(4,tfprecio.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Producto agregado exitosamente");
                    
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"El producto no se ha agragado" + e.getMessage());
            
        }
    }
    
// Método para actualizar datos de productos en la base de datos
    public void ActualizarDatos(){
        
        
        try{
            
            String SQL="update productos set Nombre=?,Marca=?,Categoría=?,Precio=? where Nombre=?";
            
            
            int filaSeleccionada = tbproducts.getSelectedRow();
            String dao = (String) tbproducts.getValueAt(filaSeleccionada, 0);
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setString(1,tfnombre.getText());
            pst.setString(2,tfmarca.getText());
            pst.setString(3,tfcategoria.getText());
            pst.setString(4,tfprecio.getText());
            
            
            pst.setString(5,dao);
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Producto editado exitosamente");
                    
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"El producto no se ha editado correctamente " + e.getMessage());
            
        }
    }    
    // Método para eliminar datos de productos en la base de datos
    public void Eliminar(){
        
        int filaSeleccionada = tbproducts.getSelectedRow();
        
        try {
            String SQL = "DELETE FROM productos WHERE Nombre='" + tbproducts.getValueAt(filaSeleccionada, 0) + "'";
            
            
            Statement st=con.createStatement();
            
            int n=st.executeUpdate(SQL);
            
            if (n>=0) {
                
                JOptionPane.showMessageDialog(null, "EL producto ha sido eliminado correctamente");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar "+ e.getMessage());
        }
    }
    
    // Método para limpiar los campos de productos en pantalla
    public void LimpiarCampos(){
        
        tfnombre.setText("");
        tfmarca.setText("");
        tfcategoria.setText("");
        tfprecio.setText("");
        
    }
    // Método para mostrar datos de productos en la base de datos
    public void mostrarDatos(){
        
        
        String[] titulos = {"Nombre","Marca","Categoría","Precio"};
        String[] registros = new String[4];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "Select * from productos";
        
        try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {
                
            registros[0] = rs.getString("Nombre");
            registros[1] = rs.getString("Marca");
            registros[2] = rs.getString("Categoría");
            registros[3] = rs.getString("Precio");
            
            modelo.addRow(registros);
                
            }
            
            tbproducts.setModel(modelo);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos" + e.getMessage());
        }
    }

    public void BuscarDatos(String valor){
        
        
        String[] titulos = {"Nombre","Marca","Categoría","Precio"};
        String[] registros = new String[4];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "Select * from productos where Nombre like '%"+valor+"%'";
        
        try {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {
                
            registros[0] = rs.getString("Nombre");
            registros[1] = rs.getString("Marca");
            registros[2] = rs.getString("Categoría");
            registros[3] = rs.getString("Precio");
            
            modelo.addRow(registros);
                
            }
            
            tbproducts.setModel(modelo);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar los datos" + e.getMessage());
        }
    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbproducts = new javax.swing.JTable();
        btnseach = new javax.swing.JLabel();
        tfsearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfmarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfcategoria = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfprecio = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btndelete = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(870, 275));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbproducts.setBackground(new java.awt.Color(255, 255, 255));
        tbproducts.setForeground(new java.awt.Color(0, 0, 0));
        tbproducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Marca", "Categoría	", "Precio"
            }
        ));
        tbproducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbproductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbproducts);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 56, 854, 216));

        btnseach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/magnifying-glass.png"))); // NOI18N
        btnseach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnseach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnseachMouseClicked(evt);
            }
        });
        btnseach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnseachKeyReleased(evt);
            }
        });
        jPanel1.add(btnseach, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 40, -1));

        tfsearch.setBackground(new java.awt.Color(255, 255, 255));
        tfsearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfsearch.setText("Search");
        tfsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfsearchKeyReleased(evt);
            }
        });
        jPanel1.add(tfsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 287, 36));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 30));

        tfnombre.setBackground(new java.awt.Color(255, 255, 255));
        tfnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnombreActionPerformed(evt);
            }
        });
        jPanel2.add(tfnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 230, 30));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Marca:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 60, 30));

        tfmarca.setBackground(new java.awt.Color(255, 255, 255));
        tfmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfmarcaActionPerformed(evt);
            }
        });
        jPanel2.add(tfmarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 230, 30));

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Categoría:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 70, 30));

        tfcategoria.setBackground(new java.awt.Color(255, 255, 255));
        tfcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(tfcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 230, 30));

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Precio:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 60, 30));

        tfprecio.setBackground(new java.awt.Color(255, 255, 255));
        tfprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfprecioActionPerformed(evt);
            }
        });
        jPanel2.add(tfprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 230, 30));

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
        btnadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddMouseClicked(evt);
            }
        });
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnombreActionPerformed

    private void tfmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfmarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfmarcaActionPerformed

    private void tfcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfcategoriaActionPerformed

    private void tfprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfprecioActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        Eliminar();
        LimpiarCampos();
        mostrarDatos();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        insertarDatos();
        LimpiarCampos();
        mostrarDatos();
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddMouseClicked

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_btnclearActionPerformed

    private void tbproductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbproductsMouseClicked
        int filaSeleccionada = tbproducts.rowAtPoint(evt.getPoint());
        
        tfnombre.setText(tbproducts.getValueAt(filaSeleccionada,0).toString());
        tfmarca.setText(tbproducts.getValueAt(filaSeleccionada,1).toString());
        tfcategoria.setText(tbproducts.getValueAt(filaSeleccionada,2).toString());
        tfprecio.setText(tbproducts.getValueAt(filaSeleccionada,3).toString());
    }//GEN-LAST:event_tbproductsMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        ActualizarDatos();
        LimpiarCampos();
        mostrarDatos();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnseachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnseachMouseClicked
        
    }//GEN-LAST:event_btnseachMouseClicked

    private void btnseachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnseachKeyReleased
        
    }//GEN-LAST:event_btnseachKeyReleased

    private void tfsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfsearchKeyReleased
        BuscarDatos(tfsearch.getText());
    }//GEN-LAST:event_tfsearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JLabel btnseach;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbproducts;
    private javax.swing.JTextField tfcategoria;
    private javax.swing.JTextField tfmarca;
    private javax.swing.JTextField tfnombre;
    private javax.swing.JTextField tfprecio;
    private javax.swing.JTextField tfsearch;
    // End of variables declaration//GEN-END:variables
}
