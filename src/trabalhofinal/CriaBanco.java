package trabalhofinal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CriaBanco {

    private final ConexaoBanco conexaoSQLite = new ConexaoBanco();

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS tbl_pessoa"
                + "("
                + "id integer PRIMARY KEY,"
                + "nome text NOT NULL,"
                + "idade integer"
                + ");";
        boolean conectou = false;
        try {
            conectou = this.conexaoSQLite.conectar();
            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql);
            System.out.println("Tabela pessoa criada!");
        } catch (SQLException e) {
            //mensagem de erro na criação da tabela
        } finally {
            if (conectou) {
                this.conexaoSQLite.desconectar();
            }
        }
    }     

}
