package cazoo.navigation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import cazoo.Car;
import cazoo.pages.MileageEntryPage;
import cazoo.pages.ValuationEstimatePage;
import cazoo.pages.ValueMyCarHomePage;

import static cazoo.pages.MileageEntryPage.unableToRetrieveEstimationsAtThisMoment;
import static cazoo.pages.MoreAboutYourCarPage.getCarMakeModel;
import static cazoo.pages.ValueMyCarHomePage.carNotFound;

public class GetVehicleValuationJourney {
    public static Performable findCar(String vrm) {
        return Task.where(
                "{0} attempts to find car for '" + vrm + "'",
                NavigateTo.theCazooValueMyCarPage(),
                Enter.theValue(vrm).into(ValueMyCarHomePage.SEARCH_FIELD),
                Click.on(ValueMyCarHomePage.GET_STARTED_BUTTON)
        );
    }

    public static Performable populateMileage() {
        return Task.where(
                "{0} populates mileage",
                Enter.theValue("50000").into(MileageEntryPage.MILEAGE_FIELD),
                Click.on(MileageEntryPage.GET_ESTIMATE_BUTTON)
        );
    }

    public static Performable navigateToFullValuationPage() {
        return Task.where(
                "{0} navigates to full valuation page",
                Click.on(ValuationEstimatePage.CONTINUE_TO_FULL_VALUATION_PAGE)
        );
    }

    public static Car getCarDetails(Car car, Actor actor, String reg) {
            actor.attemptsTo(findCar(reg));
            if (carNotFound(reg, actor)) {
                return car;
            }
            actor.attemptsTo(populateMileage());
            if (unableToRetrieveEstimationsAtThisMoment(actor)) {
                return car;
            }
            actor.attemptsTo(navigateToFullValuationPage());
            return getCarMakeModel(car, actor);
    }
}
