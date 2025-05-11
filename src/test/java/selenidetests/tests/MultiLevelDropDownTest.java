package selenidetests.tests;

import org.example.pages.MultiLevelDropDownPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;


public class MultiLevelDropDownTest extends BaseTest {

    @DataProvider
    public Object[] getAnimals() {
        return new Object[]{
                "Kangaroo",
                "Frog",
                "Horse",
                "Hedgehog"
        };
    }

    @DataProvider
    public Object[] getSettings() {
        return  new Object[] {
                "HTML",
                "CSS",
                "JavaScript"
        };
    }


    @Test(dataProvider = "getAnimals")
    public void testGetDropdownAnimals(String animals) {
        getHomePage()
                .open()
                .goToPage("Multi Level Dropdown", new MultiLevelDropDownPage())
                .getDropdown("Animals", animals);
    }

    @Test(dataProvider = "getSettings" )
    public void testGetDropdownSettings(String items) {
        getHomePage()
                .open()
                .goToPage("Multi Level Dropdown", new MultiLevelDropDownPage())
                .getDropdown("Settings", items);
    }
}
