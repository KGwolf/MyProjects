package com.xht.distributeuqid.simpleuqid;

/**
 * @ClassName: IdGenerator
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/19 13:43
 * @Version: V1.0
 */
public class IdGenerator {
    private static Sequence WORKER = new Sequence();

    public static long getId() {
        return WORKER.nextId();
    }

    public static String getIdStr() {
        return String.valueOf(WORKER.nextId());
    }

    private IdGenerator() {
    }
}
