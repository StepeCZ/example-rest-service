package com.stepanek.examplerestservice.service;

import org.springframework.stereotype.Component;

/**
 * @author Pavel Stepanek
 * <p>
 * <p>
 * Default implementation using template method ... and old school approach :-0
 *
 * Individual methods of the algorithm can be overriden in parent class, there are quite a few options.
 * For example:
 * - using Stream API to filter out '7's
 * - using Stream API to convert 8 and 9 to doubles
 * - using non-string based algorithm for counting even digits (division by 10 and modulo)
 * - performing the final division using BigDecimal from some reason etc.
 *
 */

@Component
public class DefaultNumericService implements NumericService {

    @Override
    public final String transformValue(String numCode) {
        return transformValueAlgorithm(numCode);
    }

    private String transformValueAlgorithm(String value) {
        String valueShifted = doShifts(value);
        String valueMultiplied = doMultiplication(valueShifted);
        String valueFiltered = doFilter(valueMultiplied);
        int evenDigitCount = getEvenDigitCount(valueFiltered);
        String result = doDivision(valueFiltered, evenDigitCount);
        return result;
    }

    public String doShifts(String code) {
        char[] result = new char[code.length()];
        for (int i = code.length() - 1; i >= 0; i--) {
            char digit = code.charAt(i);
            int j = i;
            switch (digit) {
                case '0':
                case '1':
                case '2':
                case '3':
                    j = ((i + 1) < code.length()) ? i + 1 : i;
            }
            //wanted to use Character array and test for null but this is better to construct resulting String
            if (result[j] == '\u0000') {
                //free spot
                result[j] = digit;
            } else {
                //occupied - need to swap
                if (j - 1 >= 0) {
                    result[j - 1] = result[j]; //existing one space left
                    result[j] = digit; //shifted to the initially occupied index
                }
            }
        }
        return String.valueOf(result);
    }

    public String doMultiplication(String code) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < code.length(); i++) {
            char digit = code.charAt(i);
            String newValue = String.valueOf(digit);
            switch (digit) {
                case '8':
                    newValue = "16";
                    break;
                case '9':
                    newValue = "18";
                    break;
            }
            result.append(newValue);
        }
        return result.toString();
    }


    public String doFilter(String code) {
        //Below easy one liner but quite complex under the hood.
        //code.replace("7", "");
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < code.length(); i++) {
            char digit = code.charAt(i);
            if (digit != '7') {
                result.append(digit);
            }
        }
        return result.toString();
    }

    public int getEvenDigitCount(String code) {
        int count = 0;
        for (int i = 0; i < code.length(); i++) {
            char digit = code.charAt(i);
            switch (digit) {
                case '0':
                case '2':
                case '4':
                case '6':
                case '8':
                    count++;
                    break;
            }
        }
        return count;
    }

    public String doDivision(String code, int divisor) {
        if(divisor == 0) {
            //what to do here? I could throw exception to indicate bad input but my modified requirements say:
            //do nothing which is equivalent to dividing by 1.
            return code;
        }
        long numValue = Long.parseLong(code);
        long result = numValue / divisor; //standard integer/long division is enough to meet the rounding req.
        return Long.toString(result);
    }

}
