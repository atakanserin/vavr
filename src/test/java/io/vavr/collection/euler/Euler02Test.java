/* ____  ______________  ________________________  __________
 * \   \/   /      \   \/   /   __/   /      \   \/   /      \
 *  \______/___/\___\______/___/_____/___/\___\______/___/\___\
 *
 * Copyright 2023 Vavr, https://vavr.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vavr.collection.euler;

import org.junit.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class Euler02Test {

    /**
     * <strong>Problem 2: Even Fibonacci numbers</strong>
     * <p>
     * Each new term in the Fibonacci sequence is generated by adding the previous
     * two terms. By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5,
     * 8, 13, 21, 34, 55, 89, ...
     * <p>
     * By considering the terms in the Fibonacci sequence whose values do not exceed
     * four million, find the sum of the even-valued terms.
     * <p>
     * See also <a href="https://projecteuler.net/problem=2">projecteuler.net problem 2</a>.
     */
    @Test
    public void shouldSolveProblem2() {
        assertThat(sumOfEvenFibonacciValuesNotExceeding(90)).isEqualTo(2 + 8 + 34);
        assertThat(sumOfEvenFibonacciValuesNotExceeding(4_000_000)).isEqualTo(4_613_732);
    }

    private static long sumOfEvenFibonacciValuesNotExceeding(final int max) {
        return Utils.fibonacci()
                .map(BigInteger::longValue)
                .takeWhile(f -> f <= max)
                .filter(f -> f % 2 == 0)
                .sum().longValue();
    }
}
