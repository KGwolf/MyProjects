package designpatten.strategy;

import java.util.HashMap;

/**
 * @ClassName: MySortStrategyFactory
 * @Description: 策略类的工厂，生产类。
 * 1.无状态的类工厂，可以用静态工厂+hashmap
 * 2.有状态的类工厂，只能new 对象，但是又会出现if else，解决办法：反射创建类
 * @Author: xiahaitao
 * @Date: 2024/1/29 16:49
 * @Version: V1.0
 */
public class MySortStrategyFactory {
    private static final HashMap<String,IStrategy> strategyHashMap = new HashMap<>();
    static {
        strategyHashMap.put("quick",new QuicklySortStrategy());
        strategyHashMap.put("out",new OutSortStrategy());
        strategyHashMap.put("concurrent",new ConcurrentSortStrategy());
        strategyHashMap.put("mapreduce",new MapReduceSortStrategy());
    }

    public static IStrategy createStrategy(String type){
       return strategyHashMap.get(type);
    }
}
