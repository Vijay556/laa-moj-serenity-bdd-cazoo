package cazoo.pages;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.NoSuchElementException;
import cazoo.Car;

public class MoreAboutYourCarPage {
    public static Target MAKE_MODEL = Target.the("Make and model details").locatedBy("//p[contains(text(),'Make/model')]");

    public static Car getCarMakeModel(Car car, Actor actor) {
        String makeModel;
        try {
            makeModel = MAKE_MODEL.resolveFor(actor).getText().split("Make/model:\s")[1];
        } catch (ArrayIndexOutOfBoundsException | NoSuchElementException ignored) {
            return car;
        }
        car.setMake(makeModel.split("\s", 2)[0]);
        car.setModel(makeModel.split("\s", 2)[1]);
        return car;
    }
}
