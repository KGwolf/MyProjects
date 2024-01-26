package designpatten.birdge;
/**
 * @ClassName: NotifyDoctor
 * @Description: 通知医生类，面向过程的写法，也是我们开发中常用的
 * 通知类型，警示级别。  不同的警示级别给出不同的通知类型
 * 这种写法很简单，也有很多问题：
 * 1.违反了单一职责原则，每个通知的方法，其实比较复杂的，比如调用微信接口。
 * 2.违反了开闭原则，增加1个类型需要修改这个代码。
 * 3.强耦合，警告类型和通知类型强耦合。
 * 重构:
 * 1.针对可能扩展的、有变化的点抽象出来接口：INotifyWays、IWarningType
 * @Author: xiahaitao
 * @Date: 2024/1/25 9:46
 * @Version: V1.0
 */
public class NotifyDoctor {
    public void notify(int warningType){//String notifyType,
        if (warningType == 1){
            //黑灯 微信通知
            weiXinNotify();
        }else if (warningType == 2){
            //红灯  邮箱通知
            youXiangNotify();
        }else if (warningType == 3){
            //橙灯  his通知
            hisNotify();
        }else if (warningType == 4){
            //黄灯   pr的im通知
            prImNotify();
        }
    }
    private void weiXinNotify(){
        System.out.println("微信通知");
    }
    private void youXiangNotify(){
        System.out.println("邮箱通知");
    }
    private void hisNotify(){
        System.out.println("his通知");
    }
    private void prImNotify(){
        System.out.println("pr的im通知");
    }
}
