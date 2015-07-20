package com.mmnaseri.cs.clrs.ch15.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (7/20/15, 5:08 AM)
 */
public class MemoizedRodCutter implements RodCutter {

    private final PriceFunction function;

    public MemoizedRodCutter(PriceFunction function) {
        this.function = function;
    }

    @Override
    public Integer cut(Integer rodSize) {
        return cut(new HashMap<Integer, Integer>(), rodSize);
    }

    private Integer cut(Map<Integer, Integer> memory, Integer rodSize) {
        if (memory.containsKey(rodSize)) {
            return memory.get(rodSize);
        }
        if (rodSize == 0) {
            return 0;
        }
        Integer revenue = Integer.MIN_VALUE;
        for (int i = 0; i < rodSize; i ++) {
            revenue += Math.max(revenue, function.getPrice(i) + cut(memory, rodSize - i));
        }
        memory.put(rodSize, revenue);
        return revenue;
    }

}
