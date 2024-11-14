package locadora.fitas;
public class FitaInfantil extends Fita {

    public FitaInfantil(String titulo) {
		super(titulo);
		this.preco = 1.5;
		
	}

	@Override
	public double calcularValorAluguel(int diasAlugada) {
		double valor = 1.5;
		if (diasAlugada > 3) {
			valor += (diasAlugada - 3) * this.preco;
		}
		return valor;
	}
}

