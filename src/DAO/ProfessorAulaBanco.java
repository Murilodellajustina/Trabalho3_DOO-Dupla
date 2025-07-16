
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ProfessorAulaBanco {
    
    public boolean associarProfessorAula(int idProfessor, int idAula){
        String sql = "INSERT INTO Professor_Aula(id_professor, id_aula) VALUES(?, ?)";
        PreparedStatement stmt = null;
        try {
            Connection conn = ConexaoDAO.conectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProfessor);
            stmt.setInt(2, idAula);
            stmt.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao fechar o stmt");
            }
        }
        return false;
    }
    
    public boolean desassociarProfessorAula(int idProfessor, int idAula){
        String sql = "DELETE FROM Professor_Aula WHERE id_professor = ? AND id_aula = ?";
        PreparedStatement stmt = null;
        try {
            Connection conn = ConexaoDAO.conectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProfessor);
            stmt.setInt(2, idAula);
            stmt.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao fechar o stmt");
            }
        }
        return false;
    }
    
    
}
