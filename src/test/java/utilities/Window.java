package utilities;

import java.util.Set;

public class Window {

    private static String mainHandle;


    //We have two windows and we switch to second window
    public static void switchToSecondWindow(){

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        mainHandle = Driver.getDriver().getWindowHandle();
        if(windowHandles.size() < 2){
            System.out.println("No multiple windows found");
        }else{
            for(String windowId: windowHandles){
                if(!windowId.equals(mainHandle)){
                    Driver.getDriver().switchTo().window(windowId);
                }
            }
        }

    }

    //This method return or switch to main window
    public static void switchToMainWindow(){
        if(mainHandle != null){
            Driver.getDriver().switchTo().window(mainHandle);
        }
    }

    //We have a multiple windows and we can switch that

    public static void switchToWindow(String title){
        mainHandle = Driver.getDriver().getWindowHandle();

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        if(windowHandles.size() < 2){
            System.out.println("No multiple windows");
        }else{
            for(String window: windowHandles){
                Driver.getDriver().switchTo().window(window);
                if(title.equals(Driver.getDriver().getTitle())){
                    break;
                }
            }
        }



    }










}
