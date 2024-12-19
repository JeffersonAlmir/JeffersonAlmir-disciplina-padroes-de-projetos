public class Apartamento extends TipoLeito {

    public Apartamento(){
        super(EnumTipoLeito.APARTAMENTO);
    }

    @Override
    public float calcularDiaria(int qtdeDias) {
       if(qtdeDias <= 3){
        return 100.0f * qtdeDias;
       }
       if(qtdeDias <= 8){
        return 90.0f * qtdeDias;
       }
       return 80.0f * qtdeDias;
    }
    
}
