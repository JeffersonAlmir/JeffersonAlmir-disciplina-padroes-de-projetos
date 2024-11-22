package RefatoracaoLocadora;

import locadora.Alugaveis;

public class Livro implements Alugaveis {

    private String titulo;
    private String autor;
    private double preco;
    public Livro(String autor, String titulo){
        this.autor = autor;
        this.titulo = titulo;
        this.preco = 3.0;
    }

    @Override
    public double calcularValorAluguel(int diasAlugada) {
        return preco*diasAlugada;
    }

    @Override
    public String getDescricao() {
       return titulo;
    }

    @Override
    public int calcularPontosFidelidade(int diasAlugada) {
        int ponto;
        if(diasAlugada>5){
            ponto =2; 
        }else {
            ponto = 1;
        }
        return ponto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    public void aumentarPrecoProduto(double preco) {
        this.preco = preco;
    }
    
    
}
