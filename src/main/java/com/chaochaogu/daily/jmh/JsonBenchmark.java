package com.chaochaogu.daily.jmh;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @author chaochao Gu
 * @date 2021/1/4
 */
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
/**
 * 配置预热参数
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
/**
 * 指定输出的耗时时长的单位
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
/**
 * 用于指定fork出多少个子进程来执行同一基准测试方法
 * 假设我们不需要多个进程，那么可以使用@Fork指定为进程数为1
 */
@Fork(1)
/**
 * 用于指定使用多少个线程来执行基准测试方法
 * 如果使用@Threads指定线程数为2，那么每次测量都会创建两个线程来执行基准测试方法
 */
@Threads(2)
/**
 * 指定字段的共享域
 */
@State(Scope.Benchmark)
public class JsonBenchmark {

    private Gson gson = new Gson();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    /**
     * 声明一个public方法为基准测试方法
     */
    @Benchmark
    /**
     * 指定mode为Mode.AverageTime
     */
    public void testGson() {
        System.out.println("current Thread:" + Thread.currentThread().getName() + "==>" + gson.hashCode());
        gson.fromJson("{\"startDate\":\"2020-04-01 16:00:00\",\"endDate\":\"2020-05-20 13:00:00\",\"flag\":true,\"threads\":5,\"shardingIndex\":0}", JsonTestModel.class);
    }

    @Test
    @Benchmark
    public void testJackson() {
        try {
            objectMapper.readValue("{\"startDate\":\"2020-04-01 16:00:00\",\"endDate\":\"2020-05-20 13:00:00\",\"flag\":true,\"threads\":5,\"shardingIndex\":0}", JsonTestModel.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
