
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class ConexaoDAO {
    public static Connection conectorBD(){
            java.sql.Connection conexao = null;
            //chama o driver para conectar 
            String driver = "com.mysql.cj.jdbc.Driver";

            //informações referentes ao banco de dados
            String url = "jdbc:mysql://localhost:3306/escolhe_aula";
                String user = "root";
                String password = "";

            //estabelecendo a conexao com o banco de dados
            try {
                Class.forName(driver); 
                conexao = DriverManager.getConnection(url, user, password); 
                return conexao;  
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco: " + e.getMessage());
                return null; 
            }
        }
}
