package com.chaochaogu.daily.jmh;

import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author chaochao Gu
 * @date 2021/1/4
 */
public class BenchmarkTest {

    @Test
    public void test() throws RunnerException {
        Options options = new OptionsBuilder().
                include(JsonBenchmark.class.getSimpleName()).
                // output("/tmp/json_benchmark.log").
                        build();
        new Runner(options).run();
    }
}
