package br.com.alura.conversordemoedas.Principal;

import br.com.alura.conversordemoedas.exchangerateapi.ConversorDeMoeda;
import br.com.alura.conversordemoedas.calculos.ServicoDeConversao;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("""
                -----------------------------------------------------
                   Olá! Seja bem-vindo(a) ao Conversor de Moedas. 
                Selecione uma opção para converter !
                
                   1) Dolar =>> Real
                   2) Real =>> Dolar
                   3) Real =>> Yuan chinês
                   4) Euro =>> Dolar
                   5) Real =>> Peso argentino
                   6) Real =>> Rand sul-africano
                   7) Sair
                   -----------------------------------------------------""");
        Scanner leitura = new Scanner(System.in);
        ConversorDeMoeda conversor = new ConversorDeMoeda();
        ServicoDeConversao servico = new ServicoDeConversao(conversor, leitura);
        String busca = "";


        while (!busca.equalsIgnoreCase("7")) {
            System.out.println("Digite uma opcao para continuar");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("7") || busca.equalsIgnoreCase("sair")){
                System.out.println("Encerrando o conversor. Obrigado");
                break;
            }
            try {
                servico.realizarConversao(busca);
            }catch (NumberFormatException e){
                System.out.println("Digite um numero Valido");
            }catch (RuntimeException e){
                System.out.println("Erro " + e.getMessage());
            }
        }
        leitura.close();

    }
}
