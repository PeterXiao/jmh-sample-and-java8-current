package com.base;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoy
 * @date 2020/05/14
 */
@Slf4j
public class testnull {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = null;
        Integer itr = null;
        Double dou = null;

        Integer integer = (Integer)null;
        String string = (String)null;

        System.out.println("integer = " + integer);
        System.out.println("string = " + string);

        var runnable = new Runnable() {
            String className = Thread.currentThread().getName();

            @Override
            public void run() {
                log.info("inside runnable");
            }
        };
        log.info(runnable.className);

        List<Object> objects = Stream.of(1, 2, 3, 4).map(i -> new Object() {
            int count = i;
        }).filter(o -> o.count > 0).collect(Collectors.toList());
        log.info("{}", objects);

    }

}
