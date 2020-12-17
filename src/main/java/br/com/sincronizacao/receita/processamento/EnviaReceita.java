/**
 * 
 */
package br.com.sincronizacao.receita.processamento;

import java.util.ArrayList;
import java.util.List;

import br.com.sincronizacao.receita.comunicacao.ReceitaService;
import br.com.sincronizacao.receita.util.RetornoReceita;
import br.com.sincronizacao.receita.util.ValidacaoUtils;
import br.com.sincronizacao.receita.util.dto.ArquivoEnvioDTO;
import br.com.sincronizacao.receita.util.dto.ArquivoRespostaDTO;

/**
 * @author valbercarreiro
 *
 */
public class EnviaReceita {
     
     private ReceitaService receitaService;
     
     public EnviaReceita() {
          this.receitaService = new ReceitaService();
     }

     public List<ArquivoRespostaDTO> enviaDadosReceita(List<ArquivoEnvioDTO> arquivoEnvio) {
          List<ArquivoRespostaDTO> retorno = new ArrayList<ArquivoRespostaDTO>();
          
          arquivoEnvio.forEach(arq -> {
               ArquivoRespostaDTO arqRetorno = ArquivoRespostaDTO.montaRespostaDto(arq);
               try {
                    receitaService.atualizarConta(arq.getAgencia(), 
                                                  arq.getConta(), 
                                                  ValidacaoUtils.formataValorDouble(arq.getSaldo()), arq.getStatus());
                                                  arqRetorno.setResultado(RetornoReceita.SUCESSO.getDescricao());
               } catch (RuntimeException | InterruptedException e) {
                    arqRetorno.setResultado(RetornoReceita.FALHA.getDescricao());
                    e.printStackTrace();
               }
               retorno.add(arqRetorno);
          });
          
          return retorno;
     }
}
