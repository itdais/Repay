package com.itdais.repay.app.function;

/**
 * @描述
 * @作者 丁军伟
 * @时间 2017/10/23
 */
public abstract class FunctionWithParam<Param> extends Function {
    public FunctionWithParam(String functionName) {
        super(functionName);
    }

    public abstract void function(Param param);
}
