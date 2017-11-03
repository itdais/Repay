package com.itdais.repay.app.function;

/**
 * @描述
 * @作者 丁军伟
 * @时间 2017/10/23
 */
public abstract class FunctionWithParamAndResult<Param, Result> extends Function {

    public FunctionWithParamAndResult(String functionName) {
        super(functionName);
    }

    public abstract Result function(Param param);
}
