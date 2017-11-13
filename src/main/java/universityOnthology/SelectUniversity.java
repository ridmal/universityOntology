/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityOnthology;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import onthologQueries.FacultyDetails;
import onthologQueries.UniversityDetails;
import org.json.JSONArray;
import org.json.JSONObject;
import static universityOnthology.SelectUniversity.facNames;
import static universityOnthology.SelectUniversity.jo;

/**
 *
 * @author Rid
 */
public class SelectUniversity extends javax.swing.JFrame {
 //public JSONArray uniNameArray;
    /**
     * Creates new form SelectUniversity
     */
    public static ArrayList<ArrayList> jo =  new UniversityDetails().getUniversities();
    public static ArrayList<ArrayList> facultyAL = null;
     public static String[] uniNames = new String[jo.get(1).size()];
     public static String[] facNames = new String[]{};
 
    public SelectUniversity() {
         for(int i =0;i<jo.get(1).size(); i++){
          uniNames[i] = jo.get(1).get(i).toString();
        }
        getFaculties(jo.get(0).get(0).toString());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btngotoCourse = new javax.swing.JButton();
        comboSelectUnversity = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        comboSelectFaculty = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("University Courses Onthology");

        jLabel4.setText("Find Details about University Courses");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Select the University ");

        btngotoCourse.setBackground(new java.awt.Color(255, 255, 255));
        btngotoCourse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btngotoCourse.setText("GO ");
        btngotoCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngotoCourseActionPerformed(evt);
            }
        });

        //String[] university = new String[]{"University Of moratuwa","University Of Colombo","University Of Ruhuna"};
        comboSelectUnversity.setModel(new DefaultComboBoxModel(uniNames));
        comboSelectUnversity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSelectUnversityActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Select the Faculty  ");

        comboSelectFaculty.setModel(new DefaultComboBoxModel(facNames));
        comboSelectFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSelectFacultyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btngotoCourse)
                            .addComponent(comboSelectUnversity, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboSelectFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboSelectUnversity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboSelectFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btngotoCourse)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btngotoCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngotoCourseActionPerformed
        // TODO add your handling code here:
        int i = comboSelectUnversity.getSelectedIndex(); // get the university select box id 
        MainPage.uniId = jo.get(0).get(i).toString(); // get UniID base on that index for pass the other page
        MainForm.uniID = jo.get(0).get(i).toString();
        int j = comboSelectFaculty.getSelectedIndex();
        MainForm.FacID = facultyAL.get(0).get(j).toString();
        MainPage mp = new MainPage();
        mp.setVisible(true);
    }//GEN-LAST:event_btngotoCourseActionPerformed

    private void comboSelectUnversityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSelectUnversityActionPerformed
        // TODO add your handling code here:
       int i    = comboSelectUnversity.getSelectedIndex();
        String uniId = jo.get(0).get(i).toString();
        System.out.println(uniId);
        getFaculties(uniId);
        comboSelectFaculty.removeAllItems();
        DefaultComboBoxModel facNameModel  = new DefaultComboBoxModel(facNames);
        comboSelectFaculty.setModel(facNameModel);
        
//     public static String[] uniNames = new String[jo.get(1).size()];
    }//GEN-LAST:event_comboSelectUnversityActionPerformed

    private void comboSelectFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSelectFacultyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSelectFacultyActionPerformed
    public void getFaculties(String uniId){

//        jo.get(0).get(i).toString();
      ArrayList<ArrayList> facjo =  new FacultyDetails().getFaculties(uniId);
      facultyAL = facjo;
      facNames = new String[facjo.get(1).size()];
        for(int j =0;j<facjo.get(1).size(); j++){
          facNames[j] = facjo.get(1).get(j).toString();
            }
        System.out.println(facNames); 
   
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
            java.util.logging.Logger.getLogger(SelectUniversity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectUniversity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectUniversity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectUniversity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectUniversity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btngotoCourse;
    private javax.swing.JComboBox comboSelectFaculty;
    private javax.swing.JComboBox comboSelectUnversity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}