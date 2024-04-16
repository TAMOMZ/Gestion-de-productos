
package App;


import auth.DBManager;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightIJTheme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {
    
    ConexionSQL cc = new ConexionSQL();
    Connection con = (Connection) cc.conexion();
    
    public Register() {
        initComponents();
    }

    // Métodos de abstracción y encapsulamiento para obtener los datos del formulario
    private String getNombre() {
        return nametf.getText();
    }

    private String getApellido() {
        return lastnametf.getText();
    }

    private String getTelefono() {
        return phonenumbertf.getText();
    }

    private String getEmail() {
        return emailtf.getText();
    }

    private String getUsuario() {
        return usertf.getText();
    }

    private String getContrasena() {
        return String.valueOf(passwordtf.getPassword());
    }

    private String getConfirmarContrasena() {
        return String.valueOf(passwordconfirmtf.getPassword());
    }
    
    private void limpiarCampos() {
    nametf.setText("");
    lastnametf.setText("");
    phonenumbertf.setText("");
    emailtf.setText("");
    usertf.setText("");
    passwordtf.setText("");
    passwordconfirmtf.setText("");
}

    // Método para insertar un nuevo usuario en la base de datos
    private void registrarUsuario() {
        // Validar los datos si es necesario
        if (getNombre().isEmpty() || getApellido().isEmpty() || getTelefono().isEmpty() || getEmail().isEmpty() || getUsuario().isEmpty() || getContrasena().isEmpty() || getConfirmarContrasena().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!getContrasena().equals(getConfirmarContrasena())) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insertar los datos en la base de datos
        try {
            Connection connection = DBManager.getConnection();
            String query = "INSERT INTO users (Nombre, Apellido, Teléfono, `Correo electrónico`, Usuario, Password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, getNombre());
            statement.setString(2, getApellido());
            statement.setString(3, getTelefono());
            statement.setString(4, getEmail());
            statement.setString(5, getUsuario());
            statement.setString(6, getContrasena());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                Login login = new Login();
                login.setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        Background = new javax.swing.JPanel();
        Panel1 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        AppName = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        Logintxt = new javax.swing.JLabel();
        passwordtxt = new javax.swing.JLabel();
        nametxt = new javax.swing.JLabel();
        passwordtf = new javax.swing.JPasswordField();
        usertf = new javax.swing.JTextField();
        logintxt = new javax.swing.JLabel();
        loginbtn = new javax.swing.JLabel();
        registerbtn = new javax.swing.JButton();
        usertxt = new javax.swing.JLabel();
        nametf = new javax.swing.JTextField();
        nametxt1 = new javax.swing.JLabel();
        lastnametf = new javax.swing.JTextField();
        phonenumbertxt = new javax.swing.JLabel();
        phonenumbertf = new javax.swing.JTextField();
        emailtxt = new javax.swing.JLabel();
        emailtf = new javax.swing.JTextField();
        passwordtconfirmtxt = new javax.swing.JLabel();
        passwordconfirmtf = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel1.setBackground(new java.awt.Color(153, 51, 255));
        Panel1.setMaximumSize(new java.awt.Dimension(402, 444));
        Panel1.setMinimumSize(new java.awt.Dimension(402, 444));
        Panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Administrator\\Downloads\\management.png")); // NOI18N
        Panel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        AppName.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        AppName.setForeground(new java.awt.Color(255, 255, 255));
        AppName.setText("USER.IO");
        Panel1.add(AppName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        Background.add(Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 450));

        Panel2.setBackground(new java.awt.Color(255, 255, 255));
        Panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logintxt.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        Logintxt.setForeground(new java.awt.Color(153, 0, 255));
        Logintxt.setText("REGISTER");
        Panel2.add(Logintxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        passwordtxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordtxt.setForeground(new java.awt.Color(0, 0, 0));
        passwordtxt.setText("Password:");
        Panel2.add(passwordtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, 30));

        nametxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nametxt.setForeground(new java.awt.Color(0, 0, 0));
        nametxt.setText("Name:");
        Panel2.add(nametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 30));

        passwordtf.setBackground(new java.awt.Color(255, 255, 255));
        passwordtf.setForeground(new java.awt.Color(0, 0, 0));
        passwordtf.setText("Password");
        Panel2.add(passwordtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 210, 30));

        usertf.setBackground(new java.awt.Color(255, 255, 255));
        usertf.setForeground(new java.awt.Color(0, 0, 0));
        Panel2.add(usertf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 210, 30));

        logintxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logintxt.setForeground(new java.awt.Color(0, 0, 0));
        logintxt.setText("have an account?");
        Panel2.add(logintxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, -1));

        loginbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginbtn.setForeground(new java.awt.Color(102, 51, 255));
        loginbtn.setText("Login");
        loginbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginbtnMouseClicked(evt);
            }
        });
        Panel2.add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, -1, -1));

        registerbtn.setBackground(new java.awt.Color(255, 255, 255));
        registerbtn.setForeground(new java.awt.Color(0, 0, 0));
        registerbtn.setText("Register");
        registerbtn.setBorder(null);
        registerbtn.setBorderPainted(false);
        registerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbtnActionPerformed(evt);
            }
        });
        Panel2.add(registerbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 100, 30));

        usertxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usertxt.setForeground(new java.awt.Color(0, 0, 0));
        usertxt.setText("User:");
        Panel2.add(usertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 30));

        nametf.setBackground(new java.awt.Color(255, 255, 255));
        nametf.setForeground(new java.awt.Color(0, 0, 0));
        Panel2.add(nametf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 210, 30));

        nametxt1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nametxt1.setForeground(new java.awt.Color(0, 0, 0));
        nametxt1.setText("Last name:");
        Panel2.add(nametxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 30));

        lastnametf.setBackground(new java.awt.Color(255, 255, 255));
        lastnametf.setForeground(new java.awt.Color(0, 0, 0));
        Panel2.add(lastnametf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 210, 30));

        phonenumbertxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phonenumbertxt.setForeground(new java.awt.Color(0, 0, 0));
        phonenumbertxt.setText("Phone:");
        Panel2.add(phonenumbertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 30));

        phonenumbertf.setBackground(new java.awt.Color(255, 255, 255));
        phonenumbertf.setForeground(new java.awt.Color(0, 0, 0));
        Panel2.add(phonenumbertf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 210, 30));

        emailtxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailtxt.setForeground(new java.awt.Color(0, 0, 0));
        emailtxt.setText("Email:");
        Panel2.add(emailtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 30));

        emailtf.setBackground(new java.awt.Color(255, 255, 255));
        emailtf.setForeground(new java.awt.Color(0, 0, 0));
        Panel2.add(emailtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 210, 30));

        passwordtconfirmtxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordtconfirmtxt.setForeground(new java.awt.Color(0, 0, 0));
        passwordtconfirmtxt.setText("Confirm Pass:");
        Panel2.add(passwordtconfirmtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, 30));

        passwordconfirmtf.setBackground(new java.awt.Color(255, 255, 255));
        passwordconfirmtf.setForeground(new java.awt.Color(0, 0, 0));
        passwordconfirmtf.setText("Password");
        Panel2.add(passwordconfirmtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 210, 30));

        Background.add(Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 390, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMouseClicked
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_loginbtnMouseClicked

    private void registerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbtnActionPerformed
        registrarUsuario();
    }//GEN-LAST:event_registerbtnActionPerformed

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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppName;
    private javax.swing.JPanel Background;
    private javax.swing.JLabel Logintxt;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JTextField emailtf;
    private javax.swing.JLabel emailtxt;
    private javax.swing.JTextField lastnametf;
    private javax.swing.JLabel loginbtn;
    private javax.swing.JLabel logintxt;
    private javax.swing.JTextField nametf;
    private javax.swing.JLabel nametxt;
    private javax.swing.JLabel nametxt1;
    private javax.swing.JPasswordField passwordconfirmtf;
    private javax.swing.JLabel passwordtconfirmtxt;
    private javax.swing.JPasswordField passwordtf;
    private javax.swing.JLabel passwordtxt;
    private javax.swing.JTextField phonenumbertf;
    private javax.swing.JLabel phonenumbertxt;
    private javax.swing.JButton registerbtn;
    private javax.swing.JTextField usertf;
    private javax.swing.JLabel usertxt;
    // End of variables declaration//GEN-END:variables
}