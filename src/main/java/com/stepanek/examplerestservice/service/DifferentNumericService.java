package com.stepanek.examplerestservice.service;

import java.util.stream.Collectors;

/**
 * Implementation re-defining certain methods but not core method which is final.
 * Some Java 8 stuff. Not really necessary here IMO.
 *
 * @author Pavel Stepanek
 */

public class DifferentNumericService extends DefaultNumericService {

    /**
     * Stream based impl. which converts char digit to int and performs the selective multiplication and finally converts back to String and collects to final String result.
     *
     * @param code
     * @return String value after performing multiplication
     */
    @Override
    public String doMultiplication(String code) {
        return code.codePoints().mapToObj(c -> Integer.parseInt(String.valueOf((char) c))).map(i -> (i >= 8 && i <= 9) ? i * 2 : i).map(i -> String.valueOf(i)).collect(Collectors.joining());
    }


    /**
     * Simple Stream based impl. which converts chars to String and filters out the required digit.
     *
     * @param code
     * @return String value after performing filtering
     */
    @Override
    public String doFilter(String code) {
        return code.codePoints().mapToObj(c -> String.valueOf((char) c)).filter((s) -> !s.equals("7")).collect(Collectors.joining());
    }

}
