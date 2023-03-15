package ai.lentra.controller;

import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Controller
public class ValidationController {

    public static boolean checkMobile(Integer number){
        Pattern p = Pattern.compile("^\\d{10}$");
        //new BigDecimal("0.03")

        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression for which
        // object of Matcher class is created
        Matcher m = p.matcher(number.toString());
        // Returning boolean value
        return (m.matches());
    }

    public int checkPresicion(BigDecimal currency) {
        BigDecimal noZero = currency.stripTrailingZeros();

        int scale = noZero.scale();
        int precision = noZero.precision();
        if (scale < 0) { // Adjust for negative scale
            precision -= scale;
            scale = 0;
        }
        return precision;
    }

    public  boolean checkCurrency(BigDecimal currency) {
//        /^[1-9][0-9]{9,14}$/
//        /^[1-9][0-9]{9,14}$/

        System.out.println("CURRENCY : "+currency.toString());

        if (checkPresicion(currency)<0 || checkPresicion(currency)>13 || currency.signum()==-1)
        {
            return false;
        }
//        if (currency.toString().length() <0 || currency.toString().length()>13 )
//        {
//            return false;
//        }
        return true;
    }


    public static boolean isBigDecimal(String in) {
        try{
//            Integer.parseInt(in);
            BigDecimal.valueOf(Long.parseLong(in));
            // log something useful here
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }


}
