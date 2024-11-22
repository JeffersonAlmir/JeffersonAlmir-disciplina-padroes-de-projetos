package locadora;
;

public class SistemaExtrato {
		
	private Cliente cliente;
	
	
	
	public SistemaExtrato(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public String extrato() {
		
		final String fimDeLinha = System.getProperty("line.separator");
		double valorTotal = 0.0;
		int pontosDeAlugadorFrequente = 0;
		
		StringBuilder resultado = new StringBuilder();
		resultado.append("Registro de Alugueis de ");
		resultado.append( cliente.getNome());
		resultado.append(fimDeLinha);
		
		
		for(Aluguel produtosAlugados: cliente.getFitasAlugadas()) {
			
			valorTotal += produtosAlugados.valorAluguel();
			pontosDeAlugadorFrequente += produtosAlugados.pontosFidelidade();
			// mostra valores para este aluguel
			resultado.append("\t" );
			resultado.append(produtosAlugados.getTitutoFita() );
			resultado.append("\t");
			resultado.append(produtosAlugados.valorAluguel());
			resultado.append(fimDeLinha);
			
		} 
		// adiciona rodapé
	
		resultado.append( "Valor total devido: ");
		resultado.append( valorTotal);
		resultado.append(fimDeLinha);
		resultado.append("Voce acumulou " );
		resultado.append(pontosDeAlugadorFrequente);
		resultado.append(" pontos de alugador frequente");
		return resultado.toString();
			
		}
}