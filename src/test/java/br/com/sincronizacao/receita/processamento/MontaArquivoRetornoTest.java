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
import br.com.sincronizacao.receita.util.RetornoReceita;
import br.com.sincronizacao.receita.util.dto.ArquivoRespostaDTO;


/**
 * @author valbercarreiro
 *
 */
class MontaArquivoRetornoTest {
     
     private MontaArquivoRetorno montaArquivoRetorno;
     
     private List<ArquivoRespostaDTO> arquivoRetorno;
     
     /**
      * @throws java.lang.Exception
      */
     @BeforeEach
     void setUp() throws Exception {
          this.montaArquivoRetorno = new MontaArquivoRetorno();
          
          this.arquivoRetorno = new ArrayList<ArquivoRespostaDTO>();
          for(int i=0; i<5; i++) {
               ArquivoRespostaDTO arq = new ArquivoRespostaDTO(EntityGenericUtil.getInteger().toString(), 
                                                                 EntityGenericUtil.getInteger().toString(), 
                                                                 EntityGenericUtil.getDouble().toString(), 
                                                                 EntityGenericUtil.getString(),
                                                                 EntityGenericUtil.getEnum(RetornoReceita.class).getDescricao());
               this.arquivoRetorno.add(arq);
          }
     }
     
     @Test
     void enviaDadosReceitaSucessoTest() {
          
          String nomeArquivoGerado = this.montaArquivoRetorno.enviaDadosReceita(this.arquivoRetorno);
          
          assertEquals(true, nomeArquivoGerado != null);
          
     }

     @Test
     void enviaDadosReceitaListaVaziaTest() {

          this.arquivoRetorno = new ArrayList<ArquivoRespostaDTO>();
          String nomeArquivoGerado = this.montaArquivoRetorno.enviaDadosReceita(this.arquivoRetorno);
          System.out.println(nomeArquivoGerado);
          assertEquals(true, nomeArquivoGerado != null);
          
     }

}
