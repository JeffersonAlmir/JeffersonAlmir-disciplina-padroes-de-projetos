public class Procedimento {

	private TipoProcedimento tipoProcedimento;

	public Procedimento(TipoProcedimento tipoProcedimento) {
		this.tipoProcedimento = tipoProcedimento;
	}

	public EnumTipoProcedimento getTipoProcedimento() {
		return this.tipoProcedimento.getTipo();
	}

	public float getValorTipoProcedimento(){
		return this.tipoProcedimento.getValorProcedimento();
	}

}
