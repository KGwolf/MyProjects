package designpatten.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MySortNew
 * @Description: 优化后的排序类
 * @Author: xiahaitao
 * @Date: 2024/1/29 16:57
 * @Version: V1.0
 */
public class MySortNew {
    private final static List<AllRange> listRange = new ArrayList<>();
    static {
        listRange.add(new AllRange(0,10,MySortStrategyFactory.createStrategy("quick")));
        listRange.add(new AllRange(11,100,MySortStrategyFactory.createStrategy("out")));
        listRange.add(new AllRange(101,1000,MySortStrategyFactory.createStrategy("concurrent")));
        listRange.add(new AllRange(1001,10000,MySortStrategyFactory.createStrategy("mapreduce")));

    }
    public static void mySortOld(int fileSize){
        IStrategy strategy = null;

        //使用里面也可以用静态代码块+List的方式来消除if else。
        for (AllRange range:
                listRange) {
            if (fileSize>= range.low && fileSize <= range.height){
                strategy = range.strategy;
                break;
            }
        }

//        if (fileSize <= 10){
//            //文件小于10M，快速排序
//            MySortStrategyFactory.createStrategy("quick");
//        }else if(fileSize > 10 && fileSize <= 100){
//            //文件大于10M，小于100M，外部排序
//            MySortStrategyFactory.createStrategy("out");
//        }else if(fileSize > 100 && fileSize <= 1000){
//            //文件大于100M，小于1000M，并发排序
//            MySortStrategyFactory.createStrategy("concurrent");
//        }else if(fileSize > 1000 && fileSize <= 10000){
//            //文件大于1000M，小于10000M，MapReduce排序
//            MySortStrategyFactory.createStrategy("mapreduce");
//        }

        strategy.sortStrategy();
    }

    public static void main(String[] args) {
        //这里使用1011，可以用配置的方式来解耦。。。。
        MySortNew.mySortOld(1011);
    }
}
