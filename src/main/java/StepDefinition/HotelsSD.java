package StepDefinition;

import Pages.HotelsSearchResult;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

import static StepDefinition.SharedSD.getDriver;

public class HotelsSD {

    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {

        Assert.assertEquals("Booking.com : Hotels in Pune . Book your hotel now!",
                getDriver().getTitle());

    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars) throws Throwable {

        hotelsSearchResult.clickRatings(stars);


    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {

        ArrayList<Integer> ratingList = hotelsSearchResult.getStarRatingsList();
        System.out.println(ratingList);

        int size = ratingList.size();

        int occurance = Collections.frequency(ratingList,stars.split(" ")[0]);


        Assert.assertTrue("Some or all the ratings are not equalto:"+stars,size==occurance);

    }

}
