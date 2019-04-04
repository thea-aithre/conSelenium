package pl.conselenium.workshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LogTest {
    Logger log = LoggerFactory.getLogger(LogTest.class);

    @Test(groups = "smoke")
    public void testLog() {
        log.info("Smoke test - Logowanie czegoś.");
        log.info("Smoke test - druga linijka logu.");
    }
}

