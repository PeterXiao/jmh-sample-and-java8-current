package versions.java11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author xiaoy
 * @date 2020/05/15
 */
public class ProcessTest {

    // ...

    static void filterProcessesTest() {
        Optional<String> currUser = ProcessHandle.current().info().user();
        ProcessHandle.allProcesses().filter(p1 -> p1.info().user().equals(currUser))
            .sorted(ProcessTest::parentComparator).forEach(ProcessTest::showProcess);
    }

    static int parentComparator(ProcessHandle p1, ProcessHandle p2) {
        long pid1 = p1.parent().map(ph -> ph.pid()).orElse(-1L);
        long pid2 = p2.parent().map(ph -> ph.pid()).orElse(-1L);
        return Long.compare(pid1, pid2);
    }

    static void showProcess(ProcessHandle ph) {
        ProcessHandle.Info info = ph.info();
        System.out.printf("pid: %d, user: %s, cmd: %s%n", ph.pid(), info.user().orElse("none"),
            info.command().orElse("none"));
    }

    // ...

}

class ProcessTest2 {

    // ...

    static public void startProcessesTest() throws IOException, InterruptedException {
        List<ProcessBuilder> greps = new ArrayList<>();
        greps.add(new ProcessBuilder("/bin/sh", "-c", "grep -c \"java\" *"));
        greps.add(new ProcessBuilder("/bin/sh", "-c", "grep -c \"Process\" *"));
        greps.add(new ProcessBuilder("/bin/sh", "-c", "grep -c \"onExit\" *"));
        ProcessTest2.startSeveralProcesses(greps, ProcessTest2::printGrepResults);
        System.out.println("\nPress enter to continue ...\n");
        System.in.read();
    }

    static void startSeveralProcesses(List<ProcessBuilder> pBList, Consumer<Process> onExitMethod)
        throws InterruptedException {
        System.out.println("Number of processes: " + pBList.size());
        pBList.stream().forEach(pb -> {
            try {
                Process p = pb.start();
                System.out.printf("Start %d, %s%n", p.pid(), p.info().commandLine().orElse("<na>"));
                p.onExit().thenAccept(onExitMethod);
            } catch (IOException e) {
                System.err.println("Exception caught");
                e.printStackTrace();
            }
        });
    }

    static void printGrepResults(Process p) {
        System.out.printf("Exit %d, status %d%n%s%n%n", p.pid(), p.exitValue(), output(p.getInputStream()));
    }

    private static String output(InputStream inputStream) {
        String s = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            s = br.lines().collect(Collectors.joining(System.getProperty("line.separator")));
        } catch (IOException e) {
            System.err.println("Caught IOException");
            e.printStackTrace();
        }
        return s;
    }

    // static void startSeveralProcesses (
    // List<ProcessBuilder> pBList, Consumer<Process> onExitMethod)
    // throws InterruptedException {
    // System.out.println("Number of processes: " + pBList.size());
    // pBList.stream().forEach(
    // pb -> {
    // try {
    // Process p = pb.start();
    // System.out.printf("Start %d, %s%n",
    // p.pid(), p.info().commandLine().orElse("<na>"));
    // p.onExit().get();//会被阻塞在这里
    // printGrepResults(p);
    // } catch (IOException|InterruptedException|ExecutionException e ) {
    // System.err.println("Exception caught");
    // e.printStackTrace();
    // }
    // }
    // );
    // }

    // ...
}