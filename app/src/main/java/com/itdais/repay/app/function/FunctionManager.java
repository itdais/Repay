package com.itdais.repay.app.function;

import android.text.TextUtils;

import java.util.HashMap;

/**
 * @描述  Fragment 通信框架
 * @作者 丁军伟
 * @时间 2017/10/20
 */
public class FunctionManager {
    HashMap<String, FunctionNoParamAndResult> mFunctionNoParamAndResultMap;
    HashMap<String, FunctionWithParam> mFunctionWithParamMap;
    HashMap<String, FunctionWithResult> mFunctionWithResultMap;
    HashMap<String, FunctionWithParamAndResult> mFunctionWithParamAndResultMap;

    private static FunctionManager instance = null;

    private FunctionManager(){
    }

    public static FunctionManager getInstance() {
        if (instance == null) {
            synchronized (FunctionManager.class) {
                if (instance == null) {
                    instance = new FunctionManager();
                }
            }
        }
        return instance;
    }

    /**
     * 添加无参无返回的Function
     *
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionNoParamAndResult function) {
        if (null != function) {
            if (null == mFunctionNoParamAndResultMap) {
                mFunctionNoParamAndResultMap = new HashMap<>(16);
            }
            mFunctionNoParamAndResultMap.put(function.functionName, function);
        }
        return this;
    }

    /**
     * 添加带参数无返回的Function
     *
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionWithParam function) {
        if (null != function) {
            if (null == mFunctionWithParamMap) {
                mFunctionWithParamMap = new HashMap<>(16);
            }
            mFunctionWithParamMap.put(function.functionName, function);
        }
        return this;
    }

    /**
     * 添加无参带返回的Function
     *
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionWithResult function) {
        if (null != function) {
            if (null == mFunctionWithParamMap) {
                mFunctionWithParamMap = new HashMap<>(16);
            }
            mFunctionWithResultMap.put(function.functionName, function);
        }
        return this;
    }

    /**
     * 添加带参数带返回的Function
     *
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionWithParamAndResult function) {
        if (null != function) {
            if (null == mFunctionWithParamMap) {
                mFunctionWithParamMap = new HashMap<>(16);
            }
            mFunctionWithParamAndResultMap.put(function.functionName, function);
        }
        return this;
    }

    /**
     * 根据函数名，回调无参无返回值的函数
     *
     * @param functionName
     */
    public void invokeFunc(String functionName) throws NoFunctionException {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }

        if (mFunctionNoParamAndResultMap != null) {
            FunctionNoParamAndResult func = mFunctionNoParamAndResultMap.get(functionName);
            if (func != null) {
                func.function();
            } else {
                throw new NoFunctionException("has no Function：" + functionName + " found in  FunctionNoParamNoResultMap");
            }
        }
    }

    /**
     * 调用具有参数的函数
     *
     * @param functionName
     * @param param
     * @param <Param>
     */
    public <Param> void invokeFunc(String functionName, Param param) throws NoFunctionException {
        FunctionWithParam f = null;
        if (mFunctionWithParamMap != null) {
            f = mFunctionWithParamMap.get(functionName);
            if (f != null) {
                f.function(param);
            } else {
                throw new NoFunctionException("has no Function：" + functionName + " found in  FunctionNoParamNoResultMap");
            }
        }
    }

    /**
     * 根据函数名，回调无参有返回值的函数
     *
     * @param functionName
     */
    public <Result> Result invokeFuncWithResult(String functionName, Class<Result> c) throws NoFunctionException {
        if (mFunctionWithResultMap != null) {
            FunctionWithResult func = mFunctionWithResultMap.get(functionName);
            if (func != null) {
                if (c != null) {
                    return c.cast(func.function());
                } else {
                    return (Result) func.function();
                }
            } else {
                throw new NoFunctionException("has no Function：" + functionName + " found in  FunctionNoParamNoResultMap");
            }
        }
        return null;
    }

    /**
     * 调用具有参数，同时具有返回值的函数
     * @param functionName
     * @param param
     * @param <Result>
     * @param <Param>
     * @return
     */
    public <Result,Param> Result invokeFuncWithResult(String functionName,Param param,Class<Result> c) throws NoFunctionException {
        FunctionWithParamAndResult f = null;
        if(mFunctionWithParamAndResultMap != null){
            f = mFunctionWithParamAndResultMap.get(functionName);
            if(f != null){
                if(c != null){
                    return c.cast(f.function(param));
                }else{
                    return (Result)f.function(param);
                }
            }
        }
        if( f == null){
            throw new NoFunctionException("has no Function：" + functionName + " found in  FunctionNoParamNoResultMap");
        }
        return null;
    }

}
