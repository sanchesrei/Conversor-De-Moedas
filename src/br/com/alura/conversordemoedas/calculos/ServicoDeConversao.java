package br.com.alura.conversordemoedas.calculos;

import br.com.alura.conversordemoedas.exchangerateapi.ConversorDeMoeda;

import java.util.Scanner;

public class ServicoDeConversao {
    private ConversorDeMoeda conversor;
    private Scanner scanner;

    public ServicoDeConversao(ConversorDeMoeda conversor, Scanner scanner) {
        this.conversor = conversor;
        this.scanner = scanner;
    }

    public void realizarConversao(String opcao) {
        String moedaBase = "";
        String moedaAlvo = "";

        switch (opcao) {
            case "1":
                moedaBase = "USD";
                moedaAlvo = "BRL";
                break;
            case "2":
                moedaBase = "BRL";
                moedaAlvo = "USD";
                break;
            case "3":
                moedaBase = "BRL";
                moedaAlvo = "CNY";
                break;
            case "4":
                moedaBase = "EUR";
                moedaAlvo = "USD";
                break;
            case "5":
                moedaBase = "BRL";
                moedaAlvo = "ARS";
                break;
            case "6":
                moedaBase = "BRL";
                moedaAlvo = "ZAR";
                break;

            default:
                System.out.println("Opção '" + opcao + "' não reconhecida. Tente novamente.");
                return;

        }
        System.out.println("Digite o valor em " + moedaBase + " para converter:");
        double valorEntrada =    Double.parseDouble(scanner.nextLine());

        TaxaDeCambio taxas = conversor.buscartaxas(moedaBase);

        if (taxas.getConversion_rates().containsKey(moedaAlvo)) {
            double taxa = taxas.getConversion_rates().get(moedaAlvo);
            double valorConvertido = valorEntrada * taxa;

            System.out.printf("\n RESULTADO DA CONVERSÃO:\n");
            System.out.printf("O valor de **%.2f %s** é equivalente a **%.2f %s**%n",
                    valorEntrada, moedaBase, valorConvertido, moedaAlvo);
            System.out.println("(Taxa atual: 1 " + moedaBase + " = " + taxa + " " + moedaAlvo + ")");
        } else {
            System.out.println("Não foi possível encontrar a taxa de conversão para " + moedaAlvo + ".");
        }


    }
}
