package helpers;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

class TestingEnvironment {
    private TestingEnvironment() {
    }

    static ISettingsFile getCurrentEnvironment(String pathFile) {
       return new JsonSettingsFile(pathFile);
    }
}