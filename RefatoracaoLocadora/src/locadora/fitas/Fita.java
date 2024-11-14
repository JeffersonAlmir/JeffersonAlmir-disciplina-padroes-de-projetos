package locadora.fitas;
public abstract class Fita {

    public String titulo;
	public double preco;
	
	
	public Fita(String titulo) {
		this.titulo = titulo;
		this.preco = 1.5;
	}


	public String getTitulo() {
		return titulo;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	

	public abstract double calcularValorAluguel(int diasAlugada);


	public int calcularPontosFidelidade(int diasAlugada) {
		
		return 1;
	}

}
