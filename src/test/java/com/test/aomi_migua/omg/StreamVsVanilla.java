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
import java.util.stream.Collectors;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.OutputTimeUnit;

/**
 * @author LiY
 *
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@OperationsPerInvocation(StreamVsVanilla.N)
public class StreamVsVanilla {
	public static final int N = 10000;

	static List<Integer> sourceList = new ArrayList<>();
	static {
		for (int i = 0; i < StreamVsVanilla.N; i++) {
			StreamVsVanilla.sourceList.add(i);
		}
	}

	@Benchmark
	public List<Double> vanilla() {
		List<Double> result = new ArrayList<>(StreamVsVanilla.sourceList.size() / 2 + 1);
		for (Integer i : StreamVsVanilla.sourceList) {
			if (i % 2 == 0) {
				result.add(Math.sqrt(i));
			}
		}
		return result;
	}

	@Benchmark
	public List<Double> stream() {
		return StreamVsVanilla.sourceList.stream().filter(i -> i % 2 == 0).map(Math::sqrt)
				.collect(Collectors.toCollection(() -> new ArrayList<>(StreamVsVanilla.sourceList.size() / 2 + 1)));
	}
}