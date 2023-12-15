package DAO;

import Model.ClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Model.EquipamentoModel;

public class AlterarBD {

    public void inserirClienteDAO(ClienteModel novoCliente) {
        String sql = "INSERT INTO cliente (cpf,nome,telefone, cidade, datacriacao) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoBD().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoCliente.getCpf());
            stmt.setString(2, novoCliente.getNome());
            stmt.setString(3, novoCliente.getTelefone());
            stmt.setString(4, novoCliente.getCidade());
            stmt.setString(5, novoCliente.getDataCriacao());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastros feito");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar registro!");
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

    public void inserirEquipamentoDAO(EquipamentoModel novoEquipamento) {
        String sql = "INSERT INTO cliente (id, equipamentotipo, equipmarca, modelo, tipodefeito) VALUES(?,?,?)";
        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoBD().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(6, novoEquipamento.getId());
            stmt.setString(7, novoEquipamento.getTipoEquipamento());
            stmt.setString(8, novoEquipamento.getModelo());
            stmt.setString(9, novoEquipamento.getEquipMarca());
            stmt.setString(10, novoEquipamento.getTipoDefeito());

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

    public ArrayList<ClienteModel> listarTodosClientes() {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        ClienteModel cliente = null;
        ArrayList<ClienteModel> listaClientes = null;

        String sql = "SELECT * FROM ROOT.CLIENTE";

        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaClientes = new ArrayList<>();
                while (rs.next()) {
                    cliente = new ClienteModel();
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setCidade(rs.getString("Cidade"));
                    cliente.setDataCriacao(rs.getString("datacriacao"));
                    listaClientes.add(cliente);
                }
            }
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
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
        return listaClientes;
    }

    public ArrayList<ClienteModel> searchModel(String nome) {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        ClienteModel cliente = null;
        ArrayList<ClienteModel> listaClientes = null;

        String sql = "SELECT *" + " FROM ROOT.CLIENTE WHERE nome LIKE '%" + nome + "%' ORDER BY nome";

        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaClientes = new ArrayList<>();
                while (rs.next()) {
                    cliente = new ClienteModel();
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setCidade(rs.getString("Cidade"));
                    cliente.setDataCriacao(rs.getString("datacriacao"));
                    listaClientes.add(cliente);
                }
            }
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
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
        return listaClientes;
    }

    public void alterarClienteBD(ClienteModel clienteAjuste) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE ROOT.CLIENTE SET nome=?, telefone=?,cidade=? WHERE cpf=?";

        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, clienteAjuste.getNome());
            stmt.setString(2, clienteAjuste.getCidade());
            stmt.setString(3, clienteAjuste.getTelefone());
            stmt.setString(4, clienteAjuste.getCpf());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao alterar contato");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao alterar contato \n" + e);
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
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }

    }

    public void excluirClienteBD(String cpf) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM ROOT.CLIENTE WHERE cpf=?";

        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errp ao realizar exclusão de dados " + e);
        }
    }
}
