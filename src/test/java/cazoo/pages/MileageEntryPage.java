package cazoo.pages;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MileageEntryPage {
    public static Target MILEAGE_FIELD = Target.the("Mileage Entry Page").located(By.name("mileage"));
    public static Target GET_ESTIMATE_BUTTON = Target.the("Get Estimate button").locatedBy("//button//span[text()='Get my estimate']");
    public static Target ERROR_GETTING_ESTIMATION = Target.the("Unable to Retrieve estimations now").locatedBy("div[class*='SubmitErrorAlertContainer']");

    public static boolean unableToRetrieveEstimationsAtThisMoment(Actor actor) {
        return Presence.of(ERROR_GETTING_ESTIMATION).answeredBy(actor);
    }
}
