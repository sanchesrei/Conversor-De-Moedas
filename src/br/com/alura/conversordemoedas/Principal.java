package br.com.alura.conversordemoedas;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("""
                1) Dolar =>> Real 
                2) Real =>> Dolar
                3) sair""");
        Scanner leitura = new Scanner(System.in);
        ConversorDeMoeda conversor = new ConversorDeMoeda();
        ServicoDeConversao servico = new ServicoDeConversao(conversor, leitura);
        String busca = "";


        while (!busca.equalsIgnoreCase("3")) {
            System.out.println("Digite uma opcao para continuar");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("3") || busca.equalsIgnoreCase("sair")){
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
