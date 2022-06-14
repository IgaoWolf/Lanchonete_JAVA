package Main;

import Classes.Lanche;
import Classes.CupomFiscal;
import Classes.Pizza;
import Classes.Alimento;
import Classes.Salgado;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static ArrayList<CupomFiscal> cupomFiscals = new ArrayList<>();
    static ArrayList<Alimento> pratosDisponiveis = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        carregarDados();

        int op = 0;

        while (true) {
            System.out.println("----Cartapio do Sabores Deliciosos----\n");
            System.out.println("1 - Fazer pedido\n2 - sair");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    fazerPedido();
                    break;
                case 2:
                    return;
            }
        }
    }


    public static void carregarDados() {
        Pizza p1 = new Pizza("Bolonhesa", "Calabresa", "catupiry","Pizza Calabresa", 50.0, "12/05/2022", 40);
        Pizza p2 = new Pizza("4 queijos", "Brocolis", "cheedar", "Pizza 4 queijos", 30.0, "12/05/2022", 40);
        Pizza p3 = new Pizza("Tomate", "4 queijos", "cheedar", "Pizza Tomate seco", 60.0, "12/05/2022", 40);
        Pizza p4 = new Pizza("Tradicional", "Sabores Deliciosos", "sem borda","Pizza da Casa", 30.0, "12/05/2022", 40);
        Pizza p5 = new Pizza("Importado", "Strogonoff", "catupiry", "Pizza Strogonoff", 40.0, "12/05/2022", 40);
        Pizza p6 = new Pizza("Tomate secos", "Frango", "catupiry", "Pizza Frango", 40.0, "12/05/2022", 40);

        Lanche l1 = new Lanche("Simples", "Salcicha", "Ketshup com mostarda","Cachorro-Quente", 15, "12/05/2022", 300);
        Lanche l2 = new Lanche("Simples", "Hamburguer com bacon", "Apimentado","X-BACON", 8, "12/05/2022", 400);
        Lanche l3 = new Lanche("Integral", "Hamburguer e vegetais", "Tradicional","X-SALADA", 20, "12/05/2022", 400);
        Lanche l4 = new Lanche("S/ pao", "Carne moida", "s/ molho","Kibe", 7, "12/05/2022", 400);

        Salgado s1 = new Salgado("Frango", "Mandioca","Esfira de frango", 5, "12/05/2022", 50);
        Salgado s2 = new Salgado("Calabresa", "Mandioca","Coxinha de calabresa", 6, "12/05/2022", 60);
        Salgado s3 = new Salgado("Carne moida", "Mandioca","Coxinha de carne moída" ,10, "12/05/2022", 70);
        Salgado s4 = new Salgado("Queijo", "Mandioca","Bolinha de Queijo", 5, "12/05/2022", 50);
        Salgado s5 = new Salgado("Salcicha", "Mandioca","Enroladinho de salcicha", 6, "12/05/2022", 60);
        Salgado s6 = new Salgado("Carne seca", "Mandioca","Salgadinho de carne seca" ,10, "12/05/2022", 70);

        pratosDisponiveis.add(p1);
        pratosDisponiveis.add(p2);
        pratosDisponiveis.add(p3);
        pratosDisponiveis.add(p4);
        pratosDisponiveis.add(p5);
        pratosDisponiveis.add(p6);

        pratosDisponiveis.add(l1);
        pratosDisponiveis.add(l2);
        pratosDisponiveis.add(l3);
        pratosDisponiveis.add(l4);

        pratosDisponiveis.add(s1);
        pratosDisponiveis.add(s2);
        pratosDisponiveis.add(s3);
        pratosDisponiveis.add(s4);
        pratosDisponiveis.add(s5);
        pratosDisponiveis.add(s6);

    }

    public static void fazerPedido() {
        CupomFiscal c = new CupomFiscal();


        int op = -1;
        while (true) {
            for (int i = 1; i < pratosDisponiveis.size(); i ++){
                System.out.println(i + "-" + pratosDisponiveis.get(i).getNome());
            }
            System.out.println("Digite 0 para encerrar o pedido");
            op = sc.nextInt();
            if(op != 0 ){
                ArrayList<Alimento> temp = new ArrayList<>();

                temp = c.getItensConsumidos();
                System.out.println(temp);
                temp.add(pratosDisponiveis.get(op));
                c.setItensConsumidos(temp);
            }else{
                break;
            }
        }

        c.imprimirNotaFiscal();

    }

}
