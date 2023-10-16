/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;
import java.util.Scanner;

/**
 *
 * @author ALDRIN
 */


class ContaBancaria {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public ContaBancaria(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso.");
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }

    public String toString() {
        return "Cliente: " + nome + " " + sobrenome + " | CPF: " + cpf + " | Saldo: R$" + saldo;
    }
}



public class GerenciaBanco {

    public static void main(String[] args) {
    
     Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao gerenciamento bancário!");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Informe seu CPF: ");
        String cpf = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);
       
        
        int opcao = 0;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Realizar saque");
            System.out.println("4. Encerrar");
            System.out.print("Opção escolhida: ");
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo atual: R$" + conta.consultarSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor a ser depositado: R$");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor a ser sacado: R$");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    System.out.println("Encerrando a aplicação.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            scanner.nextLine();  // Limpar o buffer do scanner
        }while(opcao != 4);
    
    }
}


