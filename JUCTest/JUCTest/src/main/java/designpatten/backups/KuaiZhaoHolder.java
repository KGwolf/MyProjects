package designpatten.backups;

import java.util.Stack;

/**
 * @ClassName: KuaiZhaoHolder
 * @Description: 快照操作类
 * 包含一个栈结构，来容纳所有版本的快照，跟List一样嘛
 * @Author: xiahaitao
 * @Date: 2024/2/2 11:26
 * @Version: V1.0
 */
public class KuaiZhaoHolder<T> {
    Stack<T> stack = new Stack<>();

    public void addKuaiZhao(T kuaiZhao) {
        stack.push(kuaiZhao);
    }

    public T popKuaiZhao() {
       return stack.pop();
    }
}
