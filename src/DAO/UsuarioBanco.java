
package DAO;

import DAO.ConexaoDAO;
import MODEL.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class UsuarioBanco {
    public void inserirUsuarioBD(UsuarioModel Usuario){
        String sql = "INSERT INTO Usuario(nome, cpf, dataNascimento, tipo, senha) VALUES(?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement stmt = null;
        
        try {
            if (buscarUsuarioPorLogin(Usuario.getCPF()) != null) {
            JOptionPane.showMessageDialog(null, "CPF já cadastrado ou inválido!");
            }
            else{
                connection = new ConexaoDAO().conectorBD();
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, Usuario.getNome());
                stmt.setString(2, Usuario.getCPF());
                stmt.setDate(3, new java.sql.Date(Usuario.getDataNascimento().getTime()));
                stmt.setString(4,Usuario.getTipo());
                stmt.setString(5, Usuario.getSenha());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dados inseridos no banco com sucesso!");
            }
            
            
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
    
    public boolean autenticarUsuario(String cpf, String senha) throws SQLException {
        String sql = "SELECT senha FROM Usuario WHERE cpf = ? AND senha = ?";
        PreparedStatement stmt = null;
        try {
            Connection conn = ConexaoDAO.conectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
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
        return false;
    }
    
    public UsuarioModel buscarUsuarioPorLogin(String cpf){
        String sql = "SELECT * FROM Usuario WHERE cpf = ?";
        PreparedStatement stmt = null;
        try {
            Connection conn = ConexaoDAO.conectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    UsuarioModel usuario = new UsuarioModel();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setCPF(rs.getString("cpf"));
                    usuario.setDataNascimento(rs.getDate("dataNascimento"));
                    usuario.setTipo(rs.getString("tipo"));
                    return usuario;
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

    public void atualizarUsuario(UsuarioModel usuario) throws SQLException {
        String sql = "UPDATE Usuario SET nome = ?, cpf = ?, dataNascimento = ?, tipo = ?, senha = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            Connection conn = ConexaoDAO.conectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCPF());
            stmt.setDate(3, new java.sql.Date(usuario.getDataNascimento().getTime()));
            stmt.setString(4, usuario.getTipo());
            stmt.setString(5, usuario.getSenha()); 
            stmt.setInt(6, usuario.getId());
            stmt.executeUpdate();
            System.out.println("Usuario atualizado com sucesso no banco!");
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
    }

    public void excluirUsuario(int id) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            Connection conn = ConexaoDAO.conectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuario excluido com sucesso do banco!");
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
    }

    public List<UsuarioModel> listarTodosUsuarios() throws SQLException {
        List<UsuarioModel> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            Connection conn = ConexaoDAO.conectorBD();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCPF(rs.getString("cpf"));
                usuario.setDataNascimento(rs.getDate("dataNascimento"));
                usuario.setTipo(rs.getString("tipo"));
                usuarios.add(usuario);
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
        return usuarios;
    }
    
    public UsuarioModel buscarUsuarioPorId(int id){
        String sql = "SELECT * FROM Usuario WHERE id = ?";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            Connection conn = ConexaoDAO.conectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCPF(rs.getString("cpf"));
                usuario.setDataNascimento(rs.getDate("dataNascimento"));
                usuario.setTipo(rs.getString("tipo"));
                return usuario;
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
}
