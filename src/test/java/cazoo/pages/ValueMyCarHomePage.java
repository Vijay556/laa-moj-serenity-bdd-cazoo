package cazoo.pages;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Absence;
import net.serenitybdd.screenplay.targets.Target;

public class ValueMyCarHomePage {
    public static Target SEARCH_FIELD = Target.the("vehicle registration field").locatedBy("#vrm");
    public static Target GET_STARTED_BUTTON = Target.the("Get Started Button").locatedBy("//button//span[text()='Get started']");
    public static Target ACCEPT_COOKIES_BUTTON = Target.the("Cookie Accept All button").locatedBy("//button//span[text()='Accept All']");
    public static Target CAR_FOUND = Target.the("Car make model").locatedBy("h1[class*='MakeAndModel']");

    public static boolean carNotFound(String reg, Actor actor) {
        return Absence.of(CAR_FOUND).answeredBy(actor);
    }
}
