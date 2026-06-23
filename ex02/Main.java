import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Aluno {
    String ra;
    String disciplina;
    double nota;
    int faltas;

    public Aluno(String ra, String disciplina, double nota, int faltas) {
        this.ra = ra;
        this.disciplina = disciplina;
        this.nota = nota;
        this.faltas = faltas;
    }

    @Override
    public String toString() {
        return ra + " " + disciplina + " " + nota + " " + faltas;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<Aluno> lista = new LinkedList<>();

        // Carregamento da lista
        while (true) {

            String ra = sc.next();

            if (ra.equalsIgnoreCase("XXX")) {
                break;
            }

            String disciplina = sc.next();
            double nota = Double.parseDouble(sc.next());
            int faltas = sc.nextInt();

            lista.add(new Aluno(ra, disciplina, nota, faltas));
        }

        // Impressão original
        System.out.println("Conteudo original da lista");
        System.out.println("--------------------------");

        for (Aluno a : lista) {
            System.out.println(a);
        }

        // Disciplina a remover
        String disciplinaRemover = sc.next();

        // Remoção segura usando Iterator
        Iterator<Aluno> it = lista.iterator();

        while (it.hasNext()) {

            Aluno a = it.next();

            if (a.disciplina.equalsIgnoreCase(disciplinaRemover)) {
                it.remove();
            }
        }

        // Nova lista
        System.out.println("Novo conteudo da lista");
        System.out.println("----------------------");

        for (Aluno a : lista) {
            System.out.println(a);
        }

        sc.close();
    }
}