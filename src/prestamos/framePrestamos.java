/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.util.logging.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static prestamos.frameClientes.limpiarTabla;

/**
 *
 * @author adan
 */
public class framePrestamos extends javax.swing.JFrame {

    /**
     * Creates new form framePrestamos
     */
    Connection conexion= null;
    DefaultTableModel modeloFramePrestamos;
    DefaultComboBoxModel modeloComboBox;
    SimpleDateFormat fecha;
    String id2;
   
    String[] estado={"Adeudo","Pagado"};
   // frameClientes fc=new frameClientes();
    public framePrestamos() {
        
      //   conectar();
        modeloFramePrestamos=new DefaultTableModel(null,getColumnas());
        modeloComboBox= new DefaultComboBoxModel (new String[]{});
         initComponents();
         llenaComboBox();
         setFilas();
        // jComboBox2= new JComboBox(estado);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void llenaComboBox(){
 
    try {

          String sql = "SELECT id FROM cliente"; 
          PreparedStatement verUsuarios = conectar().prepareStatement(sql);
          ResultSet ver = verUsuarios.executeQuery();
           
            while(ver.next()){
               // System.out.println(ver.getString(1));
                modeloComboBox.addElement(ver.getString(1));
 
            }
    }
 
         catch (Exception e){
                 
                 }
 
        }
 
    
    public Connection conectar(){
    try{
    DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
    conexion=(Connection) DriverManager.getConnection(
    "jdbc:mysql://localhost/prestamos","root","123456");
    
    }
    catch(Exception e){
    e.printStackTrace();
    
    }
    return conexion;
    
    }
    private String[] getColumnas(){
    
     String columna[]= new String[]{"ID","ID Cliente","Importe","Estatus","fecha"};
     return columna;
    }
    
    private void setFilas(){
    try{
        Date date=null;
    String mysql="Select id,id_cliente,importe,estatus,fecha  From prestamos";
     PreparedStatement us=conectar().prepareStatement(mysql);
       ResultSet res = us.executeQuery();
            String datos[]= new String[5];
            while(res.next()){
                for(int i=0;i<5;i++){
                    datos[i]=res.getString(i+1);
                    
                }
              //  date=(Date)res.getObject(5);
                
                jTablePrestamos.updateUI();
                modeloFramePrestamos.addRow(datos);
                
            }   
        
    }
    catch(Exception e){}
   //   Logger.getLogger(framePrestamos.class.getName()).log(Level.SEVERE,null, ex);
  // JOptionPane.showMessageDialog(this,"error al conectar");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePrestamos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtImporte = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnGuardarModificacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTablePrestamos.setModel(modeloFramePrestamos);
        jScrollPane1.setViewportView(jTablePrestamos);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Importe");

        jLabel2.setText("Estatus");

        jLabel4.setText("ID cliente");

        jLabel5.setText("Fecha");

        jComboBox1.setModel(modeloComboBox
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adeudo", "Pagado" }));

        btnGuardarModificacion.setText("Guardar modificacion");
        btnGuardarModificacion.setEnabled(false);
        btnGuardarModificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarModificacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtImporte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardarModificacion)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnEliminar)
                                .addComponent(btnAgregar)))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addComponent(btnGuardarModificacion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
       
        try{
            Date date=null;
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	String fechaS = txtFecha.getText();
	try {
	 date = formatter.parse(fechaS);

	} catch (ParseException e) {
		e.printStackTrace();
	}
        Statement con= conectar().createStatement() ;
        String sql= "insert into prestamos values("+ 0 +",'"+ jComboBox1.getSelectedItem()+"',' "+ 
          txtImporte.getText()+"','"+jComboBox2.getSelectedItem() +"','"+formatter.format(date)+"')";
        con.executeUpdate(sql);
       frameClientes.limpiarTabla(jTablePrestamos);
        setFilas();
        JOptionPane.showMessageDialog(this,"Registro agregado");
        txtImporte.setText("");
       // jComboBox1.setText("");
        txtFecha.setText("");
       // txtCiudad.setText("");
       
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,"Error al agregar");
        }
        
        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTablePrestamos.getModel();
        try{
        int datoEliminar=jTablePrestamos.getSelectedRow(); 
        int id;
        if(datoEliminar<0){
        JOptionPane.showMessageDialog(null,"Debes seleccionar una fila de la tabla");
        }
        else{
        int confirmar=JOptionPane.showConfirmDialog(null,"Esta seguro que desea Eliminar el registro? "); 
        if(JOptionPane.OK_OPTION==confirmar) {
                    id= (int) jTablePrestamos.getValueAt(datoEliminar, 0);
                   model.removeRow(datoEliminar); 
                    Statement comando=conectar().createStatement();                 
                   comando.executeUpdate("delete from prestamos where id ="+ String.valueOf(id));
                   JOptionPane.showMessageDialog(null,"Registro Eliminado" );
            } 
        }
        }
        catch(Exception e){
        
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       
         try{
        int datoModificar=jTablePrestamos.getSelectedRow(); 
        if(datoModificar<0){
        JOptionPane.showMessageDialog(null,"Debes seleccionar una fila de la tabla");
        }
        else{
                    id2=  (jTablePrestamos.getValueAt(datoModificar, 0)).toString();
               String llenar= "select id_cliente,importe,estatus,fecha from prestamos where id = " +id2;
               
             PreparedStatement comando2 = conectar().prepareStatement(llenar);
             ResultSet usuario= comando2.executeQuery();
             while(usuario.next()){
                jComboBox1.removeAllItems();
                 llenaComboBox();
                // jComboBox1.addItem(usuario.getString(1));
                 
                 txtImporte.setText(usuario.getString(2));
                // jComboBox2.addItem(usuario.getString(3));
                 txtFecha.setText(usuario.getString(4));
                
             }
             btnGuardarModificacion.setEnabled(true); 
             btnAgregar.setEnabled(false);
             btnModificar.setEnabled(false);
             btnEliminar.setEnabled(false);
                  
        }
        }
        catch(Exception e){
        
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarModificacionActionPerformed
      
        try{
       
            Statement comando= conectar().createStatement() ;
            comando.executeUpdate("update prestamos set id_cliente ='"+ jComboBox1.getSelectedItem()+"',importe='"+txtImporte.getText()
            +"',estatus='"+jComboBox2.getSelectedItem()+"',fecha='"+txtFecha.getText()+"'where id="+id2);
            JOptionPane.showMessageDialog(null,"Registro Modificado" );
            limpiarTabla(jTablePrestamos);
        setFilas();
            btnAgregar.setEnabled(true);
             btnModificar.setEnabled(true);
             btnEliminar.setEnabled(true);
             btnGuardarModificacion.setEnabled(false); 
             
       }
       catch(Exception e){
       
       }
    }//GEN-LAST:event_btnGuardarModificacionActionPerformed

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
            java.util.logging.Logger.getLogger(framePrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(framePrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(framePrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(framePrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new framePrestamos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarModificacion;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePrestamos;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtImporte;
    // End of variables declaration//GEN-END:variables
}