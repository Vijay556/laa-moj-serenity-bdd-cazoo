package cazoo.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import cazoo.pages.ValueMyCarHomePage;

public class NavigateTo {
    public static Performable theCazooValueMyCarPage() {
        return Task.where(
                "{0} opens the Cazoo Value my car home page",
                Open.browserOn().the(CazooWebsite.class)
        );
    }

    public static Performable theCazooWebsite() {
        return Task.where(
                "{0} opens the Cazoo Value my car home page",
                Open.browserOn().the(CazooWebsite.class),
                Click.on(ValueMyCarHomePage.ACCEPT_COOKIES_BUTTON)
        );
    }
}
