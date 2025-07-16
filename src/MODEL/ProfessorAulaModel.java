
package MODEL;

import DAO.ProfessorAulaBanco;


public class ProfessorAulaModel {
    
    ProfessorAulaBanco profAula = new ProfessorAulaBanco();
    
    public boolean associarAula(int idProfessor, int idAula){
        return profAula.associarProfessorAula(idProfessor, idAula);
    }
    
    public boolean desassociarAula(int idProfessor, int idAula){
        return profAula.desassociarProfessorAula(idProfessor, idAula);
    }
}
