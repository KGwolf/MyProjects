package com.xht.distributeuqid.leaf.leafcore.common;

import com.xht.distributeuqid.leaf.leafcore.IDGen;

public class ZeroIDGen implements IDGen {
    @Override
    public Result get(String key) {
        return new Result(0, Status.SUCCESS);
    }

    @Override
    public boolean init() {
        return true;
    }
}
