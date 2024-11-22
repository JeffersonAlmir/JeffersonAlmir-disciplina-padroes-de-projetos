package locadora.fitas;

import locadora.Alugaveis;

public abstract class Fita implements Alugaveis {

    public String titulo;
	public double preco;
	
	
	public Fita(String titulo) {
		this.titulo = titulo;
		this.preco = 1.5;
	}


	public String getDescricao() {
		return titulo;
	}
	
	public double getPreco() {
		return preco;
	}

	public void aumentarPrecoProduto(double preco) {
        this.preco = preco;
    }

	public abstract double calcularValorAluguel(int diasAlugada);


	public int calcularPontosFidelidade(int diasAlugada) {
		
		return 1;
	}
	

}
