package problems.compareuntil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author xiaoy
 * @date 2020/05/11
 */
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.Throughput)
public class CompareAtomicLongLongAdder {

    private static AtomicLong count = new AtomicLong();
    private static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder().include(CompareAtomicLongLongAdder.class.getName()).forks(1).build();
        new Runner(options).run();
    }

    @Benchmark
    @Threads(10)
    public void run0() {
        count.getAndIncrement();
    }

    @Benchmark
    @Threads(10)
    public void run1() {
        longAdder.increment();
    }

}
