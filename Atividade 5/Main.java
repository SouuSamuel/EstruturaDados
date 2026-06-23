import java.util.Scanner;
import java.util.Stack;

public class Main {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
        System.out.println("Digite a expressao: ");
        String expressao = sc.nextLine();

        if (expressao.equals("###")) {
            break;
        }
        Stack<Character> pilha = new Stack<>();
        boolean valida = true;
    
        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pilha.isEmpty()) {
                    valida = false;
                    break;
                }
                char topo = pilha.pop();
                if ((c == ')' && topo != '(') ||
                    (c == ']' && topo != '[') ||
                    (c == '}' && topo != '{')) {
                    valida = false;
                    break;
                }
            }
        }
        if (valida && pilha.isEmpty()) {
            System.out.println("Expressao ok.");
        } else {
            System.out.println("Expressao invalida.");
        }
    }
    sc.close();
 }   
}