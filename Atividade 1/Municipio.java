//Samuel Jesus Gonzaga do Nascimento - 0031432612026
//Samuel Henrique Lara - 0031432612038
public class Municipio {
    
    String nome;
    int populacao;
    double area;
    double idh;

    public Municipio(String nome, int populacao, double area, double idh) {
        this.nome = nome;
        this.populacao = populacao;
        this.area = area;
        this.idh = idh;
    }
    

    public String toString() {
        return nome + " " + populacao + " " + area + " " + idh;
    }
}