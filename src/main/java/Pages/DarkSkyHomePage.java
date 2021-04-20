package Pages;

import org.junit.Before;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkSkyHomePage extends Base {

    //1
    By currentTempTxt = By.xpath("//span[@class='summary swap']");
    //101˚ Clear.
    By timeLineTempTxt = By.xpath("//span[@class='first']//span");
    //101°
    By timeListRow = By.xpath("//span[@class='hour']//span");
    By expander = By.xpath("//a[@data-day='0']//span[@class='toggle']");
    By minTemp = By.xpath("By locator = By.className(\"minTemp\");");
    By maxTemp = By.xpath("By locator = By.className(\"maxTemp\");");
    By timelineMinTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");
    By timelineMaxTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[@class='temp']");

    By lnkDarkSkyAPI = By.xpath("//a[normalize-space()='Dark Sky API']");

    public void clickDarkSkyAPI() {
        clickOn(lnkDarkSkyAPI);
    }

/*
    public ArrayList<String> getBarTempList() {
        ArrayList<String> tempList = new ArrayList<>();
        String minTemp = getTextFromElement(barMinTemp).split("˚")[0];
        String maxTemp = getTextFromElement(barMaxTemp).split("˚")[0];
        tempList.add(minTemp);
        tempList.add(maxTemp);
        return tempList;

    }

    public ArrayList<String> getTimeLineTempList() {
        ArrayList<String> tempList = new ArrayList<>();
        String timeminTemp = getTextFromElement(timelinemaxTemp).split("˚")[0];
        String timemaxTemp = getTextFromElement(timelinemaxTemp).split("˚")[0];
        tempList.add(minTemp);
        tempList.add(maxTemp);

        return tempList;

        public void clickExpander ()
        {
            clickOn(expander);
        }

    }*/

    public int getCurrentTemp() {
        String TempTxtRow = getTextFromElement(currentTempTxt);
        //101˚ Clear.

        String strTemp = TempTxtRow.split("˚")[0];   //86

        int temp = Integer.parseInt(strTemp);
        return temp;
    }

    public int timeLineTempTxt() {
        String TempTxtRow = getTextFromElement(timeLineTempTxt);
        //101°
        String strTemp = TempTxtRow.split("°")[0];   //86

        int temp = Integer.parseInt(strTemp);
        return temp;
    }
    //2

    public ArrayList<Integer> getTimeList() {
        ArrayList<String> timeListStr = getElementTextList(timeListRow);
        ArrayList<Integer> timelist = new ArrayList<>();

        for (int i = 0; i < timeListStr.size() - 1; i++) {
            String timeRowStr = timeListStr.get(i);  //11am
            int l = timeRowStr.length();
            String timeStr = timeRowStr.substring(0, l - 2);   //11
            int time = Integer.parseInt(timeStr);
            timelist.add(time);



        }
        return timelist;
    }

}