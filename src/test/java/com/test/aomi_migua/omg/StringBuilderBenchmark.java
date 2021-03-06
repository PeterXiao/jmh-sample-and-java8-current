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
/**
 *
 */
package com.test.aomi_migua.omg;

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
 * @author LiY
 *
 */
/**
 * 比较字符串直接相加和StringBuilder的效率
 *
 * @author xiaoyulong
 * @version 1.0
 * @since 2018/1/7
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(8)
@Fork(2)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringBuilderBenchmark {

	@Benchmark
	public void testStringAdd() {
		String a = "";
		for (int i = 0; i < 10; i++) {
			a += i;
		}
		print(a);
	}

	@Benchmark
	public void testStringBuilderAdd() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(i);
		}
		print(sb.toString());
	}

	private void print(String a) {
	}

	public static void main(String[] args) throws RunnerException {
		Options options = new OptionsBuilder().include(StringBuilderBenchmark.class.getSimpleName()).forks(1).build(); // output("D:/Benchmark.log")
		new Runner(options).run();
	}
}
