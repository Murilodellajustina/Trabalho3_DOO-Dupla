
package Controller;

import DAO.UsuarioBanco;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import MODEL.UsuarioModel;
import java.sql.SQLException;
import java.util.List;



public class UsuarioController {
    
    UsuarioModel usuarioModel = new UsuarioModel();
    Date antes = new Date("1940/01/01");
    Date depois = new Date("2002/01/01");
    
    public void cadastraUsuarioController(UsuarioModel usuario){
        if(usuario.getDataNascimento().after(depois) || usuario.getDataNascimento().before(antes)){
            JOptionPane.showMessageDialog(null, "Data Inválida!");
        }
        else if(usuario.getCPF().length() < 13 || usuario.getCPF().equalsIgnoreCase("   .   .   -  ")){
            JOptionPane.showMessageDialog(null, "CPF Inválido!");
        }
        else if((usuario.getNome() != null && usuario.getNome().length()>0) && (usuario.getCPF() != null && usuario.getCPF().length()>0) && (usuario.getSenha() != null && usuario.getSenha().length()>0) && (usuario.getDataNascimento() != null) && (usuario.getTipo() != null)){
            usuarioModel.cadastrarUsuarioDAO(usuario);
        }else{
            JOptionPane.showMessageDialog(null, "Digite os dados corretamente!");
        }
    }
    
    public boolean autenticarUsuario(String cpf, String senha) throws SQLException{
        if (cpf == null || cpf.isEmpty() || senha == null || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha CPF e senha!");
        }
        return usuarioModel.autenticarUsuario(cpf, senha);
        
    }
    
    public void atualizarUsuario(UsuarioModel usuario) throws SQLException{
        if (usuario.getNome().isEmpty() || usuario.getCPF().isEmpty() || usuario.getDataNascimento() == null || usuario.getSenha().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
        else{
            usuarioModel.atualizarUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Dados Alterados!");
        }
        
    }
    
    public void excluirUsuario(int id) throws SQLException{
        usuarioModel.excluirUsuario(id);
    }
    
    public List<UsuarioModel> listarTodosUsuarios() throws SQLException{
        return usuarioModel.listarTodosUsuarios();
    } 
    
    public UsuarioModel listarUsuarioPorId(int id){
        return usuarioModel.listarUsuarioPorId(id);
    }
}
