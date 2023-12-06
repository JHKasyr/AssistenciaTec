package DAO;

import model.ContatoModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class AlterarBD {

    public void inserirClite(ClienteModel novoCliente, EquipamentoModel novoEquipamento) {
        String sql = "INSERT INTO cliente (cpf,nome,telefone, cidade, datacriacao, equipamentotipo, equipmarca, tipodefeito) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoBD().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoCliente.getCpf);
            stmt.setString(2, novoCliente.getNome);
            stmt.setString(3, novoCliente.getTelefone);
            stmt.setString(4, novoCliente.getCidade);
            stmt.setDate(5, Date.valueOf(LocalDate.MAX));
            stmt.setString(6, novoEquipamento.getEquipamentoTipo);
            stmt.setString(7, novoEquipamento.getEquipMarca);
            stmt.setString(8, novoEquipamento.getTipoDefeito);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar regitro!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();

            }

        }
    }
}
