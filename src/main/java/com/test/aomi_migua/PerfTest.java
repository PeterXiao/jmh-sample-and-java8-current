/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 *  This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.test.aomi_migua;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

public class PerfTest {

	private static List<Integer> integers = new ArrayList<>();

	public static final int size = 100000;
	{
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < PerfTest.size; i++) {
			int i1 = random.nextInt(PerfTest.size);
			PerfTest.integers.add(i1);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@BenchmarkMode(Mode.AverageTime)
	public int iteratorMaxInteger() {

		int max = Integer.MIN_VALUE;
		for (Iterator<Integer> it = PerfTest.integers.iterator(); it.hasNext();) {
			max = Integer.max(max, it.next());
		}
		return max;
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@BenchmarkMode(Mode.AverageTime)
	public int forEachLoopMaxInteger() {
		int max = Integer.MIN_VALUE;
		for (Integer n : PerfTest.integers) {
			max = Integer.max(max, n);
		}
		return max;
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@BenchmarkMode(Mode.AverageTime)
	public int forMaxInteger() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < PerfTest.size; i++) {
			max = Integer.max(max, PerfTest.integers.get(i));
		}
		return max;
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@BenchmarkMode(Mode.AverageTime)
	public int parallelStreamMaxInteger() {
		Optional<Integer> max;
		max = PerfTest.integers.parallelStream().reduce(Integer::max);
		return max.get();
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@BenchmarkMode(Mode.AverageTime)
	public int lambdaMaxInteger() {
		return PerfTest.integers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(PerfTest.class.getSimpleName()).warmupTime(TimeValue.seconds(1))
				.forks(1).build();

		new Runner(opt).run();

//		assertThat(some.testMethod()).hasSize(4).contains("some result", "some other result")
//				.doesNotContain("shouldn't be here");
	}

	@Test
	public void test() {
		time(new PerfTest()::parallelStreamMaxInteger);
	}

	public void time(Runnable run) {
		long startTime = System.currentTimeMillis();
		System.out.println("startTime = " + startTime);

		run.run();

		long endTime = System.currentTimeMillis();
		System.out.println("endTime = " + endTime);
		System.out.println("###################");
		long cost = endTime - startTime;
		System.out.println("cost = " + cost);

	}

	public void time(Runnable... runList) {
		for (Runnable runnable : runList) {
			time(runnable);
		}
	}

	/*
	 * public static void main(String[] args) { PerfTest test = new PerfTest();
	 * test.time(test::forEachLoopMaxInteger, test::forMaxInteger,
	 * test::iteratorMaxInteger, test::lambdaMaxInteger,
	 * test::parallelStreamMaxInteger); }
	 */

}
