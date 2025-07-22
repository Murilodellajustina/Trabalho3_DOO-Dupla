/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import Controller.AulaController;
import MODEL.AulaModel;
import MODEL.UsuarioModel;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaJFrameDiretor extends javax.swing.JFrame {

    private AulaController aulaController;
    private UsuarioModel usuario;

    public TelaJFrameDiretor() {
    }
    
    
    
    public TelaJFrameDiretor(UsuarioModel usuario) {
        this.usuario = usuario;
        this.aulaController = new AulaController();
        initComponents();
        jLabelNomeUsuario.setText(usuario.getNome());
    }
    
    public void listarTodasAulas() throws SQLException{
        List<AulaModel> aulas = aulaController.listarTodasAulas();
        DefaultTableModel model = (DefaultTableModel) jTableAulasCadastradas.getModel();
        model.setRowCount(0);
        
        for (AulaModel aula : aulas) {
            model.addRow(new Object[]{
                aula.getId(),
                aula.getTurma(),
                aula.getHorario(),
                aula.getMateria(),
                aula.getNomeDiretor()
            });
        }
    }
    
    public void listarAulasDisponiveis() throws SQLException{
        List<AulaModel> aulas = aulaController.listarAulasDisponiveis();
        DefaultTableModel model = (DefaultTableModel) jTableAulasCadastradas.getModel();
        model.setRowCount(0);
        
        for (AulaModel aula : aulas) {
            model.addRow(new Object[]{
                aula.getId(),
                aula.getTurma(),
                aula.getHorario(),
                aula.getMateria(),
                aula.getNomeDiretor()
            });
        }
    }
    
    public void listarAulasIndisponiveis() throws SQLException{
        List<AulaModel> aulas = aulaController.listarAulasIndisponiveis();
        DefaultTableModel model = (DefaultTableModel) jTableAulasCadastradas.getModel();
        model.setRowCount(0);
        
        for (AulaModel aula : aulas) {
            model.addRow(new Object[]{
                aula.getId(),
                aula.getTurma(),
                aula.getHorario(),
                aula.getMateria(),
                aula.getNomeDiretor()
            });
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelNomeUsuario = new javax.swing.JLabel();
        jButtonCadastrarNovaAula = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAulasCadastradas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButtonAlterarAula = new javax.swing.JButton();
        jButtonAlterarLogin = new javax.swing.JButton();
        jComboBoxSeletorTabela = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("BEM-VINDO");

        jLabel2.setFont(new java.awt.Font("Cooper Black", 3, 24)); // NOI18N
        jLabel2.setText("ESCOLHE AULA");

        jLabelNomeUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelNomeUsuario.setText("<< nome >>");

        jButtonCadastrarNovaAula.setText("Cadastrar nova aula");
        jButtonCadastrarNovaAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarNovaAulaActionPerformed(evt);
            }
        });

        jTableAulasCadastradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Turma", "Dia/Horario", "Materia", "Diretor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAulasCadastradas);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Aulas cadastradas:");

        jButtonAlterarAula.setText("Alterar aula cadastrada");
        jButtonAlterarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarAulaActionPerformed(evt);
            }
        });

        jButtonAlterarLogin.setText("Alterar Login");
        jButtonAlterarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarLoginActionPerformed(evt);
            }
        });

        jComboBoxSeletorTabela.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Disponiveis", "Indisponiveis" }));
        jComboBoxSeletorTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSeletorTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonAlterarAula)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonCadastrarNovaAula, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAlterarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxSeletorTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabelNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(86, 86, 86))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNomeUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrarNovaAula)
                    .addComponent(jButtonAlterarLogin))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxSeletorTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAlterarAula)
                .addContainerGap())
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/images/user.png"))); // NOI18N
        jMenu1.setText("Inicio");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/images/edit.png"))); // NOI18N
        jMenuItem3.setText("Alterar Login");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/images/icons8-sala-de-aula-50_resized.png"))); // NOI18N
        jMenuItem1.setText("Cadastrar nova aula");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/images/icons8-sala-de-aula-64_resized.png"))); // NOI18N
        jMenuItem2.setText("Alterar aula cadastrada");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/images/users.png"))); // NOI18N
        jMenuItem4.setText("LogOut");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGS/images/log-out.png"))); // NOI18N
        jMenuItem5.setText("Sair");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAlterarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarLoginActionPerformed
        TelaAlterarDiretor TelaAlterarDiretors = new TelaAlterarDiretor(usuario);
        TelaAlterarDiretors.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAlterarLoginActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TelaAlterarDiretor TelaAlterarDiretors = new TelaAlterarDiretor(usuario);
        TelaAlterarDiretors.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaCadastrarAula TelaCadastrarAulas = new TelaCadastrarAula(usuario);
        TelaCadastrarAulas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TelaAlterarAula TelaAlterarAulas = new TelaAlterarAula(usuario);
        TelaAlterarAulas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButtonCadastrarNovaAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarNovaAulaActionPerformed
        TelaCadastrarAula TelaCadastrarAulas = new TelaCadastrarAula(usuario);
        TelaCadastrarAulas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCadastrarNovaAulaActionPerformed

    private void jButtonAlterarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarAulaActionPerformed
        TelaAlterarAula TelaAlterarAulas = new TelaAlterarAula(usuario);
        TelaAlterarAulas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAlterarAulaActionPerformed

    private void jComboBoxSeletorTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSeletorTabelaActionPerformed
        if(jComboBoxSeletorTabela.getSelectedItem().equals("Todas")){
            try {
                listarTodasAulas();
            } catch (SQLException ex) {
                Logger.getLogger(TelaJFrameDiretor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(jComboBoxSeletorTabela.getSelectedItem().equals("Disponiveis")){
            try {
                listarAulasDisponiveis();
            } catch (SQLException ex) {
                Logger.getLogger(TelaJFrameDiretor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(jComboBoxSeletorTabela.getSelectedItem().equals("Indisponiveis")){
            try {
                listarAulasIndisponiveis();
            } catch (SQLException ex) {
                Logger.getLogger(TelaJFrameDiretor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBoxSeletorTabelaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente fazer LogOut?", "LogOut", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            TelaLogin loginFrame = new TelaLogin();
            loginFrame.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Saindo... Até mais!");
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaJFrameDiretor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJFrameDiretor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJFrameDiretor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJFrameDiretor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJFrameDiretor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarAula;
    private javax.swing.JButton jButtonAlterarLogin;
    private javax.swing.JButton jButtonCadastrarNovaAula;
    private javax.swing.JComboBox<String> jComboBoxSeletorTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelNomeUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableAulasCadastradas;
    // End of variables declaration//GEN-END:variables
}
