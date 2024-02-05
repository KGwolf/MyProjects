package designpatten.command;

/**
 * @ClassName: MyCommandOld
 * @Description: 根据不同的命令值，去做不同的事情
 * 咋一看跟策略模式有点像，跟工厂模式也有点像。
 * 工厂：侧重于封装类的创建
 * 策略：侧重于算法，根据运行时状态从一组策略中选择不同策略。策略有相同的目的，不同的而实现。相互可替换
 * 命令：不同的目的，不同的而实现，互相之间不可以替换。
 * @Author: xiahaitao
 * @Date: 2024/2/2 14:40
 * @Version: V1.0
 */
public class MyCommandOld {

    public void excuteOld(int key){
        if (key == 1){
            //执行从去数据库查询所有的配置信息

        }else if (key == 2){
            //执行 100+100的结果
        }
    }

    public void excuteNew(int key){
        ICommand command = null;
        if (key == 1){
            command = new ReadDataBase();

        }else if (key == 2){
            command = new Caculate();
        }

        command.excute();
    }
}
