package Controller;

import Model.EquipamentoModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EquipamentoController {
   
    public void cadastrarEquipamentoController(String tipo, String cpf, String marca, String modelo, String defeito, String prazoEntrega){

        //Verificar se as informações foram enviadas da maneira correta!
        if ((tipo != null && tipo.length() > 0)
                && (cpf != null && cpf.length() > 0)
                && (marca != null && marca.length() > 0)
                && (modelo != null && modelo.length() > 0)
                && (defeito != null && defeito.length() > 0)
                && (prazoEntrega != null && prazoEntrega.length() > 0)) {

            // Intanciar o objeto de acordo com o nosso modelo (Classe Contato)
            EquipamentoModel novoEquipamento = new EquipamentoModel(tipo, cpf, marca, modelo, defeito, prazoEntrega);
                       
            //Chamar o método disponivel na classe de contatos que realiza a inserção do
            // registro no banco de dados.
            novoEquipamento.cadastrarEquipamentoDAO(novoEquipamento);
            
        } else {
            JOptionPane.showMessageDialog(null, "Digite os dados corretamente!");
        }
    }
    
    public ArrayList<EquipamentoModel> listarEquipamentosController(){
        EquipamentoModel equipamento = new EquipamentoModel();
        return equipamento.listarEquipamentos();
    }
    
    public ArrayList<EquipamentoModel> buscarEquipamentoController(String cpf){
        EquipamentoModel equipamento = new EquipamentoModel();
        return equipamento.buscarEquipamento(cpf);
    }
        
    public void alterarEquipamento(int id, String tipo, String cpf, String marca, String modelo,  String defeito, String prazoEntrega){
        
        if ((tipo != null && tipo.length() > 0)
                && (cpf != null && cpf.length() > 0)
                && (marca != null && marca.length() > 0)
                && (modelo != null && modelo.length() > 0)
                && (defeito != null && defeito.length() > 0)
                && (prazoEntrega != null && prazoEntrega.length() > 0)) {
            
            EquipamentoModel equipamentoAjuste = new EquipamentoModel(id, tipo, cpf, marca, modelo, defeito, prazoEntrega);
            equipamentoAjuste.alterarEquipamento(equipamentoAjuste);
        }
    }
    
    public void excluirEquipamento(int id){
        
        EquipamentoModel idEquipamento = new EquipamentoModel();
        idEquipamento.excluirEquipamento(id);
    }
}
