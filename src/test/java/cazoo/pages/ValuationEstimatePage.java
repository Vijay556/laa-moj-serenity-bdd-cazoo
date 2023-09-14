package cazoo.pages;

import net.serenitybdd.screenplay.targets.Target;

public class ValuationEstimatePage {
    public static final Target CONTINUE_TO_FULL_VALUATION_PAGE =
            Target.the("Continue to full valuation page button")
                    .locatedBy("//span[text()='Continue to full valuation']");
}
