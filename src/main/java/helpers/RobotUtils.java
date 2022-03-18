package helpers;

import aquality.selenium.core.logging.Logger;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotUtils {

    public static void putToClipBoard(String filePath) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(filePath);
        clipboard.setContents(stringSelection, null);
        Logger.getInstance().info("Copy required String");
    }

    public static void copyPasteByRobo(){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            Logger.getInstance().warn("Sorry, failed to create Robot");
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Logger.getInstance().info("Paste copied String ");
    }
}
