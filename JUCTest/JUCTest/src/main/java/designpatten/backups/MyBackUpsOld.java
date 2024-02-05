package designpatten.backups;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MyBackUps
 * @Description: 备忘录模式，不用模式实现文本的撤销功能
 * 这里是针对某一个场景，文本框的撤销场景，针对String类型的。
 * 那么其它呢，比如某个对象的备份，int等类型的数据，每次都有修改其中的字段值，怎么存？
 * @Author: xiahaitao
 * @Date: 2024/2/2 10:41
 * @Version: V1.0
 */
public class MyBackUpsOld {
    private int addPrevIndex;
    private int addAfterIndex;

    private StringBuilder sb = new StringBuilder();

    public void add(String inputStr) {
        addPrevIndex = addAfterIndex;
        sb.append(inputStr);
        addAfterIndex += inputStr.length();
    }

    /**
     * 展示所有的
     */
    public String showAll() {
        return sb.toString();
    }

    /**
     * 这里回退了上一步的操作，显示上一步的所有信息
     * 这里特殊文本撤销可以用SB，其它的呢，对象呢？
     * 还有这里只能撤销一步，再继续撤销呢？维护一个List
     * 存每次add的字符串长度，然后Int变量记录撤销次数。
     */
    public String backOneStep() {
        return sb.substring(0, addPrevIndex);
    }
}
