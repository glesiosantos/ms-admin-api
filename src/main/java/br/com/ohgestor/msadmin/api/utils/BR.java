package br.com.ohgestor.msadmin.api.utils;

public class BR {
    // CPF
    private static final int[] weightSsn = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

    // CNPJ
    private static final int[] weightTin = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

    private static int calculate(final String str, final int[] weight) {
        int sum = 0;
        for (int i = str.length() - 1, digit; i >= 0; i--) {
            digit = Integer.parseInt(str.substring(i, i + 1));
            sum += digit * weight[weight.length - str.length() + i];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

    private static String limparFormatacao(String documento) {
        if (documento == null) return null;
        return documento.replaceAll("[\\.\\-/]", "").trim();
    }

    /**
     * Valida CPF
     *
     * @param ssn
     * @return
     */
    public static boolean isValidCPF(final String ssn) {
        String cleanedSsn = limparFormatacao(ssn);
        if ((cleanedSsn == null) || (cleanedSsn.length() != 11) || cleanedSsn.matches(cleanedSsn.charAt(0) + "{11}"))
            return false;

        final Integer digit1 = calculate(cleanedSsn.substring(0, 9), weightSsn);
        final Integer digit2 = calculate(cleanedSsn.substring(0, 9) + digit1, weightSsn);
        return cleanedSsn.equals(cleanedSsn.substring(0, 9) + digit1.toString() + digit2.toString());
    }

    /**
     * Valida CNPJ
     *
     * @param tin
     * @return
     */
    public static boolean isValidCNPJ(final String tin) {
        String cleanedTin = limparFormatacao(tin);
        if ((cleanedTin == null) || (cleanedTin.length() != 14) || cleanedTin.matches(cleanedTin.charAt(0) + "{14}"))
            return false;

        final Integer digit1 = calculate(cleanedTin.substring(0, 12), weightTin);
        final Integer digit2 = calculate(cleanedTin.substring(0, 12) + digit1, weightTin);
        return cleanedTin.equals(cleanedTin.substring(0, 12) + digit1.toString() + digit2.toString());
    }
}