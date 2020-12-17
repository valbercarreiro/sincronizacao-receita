/**
 * 
 */
package br.com.sincronizacao.receita.processamento;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.sincronizacao.receita.util.dto.ArquivoRespostaDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author valbercarreiro
 *
 */
@Slf4j
public class MontaArquivoRetorno {
     
     private static final String NOME_ARQUIVO_RETORNO = "./arquivo_retorno_";
     private static final String EXTENSAO_ARQUIVO_RETORNO = ".CSV";

     public String enviaDadosReceita(List<ArquivoRespostaDTO> arquivoRetorno) {
          
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
          String dataFormatada = LocalDateTime.now().format(formatter);
               
          String nomeArquivo = NOME_ARQUIVO_RETORNO + dataFormatada + EXTENSAO_ARQUIVO_RETORNO;
          File arquivoSaida = null;
          BufferedWriter writer = null;
                              
          try {

               log.info("Gerando arquivo " + nomeArquivo);

               arquivoSaida = new File(nomeArquivo);

               writer = new BufferedWriter(new FileWriter(arquivoSaida));
               writer.write("agencia;conta;saldo;status;retornoReceita"+ System.getProperty("line.separator"));

               for (ArquivoRespostaDTO arq : arquivoRetorno) {
                    writer.write(arq.getAgencia() + ";" + arq.getConta() + ";"
                              + arq.getSaldo() + ";" + arq.getStatus() + ";" + arq.getResultado() + ";"
                              + System.getProperty("line.separator"));
               }
               
               writer.close();
               log.info("Arquivo gerado: " + nomeArquivo);

          } catch (Exception e) {
               e.printStackTrace();
               log.info("Erro fatal ao processar arquivo de retorno: " + nomeArquivo);
               throw new RuntimeException();

          } finally {
               try {

                    if (writer != null) {
                         writer.close();
                    }

                    if (writer != null) {
                         writer.close();
                    }
               } catch (Exception e) {
                    e.printStackTrace();
               }
          }
               
          return nomeArquivo;
     }
     
}
