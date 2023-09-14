package cazoo.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationMatcher {
    public static final String regex = "" +
            "([A-Z]{2}[0-9]{2}\s*[A-Z]{3})|" +
            "([A-Z][0-9]{1,3}\s*[A-Z]{3})|" +
            "([A-Z]{3}[0-9]{1,3}[A-Z])|" +
            "([0-9]{1,4}[A-Z]{1,2})|" +
            "([0-9]{1,3}[A-Z]{1,3})|" +
            "([A-Z]{1,2}[0-9]{1,4})|" +
            "([A-Z]{1,3}[0-9]{1,3})|" +
            "([A-Z]{1,3}[0-9]{1,4})|" +
            "([0-9]{3}[DX]{1}[0-9]{3})";

    public List<String> getRegistrationList(String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}
