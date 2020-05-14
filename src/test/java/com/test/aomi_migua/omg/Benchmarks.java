
/**
 * @Copyright:Copyright (c) 2017 - 2018
 * @Company:aomi-miguatch
 * @User: Petershow@mem853.com
 * @Benchmark.java
 * @Author Petershow@mem853.com
 * @Time 涓嬪崍5:38:10
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

import com.alibaba.fastjson.JSON;

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
@Warmup(iterations = 3)
@Measurement(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Threads(8)
@Fork(2)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Benchmarks {



	@Benchmark
	public String testInstanceOf() {
		
		final VO obj = new VO();
		
		String text = JSON.toJSONString(obj); //序列化
		
		return text;
	}

	@Benchmark
	public VO testIsInstance() {
		VO vo = JSON.parseObject("{...}", VO.class); //反序列化
		return vo;
	}



	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(Benchmarks.class.getSimpleName()).warmupIterations(1) 
				.measurementIterations(6).forks(1).build();

		new Runner(opt).run();
	}
}
