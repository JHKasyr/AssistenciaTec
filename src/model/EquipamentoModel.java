package Model;

public class EquipamentoModel {
    
    // Atributos
    private Integer id;
    private String tipoEquipamento;
    private String cpf;
    private String equipMarca;
    private String modelo;
    private String tipoDefeito;
    private String prazoEntrega;
    
    // Construtores

    public EquipamentoModel() {
    }

    public EquipamentoModel(int id, String tipoEquipamento, String cpf, String equipMarca, String modelo, String tipoDefeito, String prazoEntrega) {
        this.id = id;
        this.tipoEquipamento = tipoEquipamento;
        this.cpf = cpf;
        this.equipMarca = equipMarca;
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

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEquipMarca() {
        return equipMarca;
    }

    public void setEquipMarca(String equipMarca) {
        this.equipMarca = equipMarca;
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
}
    
