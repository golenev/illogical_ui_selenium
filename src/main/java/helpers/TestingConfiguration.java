package helpers;

import java.util.Objects;

public class TestingConfiguration {

    private TestingConfiguration() {
    }

    public static String getStartUrl() {
        return TestingEnvironment.getCurrentEnvironment("testing.json").getValue("/start_url").toString();
    }

    public static String setStartBrowser(){
        return TestingEnvironment.getCurrentEnvironment("settings.json").getValue("/browserName").toString();
    }

    public static void main(String[] args) {
        String value = setStartBrowser();
        System.out.println(value);
        if (value.equals("chrome")) {
            // if (Objects.equals(setStartBrowser(), "${BROWSER}"))
            value = "edge";
            System.out.println(value);
        }



    }

}
