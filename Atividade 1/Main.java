//Samuel Jesus Gonzaga do Nascimento - 0031432612026
//Samuel Henrique Lara - 0031432612038

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");

        ArrayList<Municipio> lista = new ArrayList<>();

        while (sc.hasNextLine()) {
            String linha = sc.nextLine().trim();

            if (linha.equals("XXX")) {
                break;
            }

            String[] partes = linha.split(" ");
            int n = partes.length;

            double idh = Double.parseDouble(partes[n - 1]);
            double area = Double.parseDouble(partes[n - 2]);
            int populacao = Integer.parseInt(partes[n - 3]);

            String nome = partes[0];
            for (int i = 1; i <= n - 4; i++) {
                nome = nome + " " + partes[i];
            }

            lista.add(new Municipio(nome, populacao, area, idh));
        }

        System.out.println("Todos os municipios");
        System.out.println("-------------------");
        for (Municipio m : lista) {
            System.out.println(m);
        }
        System.out.println();

        if (sc.hasNext()) {
            double idhFiltro = Double.parseDouble(sc.nextLine().trim());

            System.out.println("Municipios IDH <= " + idhFiltro);
            System.out.println("----------------------");
            for (Municipio m : lista) {
                if (m.idh <= idhFiltro) {
                    System.out.println(m);
                }
            }
        }

        sc.close();
    }
}