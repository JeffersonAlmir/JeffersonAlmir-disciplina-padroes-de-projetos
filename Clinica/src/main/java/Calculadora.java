import java.util.HashMap;
import java.util.Map;

public class Calculadora {

    public Map<String,Number> calcularValores(Prontuario prontuario){

        Map<String,Number> valoreMap = new HashMap<>();

		float valorDiarias = 0.0f;
		// Contabilizar as diárias
        if (prontuario.getInternacao() != null) {
			valorDiarias = prontuario.getCalculoDiaria();
		}

		float valorTotalProcedimentos = 0.00f;
		Map<EnumTipoProcedimento,Integer> contagemProcedimentos = new HashMap<>();
		contagemProcedimentos.put(EnumTipoProcedimento.BASICO, 0);
		contagemProcedimentos.put(EnumTipoProcedimento.COMUM, 0);
		contagemProcedimentos.put(EnumTipoProcedimento.AVANCADO, 0);
		
		//Contabiliza os procedimentos
		for (Procedimento procedimento : prontuario.getProcedimentos()) {
			valorTotalProcedimentos += procedimento.getValorTipoProcedimento();
			
			EnumTipoProcedimento tipo = procedimento.getTipoProcedimento();
			contagemProcedimentos.put(tipo, contagemProcedimentos.get(tipo) + 1);
			
		}
		int qtdeProcedimentosBasicos = contagemProcedimentos.get(EnumTipoProcedimento.BASICO);
		int qtdeProcedimentosComuns = contagemProcedimentos.get(EnumTipoProcedimento.COMUM);
		int qtdeProcedimentosAvancados = contagemProcedimentos.get(EnumTipoProcedimento.AVANCADO);
        return null;
    }
}
