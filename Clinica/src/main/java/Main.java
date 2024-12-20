import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Prontuario prontuario = new Prontuario(null);
        FileService service = new CsvProntuarioService(prontuario);
        String path1 = "src/test/resources/prontuario_exportado_sem_procedimentos.csv";
        String path2 = "src/test/resources/prontuario_exportado_sem_internacao.csv";
        String path3 = "src/test/resources/prontuario_exportado_completo.csv";

        service.carregarProntuario(path3);
        service.carregarProntuario(path2);
        service.carregarProntuario(path1);
       
        

    }
}
