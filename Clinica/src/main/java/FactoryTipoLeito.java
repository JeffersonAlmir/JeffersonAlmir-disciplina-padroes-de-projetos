
import java.util.HashMap;
import java.util.Map;

public class FactoryTipoLeito {
    Map<String,TipoLeito> factoryLeito;
    
    public FactoryTipoLeito(){
        this.factoryLeito =  new HashMap<>();
        factoryLeito.put("enfermaria",new Enfermaria());
        factoryLeito.put("apartamento",new Apartamento());
    }
    
    
    public TipoLeito criarLeito(String nome){
       
        String key = nome.toLowerCase();
        return  factoryLeito.get(key);
    } 
}
