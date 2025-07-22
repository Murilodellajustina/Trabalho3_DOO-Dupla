
package DAO;

import MODEL.AulaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class AulaBanco {
    public void cadastrarAula(AulaModel aula){
        String sql = "INSERT INTO Aula(turma, horario, materia, id_diretor) VALUES(?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement stmt = null;
        
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, aula.getTurma());
            stmt.setString(2, aula.getHorario());
            stmt.setString(3, aula.getMateria());
            stmt.setInt(4, aula.getIdDiretor());
            stmt.executeUpdate();
            
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco");
        }finally{
            try{
               if(stmt != null){
                   stmt.close();
               } 
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao fechar o stmt");
            }
        }
    }
    
    public AulaModel buscarAulaPorId(int id){
        String sql = "SELECT a.*, u.nome as nome_diretor FROM Aula a " + "JOIN Usuario u ON a.id_diretor = u.id WHERE a.id = ?";
        Connection connection = null;
        PreparedStatement stmt = null;
        
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    AulaModel aula = new AulaModel(
                            rs.getInt("id"),
                            rs.getString("turma"),
                            rs.getString("horario"),
                            rs.getString("materia"),
                            rs.getInt("id_diretor"),
                            rs.getString("nome_diretor")
                    );
                    
                    return aula;
                }
            }
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
        return null; 
    }
    
    public List<AulaModel> listarTodasAulas() throws SQLException{
        List<AulaModel> aulas = new ArrayList<>();
        String sql = "SELECT a.*, u.nome as nome_diretor FROM Aula a " +
                     "JOIN Usuario u ON a.id_diretor = u.id";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            Connection conn = ConexaoDAO.conectorBD();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AulaModel aula = new AulaModel();
                aula.setId(rs.getInt("id"));
                aula.setTurma(rs.getString("turma"));
                aula.setHorario(rs.getString("horario"));
                aula.setMateria(rs.getString("materia"));
                aula.setIdDiretor(rs.getInt("id_diretor"));
                aula.setNomeDiretor(rs.getString("nome_diretor"));
                aulas.add(aula);
            }
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
        return aulas;
    }
    
    public List<AulaModel> listarAulasDisponiveis() throws SQLException {
        List<AulaModel> aulas = new ArrayList<>();
        String sql = "SELECT a.*, u.nome as nome_diretor FROM Aula a " +
                     "JOIN Usuario u ON a.id_diretor = u.id " +
                     "LEFT JOIN Professor_Aula pa ON a.id = pa.id_aula " +
                     "WHERE pa.id_aula IS NULL";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            Connection conn = ConexaoDAO.conectorBD();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AulaModel aula = new AulaModel();
                aula.setId(rs.getInt("id"));
                aula.setTurma(rs.getString("turma"));
                aula.setHorario(rs.getString("horario"));
                aula.setMateria(rs.getString("materia"));
                aula.setIdDiretor(rs.getInt("id_diretor"));
                aula.setNomeDiretor(rs.getString("nome_diretor"));
                aula.setDisponivel(true);
                aulas.add(aula);
            }
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
        return aulas;
    }
    
    public List<AulaModel> listarAulasIndisponiveis() throws SQLException {
        List<AulaModel> aulas = new ArrayList<>();
        String sql = "SELECT a.*, u.nome as nome_diretor FROM Aula a " +
                     "JOIN Usuario u ON a.id_diretor = u.id " +
                     "LEFT JOIN Professor_Aula pa ON a.id = pa.id_aula " +
                     "WHERE pa.id_aula IS NOT NULL";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            Connection conn = ConexaoDAO.conectorBD();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AulaModel aula = new AulaModel();
                aula.setId(rs.getInt("id"));
                aula.setTurma(rs.getString("turma"));
                aula.setHorario(rs.getString("horario"));
                aula.setMateria(rs.getString("materia"));
                aula.setIdDiretor(rs.getInt("id_diretor"));
                aula.setNomeDiretor(rs.getString("nome_diretor"));
                aula.setDisponivel(false);
                aulas.add(aula);
            }
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
        return aulas;
    }
    
    public List<AulaModel> listarAulasPorProfessor(int idProfessor) throws SQLException{
        List<AulaModel> aulas = new ArrayList<>();
        String sql = "SELECT a.*, u.nome as nome_diretor FROM Aula a " +
                     "JOIN Usuario u ON a.id_diretor = u.id " +
                     "JOIN Professor_Aula pa ON a.id = pa.id_aula " +
                     "WHERE pa.id_professor = ?";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            Connection conn = ConexaoDAO.conectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProfessor);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AulaModel aula = new AulaModel();
                aula.setId(rs.getInt("id"));
                aula.setTurma(rs.getString("turma"));
                aula.setHorario(rs.getString("horario"));
                aula.setMateria(rs.getString("materia"));
                aula.setIdDiretor(rs.getInt("id_diretor"));
                aula.setNomeDiretor(rs.getString("nome_diretor"));
                aula.setDisponivel(false);
                aulas.add(aula);
            }
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
        return aulas;
    
    }
    
    public void alterarAula(AulaModel aula){
        String sql = "UPDATE Aula SET turma = ?, horario = ?, materia = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement stmt = null;
        
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, aula.getTurma());
            stmt.setString(2, aula.getHorario());
            stmt.setString(3, aula.getMateria());
            stmt.setInt(4, aula.getId());
            stmt.executeUpdate();
            System.out.println("Dados atualizados no banco com sucesso!");
            
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco");
        }finally{
            try{
               if(stmt != null){
                   stmt.close();
               } 
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao fechar o stmt");
            }
        }
    }
    
    public void excluirAula(int id){
        String sql = "DELETE FROM Aula WHERE id = ?";
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Dados excluidos do banco com sucesso!");
            
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco");
        }finally{
            try{
               if(stmt != null){
                   stmt.close();
               } 
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao fechar o stmt");
            }
        }
    }
}
