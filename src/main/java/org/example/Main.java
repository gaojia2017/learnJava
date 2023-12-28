//package org.example;
//
//import java.lang.reflect.*;
//import java.util.*;
//import java.lang.Class.*;
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        try {
//            // 动态加载xx类的运行时对象
//            Class c = Class.forName("java.lang.String");
//            // 获取成员方法集合
//            Method[] methods = c.getDeclaredMethods();
//            // 遍历成员方法集合
//            for (Method method : methods) {
//                // 打印权限修饰符，如public、protected、private
//                System.out.print(Modifier.toString(method.getModifiers()));
//                // 打印返回值类型名称
//                System.out.print(" " + method.getReturnType().getName() + " ");
//                // 打印方法名称
//                System.out.println(method.getName() + "();");
//            }
//        } catch (ClassNotFoundException e) {
//            System.out.println("找不到指定类");
//        }
//    }
//}