package Model;

import DAO.AlterarBD;
import java.util.ArrayList;

public class ClienteModel {

    // Atributos
    private String cpf;
    private String nome;
    private String telefone;
    private String cidade;
    private String dataCriacao;

    // Construtores
    public ClienteModel() {
    }

    public ClienteModel(String cpf, String nome, String telefone, String cidade, String dataCriacao) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.cidade = cidade;
        this.dataCriacao = dataCriacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    // Métodos DAO
    public void cadastrarClienteDAO(ClienteModel novoCliente) {
        AlterarBD novoRegistro = new AlterarBD();
        novoRegistro.inserirClienteDAO(novoCliente);
    }

    public ArrayList<ClienteModel> buscarCliente() {
        return new AlterarBD().listarTodosClientes();
    }

    public ArrayList<ClienteModel> searchCliente(String nome) {
        return new AlterarBD().searchModel(nome);
    }

    public void alterarCliente(ClienteModel clienteAjuste) {
        new AlterarBD().alterarClienteBD(clienteAjuste);
    }

    public void excluirCliente(String cpf) {
        new AlterarBD().excluirClienteBD(cpf);
    }
}
