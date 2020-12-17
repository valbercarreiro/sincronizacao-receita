/**
 * 
 */
package br.com.sincronizacao.receita.util.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author valbercarreiro
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "agencia", "conta" }, callSuper = false )
@ToString(of = { "agencia", "conta", "saldo", "status" })
public class ArquivoRespostaDTO {

     private String agencia;
     
     private String conta;
     
     private String saldo;     
     
     private String status;
     
     private String resultado;
     
     public static ArquivoRespostaDTO montaRespostaDto(ArquivoEnvioDTO arqEnvio) {
          return new ArquivoRespostaDTO(arqEnvio.getAgencia(), arqEnvio.getConta(), arqEnvio.getSaldo(), arqEnvio.getStatus(), null);
     }
}
