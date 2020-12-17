/**
 * 
 */
package br.com.sincronizacao.receita.processamento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.sincronizacao.receita.util.EntityGenericUtil;
import br.com.sincronizacao.receita.util.dto.ArquivoEnvioDTO;
import br.com.sincronizacao.receita.util.dto.ArquivoRespostaDTO;


/**
 * @author valbercarreiro
 *
 */
public class EnviaReceitaTest {
     
     private EnviaReceita enviaReceita;
     
     private List<ArquivoEnvioDTO> arquivoEnvio;

     /**
      * @throws java.lang.Exception
      */
     @BeforeEach
     public void setUp() throws Exception {
          this.enviaReceita = new EnviaReceita();
          
          arquivoEnvio = new ArrayList<ArquivoEnvioDTO>();
          for(int i=0; i<5; i++) {
               ArquivoEnvioDTO arq = new ArquivoEnvioDTO(EntityGenericUtil.getInteger().toString(), EntityGenericUtil.getInteger().toString(), EntityGenericUtil.getDouble().toString(), EntityGenericUtil.getString());
               arquivoEnvio.add(arq);
          }
     }
     
     @Test
     public void enviaDadosReceitaSucessoTest() {
          List<ArquivoRespostaDTO> enviaDadosReceita = this.enviaReceita.enviaDadosReceita(this.arquivoEnvio);
          
          assertEquals(true, !enviaDadosReceita.isEmpty());
          assertEquals(5, enviaDadosReceita.size());
     }

     @Test
     public void enviaDadosReceitaArquivoVazioTest() {
          this.arquivoEnvio = new ArrayList<ArquivoEnvioDTO>();
          List<ArquivoRespostaDTO> enviaDadosReceita = this.enviaReceita.enviaDadosReceita(this.arquivoEnvio);
          
          assertEquals(true, enviaDadosReceita.isEmpty());
          assertEquals(0, enviaDadosReceita.size());
     }

}
