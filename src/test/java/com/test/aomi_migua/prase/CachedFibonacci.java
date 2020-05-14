package com.test.aomi_migua.prase;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CachedFibonacci {
    private static Map<BigDecimal, BigDecimal> previousValuesHolder;
    static {
        previousValuesHolder = new HashMap<>();
        previousValuesHolder.put(BigDecimal.ZERO, BigDecimal.ZERO);
        previousValuesHolder.put(BigDecimal.ONE, BigDecimal.ONE);
    }

    private static LoadingCache<BigDecimal, BigDecimal> cachedFibonacci = CacheBuilder.newBuilder()
            .expireAfterWrite(3, TimeUnit.MINUTES)
            .maximumSize(500000)
            .concurrencyLevel(5)
            //.weakKeys()
            .build(new CacheLoader<BigDecimal, BigDecimal>() {
                @Override
                public BigDecimal load(BigDecimal key) throws Exception {
                    return getFibonacciByKey(key);
                }
            });

    private static BigDecimal getFibonacciByKey(BigDecimal key) {
        long number = key.longValue();

        BigDecimal olderValue = BigDecimal.ONE,
                oldValue = BigDecimal.ONE,
                newValue = BigDecimal.ONE;

        for (int i = 3; i <= number; i++) {
            newValue = oldValue.add(olderValue);
            olderValue = oldValue;
            oldValue = newValue;
        }
        return newValue;
    }

    public static BigDecimal getGuavaCache(long number) {
        if (0 == number) {
            return BigDecimal.ZERO;
        } else if (1 == number) {
            return BigDecimal.ONE;
        } else {
            return cachedFibonacci.getUnchecked(BigDecimal.valueOf(number));
        }
    }

    public static BigDecimal getCachedFibonacciOf(long number) {
        if (0 == number) {
            return BigDecimal.ZERO;
        } else if (1 == number) {
            return BigDecimal.ONE;
        } else {
            if (previousValuesHolder.containsKey(BigDecimal.valueOf(number))) {
                return previousValuesHolder.get(BigDecimal.valueOf(number));
            } else {
                BigDecimal olderValue = BigDecimal.ONE,
                        oldValue = BigDecimal.ONE,
                        newValue = BigDecimal.ONE;

                for (int i = 3; i <= number; i++) {
                    newValue = oldValue.add(olderValue);
                    olderValue = oldValue;
                    oldValue = newValue;
                }
                previousValuesHolder.put(BigDecimal.valueOf(number), newValue);
                return newValue;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter n: ");
            long inputNumber = scanner.nextLong();
            if (inputNumber >= 0) {
                long beginTime = System.nanoTime();
//                BigDecimal fibo = getCachedFibonacciOf(inputNumber);
                BigDecimal fibo = getGuavaCache(inputNumber);

                long endTime = System.nanoTime();
                long delta = endTime - beginTime;

                System.out.printf("F(%d) = %.10s ... computed in %,d ms\n", inputNumber, fibo, delta / 1_000_000);
            } else {
                System.err.println("You must enter number > 0");
                System.out.println("try, enter number again, please:");
                break;
            }
        }
    }
}
