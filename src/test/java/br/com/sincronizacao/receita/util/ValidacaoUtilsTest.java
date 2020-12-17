/**
 * 
 */
package br.com.sincronizacao.receita.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author valber.paulino
 *
 */
class ValidacaoUtilsTest {
     
     private static final String LINHA_HEADER = "agencia;conta;saldo;status";
     
     private static final String LINHA_HEADER_FALHA = "cia;conta;saldo;status";
     
     private static final String LINHA_HEADER_NULA = null;
     
     private static final String LINHA_DETAIL = "0101;12225-6;100,00;A";
     
     private static final String LINHA_DETAIL_FALHA = "0101;12225-6;100,00";
     
     private static final String LINHA_DETAIL_NULA = null;

     /**
      * @throws java.lang.Exception
      */
     @BeforeEach
     void setUp() throws Exception {

     }
     
     @Test
     void cabecalhoValidoSucessoTest() {
          
          assertTrue(ValidacaoUtils.cabecalhoValido(LINHA_HEADER));
          
     }
     
     @Test
     void cabecalhoValidoFalhaTest() {
          
          assertFalse(ValidacaoUtils.cabecalhoValido(LINHA_HEADER_FALHA));
          
     }
     
     @Test
     void cabecalhoValidoLinhaNulaTest() {
          
          assertFalse(ValidacaoUtils.cabecalhoValido(LINHA_HEADER_NULA));
          
     }
     
     @Test
     void ehCabecalhoSucessoTest() {
          
          assertTrue(ValidacaoUtils.ehCabecalho(LINHA_HEADER));
          
     }
     
     @Test
     void ehCabecalhoFalhaTest() {
          
          assertFalse(ValidacaoUtils.ehCabecalho(LINHA_HEADER_FALHA));
          
     }
     
     @Test
     void ehCabecalhoLinhaNulaTest() {
          
          assertFalse(ValidacaoUtils.ehCabecalho(LINHA_HEADER_NULA));
          
     }
     
     @Test
     void validaLinhaDetailSucessoTest() {
          
          assertTrue(ValidacaoUtils.validaLinhaDetail(LINHA_DETAIL));
          
     }
     
     @Test
     void validaLinhaDetailFalhaTest() {
          
          assertFalse(ValidacaoUtils.validaLinhaDetail(LINHA_DETAIL_FALHA));
          
     }

     @Test
     void validaLinhaDetailLinhaNulaTest() {

          assertFalse(ValidacaoUtils.validaLinhaDetail(LINHA_DETAIL_NULA));
          
     }

}
