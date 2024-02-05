package designpatten.command;

/**
 * @ClassName: ReadDataBase
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/2/2 14:53
 * @Version: V1.0
 */
public class ReadDataBase implements ICommand{
    @Override
    public void excute() {
        System.out.println("从数据库读取信息。");
    }
}
