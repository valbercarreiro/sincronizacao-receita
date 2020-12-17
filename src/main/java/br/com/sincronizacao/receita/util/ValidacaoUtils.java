/**
 * 
 */
package br.com.sincronizacao.receita.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Objects;

/**
 * @author valbercarreiro
 *
 */
public final class ValidacaoUtils {
     
     public static final boolean ehCabecalho(String linha) {
          boolean retorno = false;
          
          if(linha != null) {               
               String[] strLinha = linha.split(";");
               
               if(strLinha.length > 0 && strLinha[0].contains("agencia")) {
                    retorno = true;
               }
          }
          
          return retorno;
     }
     
     public static final boolean cabecalhoValido(String linha) {
          boolean retorno = true;
          
          if(linha == null) {
               return false;
          }
          
          String[] strLinha = linha.split(";");
       
          for (String item : strLinha) {
               if(!"agencia".equals(removerCaracteresEspeciais(item)) && !"conta".equals(removerCaracteresEspeciais(item)) 
                         && !"saldo".equals(removerCaracteresEspeciais(item)) && !"status".equals(removerCaracteresEspeciais(item))) {
                  retorno = false;
                  break;
             }
          }
       
          return retorno;
     }
     
     public static final boolean validaLinhaDetail(String linha) {
          return (linha != null && linha.split(";").length == 4) ? true : false;
     }
     
     public static final String removerCaracteresEspeciais(String texto) {
          if(Objects.nonNull(texto)) {
               texto = texto.replaceAll("[^a-zA-Z0-9 ]+","");
               return texto.trim().replaceAll("\\s+", " ");
          }
          return texto;
     }
     
     public static final double formataValorDouble(String valor) {
          
          String formatUS = "###,##0.00";
          NumberFormat formatter = new DecimalFormat( formatUS );
          double doubleValue = 0;
          try {
               doubleValue = formatter.parse( "3200,50" ).doubleValue();
          } catch (ParseException e) {
               e.printStackTrace();
          }
          
          return doubleValue;
     }
 }