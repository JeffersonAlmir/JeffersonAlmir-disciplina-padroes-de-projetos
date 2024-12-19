public class Internacao {

	private TipoLeito tipoLeito;
	private int qtdeDias;

	public Internacao(TipoLeito tipoLeito, int qtdeDias) {
		this.tipoLeito = tipoLeito;
		this.qtdeDias = qtdeDias;
	}

	public EnumTipoLeito getTipoLeito() {
		return this.tipoLeito.getEnumTipoLeito();
	}

	public int getQtdeDias() {
		return this.qtdeDias;
	}

	public float getCalcularDiaria(){
       
        return  tipoLeito.calcularDiaria(qtdeDias);
    }

}
