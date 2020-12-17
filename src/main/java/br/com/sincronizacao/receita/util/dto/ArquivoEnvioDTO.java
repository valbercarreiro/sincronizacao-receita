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
public class ArquivoEnvioDTO {

     private String agencia;
     
     private String conta;
     
     private String saldo;     
     
     private String status;
     
}
