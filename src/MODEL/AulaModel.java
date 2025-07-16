
package MODEL;

import DAO.AulaBanco;
import java.sql.SQLException;
import java.util.List;


public class AulaModel {
    
    private int id;
    private String turma;
    private String horario;
    private String materia;
    private int idDiretor;
    private String nomeDiretor;
    private boolean disponivel;
    private AulaBanco aula = new AulaBanco();

    public AulaModel(int id, String turma, String horario, String materia, int idDiretor, String nomeDiretor) {
        this.id = id;
        this.turma = turma;
        this.horario = horario;
        this.materia = materia;
        this.idDiretor = idDiretor;
        this.nomeDiretor = nomeDiretor;
    }

    public AulaModel(int id, String turma, String horario, String materia, int idDiretor, String nomeDiretor, boolean disponivel) {
        this.id = id;
        this.turma = turma;
        this.horario = horario;
        this.materia = materia;
        this.idDiretor = idDiretor;
        this.nomeDiretor = nomeDiretor;
        this.disponivel = disponivel;
    }
    
    

    public AulaModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getIdDiretor() {
        return idDiretor;
    }

    public void setIdDiretor(int idDiretor) {
        this.idDiretor = idDiretor;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    public void cadastrarAula(AulaModel novaAula){
        aula.cadastrarAula(novaAula);
    }
    
    public AulaModel buscarAulaPorId(int id){
        return aula.buscarAulaPorId(id);
    }
    
    public List<AulaModel> listarTodasAulas() throws SQLException{
        return aula.listarTodasAulas();
    }
    
    public List<AulaModel> listarAulasDisponiveis() throws SQLException{
        return aula.listarAulasDisponiveis();
    }
    
    public List<AulaModel> listarAulasIndisponiveis() throws SQLException{
        return aula.listarAulasIndisponiveis();
    }
    
    public List<AulaModel> listarAulasPorProfessor(int idProfessor) throws SQLException{
        return aula.listarAulasPorProfessor(idProfessor);
    }
    
    public void alterarAula(AulaModel aulaNova){
        aula.alterarAula(aulaNova);
    }
    
    public void excluirAula(int id){
        aula.excluirAula(id);
    }
}
