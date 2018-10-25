package banco;

import java.util.Scanner;

public class ContaPoupanca implements Conta, Depositavel {

    int id;
    double saldo = 1000;
    Scanner in = new Scanner(System.in);

    @Override
    public void verExtrato() {
        saldo += (saldo / 100);
        System.out.println("Seu extrato é de: R$" + saldo);
    }

    @Override
    public void sacar() {
        System.out.println("Digite o valor que deseja sacar!");
        System.out.print("R$");
        String transformacao = in.next().replace(".", ",").replaceFirst(",", ".").replaceAll("[^0-9^.]", "");
        //primeiro replace transformando todos os pontos em virgula para conseguir fazer o segundo replace de forma lógica
        //segundo replace como replaceFirst para que ele consiga sacar o valor porque todas as "," virgula foram transformadas em  um unico ponto"." ponto
        //terceiro replace para somente aceitar numeros e "." 
        if (transformacao.equals("")) {
            System.out.println("Impossível sacar um valor nulo!");
        } else {
            double saque = Double.parseDouble(transformacao);
            if (saldo - saque >= 0) {
                while (true) {

                    System.out.println("Deseja realmente sacar o valor de R$" + saque + "?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    String sacar = in.next();
                    if (sacar.equals("1")) {
                        saldo -= saque;
                        System.out.println("Saque de: R$" + saque + " efetuado com sucesso!");
                        break;
                    } else if (sacar.equals("2")) {
                        System.out.println("Saque cancelado com sucesso!");
                        break;
                    } else {
                        System.out.println("Digito inválido!");
                    }
                }

            } else {
                System.out.println("Saldo insuficiente!");
            }
        }
    }

    @Override
    public void depositar() {
        System.out.println("Digite o valor que deseja depositar!");
        System.out.print("R$");
        String transformacao = in.next().replace(".", ",").replaceFirst(",", ".").replaceAll("[^0-9^.]", "");
        //primeiro replace transformando todos os pontos em virgula para conseguir fazer o segundo replace de forma lógica
        //segundo replace como replaceFirst para que ele consiga sacar o valor porque todas as "," virgula foram transformadas em  um unico ponto"." ponto
        //terceiro replace para somente aceitar numeros e "." 
        if (transformacao.equals("")) {
            System.out.println("Impossível depositar um valor nulo!");
        } else {
            double deposito = Double.parseDouble(transformacao);
            while (true) {

                System.out.println("Deseja realmente depositar o valor de R$" + deposito + "?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                String depositar = in.next();
                if (depositar.equals("1")) {
                    saldo += deposito;
                    System.out.println("Deposito de: R$" + deposito + " efetuado com sucesso!");
                    break;
                } else if (depositar.equals("2")) {
                    System.out.println("Deposito cancelado com sucesso!");
                    break;
                } else {
                    System.out.println("Digito inválido!");
                }
            }
        }
    }
}
