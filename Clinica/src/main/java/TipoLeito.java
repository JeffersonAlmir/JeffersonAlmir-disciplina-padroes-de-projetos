

public abstract class  TipoLeito {

	public EnumTipoLeito tipoLeito;
	public TipoLeito(EnumTipoLeito tipoLeito){
		this.tipoLeito = tipoLeito;
	}
	
	public abstract float calcularDiaria(int qtdeDias);

	public EnumTipoLeito getEnumTipoLeito(){
		return this.tipoLeito;
	}
}
