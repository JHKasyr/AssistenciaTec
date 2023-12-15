package Controller;

import Model.EquipamentoModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EquipamentoController {
   
    public void cadastrarEquipamentoController(String modelo, String marca, String tipoDefeito, String prazoEntrega, String cpf){

        //Verificar se as informações foram enviadas da maneira correta!
        if ((tipoDefeito != null && tipoDefeito.length() > 0)
                && (cpf != null && cpf.length() > 0)
                && (marca != null && marca.length() > 0)
                && (modelo != null && modelo.length() > 0)
                && (tipoDefeito != null && tipoDefeito.length() > 0)
                && (prazoEntrega != null && prazoEntrega.length() > 0)) {

            // Intanciar o objeto de acordo com o nosso modelo (Classe Contato)
            EquipamentoModel novoEquipamento = new EquipamentoModel(modelo, marca, tipoDefeito, prazoEntrega, cpf);
                       
            //Chamar o método disponivel na classe de contatos que realiza a inserção do
            // registro no banco de dados.
            novoEquipamento.cadastrarEquipamentoDAO(novoEquipamento);
            
        } else {
            JOptionPane.showMessageDialog(null, "Digite os dados corretamente!");
        }
    }
    
    public ArrayList<EquipamentoModel> listarEquipamentosController(){
        EquipamentoModel equipamento = new EquipamentoModel();
        return equipamento.buscarEquipamento();
    }
    
    public ArrayList<EquipamentoModel> buscarEquipamentoController(String cpf){
        EquipamentoModel equipamento = new EquipamentoModel();
        return equipamento.searchEquipamento(cpf);
    }
        
    public void alterarEquipamento(String modelo, String marca, String tipoDefeito, String prazoEntrega, String cpf){
        
        if ((tipoDefeito != null && tipoDefeito.length() > 0)
                && (cpf != null && cpf.length() > 0)
                && (marca != null && marca.length() > 0)
                && (modelo != null && modelo.length() > 0)
                && (tipoDefeito != null && tipoDefeito.length() > 0)
                && (prazoEntrega != null && prazoEntrega.length() > 0)) {
            
            EquipamentoModel equipamentoAjuste = new EquipamentoModel(cpf,marca,modelo,tipoDefeito,prazoEntrega);
            equipamentoAjuste.alterarEquipamento(equipamentoAjuste);
        }
    }
    
    public void excluirEquipamento(int id){
        
        EquipamentoModel idEquipamento = new EquipamentoModel();
        idEquipamento.excluirEquipamento(id);
    }
}
