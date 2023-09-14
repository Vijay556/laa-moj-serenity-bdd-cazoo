package cazoo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import cazoo.Car;
import cazoo.helpers.RegistrationMatcher;
import cazoo.helpers.TextFileReadWriter;
import cazoo.navigation.NavigateTo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static cazoo.navigation.GetVehicleValuationJourney.getCarDetails;

public class PullVehicleDetailsStepDefinitions {
    private List<String> regListFromInputFile;
    private List<Car> actualCarListMakeModel;


    @Given("{actor} reads car registrations for {string}")
    public void iReadCarRegistrationsFormInputFile(Actor actor, String input_file) {
        String input_file_content = new TextFileReadWriter().read(input_file);
        regListFromInputFile = new RegistrationMatcher().getRegistrationList(input_file_content);
    }

    @When("{actor} query cazoo website for vehicle details")
    public void iQueryCazooWebsiteForVehicleDetailsForTheseRegistrations(Actor actor) {
        actor.wasAbleTo(NavigateTo.theCazooWebsite());
        actualCarListMakeModel = new ArrayList<>();
        for (String reg : regListFromInputFile) {
            Car car = new Car(reg);
            actualCarListMakeModel.add(getCarDetails(car, actor, reg));
        }
    }

    @Then("it should match with the {string} provided")
    public void itShouldMatchWithTheOutputFileProvided(String output_file) {
        List<Car> expectedCarDetails = new TextFileReadWriter().getCarDetails(output_file);
        for (Car expectedCar : expectedCarDetails) {
            for (Car actualCar : actualCarListMakeModel) {
                if (expectedCar.getReg().equals(actualCar.getReg())) {
                    assertEquals(expectedCar.getMake(), actualCar.getMake());
                    assertEquals(expectedCar.getModel(), actualCar.getModel());
                }
            }
        }
    }
}
