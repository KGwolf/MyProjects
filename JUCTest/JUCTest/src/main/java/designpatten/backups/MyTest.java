package designpatten.backups;

/**
 * @ClassName: MyTest
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/2/2 11:19
 * @Version: V1.0
 */
public class MyTest {
    public static void main(String[] args) {
//        MyBackUpsOld backUpsOld = new MyBackUpsOld();
//        backUpsOld.add("123");
//        backUpsOld.add("456");
//        System.out.println(backUpsOld.showAll());
//        System.out.println(backUpsOld.backOneStep());
//        System.out.println(backUpsOld.showAll());

        KuaiZhaoHolder holder = new KuaiZhaoHolder();
        MyBackUps myBackUps = new MyBackUps();
        myBackUps.setName("x1");
        myBackUps.setAge(1);

        myBackUps.setName("x1");
        myBackUps.setAge(2);

        holder.addKuaiZhao(myBackUps.getKuaiZhao());

        myBackUps.setName("x2");
        myBackUps.setAge(3);

        holder.addKuaiZhao(myBackUps.getKuaiZhao());

        myBackUps.setName("x3");
        myBackUps.setAge(4);

        holder.addKuaiZhao(myBackUps.getKuaiZhao());
        MyBackUps t  = (MyBackUps)holder.popKuaiZhao();
        System.out.println(t.getName()+"--"+t.getAge());
    }
}
