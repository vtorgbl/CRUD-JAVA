package trabalhofinal;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrabalhoFinal {

    public static void main(String[] args) {
        ConexaoBanco conexao = new ConexaoBanco();
        
         
        CriaBanco criarBanco = new CriaBanco();
        criarBanco.criarTabela();

        TelaInicial frame = new TelaInicial();
        frame.setVisible(true);

        TelaCadastro frame2 = new TelaCadastro();
        frame2.setVisible(true);

        TelaAtualizar frame3 = new TelaAtualizar();
        frame3.setVisible(true);

        TelaExcluir frame4 = new TelaExcluir();
        frame4.setVisible(true);
        
        TelaConsulta frame5 = new TelaConsulta();
        frame5.setVisible(true);

    }

}
          

