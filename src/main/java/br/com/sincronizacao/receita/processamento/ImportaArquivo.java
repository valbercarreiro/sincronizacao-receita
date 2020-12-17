/**
 * 
 */
package br.com.sincronizacao.receita.processamento;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.sincronizacao.receita.util.ValidacaoUtils;
import br.com.sincronizacao.receita.util.dto.ArquivoEnvioDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author valbercarreiro
 *
 */
@Slf4j
@Data
public class ImportaArquivo {
     
     private int countAux;

     public List<ArquivoEnvioDTO> lerArquivo(String caminho) throws Exception {
          
          List<ArquivoEnvioDTO> resultado = new ArrayList<ArquivoEnvioDTO>();
          
          File arquivoProcessando = null;
          FileReader fileReader = null;
          LineNumberReader reader = null;

          try {

               log.info("Iniciando processamento do arquivo: "+caminho);

               arquivoProcessando = new File(caminho);

               fileReader = new FileReader(arquivoProcessando);
               reader = new LineNumberReader(fileReader);

               String linha = "";
               Boolean validouHeader = false;
               int countLine = 0;

               while ((linha = reader.readLine()) != null) {
                    
                    if(!validouHeader) {
                         if(ValidacaoUtils.ehCabecalho(linha) && ValidacaoUtils.cabecalhoValido(linha)) {
                              validouHeader = true;
                         }
                    } else {
                         resultado.add(montaDTO(linha, countLine));
                    }
                    
                    countLine++;
                    
               }

               if (fileReader != null) {
                    fileReader.close();
               }

               if (reader != null) {
                    reader.close();
               }

          } catch (NullPointerException ne) {
               ne.printStackTrace();
          } catch (Exception e) {
               e.printStackTrace();
               log.info("Erro fatal ao importar arquivo: " + caminho);
               throw new Exception();

          } finally {
               try {

                    if (fileReader != null) {
                         fileReader.close();
                    }

                    if (reader != null) {
                         reader.close();
                    }
               } catch (Exception e) {
                    e.printStackTrace();
               }
          }
          
          return resultado;
     }
     
     private ArquivoEnvioDTO montaDTO(String linha, int count) throws Exception {
          ArquivoEnvioDTO arqDto = new ArquivoEnvioDTO();
          
          if(!ValidacaoUtils.validaLinhaDetail(linha)) {
               log.info("Erro ao processar linha "+count+" do detalhe");
               throw new Exception("Linha detalhe inválida"); 
          }
          
          String[] strLinha = linha.split(";");
          List<String> strList = Arrays.asList(strLinha);
          this.setCountAux(0);
          strList.forEach(str -> {
               switch (this.getCountAux()) {
                    case 0:                         
                         arqDto.setAgencia(str);
                         break;
                    case 1:
                         arqDto.setConta(str);
                         break;
                    case 2:
                         arqDto.setSaldo(str);
                         break;
                    case 3:
                         arqDto.setStatus(str);
                         break;
                    default:
                         break;
               } 
               this.setCountAux(this.getCountAux()+1);;
          });
          
          return arqDto;
     }
}
