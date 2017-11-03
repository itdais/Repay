package com.itdais.repay.app.function;

/**
 * @描述
 * @作者 丁军伟
 * @时间 2017/10/23
 */
public abstract class FunctionNoParamAndResult extends Function {

    public FunctionNoParamAndResult(String functionName) {
        super(functionName);
    }

    public abstract void function();
}
