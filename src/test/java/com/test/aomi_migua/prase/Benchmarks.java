
/**
 * @Copyright:Copyright (c) 2017 - 2018
 * @Company:aomi-miguatch
 * @User: Petershow@mem853.com
 * @Benchmark.java
 * @Author Petershow@mem853.com
 * @Time 涓嬪崍5:38:10
 */

package com.test.aomi_migua.prase;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @Title:
 * @Description:
 * @Author:LiY
 * @Since:2018骞�9鏈�10鏃�
 * @Version:1.1.0
 */

class A {
}

class B extends A {
}

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Benchmarks {

	public static final Object a = new A();
	public static final Object b = new B();

	@Benchmark
	public boolean testInstanceOf() {
		return Benchmarks.b instanceof A;
	}

	@Benchmark
	public boolean testIsInstance() {
		return A.class.isInstance(Benchmarks.b);
	}

	@Benchmark
	public boolean testIsAssignableFrom() {
		return A.class.isAssignableFrom(Benchmarks.b.getClass());
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(Benchmarks.class.getSimpleName()).warmupIterations(1) // TestPerf2.class.getSimpleName()
				.measurementIterations(6).forks(1).build();

		new Runner(opt).run();
	}
}
