package com.checkr.interviews;

import java.io.IOException;
import java.util.List;



public interface ReaderService {

    public List<String[]> readCsvFile(String caminhoArquivo) throws IOException;
    
} 
