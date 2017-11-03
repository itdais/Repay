package com.itdais.repay.app.function;

/**
 * @描述
 * @作者 丁军伟
 * @时间 2017/10/23
 */
public abstract class FunctionWithResult<Result> extends Function {

    public FunctionWithResult(String functionName) {
        super(functionName);
    }

    public abstract Result function();
}
