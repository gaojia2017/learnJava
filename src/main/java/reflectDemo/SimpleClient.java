package reflectDemo;

import java.io.*;
import  java.net.*;
import  java.util.*;
import  java.lang.reflect.*;

public class SimpleClient {
    public void invoke() throws Exception {
        Socket socket = new Socket("localhost", 8000);
        System.out.println("客户端连接");
        OutputStream out = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        InputStream in = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(in);

        //create a remote process object
        Call call = new Call("HelloService", "echo", new Class[] {String.class}, new Object[] {"java"});
        //send the call object to service
        oos.writeObject(call);
        //receive the call object including the result
        call = (Call) ois.readObject();
        System.out.println(call.getResult());
        ois.close();
        oos.close();
        socket.close();
    }

    public static void main(String[] args) throws Exception{
        new SimpleClient().invoke();
    }
}
