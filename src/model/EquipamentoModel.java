package Model;

import DAO.AlterarBD;
import java.util.ArrayList;

public class EquipamentoModel {
    
    // Atributos
    private Integer id;
    private String tipo;
    private String cpf;
    private String marca;
    private String modelo;
    private String tipoDefeito;
    private String prazoEntrega;
    
    // Construtores

    public EquipamentoModel() {
    }

    public EquipamentoModel(String tipo, String modelo, String marca, String tipoDefeito, String prazoEntrega, String cpf) {
        this.id = id;
        this.tipo = tipo;
        this.cpf = cpf;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoDefeito = tipoDefeito;
        this.prazoEntrega = prazoEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEquipMarca() {
        return marca;
    }

    public void setEquipMarca(String equipMarca) {
        this.marca = equipMarca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoDefeito() {
        return tipoDefeito;
    }

    public void setTipoDefeito(String tipoDefeito) {
        this.tipoDefeito = tipoDefeito;
    }

    public String getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(String prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }
    public void cadastrarEquipamentoDAO(EquipamentoModel novoEquipamento) {
        AlterarBD novoRegistro = new AlterarBD();
        novoRegistro.inserirEquipamentoDAO(novoEquipamento);
    }

    public ArrayList<EquipamentoModel> buscarEquipamento() {
        return new AlterarBD().listarTodosEquipamentos();
    }

    public ArrayList<EquipamentoModel> searchEquipamento(String cpf) {
        return new AlterarBD().searchEquipModel(cpf);
    }

    public void alterarEquipamento(EquipamentoModel alterarEquipamento) {
        
        new AlterarBD().alterarEquipamentoBD(alterarEquipamento);
    }

    public void excluirEquipamento(int id) {
        new AlterarBD().excluirEquipamentoBD(id);
    }
}
    
