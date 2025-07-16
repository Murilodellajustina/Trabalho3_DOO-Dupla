
package Controller;

import MODEL.UsuarioModel;
import VIEW.TelaJFrameDiretor;
import VIEW.TelaJFrameProfessor;
import VIEW.TelaLogin;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController {
    
    private TelaLogin view;
    private UsuarioController usuarioController;

    public LoginController(TelaLogin view) {
        this.view = view;
        this.usuarioController = new UsuarioController();
    }
    
    public void autenticar(String cpf, String senha) throws SQLException{
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.autenticarUsuario(cpf, senha);
        
        if(cpf.isEmpty() || senha.isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
        
        UsuarioModel usuario = usuarioModel.buscarUsuarioPorLogin(cpf);
        
        if(usuario != null){
            if(usuario.getTipo().equalsIgnoreCase("Professor")){
                new TelaJFrameProfessor(usuario).setVisible(true);
            }
            else{
                new TelaJFrameDiretor(usuario).setVisible(true);
            }
            view.dispose();
        }
        else{
            JOptionPane.showMessageDialog(view, "CPF ou senha inválidos!");
        }
        
    }
    
}
