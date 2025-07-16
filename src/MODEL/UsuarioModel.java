
package MODEL;

import DAO.UsuarioBanco;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public class UsuarioModel {
    private int id;
    private String nome;
    private String CPF;
    private Date dataNascimento;
    private String tipo;
    private String senha;
    private UsuarioBanco usuarioBanco = new UsuarioBanco();

    public UsuarioModel() {
    }

    public UsuarioModel(int id, String nome, String CPF, Date dataNascimento, String tipo, String senha) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
        this.senha = senha;
    }

    public UsuarioModel(String nome, String CPF, Date dataNascimento, String tipo, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
        this.senha = senha;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.dataNascimento = DataNascimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String Tipo) {
        this.tipo = Tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
    public void cadastrarUsuarioDAO(UsuarioModel usuario){
        usuarioBanco.inserirUsuarioBD(usuario);
        System.out.println("Dados enviados para o banco de dados!");
    }
    
    public boolean autenticarUsuario(String cpf, String senha) throws SQLException{
        return usuarioBanco.autenticarUsuario(cpf, senha);
    }
    
    public UsuarioModel buscarUsuarioPorLogin(String cpf){
        return usuarioBanco.buscarUsuarioPorLogin(cpf);
    }
    
    public void atualizarUsuario(UsuarioModel usuario) throws SQLException{
        usuarioBanco.atualizarUsuario(usuario);
    }
    
    public void excluirUsuario(int id) throws SQLException{
        usuarioBanco.excluirUsuario(id);
    }
    
    public List<UsuarioModel> listarTodosUsuarios() throws SQLException{
        return usuarioBanco.listarTodosUsuarios();
    } 
    
    public UsuarioModel listarUsuarioPorId(int id){
        return usuarioBanco.buscarUsuarioPorId(id);
    }
}
