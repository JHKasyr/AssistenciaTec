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
        String sql = "INSERT INTO EQUIPAMENTO (id, modelo, marca, tipodefeito, prazoentrega, cpf) VALUES(1,?,?,?,?,?)";
        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoBD().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoEquipamento.getModelo());
            stmt.setString(2, novoEquipamento.getEquipMarca());
            stmt.setString(3, novoEquipamento.getTipoDefeito());
            stmt.setString(4, novoEquipamento.getPrazoEntrega());
            stmt.setString(5, novoEquipamento.getCpf());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastros feito");
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

        String sql = "SELECT * FROM ROOT.cliente";

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
                    cliente.setDataCriacao(rs.getString("dataCriacao"));
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

    public void alterarClienteBD(ClienteModel alterarCliente) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE ROOT.CLIENTE SET nome=?, telefone=?,cidade=? WHERE cpf=?";

        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, alterarCliente.getNome());
            stmt.setString(2, alterarCliente.getTelefone());
            stmt.setString(3, alterarCliente.getCidade());
            stmt.setString(4, alterarCliente.getCpf());
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
            JOptionPane.showMessageDialog(null, "Erro ao realizar exclusão de dados " + e);
        }
    }
    public ArrayList<EquipamentoModel> listarTodosEquipamentos() {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        EquipamentoModel equipamento = null;
        ArrayList<EquipamentoModel> listaEquipamentos = null;

        String sql = "SELECT * FROM ROOT.EQUIPAMENTO";

        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaEquipamentos = new ArrayList<>();
                while (rs.next()) {
                    equipamento = new EquipamentoModel();
                    equipamento.setId(rs.getInt("id"));
                    equipamento.setModelo(rs.getString("modelo"));
                    equipamento.setEquipMarca(rs.getString("marca"));
                    equipamento.setTipoDefeito(rs.getString("tipodefeito"));
                    equipamento.setPrazoEntrega(rs.getString("prazoentrega"));
                    equipamento.setCpf(rs.getString("cpf"));
                    listaEquipamentos.add(equipamento);
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
        return listaEquipamentos;
    }

    public ArrayList<EquipamentoModel> searchEquipModel(String cpf) {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        EquipamentoModel equip = null;
        ArrayList<EquipamentoModel> listaEquipamentos = null;

        String sql = "SELECT *" + " FROM ROOT.EQUIPAMENTO WHERE nome LIKE '%" + cpf + "%' ORDER BY nome";

        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaEquipamentos = new ArrayList<>();
                while (rs.next()) {
                    equip = new EquipamentoModel();
                    equip.setId(rs.getInt("id"));
                    equip.setModelo(rs.getString("modelo"));
                    equip.setEquipMarca(rs.getString("marca"));
                    equip.setTipoDefeito(rs.getString("tipodefeito"));
                    equip.setPrazoEntrega(rs.getString("praazoentrega"));
                    equip.setCpf(rs.getString("cpf"));
                    listaEquipamentos.add(equip);
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
        return listaEquipamentos;
    }

    public void alterarEquipamentoBD(EquipamentoModel alterarEquipamento) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE ROOT.EQUIPAMENTO SET MODELO=?, MARCA=?,TIPODEFEITO=?, PRAZOENTRGA=? WHERE id=?";

        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(2, alterarEquipamento.getModelo());
            stmt.setString(3, alterarEquipamento.getEquipMarca());
            stmt.setString(4, alterarEquipamento.getTipoDefeito());
            stmt.setString(5, alterarEquipamento.getPrazoEntrega());
            stmt.setInt(1, alterarEquipamento.getId());
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

    public void excluirEquipamentoBD(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM ROOT.EQUIPAMENTO WHERE id=?";

        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao realizar exclusão de dados " + e);
        }
    }
    public ArrayList<EquipamentoModel> listarTodosEquipamento() {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        EquipamentoModel equip = null;
        ArrayList<EquipamentoModel> listaEquipamentos = null;

        String sql = "SELECT * FROM ROOT.EQUIPAMENTO";

        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaEquipamentos = new ArrayList<>();
                while (rs.next()) {
                    equip = new EquipamentoModel();
                    equip.setModelo(rs.getString("modelo"));
                    equip.setEquipMarca(rs.getString("Marca"));
                    equip.setTipoDefeito(rs.getString("Tipodefeito"));
                    equip.setPrazoEntrega(rs.getString("prazoEntrega"));
                    equip.setCpf(rs.getString("cpf"));
                    listaEquipamentos.add(equip);
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
        return listaEquipamentos;
    }

}
