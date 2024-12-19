public class Enfermaria extends TipoLeito {
    public Enfermaria(){
        super(EnumTipoLeito.ENFERMARIA);
    }
    
    @Override
    public float calcularDiaria(int qtdeDias) {
        if(qtdeDias <= 3){
            return 40.0f * qtdeDias;
        }
        if(qtdeDias <= 8){
            return 35.0f * qtdeDias;
        }
        return 30.0f * qtdeDias;
    }            
}
