package locadora.fitas;
public class FitaNormal extends Fita {
    public FitaNormal(String titulo) {
		super(titulo);
		this.preco = 1.5;
	}

	@Override
	public double calcularValorAluguel(int diasAlugada) {
		double valor = 2;
		if(diasAlugada > 2 ) {
			 valor += (diasAlugada -2) * this.preco;
		}
		return valor;
	}
}
