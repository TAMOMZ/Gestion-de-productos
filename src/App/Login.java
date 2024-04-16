
package App;


import auth.DBManager;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightIJTheme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;



public class Login extends javax.swing.JFrame {

   // Objeto de conexión a la base de datos
    ConexionSQL cc = new ConexionSQL();
    Connection con = (Connection) cc.conexion();
    
    public Login() {
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        Panel1 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        AppName = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        Logintxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usertxt = new javax.swing.JLabel();
        usertxt1 = new javax.swing.JLabel();
        passwordtf = new javax.swing.JPasswordField();
        usertf = new javax.swing.JTextField();
        registertxt = new javax.swing.JLabel();
        registerbtn1 = new javax.swing.JLabel();
        showPassword = new javax.swing.JCheckBox();
        Loginbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel1.setBackground(new java.awt.Color(153, 51, 255));
        Panel1.setMaximumSize(new java.awt.Dimension(402, 444));
        Panel1.setMinimumSize(new java.awt.Dimension(402, 444));

        Logo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Administrator\\Downloads\\management.png")); // NOI18N

        AppName.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        AppName.setForeground(new java.awt.Color(255, 255, 255));
        AppName.setText("USER.IO");

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(AppName))
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(Logo))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(AppName)
                .addGap(36, 36, 36)
                .addComponent(Logo))
        );

        Background.add(Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 450));

        Panel2.setBackground(new java.awt.Color(255, 255, 255));
        Panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logintxt.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        Logintxt.setForeground(new java.awt.Color(153, 51, 255));
        Logintxt.setText("LOGIN");
        Panel2.add(Logintxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hide.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        Panel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 30, 30));

        usertxt.setBackground(new java.awt.Color(255, 255, 255));
        usertxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usertxt.setForeground(new java.awt.Color(0, 0, 0));
        usertxt.setText("Password:");
        Panel2.add(usertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        usertxt1.setBackground(new java.awt.Color(255, 255, 255));
        usertxt1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usertxt1.setForeground(new java.awt.Color(0, 0, 0));
        usertxt1.setText("User:");
        Panel2.add(usertxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        passwordtf.setBackground(new java.awt.Color(255, 255, 255));
        passwordtf.setForeground(new java.awt.Color(0, 0, 0));
        passwordtf.setText("Password");
        Panel2.add(passwordtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 210, 30));

        usertf.setBackground(new java.awt.Color(255, 255, 255));
        usertf.setForeground(new java.awt.Color(0, 0, 0));
        Panel2.add(usertf, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 210, 30));

        registertxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        registertxt.setForeground(new java.awt.Color(0, 0, 0));
        registertxt.setText("don't have an account?");
        Panel2.add(registertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 395, -1, -1));

        registerbtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        registerbtn1.setForeground(new java.awt.Color(153, 51, 255));
        registerbtn1.setText("Register");
        registerbtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerbtn1MouseClicked(evt);
            }
        });
        Panel2.add(registerbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 415, -1, -1));

        showPassword.setBackground(new java.awt.Color(255, 255, 255));
        showPassword.setForeground(new java.awt.Color(255, 255, 255));
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });
        Panel2.add(showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, 30));

        Loginbtn.setBackground(new java.awt.Color(255, 255, 255));
        Loginbtn.setForeground(new java.awt.Color(0, 0, 0));
        Loginbtn.setText("Login");
        Loginbtn.setBorder(null);
        Loginbtn.setBorderPainted(false);
        Loginbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginbtnActionPerformed(evt);
            }
        });
        Panel2.add(Loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 90, 30));

        Background.add(Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 390, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerbtn1MouseClicked
        Register register = new Register();
        register.setVisible(true);
        dispose();
    }//GEN-LAST:event_registerbtn1MouseClicked

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        if(showPassword.isSelected()){
            passwordtf.setEchoChar((char)0);
        }else{
            passwordtf.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasswordActionPerformed

    private void LoginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginbtnActionPerformed
    String usuario = usertf.getText().trim();
    String contrasena = new String(passwordtf.getPassword());

    if (validarCredenciales(usuario, contrasena)) {
        // Si las credenciales son válidas, cerrar la ventana de inicio de sesión
        this.dispose();
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true); // Make the Dashboard window visible

    } else {
        JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
    }     
    }//GEN-LAST:event_LoginbtnActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if(showPassword.isSelected()){
            passwordtf.setEchoChar((char)0);
        }else{
            passwordtf.setEchoChar('*');
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private boolean validarCredenciales(String usuario, String contrasena) {
        Connection connection = DBManager.getConnection();
        try {
            String query = "SELECT * FROM users WHERE Usuario = ? AND Password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Si hay al menos una fila en el resultado, las credenciales son válidas
        } catch (SQLException e) {
            System.out.println("Error al validar las credenciales: " + e.getMessage());
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try{
           FlatMaterialPalenightIJTheme.setup();
        } catch (Exception e){
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppName;
    private javax.swing.JPanel Background;
    private javax.swing.JButton Loginbtn;
    private javax.swing.JLabel Logintxt;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField passwordtf;
    private javax.swing.JLabel registerbtn1;
    private javax.swing.JLabel registertxt;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JTextField usertf;
    private javax.swing.JLabel usertxt;
    private javax.swing.JLabel usertxt1;
    // End of variables declaration//GEN-END:variables
}
