import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class ConsolePrinter implements GerenciadorDeImpressao {

    private Prontuario prontuario;
    private Map<EnumTipoProcedimento,Integer> contagemProcedimentos;

    public ConsolePrinter(Prontuario prontuario){
        this.prontuario = prontuario;
        this.contagemProcedimentos = new HashMap<>();
        contagemProcedimentos.put(EnumTipoProcedimento.BASICO, 0);
		contagemProcedimentos.put(EnumTipoProcedimento.COMUM, 0);
		contagemProcedimentos.put(EnumTipoProcedimento.AVANCADO, 0);
		
    }

    @Override
	public String imprimaConta() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		StringBuilder conta = new StringBuilder("----------------------------------------------------------------------------------------------");

		float valorDiarias = 0.0f;

		// Contabilizar as diárias
		if (prontuario.getInternacao() != null) {
			valorDiarias = prontuario.getCalculoDiaria();
		}

		float valorTotalProcedimentos = 0.00f;
		
		//Contabiliza os procedimentos
		for (Procedimento procedimento : prontuario.getProcedimentos()) {
			valorTotalProcedimentos += procedimento.getValorTipoProcedimento();
			
			EnumTipoProcedimento tipo = procedimento.getTipoProcedimento();
			contagemProcedimentos.put(tipo, contagemProcedimentos.get(tipo) + 1);
			
		}
		int qtdeProcedimentosBasicos = contagemProcedimentos.get(EnumTipoProcedimento.BASICO);
		int qtdeProcedimentosComuns = contagemProcedimentos.get(EnumTipoProcedimento.COMUM);
		int qtdeProcedimentosAvancados = contagemProcedimentos.get(EnumTipoProcedimento.AVANCADO);


		conta.append("\nA conta do(a) paciente ");
		conta.append(prontuario.getNomePaciente());
		conta.append(" tem valor total de __ ");
		conta.append(formatter.format(valorDiarias + valorTotalProcedimentos));
		conta.append(" __");
		conta.append("\n\nConforme os detalhes abaixo:");
		
		

		if (prontuario.getInternacao() != null) {
			conta.append("\n\nValor Total Diárias:\t\t\t");
			conta.append(formatter.format(valorDiarias));
			conta.append("\n\t\t\t\t\t");
			conta.append(prontuario.getInternacaoQtdeDias());
			conta.append(" diária");
			conta.append((prontuario.getInternacaoQtdeDias()) > 1 ? "s" : "");
			conta.append(" em ");
			conta.append((prontuario.getIntercaoTipoLeito().equals(EnumTipoLeito.APARTAMENTO)  ? "apartamento" : "enfermaria"));
	
		}

		if (prontuario.getProcedimentos().size() > 0) {
			conta.append("\n\nValor Total Procedimentos:\t\t");
			conta.append(formatter.format(valorTotalProcedimentos));
			
			
			if (qtdeProcedimentosBasicos > 0) {
				conta.append("\n\t\t\t\t\t");
				conta.append(qtdeProcedimentosBasicos);
				conta.append(" procedimento");
				conta.append((qtdeProcedimentosBasicos > 1 ? "s" : ""));
				conta.append(" básico");
				conta.append((qtdeProcedimentosBasicos > 1 ? "s" : ""));	
			}

			if (qtdeProcedimentosComuns > 0) {
				conta.append("\n\t\t\t\t\t");
				conta.append(qtdeProcedimentosComuns);
				conta.append(" procedimento");
				conta.append((qtdeProcedimentosComuns > 1 ? "s" : ""));
				conta.append(" comu");
				conta.append((qtdeProcedimentosComuns > 1 ? "ns" : "m"));	
			}

			if (qtdeProcedimentosAvancados > 0) {
				conta.append("\n\t\t\t\t\t");
				conta.append(qtdeProcedimentosAvancados);
				conta.append(" procedimento");
				conta.append((qtdeProcedimentosBasicos > 1 ? "s" : ""));
				conta.append( " avançado");
				conta.append((qtdeProcedimentosAvancados > 1 ? "s" : ""));	
			}
		}
		conta.append("\n\nVolte sempre, a casa é sua!");
		conta.append("\n----------------------------------------------------------------------------------------------");


		return conta.toString();
	}
}
