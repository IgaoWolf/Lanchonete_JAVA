package Classes;


import java.util.ArrayList;
import java.util.Scanner;

public class CupomFiscal {


    private String nomeCliente;
    private double taxaDeServico;
    private ArrayList<Alimento> itensConsumidos;

    public CupomFiscal() {
        itensConsumidos = new ArrayList<>();
    }

    public CupomFiscal(String nomeCliente, double taxaDeServico, ArrayList<Alimento> itensConsumidos) {
        this.nomeCliente = nomeCliente;
        this.taxaDeServico = taxaDeServico;
        this.itensConsumidos = itensConsumidos;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getTaxaDeServico() {
        return taxaDeServico;
    }

    public void setTaxaDeServico(double taxaDeServico) {
        this.taxaDeServico = taxaDeServico;
    }

    public ArrayList<Alimento> getItensConsumidos() {
        return itensConsumidos;
    }

    public void setItensConsumidos(ArrayList<Alimento> itensConsumidos) {
        this.itensConsumidos = itensConsumidos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "nomeCliente=" + nomeCliente + ", taxaDeServico=" + taxaDeServico + ", itensConsumidos=" + itensConsumidos + '}';
    }

    public double calcularTaxaDeServico() {
        double somaItens = 0.0;
        for (Alimento p : itensConsumidos) {
            somaItens += p.getPreco();
        }
        double taxa = somaItens * 0.1;
        return taxa;
    }

    public double calcularTroco() {
        double valorRecebido;
        Scanner sc = new Scanner(System.in);
        valorRecebido = sc.nextDouble();
        double somaItens = 0.0;
        for (Alimento p : itensConsumidos) {
            somaItens += p.getPreco();
        }
        double troco = (valorRecebido - somaItens);
        return troco;
    }

    public void imprimirNotaFiscal() {
        System.out.println("--------Cupom Fiscal---------");
        System.out.println("Itens consumidos:");
        double valorFinal = 0.0;
        for (Alimento p : itensConsumidos) {
            System.out.println(p);
            valorFinal += p.getPreco();
        }
        System.out.println("Nome do cliente: Elenilton");
        System.out.println("A taxa de servio e:" + calcularTaxaDeServico());
        System.out.println("Valor final a pagar:" + valorFinal);
        System.out.println("Valor para gerar troco: " + calcularTroco());

        System.out.println("-----------------------------");
    }

}