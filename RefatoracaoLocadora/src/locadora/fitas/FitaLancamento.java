package locadora.fitas;
public class FitaLancamento extends Fita {

    public FitaLancamento(String titulo) {
		super(titulo);
		this.preco = 3.0;
	}

	@Override
	public double calcularValorAluguel(int diasAlugada) {
		return diasAlugada * this.preco;
	}
	@Override
	public int calcularPontosFidelidade(int diasAlugada) {
		if(diasAlugada > 1) {
			return  2;
		} else {
			return  1;
		}
	}
}
