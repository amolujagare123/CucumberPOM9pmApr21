package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static StepDefinition.SharedSD.getDriver;

public class HotelsSearchResult extends  Base {




    public void clickRatings(String starRating)
    {

        // starRating = 5 Stars -->  starRatings.split(" ")[0]
        //a[@data-id="class-4"]

        String starNo = starRating.split(" ")[0];
        getDriver().findElement(By.xpath("//a[@data-id='class-"+starNo+"']")).click();

    }


    public ArrayList<Integer> getStarRatingsList()
    {

        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

      List<WebElement> ratingsList =
              getDriver().findElements(By.xpath("//span[contains(@class,'bui-rating--smaller')]"));
// aria-label="5 out of 5"  --> getAttributeValue("aria-label") --> "5 out of 5"

        ArrayList<Integer> ratingListNo = new ArrayList<>();

      for(int i=0;i<ratingsList.size();i++)
      {
          String strRow = ratingsList.get(i).getAttribute("aria-label"); // "5 out of 5"

          int rating = Integer.parseInt(strRow.split(" ")[0]); //"5"

          ratingListNo.add(rating);
      }

      return ratingListNo;
    }

}
