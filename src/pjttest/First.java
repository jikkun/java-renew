package pjttest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class First {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        int i = 10;
        logger.debug("First i = {}", i);

        i = 100;
        logger.debug("Second i = {}", i);

        i = 3000;
        logger.debug("Third i = {}", i);

        i = 00;
        logger.debug("Fourth i = {}", i);
    }

}
