import java.util.Scanner;

class Item {
    String nome;
    double quantidade;
    boolean comprado;

    public Item(String nome, double quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.comprado = false;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Item[] lista = new Item[50];
        int total = 0;

        while (true) {

            String operacao = sc.next();

            if (operacao.equalsIgnoreCase("FIM")) {

                int pendentes = 0;

                for (int i = 0; i < total; i++) {
                    if (!lista[i].comprado) {
                        pendentes++;
                    }
                }

                System.out.println("Fim do programa (" + pendentes + " item sem comprar)");
                break;
            }

            switch (operacao.toUpperCase()) {

                case "I":

                    String nome = sc.next();
                    double quantidade = sc.nextDouble();

                    if (total >= 50) {
                        System.out.println("Falha ao incluir " + nome + " (lista cheia)");
                        break;
                    }

                    int pos = 0;

                    while (pos < total &&
                        lista[pos].nome.compareToIgnoreCase(nome) < 0) {
                        pos++;
                    }

                    for (int i = total; i > pos; i--) {
                        lista[i] = lista[i - 1];
                    }

                    lista[pos] = new Item(nome, quantidade);
                    total++;

                    System.out.println("Incluiu " + nome);
                    break;

                case "A":

                    nome = sc.next();

                    boolean encontrou = false;

                    for (int i = 0; i < total; i++) {

                        if (lista[i].nome.equalsIgnoreCase(nome)) {

                            lista[i].comprado = true;
                            encontrou = true;

                            System.out.println("Comprou " + nome);
                            break;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Produto nao encontrado");
                    }

                    break;

                case "X":

                    nome = sc.next();

                    int indice = -1;

                    for (int i = 0; i < total; i++) {

                        if (lista[i].nome.equalsIgnoreCase(nome)) {
                            indice = i;
                            break;
                        }
                    }

                    if (indice == -1) {
                        System.out.println("Produto nao encontrado");
                    } else {

                        for (int i = indice; i < total - 1; i++) {
                            lista[i] = lista[i + 1];
                        }

                        lista[total - 1] = null;
                        total--;

                        System.out.println("Excluiu " + nome);
                    }

                    break;

                case "P":

                    String sentido = sc.next();

                    int comprados = 0;

                    for (int i = 0; i < total; i++) {
                        if (lista[i].comprado) {
                            comprados++;
                        }
                    }

                    if (sentido.equalsIgnoreCase("F")) {

                        System.out.println("Lista de compras (do inicio)");

                        for (int i = 0; i < total; i++) {

                            System.out.println(
                                    lista[i].nome + " " +
                                    lista[i].quantidade + " " +
                                    lista[i].comprado);
                        }

                    } else {

                        System.out.println("Lista de compras (do final)");

                        for (int i = total - 1; i >= 0; i--) {

                            System.out.println(
                                    lista[i].nome + " " +
                                    lista[i].quantidade + " " +
                                    lista[i].comprado);
                        }
                    }

                    System.out.println(
                            "Total itens: " + total +
                            " Itens comprados: " + comprados);

                    break;

                default:
                    System.out.println("Operacao invalida");
            }
        }

        sc.close();
    }
}