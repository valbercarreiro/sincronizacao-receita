/**
 * 
 */
package br.com.sincronizacao.receita.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author valbercarreiro
 *
 */
@Getter
@AllArgsConstructor
public enum RetornoReceita {

     SUCESSO("Sucesso"),
     FALHA("Falha");
     
     private final String descricao;

}
