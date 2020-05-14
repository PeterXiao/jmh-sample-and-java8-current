
/**
 * @Copyright:Copyright (c) 2017 - 2018
 * @Company:aomi-miguatch
 * @User: Petershow@mem853.com
 * @Benchmark.java
 * @Author Petershow@mem853.com
 * @Time
 */

package com.migua.tech.test.jdk11;

import java.util.HashMap;
import java.util.Map;
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
 * @Since:2018
 * @Version:1.1.0
 */


@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
@Threads(8)
@Fork(2)
@OutputTimeUnit(TimeUnit.SECONDS)
public class Benchmarks2 {

	//	Benchmark                    Mode  Cnt       Score       Error  Units
	//	Benchmarks2.testInstanceOf  thrpt    6  127637.056 ± 20870.743  ops/s
	@Benchmark
	public Map<String,String> testHashMapWithDEFAULT_LOAD_FACTOR() {
		Map<String,String> map = new HashMap<>(16);
		for(int i =0 ; i<=1023;i++) {
			map.put("123456", "654321"+i);
		}
		return map;
	}
	////	Benchmark                    Mode  Cnt      Score       Error  Units
	////	Benchmarks2.testInstanceOf  thrpt    6  96195.775 ± 65339.477  ops/s
	@Benchmark
	public Map<String,String> testHashMapWithoutDEFAULT_LOAD_FACTOR() {
		Map<String,String> map = new HashMap<>();
		for(int i =0 ; i<=1023;i++) {
			map.put("123456", "654321"+i);
		}
		return map;
	}


	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(Benchmarks2.class.getSimpleName()).warmupIterations(1) // TestPerf2.class.getSimpleName()
				.measurementIterations(6).forks(1).build();

		new Runner(opt).run();
	}
}
