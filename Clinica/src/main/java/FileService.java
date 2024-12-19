import java.io.IOException;

public interface FileService {

    String salvarProntuario() throws IOException;
    Prontuario carregarProntuario(String arquivo) throws IOException;
    String imprimaConta();
} 
