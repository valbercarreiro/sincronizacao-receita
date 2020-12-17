
package br.com.sincronizacao.receita.util;

import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;


public class EntityGenericUtil {
     
     public static Integer getInteger() {

          return getInteger(0, 999999);
     }
     
     public static Integer getInteger(Integer start, Integer end) {

          return RandomUtils.nextInt(start, end);
          
     }

     public static Double getDouble() {

          return RandomUtils.nextDouble();
     }

     public static String getString() {

          return UUID.randomUUID().toString().replace("-", "");
     }

     public static Boolean getBoolean() {
          return new Random().nextBoolean();
     }

     public static <T> T getEnum(Class<T> clazz) {

          int length = clazz.getEnumConstants().length;

          int nextInt = new Random().nextInt(length);

          return clazz.getEnumConstants()[nextInt];
     }

     public static Object getByType(Class<?> type) {

          if (type == Integer.class || type == int.class) {

               return getInteger();

          } else if (type == String.class) {

               return getString();

          }

          return null;

     }

}
