/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gerenciabanco;

/**
 *
 * @author kayky
 */
import java.util.Scanner;

public class GerenciaBanco {

    private static double saldo = 0;
    private static String nome;
    private static String sobrenome;
    private static String cpf;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Gerenciamento Bancário!");
        System.out.print("Informe seu nome: ");
        nome = scanner.nextLine();

        System.out.print("Informe seu sobrenome: ");
        sobrenome = scanner.nextLine();

        System.out.print("Informe seu CPF: ");
        cpf = scanner.nextLine();

        boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar saque");
            System.out.println("4. Sair");
            System.out.print("Opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    realizarDeposito(scanner);
                    break;
                case 3:
                    realizarSaque(scanner);
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Obrigado por usar o Sistema de Gerenciamento Bancário, " + nome + " " + sobrenome + "!");
        scanner.close();
    }

    private static void consultarSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }

    private static void realizarDeposito(Scanner scanner) {
        System.out.print("Informe o valor do depósito: R$");
        double valorDeposito = Double.parseDouble(scanner.nextLine());

        if (valorDeposito > 0) {
            saldo += valorDeposito;
            System.out.println("Depósito de R$" + valorDeposito + " realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido. Tente novamente.");
        }
    }

    private static void realizarSaque(Scanner scanner) {
        System.out.print("Informe o valor do saque: R$");
        double valorSaque = Double.parseDouble(scanner.nextLine());

        if (valorSaque > 0 && valorSaque <= saldo) {
            saldo -= valorSaque;
            System.out.println("Saque de R$" + valorSaque + " realizado com sucesso!");
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente. Tente novamente.");
        }
    }
}
