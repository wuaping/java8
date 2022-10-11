package com.aping.java8.stream;

import java.math.BigDecimal;

/**
 * <p>
 * ToBigDecimalFunction
 * </p>
 *
 * @author Aping
 * @since 2022/10/10 21:37
 */
@FunctionalInterface
public interface ToBigDecimalFunction<T> {

    BigDecimal applyAsBigDecimal(T value);
}
