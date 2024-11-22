package locadora;

public interface Alugaveis {

    double calcularValorAluguel(int diasAlugada);

    String getDescricao();

    int calcularPontosFidelidade(int diasAlugada);
    
}
