package versions.java11;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.time.ZoneId;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xiaoy
 * @date 2020/05/15
 */
public class PorcessCase {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        // ProcessBuilder pb = new ProcessBuilder("echo", "Hello World!");
        // Process p = pb.start();
        // p.destroy();
        getInfoTest();

    }

    public static void setEnvTest() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "echo $horse $dog $HOME").inheritIO();
        pb.environment().put("horse", "oats");
        pb.environment().put("dog", "treats");
        pb.start().waitFor();
    }

    public static void getInfoTest() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("echo", "Hello World!");
        String na = "<not available>";
        Process p = pb.start();
        ProcessHandle.Info info = p.info();
        System.out.printf("Process ID: %s%n", p.pid());
        System.out.printf("Command name: %s%n", info.command().orElse(na));
        System.out.printf("Command line: %s%n", info.commandLine().orElse(na));

        System.out.printf("Start time: %s%n",
            info.startInstant().map(i -> i.atZone(ZoneId.systemDefault()).toLocalDateTime().toString()).orElse(na));

        System.out.printf("Arguments: %s%n",
            info.arguments().map(a -> Stream.of(a).collect(Collectors.joining(" "))).orElse(na));

        System.out.printf("User: %s%n", info.user().orElse(na));
    }

    public static void redirectToFileTest() throws IOException, InterruptedException {
        File outFile = new File("out.tmp");
        Process p = new ProcessBuilder("ls", "-la").redirectOutput(outFile).redirectError(Redirect.INHERIT).start();
        int status = p.waitFor();
        if (status == 0) {
            p = new ProcessBuilder("cat", outFile.toString()).inheritIO().start();
            p.waitFor();
        }
    }

}
