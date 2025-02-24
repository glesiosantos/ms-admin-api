package br.com.ohgestor.msadmin.api.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class GeradorUtils {
    public static String geradorSenhaAleatorias(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes).substring(0,length);
    }
}
