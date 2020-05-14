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

import static strman.Strman.append;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class StrmanTest {
	/*
	 * This is our first benchmark method.
	 *
	 * JMH works as follows: users annotate the methods with @Benchmark, and then
	 * JMH produces the generated code to run this particular benchmark as reliably
	 * as possible. In general one might think about @Benchmark methods as the
	 * benchmark "payload", the things we want to measure. The surrounding
	 * infrastructure is provided by the harness itself.
	 *
	 * Read the Javadoc for @Benchmark annotation for complete semantics and
	 * restrictions. At this point we only note that the methods names are
	 * non-essential, and it only matters that the methods are marked with
	 *
	 * @Benchmark. You can have multiple benchmark methods within the same class.
	 *
	 * Note: if the benchmark method never finishes, then JMH run never finishes as
	 * well. If you throw an exception from the method body the JMH run ends
	 * abruptly for this benchmark and JMH will run the next benchmark down the
	 * list.
	 *
	 * Although this benchmark measures "nothing" it is a good showcase for the
	 * overheads the infrastructure bear on the code you measure in the method.
	 * There are no magical infrastructures which incur no overhead, and it is
	 * important to know what are the infra overheads you are dealing with. You
	 * might find this thought unfolded in future examples by having the "baseline"
	 * measurements to compare against.
	 */

	@Benchmark
	public void wellHelloThere() {
		// this method was intentionally left blank.

		append("f", "o", "o", "b", "a", "r");
		List<Integer> list = Arrays.asList(3,1,4,5,1,8,9,4,7);
		List<Integer> numbers = list.parallelStream().map(n -> n*2).sequential().sorted().collect(Collectors.toList());
		int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

		int min = IntStream.of(nums).min().getAsInt();
		new Thread(() -> System.out.println("running")).start();
		Runnable runnable1 = () -> System.out.println("running");
		//Runnable runnable2 = RunnableFactory.getInstance();
	}

	/*
	 * ============================== HOW TO RUN THIS TEST:
	 * ====================================
	 *
	 * You are expected to see the run with large number of iterations, and very
	 * large throughput numbers. You can see that as the estimate of the harness
	 * overheads per method call. In most of our measurements, it is down to several
	 * cycles per call.
	 *
	 * a) Via command-line: $ mvn clean install $ java -jar target/benchmarks.jar
	 * JMHSample_01
	 *
	 * JMH generates self-contained JARs, bundling JMH together with it. The runtime
	 * options for the JMH are available with "-h": $ java -jar
	 * target/benchmarks.jar -h
	 *
	 * b) Via the Java API: (see the JMH homepage for possible caveats when running
	 * from IDE: http://openjdk.java.net/projects/code-tools/jmh/)
	 */

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(StrmanTest.class.getSimpleName()).forks(1).build();

		new Runner(opt).run();
	}

}
