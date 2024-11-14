package locadora;
import locadora.fitas.Fita;
import locadora.fitas.FitaNormal;
import locadora.fitas.FitaInfantil;
import locadora.fitas.FitaLancamento;


public class Locadora {
	public static void main(String[] args) {
		
		Cliente c1= new Cliente("jefferson");
		Fita fita1 = new FitaNormal("O Exorcista ");
		Fita fita2 = new FitaNormal("Men in Black ");
		Fita fita3 = new FitaLancamento("Jurassic Park III ");
		Fita fita4 = new FitaLancamento("Planeta dos Macacos ");
		Fita fita5 = new FitaInfantil("Pateta no Planeta dos Macacos ");
		Fita fita6 = new FitaInfantil("O Rei Leao ");
		c1.adicionaAluguel(new Aluguel(fita1,3));
		c1.adicionaAluguel(new Aluguel(fita2,2));
		c1.adicionaAluguel(new Aluguel(fita3,3));
		c1.adicionaAluguel(new Aluguel(fita4,4));
		c1.adicionaAluguel(new Aluguel(fita5,10));
		c1.adicionaAluguel(new Aluguel(fita6,30));
		SistemaExtrato ext = new SistemaExtrato(c1);
		System.out.println(ext.extrato());
		;
	}
}



