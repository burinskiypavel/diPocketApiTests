package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


public class OpeningATariffPlanTest extends UITestBase {

    @Test
    public void testOpeningATariffPlan() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        gotoOperations();
        gotoFeeTariffPlanTab();
        selectFromDropDown("name", "United Kingdom - standard");

        List<String> actualElementsText = getActualText(By.xpath("//table //tbody //tr"));
        List<String> expectedElementsText = getDateFromFile("files/bo/boOperations/openingATariffPlan.txt");

        //MatcherAssert.assertThat(actualElementsText, equalTo(expectedElementsText));
        //assertEquals(actualElementsText, expectedElementsText);

        //assertThat(actualElementsText).isEqualToNormalizingNewlines(expectedElementsText);
        assertThat("text").isEqualToNormalizingNewlines("test");
    }
}
