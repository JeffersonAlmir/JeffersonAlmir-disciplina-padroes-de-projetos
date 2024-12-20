import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvProntuarioService implements FileService {

	private Prontuario prontuario;

	public CsvProntuarioService(Prontuario prontuario){
		this.prontuario = prontuario;
	}


    @Override
    public String salvarProntuario() throws IOException {
        List<String> linha = new ArrayList<>();

		linha.add("nome_paciente,tipo_leito,qtde_dias_internacao,tipo_procedimento,qtde_procedimentos");

		StringBuilder l1 = new StringBuilder(prontuario.getNomePaciente() ).append(",") ;

		if (prontuario.getInternacao() != null) {
			l1.append(prontuario.getIntercaoTipoLeito());
			l1.append (",");
			l1.append(prontuario.getInternacaoQtdeDias());
			l1.append(",,");
			
			linha.add(l1.toString());
		}

		if (prontuario.getProcedimentos().size() > 0) {
			Map<EnumTipoProcedimento, Long> procedimentosAgrupados = prontuario.getProcedimentos().stream().collect(
					Collectors.groupingBy(Procedimento::getTipoProcedimento, Collectors.counting()));

			List<EnumTipoProcedimento> procedimentosOrdenados = new ArrayList<>(procedimentosAgrupados.keySet());
			Collections.sort(procedimentosOrdenados);

			for (EnumTipoProcedimento chave : procedimentosOrdenados) {
				StringBuilder l2 = new StringBuilder(prontuario.getNomePaciente());
				l2.append(",,,");
				l2.append(chave + ",");
				l2.append(procedimentosAgrupados.get(chave));
				linha.add(l2.toString());
			}
		}

		if (linha.size() == 1) {
			l1.append(",,,");
			linha.add(l1.toString());
		}

		Path path = Paths.get(prontuario.getNomePaciente().replaceAll(" ", "_").concat(String.valueOf(System.currentTimeMillis())).concat(".csv"));

		Files.write(path, linha);
		
		return path.toString();
    }



    @Override
    public Prontuario carregarProntuario(String arquivoCsv) throws IOException {

		Path path = Paths.get(arquivoCsv);

		Stream<String> linhas = Files.lines(path);
		FactoryTipoProcedimento criarTipoProcedimento = new FactoryTipoProcedimento();
		FactoryTipoLeito criarTipoLeito = new FactoryTipoLeito();

		linhas.skip(1).forEach((str) -> {
			System.out.println(str);
			String[] dados = str.split(",");
			String nomePaciente = dados[0].trim();
			TipoLeito tipoLeito = dados[1] != null && !dados[1].trim().isEmpty() ? criarTipoLeito.criarLeito(dados[1].trim()) : null;
			int qtdeDiasInternacao = dados[2] != null && !dados[2].trim().isEmpty() ? Integer.parseInt(dados[2].trim()) : -1;
			TipoProcedimento tipoProcedimento = dados[3] != null && !dados[3].trim().isEmpty() ? criarTipoProcedimento.criaProcedimento(dados[3].trim()) : null;
			int qtdeProcedimentos = dados.length == 5 && dados[4] != null && !dados[4].trim().isEmpty() ? Integer.parseInt(dados[4].trim()) : -1;
			prontuario.setNomePaciente(nomePaciente);

			if (tipoLeito != null && qtdeDiasInternacao > 0) {
				prontuario.setInternacao(new Internacao(tipoLeito, qtdeDiasInternacao));
					
			}

			if (tipoProcedimento != null && qtdeProcedimentos > 0) {
				while (qtdeProcedimentos > 0) {
					prontuario.addProcedimento(new Procedimento(tipoProcedimento));
					qtdeProcedimentos--;
				}
			}
			
		});

		linhas.close();
		return prontuario;
    }




	// @Override
	// public String imprimaConta() {
	// 	NumberFormat formatter = NumberFormat.getCurrencyInstance();

	// 	StringBuilder conta = new StringBuilder("----------------------------------------------------------------------------------------------");

	// 	float valorDiarias = 0.0f;

	// 	// Contabilizar as diárias
	// 	if (prontuario.getInternacao() != null) {
	// 		valorDiarias = prontuario.getCalculoDiaria();
	// 	}

	// 	float valorTotalProcedimentos = 0.00f;
		
	// 	Map<EnumTipoProcedimento,Integer> contagemProcedimentos = new HashMap<>();
	// 	contagemProcedimentos.put(EnumTipoProcedimento.BASICO, 0);
	// 	contagemProcedimentos.put(EnumTipoProcedimento.COMUM, 0);
	// 	contagemProcedimentos.put(EnumTipoProcedimento.AVANCADO, 0);
		
	// 	//Contabiliza os procedimentos
	// 	for (Procedimento procedimento : prontuario.getProcedimentos()) {
	// 		valorTotalProcedimentos += procedimento.getValorTipoProcedimento();
			
	// 		EnumTipoProcedimento tipo = procedimento.getTipoProcedimento();
	// 		contagemProcedimentos.put(tipo, contagemProcedimentos.get(tipo) + 1);
			
	// 	}
	// 	int qtdeProcedimentosBasicos = contagemProcedimentos.get(EnumTipoProcedimento.BASICO);
	// 	int qtdeProcedimentosComuns = contagemProcedimentos.get(EnumTipoProcedimento.COMUM);
	// 	int qtdeProcedimentosAvancados = contagemProcedimentos.get(EnumTipoProcedimento.AVANCADO);


	// 	conta.append("\nA conta do(a) paciente ");
	// 	conta.append(prontuario.getNomePaciente());
	// 	conta.append(" tem valor total de __ ");
	// 	conta.append(formatter.format(valorDiarias + valorTotalProcedimentos));
	// 	conta.append(" __");
	// 	conta.append("\n\nConforme os detalhes abaixo:");
		
		

	// 	if (prontuario.getInternacao() != null) {
	// 		conta.append("\n\nValor Total Diárias:\t\t\t");
	// 		conta.append(formatter.format(valorDiarias));
	// 		conta.append("\n\t\t\t\t\t");
	// 		conta.append(prontuario.getInternacaoQtdeDias());
	// 		conta.append(" diária");
	// 		conta.append((prontuario.getInternacaoQtdeDias()) > 1 ? "s" : "");
	// 		conta.append(" em ");
	// 		conta.append((prontuario.getIntercaoTipoLeito().equals(EnumTipoLeito.APARTAMENTO)  ? "apartamento" : "enfermaria"));
	
	// 	}

	// 	if (prontuario.getProcedimentos().size() > 0) {
	// 		conta.append("\n\nValor Total Procedimentos:\t\t");
	// 		conta.append(formatter.format(valorTotalProcedimentos));
			
			
	// 		if (qtdeProcedimentosBasicos > 0) {
	// 			conta.append("\n\t\t\t\t\t");
	// 			conta.append(qtdeProcedimentosBasicos);
	// 			conta.append(" procedimento");
	// 			conta.append((qtdeProcedimentosBasicos > 1 ? "s" : ""));
	// 			conta.append(" básico");
	// 			conta.append((qtdeProcedimentosBasicos > 1 ? "s" : ""));	
	// 		}

	// 		if (qtdeProcedimentosComuns > 0) {
	// 			conta.append("\n\t\t\t\t\t");
	// 			conta.append(qtdeProcedimentosComuns);
	// 			conta.append(" procedimento");
	// 			conta.append((qtdeProcedimentosComuns > 1 ? "s" : ""));
	// 			conta.append(" comu");
	// 			conta.append((qtdeProcedimentosComuns > 1 ? "ns" : "m"));	
	// 		}

	// 		if (qtdeProcedimentosAvancados > 0) {
	// 			conta.append("\n\t\t\t\t\t");
	// 			conta.append(qtdeProcedimentosAvancados);
	// 			conta.append(" procedimento");
	// 			conta.append((qtdeProcedimentosBasicos > 1 ? "s" : ""));
	// 			conta.append( " avançado");
	// 			conta.append((qtdeProcedimentosAvancados > 1 ? "s" : ""));	
	// 		}
	// 	}
	// 	conta.append("\n\nVolte sempre, a casa é sua!");
	// 	conta.append("\n----------------------------------------------------------------------------------------------");


	// 	return conta.toString();
	// }
    
}
