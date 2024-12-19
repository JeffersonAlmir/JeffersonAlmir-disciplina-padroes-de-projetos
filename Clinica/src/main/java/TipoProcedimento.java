

public abstract class TipoProcedimento implements Comparable<TipoProcedimento> {
    private float valorProcedimento;
    private EnumTipoProcedimento tipo;

    
    public TipoProcedimento(float valorProcedimento, EnumTipoProcedimento tipo) {
        this.valorProcedimento = valorProcedimento;
        this.tipo = tipo;
    }


    public float getValorProcedimento() {
        return valorProcedimento;
    }


    public void setValorProcedimento(float valorProcedimento) {
        this.valorProcedimento = valorProcedimento;
    }


    public EnumTipoProcedimento getTipo() {
        return tipo;
    }


    public void setTipo(EnumTipoProcedimento tipo) {
        this.tipo = tipo;
    }

    @Override
    public int compareTo(TipoProcedimento o) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
