package tests;

import common.Config;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.*;

public class BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    static {
        LOGGER.info("START TIME:" + LocalTime.now());
        LOGGER.info("Start clear reports dir: build/reports ...");
        File allureResults = new File("allure-results");
        if (allureResults.isDirectory()) {
            for (File item : Objects.requireNonNull(allureResults.listFiles()))
                item.delete();
        }
        if (CLEAR_REPORTS_DIR) {
            File allureScreenshots = new File("build/reports/tests/");
            for (File item : Objects.requireNonNull(allureScreenshots.listFiles()))
                item.delete();
        }
        if (CLEAR_REPORTS_DIR) {
            File reports = new File("build/reports/tests/");
            if (reports.isDirectory()) {
                for (File item : Objects.requireNonNull(reports.listFiles())) {
                    item.delete();
                }
            }
            File downloads = new File("build/downloads/");
            if (downloads.isDirectory()) {
                for (File item : Objects.requireNonNull(reports.listFiles())) {
                }
            }
        }
    }
}