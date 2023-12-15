package Controller;

import Model.ClienteModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteController {
    
    public void cadastrarClienteController(String cpf, String nome, String telefone, String cidade,  String dataCriacao){

        //Verificar se as informações foram enviadas da maneira correta!
        if ((nome != null && nome.length() > 0)
                && (cpf != null && cpf.length() > 0)
                && (telefone != null && telefone.length() > 0)
                && (cidade != null && cidade.length() > 0)
                && (dataCriacao != null && dataCriacao.length() > 0)) {

            // Intanciar o objeto de acordo com o nosso modelo (Classe Contato)
            ClienteModel novoCliente = new ClienteModel(cpf, nome, telefone, cidade, dataCriacao);
                       
            //Chamar o método disponivel na classe de contatos que realiza a inserção do
            // registro no banco de dados.
            novoCliente.cadastrarClienteDAO(novoCliente);
            
        } else {
            JOptionPane.showMessageDialog(null, "Digite os dados corretamente!");
        }
    }
    
    public ArrayList<ClienteModel> listarClientesController(){
        ClienteModel cliente = new ClienteModel();
        return cliente.buscarCliente();
    }
    
    public ArrayList<ClienteModel> buscarClienteController(String cpf){
        ClienteModel cliente = new ClienteModel();
        return cliente.searchCliente(cpf);
    }
        
    public void alterarCliente(String cpf, String nome, String telefone, String cidade,  String dataCriacao){
        if ((nome != null && nome.length() > 0)
                && (cpf != null && cpf.length() > 0)
                && (telefone != null && telefone.length() > 0)
                && (cidade != null && cidade.length() > 0)
                && (dataCriacao != null && dataCriacao.length() > 0)) {
            
            ClienteModel clienteAjuste = new ClienteModel( cpf, nome, telefone, cidade, dataCriacao);
            clienteAjuste.alterarCliente(clienteAjuste);
        }
    }
    
    public void excluirCliente(String cpf){
        
        ClienteModel cpfCliente = new ClienteModel();
        cpfCliente.excluirCliente(cpf);
    }
    public ArrayList<ClienteModel> ListarContatoController(){
        ClienteModel cliente = new ClienteModel();
        return cliente.buscarCliente();
}
}
