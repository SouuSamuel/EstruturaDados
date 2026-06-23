import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<Item> lista = new LinkedList<>();

        while (true) {

            String op = sc.next();

            if (op.equalsIgnoreCase("FIM")) {

                int pendentes = 0;

                for (Item item : lista) {
                    if (!item.comprado) {
                        pendentes++;
                    }
                }

                System.out.println("Fim do programa (" + pendentes + " item sem comprar)");
                break;
            }

            switch (op.toUpperCase()) {

                case "I":

                    String nome = sc.next();
                    double quantidade = sc.nextDouble();

                    Item novo = new Item(nome, quantidade);

                    int pos = 0;

                    while (pos < lista.size() &&
                        lista.get(pos).nome.compareToIgnoreCase(nome) < 0) {
                        pos++;
                    }

                    lista.add(pos, novo);

                    System.out.println("Incluiu " + nome);
                    break;

                case "A":

                    nome = sc.next();

                    for (Item item : lista) {
                        if (item.nome.equalsIgnoreCase(nome)) {
                            item.comprado = true;
                            System.out.println("Comprou " + nome);
                            break;
                        }
                    }

                    break;

                case "X":

                    nome = sc.next();

                    for (int i = 0; i < lista.size(); i++) {

                        if (lista.get(i).nome.equalsIgnoreCase(nome)) {

                            lista.remove(i);

                            System.out.println("Excluiu " + nome);
                            break;
                        }
                    }

                    break;

                case "P":

                    String sentido = sc.next();

                    int comprados = 0;

                    for (Item item : lista) {
                        if (item.comprado) {
                            comprados++;
                        }
                    }

                    if (sentido.equalsIgnoreCase("F")) {

                        System.out.println("Lista de compras (do inicio)");

                        for (Item item : lista) {
                            System.out.println(
                                    item.nome + " " +
                                    item.quantidade + " " +
                                    item.comprado);
                        }

                    } else {

                        System.out.println("Lista de compras (do final)");

                        for (int i = lista.size() - 1; i >= 0; i--) {

                            Item item = lista.get(i);

                            System.out.println(
                                    item.nome + " " +
                                    item.quantidade + " " +
                                    item.comprado);
                        }
                    }

                    System.out.println(
                            "Total itens: " + lista.size() +
                            " Itens comprados: " + comprados);

                    break;
            }
        }

        sc.close();
    }
}