
package Controller;

import MODEL.AulaModel;
import MODEL.ProfessorAulaModel;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class AulaController {
    
    AulaModel aula = new AulaModel();
    
    public void cadastrarAula(AulaModel aulaNova){
        if (aulaNova.getTurma() == null || aulaNova.getTurma().isEmpty() || 
            aulaNova.getHorario() == null || aulaNova.getHorario().isEmpty() || 
            aulaNova.getMateria() == null || aulaNova.getMateria().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
        else{
            aula.cadastrarAula(aulaNova);
            JOptionPane.showMessageDialog(null, "Aula Cadastrada!");
        }
        
    }
    
    public AulaModel bucarAulaPorId(int id){
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
    
    public boolean solicitarAula(int idProfessor, int idAula) throws SQLException{
        AulaModel aulaSolicitar = aula.buscarAulaPorId(idAula);
        List<AulaModel> aulaDisponivel = aula.listarAulasDisponiveis();
        boolean disponivel = false;
        for (AulaModel aulaModel : aulaDisponivel) {
            if(aulaSolicitar.getId() == aulaModel.getId()){
                disponivel = true;
            }
        }
        if(aulaSolicitar == null){
            JOptionPane.showMessageDialog(null, "Aula nao existe!");
            return false;
        }
        
        else if(disponivel == false){
            JOptionPane.showMessageDialog(null, "Id informado invalido!");
            return false;
        }
        else if(disponivel == true){
            ProfessorAulaModel profAula = new ProfessorAulaModel();
            return profAula.associarAula(idProfessor, idAula);
        }
        return false;
    }
    
    public boolean desistirAula(int idProfessor, int idAula){
        AulaModel aulaSolicitar = aula.buscarAulaPorId(idAula);
        if(aulaSolicitar == null){
            JOptionPane.showMessageDialog(null, "Aula nao existe!");
            return false;
        }
        else{
            ProfessorAulaModel profAula = new ProfessorAulaModel();
            return profAula.desassociarAula(idProfessor, idAula);
        }
        
    }

    public void alterarAula(AulaModel aulaNova){
        if (aulaNova.getTurma().isEmpty() || aulaNova.getHorario().isEmpty() || aulaNova.getMateria().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
        else{
            aula.alterarAula(aulaNova);
            JOptionPane.showMessageDialog(null, "Aula Atualizada com sucesso!");
        }
        
    }
    
    public void excluirAula(int id){
        aula.excluirAula(id);
        JOptionPane.showMessageDialog(null, "Aula excluida com sucesso!");
        
    }
}
