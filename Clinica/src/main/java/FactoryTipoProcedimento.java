

import java.util.HashMap;
import java.util.Map;

public class FactoryTipoProcedimento {

    Map<String,TipoProcedimento> factoryProcedimento;
    public FactoryTipoProcedimento(){
        this.factoryProcedimento = new HashMap<>();
        factoryProcedimento.put("basico", new Basico());
        factoryProcedimento.put("comum", new Comum());
        factoryProcedimento.put("avancado", new Avancado());
    }
    
    public TipoProcedimento criaProcedimento(String nome){
        String key = nome.toLowerCase();
        return factoryProcedimento.get(key);
    }
}
