package locadora;

public class Aluguel {
	private Alugaveis fita;
	private int diasAlugada;
	
	
	public Aluguel(Alugaveis fita, int diasAlugada) {
		this.fita = fita;
		this.diasAlugada = diasAlugada;
	}
	public Alugaveis getFita() {
		return fita;
	}
	public int getDiasAlugada() {
		return diasAlugada;
	}
	public String getTitutoFita() {
		return fita.getDescricao();
		}
	
	public double valorAluguel() {
		return fita.calcularValorAluguel(diasAlugada);
	}
	
	public int pontosFidelidade() {
		return fita.calcularPontosFidelidade(diasAlugada);
	}
}
