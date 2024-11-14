package locadora;
import java.util.*;

public class Cliente  {
	private String nome;
	private Collection<Aluguel> fitasAlugadas = new ArrayList<Aluguel>();
	
	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public Collection<Aluguel> getFitasAlugadas() {
		return fitasAlugadas;
	}
	
	public void adicionaAluguel(Aluguel aluguel) {
		fitasAlugadas.add(aluguel);
	}
	
	
}