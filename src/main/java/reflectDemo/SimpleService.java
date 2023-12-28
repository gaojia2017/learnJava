package reflectDemo;

import com.sun.jdi.ClassType;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.reflect.*;
public class SimpleService {
    private Map remoteObjects = new HashMap(); //save the buffer of remote object

    public void register(String className, Object remoteObject){
        remoteObjects.put(className, remoteObject);
    }

    public void service() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("服务器启动");

        while(true){
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(in);
            OutputStream out = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            Call call = (Call) ois.readObject();
            System.out.println(call);
            call = invoke(call);
            oos.writeObject(call);
            ois.close();
            oos.close();
            socket.close();
        }
    }

    public Call invoke(Call call){
        Object result = null;
        try{
            String className = call.getClassName();
            String methodName = call.getMethodName();
            Object[] params = call.getParams();
            Class[] paramTypes = call.getParamTypes();;

            Class classType = Class.forName(className);
            Method method = classType.getMethod(methodName, paramTypes);
            Object remoteObject = remoteObjects.get(className);
            if(remoteObject == null){
                //throw new Exception(className + "的远程对象不存在");
                //create new object
                Constructor[] declaredContructors = classType.getDeclaredConstructors();
                if(declaredContructors.length > 0){
                    Constructor con = declaredContructors[0];
                    remoteObject = con.newInstance();
                    remoteObjects.put(className, remoteObject);
                }
            }

                result = method.invoke(remoteObject, params);

        }catch (Exception e){
            result = e;
        }
        call.setResult(result);
        return call;
    }
    public static void main(String[] args) throws Exception {
        SimpleService server = new SimpleService();

        //server.register("HelloService", new HelloServiceImpl());
        server.service();
    }
}
