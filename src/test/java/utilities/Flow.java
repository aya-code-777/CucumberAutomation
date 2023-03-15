package utilities;

import org.openqa.selenium.interactions.Actions;

public class Flow {

    //This method will wait and driver will sleep in a bit
    public static void wait(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch (InterruptedException e){
            System.out.println("Interruption happened");
        }
    }

    //Scroll down page method
    public static void scrollDown(int deltaY){

        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0,deltaY).perform();

    }

    //Scroll up page method
    public static void scrollUp(int deltaY){

        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0,deltaY).perform();

    }







}
