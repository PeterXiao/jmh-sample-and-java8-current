package versions.java11;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author xiaoy
 * @date 2020/05/15
 */
public class Nose {

    /**
     * @param args
     */
    // Obtain a suitable logger.
    private static Logger logger = Logger.getLogger("versions.java11.nose");

    // Handler fh = new FileHandler("%t/wombat.log");
    // Logger.getLogger("").addHandler(fh);
    // Logger.getLogger("com.wombat").setLevel(Level.FINEST);

    public static void main(String argv[]) {
        // Log a FINE tracing message
        logger.fine("doing stuff");
        try {
            // Wombat.sneeze();
        } catch (Exception ex) {
            // Log the exception
            logger.log(Level.WARNING, "trouble sneezing", ex);
        }
        logger.fine("done");
    }

    /* private static Logger logger = Logger.getLogger("com.wombat.nose");
    private static FileHandler fh = new FileHandler("mylog.txt");
    public static void main(String argv[]) {
        // Send logger output to our FileHandler.
        logger.addHandler(fh);
        // Request that every detail gets logged.
        logger.setLevel(Level.ALL);
        // Log a simple INFO message.
        logger.info("doing stuff");
        try {
            Wombat.sneeze();
        } catch (Exception ex) {
            logger.log(Level.WARNING, "trouble sneezing", ex);
        }
        logger.fine("done");
    }*/
}
