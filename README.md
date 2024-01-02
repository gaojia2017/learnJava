# java 网络变成中的反射应用
> 根据[c语言中文网](https://c.biancheng.net/view/1115.html)实现

## 功能
客户端调用后端的方法，并得到相应

## 流程
![image](https://github.com/gaojia2017/learnJava/assets/34051249/fb176354-11be-4c77-920d-e7dd2a903de8)

* 客户端 SimpleClient 类的主要作用是建立与服务器的连接，然后将带有调用信息的 Call 对象发送到服务器端。
* 服务器端 SimpleServer 类在收到调用请求之后会使用反射机制动态调用指定对象的指定方法，再将执行结果返回给客户端

## 新增功能
* 如果服务器端未创建相应对象，则动态创建

## 运行
* 先run 服务器的main程序，再run 客户端的main程序
