/**
 * 
 */
package br.com.sincronizacao.receita.processamento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.sincronizacao.receita.util.dto.ArquivoEnvioDTO;


/**
 * @author valbercarreiro
 *
 */
public class ImportaArquivoTest {

     private static final String CAMINHO_ARQUIVO = "src\\main\\resources\\arquivo\\arquivo_receita.csv";
     
     private static final String CAMINHO_ARQUIVO_VAZIO = "src\\main\\resources\\arquivo\\arquivo_receita_vazio.csv";
     
     private ImportaArquivo importaArquivo;
     
     /**
      * @throws java.lang.Exception
      */
     @BeforeEach
     void setUp() throws Exception {
          this.importaArquivo = new ImportaArquivo();
     }

     @Test
     void lerArquivoSucessoTest() throws Exception {

          List<ArquivoEnvioDTO> lerArquivo = this.importaArquivo.lerArquivo(CAMINHO_ARQUIVO);
          
          assertEquals(true, !lerArquivo.isEmpty());
          assertEquals(5, lerArquivo.size());
          
     }
     
     @Test
     void lerArquivoVazioTest() throws Exception {
          
          List<ArquivoEnvioDTO> lerArquivo = this.importaArquivo.lerArquivo(CAMINHO_ARQUIVO_VAZIO);
          
          assertEquals(true, lerArquivo.isEmpty());
          assertEquals(0, lerArquivo.size());
          
     }
     
     @Test
     void lerArquivoCaminhoInvalidoTest() throws Exception {

          try {
               this.importaArquivo.lerArquivo(null);
          } catch (NullPointerException ne) {
               assertEquals(true, ne instanceof NullPointerException);
          }
          
          
     }

}
