package reflectDemo;

import java.io.Serializable;
import java.lang.Class;
import java.lang.Object;
/**
 *
 * @author  gao
 * @createDate 2023/12/28
 * @description pacakge the method information that service need.
 */
public class Call implements Serializable {
    private static final long serialVersionUID = 6659953547331194808L;

    private String className;
    private String methodName;
    private Class[] paramTypes;
    private Object[] params;

    //the execution result of method.
    //if method success, return result. If fail, return exception
    private Object result;

    public Call() {}

    public Call(String className, String methodName, Class[] paramTypes, Object[] params) {
        this.className = className;
        this.methodName = methodName;
        this.params = params;
        this.paramTypes = paramTypes;
    }

    public String getClassName(){
        return this.className;
    }


    public void setClassName(String className) {
        this.className = className;
    }
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public Class[] getParamTypes() {
        return paramTypes;
    }
    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }
    public Object[] getParams() {
        return params;
    }
    public void setParams(Object[] params) {
        this.params = params;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }
    public String toString() {
        return "className=" + className + "methodName=" + methodName;
    }

}
