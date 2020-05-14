
/**
 * @Copyright:Copyright (c) 2017 - 2018
 * @Company:aomi-miguatch
 * @User: Petershow@mem853.com
 * @Benchmark.java
 * @Author Petershow@mem853.com
 * @Time
 */

package com.migua.tech.test.jdk11;

import java.io.IOException;
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

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
public class BenchmarksHttp {
	//	OkHttpClient client = new OkHttpClient();
	//
	//	String run(String url) throws IOException {
	//		Request request = new Request.Builder()
	//				.url(url)
	//				.build();
	//
	//		try (Response response = client.newCall(request).execute()) {
	//			return response.body().string();
	//		}
	//	}

	//	Benchmark                    Mode  Cnt       Score       Error  Units
	//	Benchmarks2.testInstanceOf  thrpt    6  127637.056 ± 20870.743  ops/s
	@Benchmark
	public String testHashMapWithDEFAULT_LOAD_FACTOR() throws IOException {
		OkHttpClient client = new OkHttpClient();
		String url = "https://www.baidu.com";

		Request request = new Request.Builder()
				.url(url)
				.build();

		Response response = client.newCall(request).execute();
		return response.body().string();

	}



	public static void main(String[] args) throws RunnerException {

		//String response = example.run("https://raw.github.com/square/okhttp/master/README.md");

		Options opt = new OptionsBuilder().include(BenchmarksHttp.class.getSimpleName()).warmupIterations(1) // TestPerf2.class.getSimpleName()
				.measurementIterations(6).forks(1).build();

		new Runner(opt).run();
	}
}
