package com.aping.java8.function;

import java.util.function.Supplier;
import java.util.logging.Level;

/**
 * <p>
 * SupplierExample
 * </p>
 *
 * @author Aping
 * @since 2022/10/9 21:32
 */
public class SupplierExample {

    public static void main(String[] args) {

        info(Level.INFO, () -> "hello etcp");

    }

    public static void info(Level level, Supplier<String> msgSupplier) {
        if (level == Level.INFO) {
            System.out.println(msgSupplier.get());
        }

    }
}
