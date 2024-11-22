package locadora;
import locadora.fitas.FitaNormal;
import RefatoracaoLocadora.Livro;
import locadora.fitas.FitaInfantil;
import locadora.fitas.FitaLancamento;


public class Locadora {
	public static void main(String[] args) {
		
		Cliente c1= new Cliente("jefferson");
		Alugaveis fita1 = new FitaNormal("O Exorcista ");
		Alugaveis fita2 = new FitaNormal("Men in Black ");
		Alugaveis fita3 = new FitaLancamento("Jurassic Park III ");
		Alugaveis fita4 = new FitaLancamento("Planeta dos Macacos ");
		Alugaveis fita5 = new FitaInfantil("Pateta no Planeta dos Macacos ");
		Alugaveis fita6 = new FitaInfantil("O Rei Leao ");
		Alugaveis livro = new Livro("Ariano Suasuna", "Auto da Compadecida");
		c1.adicionaAluguel(new Aluguel(fita1,3));
		c1.adicionaAluguel(new Aluguel(fita2,2));
		c1.adicionaAluguel(new Aluguel(fita3,3));
		c1.adicionaAluguel(new Aluguel(fita4,4));
		c1.adicionaAluguel(new Aluguel(fita5,10));
		c1.adicionaAluguel(new Aluguel(fita6,30));
		c1.adicionaAluguel(new Aluguel(livro,15) );
			
		
		SistemaExtrato ext = new SistemaExtrato(c1);
		System.out.println(ext.extrato());
		;
	}
}



