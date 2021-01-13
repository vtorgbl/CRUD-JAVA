package trabalhofinal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JTextField;

public class Pessoa {

    private int id;
    private String nome;
    private int idade;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void cadastrar(int id, String nome, int idade) {
        ConexaoBanco conexaoSQLite = new ConexaoBanco();
        conexaoSQLite.conectar();
        String sqlInsert = "INSERT INTO tbl_pessoa"
                + " (" + "id,nome,idade)"
                + "values (?,?,?)";
        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStament(sqlInsert);
        try {
            //inserindo os dados 
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nome);
            preparedStatement.setInt(3, idade);
            int resultado = preparedStatement.executeUpdate();
            //Se resultado = 1 inseriu dados, senão quer dizer que não inseriu
            if (resultado == 1) {
                System.out.println("Dados inseridos com sucesso");
            } else {
                System.out.println("Dados não inseridos!!!!");
            }
        } catch (SQLException e) {
            System.out.println("Dados não inseridos!!!!");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                conexaoSQLite.desconectar();
            }
        }
    }

    public ResultSet consulta() {
        ConexaoBanco conexaoSQLite = new ConexaoBanco();
        final String SQL = "SELECT id, nome, idade FROM tbl_pessoa";

        try {
            conexaoSQLite.conectar();
            PreparedStatement select = conexaoSQLite.criarPreparedStament(SQL);
            ResultSet rs = select.executeQuery();
            System.out.println("Consulta realizada!");
            return rs;
        } catch (SQLException e) {
            System.out.println("Erro ao Consultar os registro na tabela " + e.getMessage());
            return null;
        }

    }

    public void atualizar(String nome, int idade) {
        ConexaoBanco conexaoSQLite = new ConexaoBanco();
        conexaoSQLite.conectar();
        String sqlUpdate = "UPDATE tbl_pessoa SET  nome = ?, idade = ? WHERE id = ?";
        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStament(sqlUpdate);
        try {
            //atualizando os dados 
            preparedStatement.setString(1, nome);
            preparedStatement.setInt(2, idade);
            preparedStatement.setInt(3, id);
            int resultado = preparedStatement.executeUpdate();
            //Se resultado = 1 atualizou, senão quer dizer que não inseriu
            if (resultado == 1) {
                System.out.println("Dados atualizados com sucesso");
            } else {
                System.out.println("Dados não atualizados!!!!");
            }
        } catch (SQLException e) {
            System.out.println("Dados não atualizados!!!!");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                conexaoSQLite.desconectar();
            }
        }
    }

    public void excluir(int id) {
        ConexaoBanco conexaoSQLite = new ConexaoBanco();
        conexaoSQLite.conectar();
        String sqlInsert = "DELETE FROM tbl_pessoa WHERE id = ?";
        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStament(sqlInsert);
        try {
            //deletando os dados 
            preparedStatement.setInt(1, id);
            int resultado = preparedStatement.executeUpdate();
            //Se resultado for 1 deletado, senão quer dizer que não inseriu
            if (resultado == 1) {
                System.out.println("Dados deletados com sucesso");
            } else {
                System.out.println("Dados não deletados!!!!");
            }
        } catch (SQLException e) {
            System.out.println("Dados não deletados!!!!");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                conexaoSQLite.desconectar();
            }
        }
    }

}
