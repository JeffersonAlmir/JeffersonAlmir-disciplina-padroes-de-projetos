package locadora;
import java.util.Iterator;

public class SistemaExtrato {	
	private Cliente cliente;
	
	
	
	public SistemaExtrato(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public String extrato() {
		
		final String fimDeLinha = System.getProperty("line.separator");
		double valorTotal = 0.0;
		int pontosDeAlugadorFrequente = 0;
		Iterator alugueis = cliente.getFitasAlugadas().iterator();
		String resultado = "Registro de Alugueis de " + cliente.getNome() + fimDeLinha;
		
		while(alugueis.hasNext()) {
			
			Aluguel fitaAlugada = (Aluguel)alugueis.next();
			valorTotal += fitaAlugada.valorAluguel();
			pontosDeAlugadorFrequente += fitaAlugada.pontosFidelidade();
			// mostra valores para este aluguel
			resultado += "\t" + fitaAlugada.getTitutoFita() + "\t"+ fitaAlugada.valorAluguel() +
			fimDeLinha;
		} // while
		// adiciona rodapé
	
		resultado += "Valor total devido: " + valorTotal + fimDeLinha;
		resultado += "Voce acumulou " + pontosDeAlugadorFrequente +
		" pontos de alugador frequente";
		return resultado;
			
		}
}