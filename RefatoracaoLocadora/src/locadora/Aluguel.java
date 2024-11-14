package locadora;
import locadora.fitas.Fita;

public class Aluguel {
	private Fita fita;
	private int diasAlugada;
	
	
	public Aluguel(Fita fita, int diasAlugada) {
		this.fita = fita;
		this.diasAlugada = diasAlugada;
	}
	public Fita getFita() {
		return fita;
	}
	public int getDiasAlugada() {
		return diasAlugada;
	}
	public String getTitutoFita() {
		return fita.getTitulo();
		}
	
	public double valorAluguel() {
		return fita.calcularValorAluguel(diasAlugada);
	}
	
	public int pontosFidelidade() {
		return fita.calcularPontosFidelidade(diasAlugada);
	}
}
