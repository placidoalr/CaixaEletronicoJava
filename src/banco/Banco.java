package banco;

import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("BEM VINDO AO BANCO INPERIONT!");
        System.out.println(" ");
        System.out.println(" ");
        Conta contaCorrente = new ContaCorrente();
        Conta contaPoupanca = new ContaPoupanca();
        Conta contaSalario = new ContaSalario();
        while (true) {
            System.out.println("1- Conta corrente!");
            System.out.println("2- Conta poupança!");
            System.out.println("3- Conta salário!");
            String banco = in.next();

            if (banco.equals("1")) {
                while (true) {
                    System.out.println("CONTA CORRENTE");
                    System.out.println("1- Ver extrato!");
                    System.out.println("2- Depositar!");
                    System.out.println("3- Sacar!");
                    System.out.println("4- Voltar!");

                    String acao = in.next();

                    if (acao.equals("1")) {//ver extrato
                        contaCorrente.verExtrato();
                    } else if (acao.equals("2")) {
                        if (contaCorrente instanceof Depositavel) { //instanceof para pegar a interface "Depositavel"
                            Depositavel d = (Depositavel) contaCorrente;
                            d.depositar();
                        }
                    } else if (acao.equals("3")) {
                        contaCorrente.sacar();
                    } else if (acao.equals("4")) {
                        break;
                    } else {
                        System.out.println("Opção não encontrada, tente novamente!");
                    }
                }

            } else if (banco.equals("2")) {//opçoes da poupança
                while (true) {
                    System.out.println("CONTA POUPANÇA");
                    System.out.println("1- Ver extrato!");
                    System.out.println("2- Depositar!");
                    System.out.println("3- Sacar!");
                    System.out.println("4- Voltar!");

                    String acao = in.next();
                    if (acao.equals("1")) {//ver extrato
                        contaPoupanca.verExtrato();
                    } else if (acao.equals("2")) {
                        if (contaPoupanca instanceof Depositavel) {
                            Depositavel d = (Depositavel) contaPoupanca;
                            d.depositar();
                        }
                    } else if (acao.equals("3")) {
                        contaPoupanca.sacar();
                    } else if (acao.equals("4")) {
                        break;
                    } else {
                        System.out.println("Opção não encontrada, tente novamente!");
                    }
                }
            } else if (banco.equals("3")) {//opçoes da salario
                while (true) {
                    System.out.println("CONTA SALÁRIO");
                    System.out.println("1- Ver extrato!");
                    System.out.println("2- Sacar!");
                    System.out.println("3- Voltar!");
                    String acao = in.next();
                    if (acao.equals("1")) {//ver extrato
                        contaSalario.verExtrato();
                    } else if (acao.equals("2")) {
                        contaSalario.sacar();
                    } else if (acao.equals("3")) {
                        break;
                    } else {
                        System.out.println("Opção não encontrada, tente novamente!");
                    }
                }
            } else {//Error
                System.out.println("Opção não encontrada, tente novamente!");
            }

        }

    }
}
