package banco;

import java.util.Scanner;

public class ContaSalario implements Conta {

    int id;
    double saldo = 1000;
    Scanner in = new Scanner(System.in);

    @Override
    public void verExtrato() {
        System.out.println("Seu extrato é de: R$" + saldo);

    }

    @Override
    public void sacar() {
        System.out.println("Digite o valor que deseja sacar!");
        System.out.print("R$");
        String transformacao;
        transformacao = in.next().replace(".", ",").replaceFirst(",", ".").replaceAll("[^0-9^.]", "");
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
}
