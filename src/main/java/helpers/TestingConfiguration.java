package helpers;

public class TestingConfiguration {

    private TestingConfiguration() {
    }

    public static String getStartUrl() {
        return TestingEnvironment.getCurrentEnvironment("testing.json").getValue("/start_url").toString();
    }
}
