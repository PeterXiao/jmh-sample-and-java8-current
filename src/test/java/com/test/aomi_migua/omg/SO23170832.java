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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class SO23170832 {

	public final static int ARR_SIZE = 100;
	public final static int ITER_COUNT = 100000;

	String arr[] = new String[SO23170832.ARR_SIZE];
	List<String> list = new ArrayList<>(SO23170832.ARR_SIZE);

	public SO23170832() {
		for (int i = 0; i < SO23170832.ARR_SIZE; i++) {
			list.add(null);
		}
	}

	@Benchmark
	public void testListForEach() {
		int count = 0;
		for (int i = 0; i < SO23170832.ITER_COUNT; i++) {
			for (String str : list) {
				if (str != null)
					count++;
			}
		}
		if (count > 0)
			System.out.print(count);
	}

	@Benchmark
	public void testListForGet() {
		int count = 0;
		for (int i = 0; i < SO23170832.ITER_COUNT; i++) {
			for (int j = 0; j < SO23170832.ARR_SIZE; j++) {
				if (list.get(j) != null)
					count++;
			}
		}
		if (count > 0)
			System.out.print(count);
	}

	@Benchmark
	public void testArrayForGet() {
		int count = 0;
		for (int i = 0; i < SO23170832.ITER_COUNT; i++) {
			for (int j = 0; j < SO23170832.ARR_SIZE; j++) {
				if (arr[j] != null)
					count++;
			}
		}
		if (count > 0)
			System.out.print(count);
	}
//	@State(Scope.Benchmark)
//	public static class BenchmarkState {
//		static String[] array;
//		static {
//			BenchmarkState.array = new String[1000000];
//			Arrays.fill(BenchmarkState.array, "AbabagalamagA");
//		}
//	}
//
//	@GenerateMicroBenchmark
//	@OutputTimeUnit(TimeUnit.SECONDS)
//	public List<String> sequential(BenchmarkState state) {
//		return Arrays.stream(BenchmarkState.array).map(x -> x.toLowerCase()).collect(Collectors.toList());
//	}
//
//	@GenerateMicroBenchmark
//	@OutputTimeUnit(TimeUnit.SECONDS)
//	public List<String> parallel(BenchmarkState state) {
//		return Arrays.stream(BenchmarkState.array).parallel().map(x -> x.toLowerCase()).collect(Collectors.toList());
//	}
}
