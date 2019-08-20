package com.xing.design.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Person{
    void doSomeThing();
    void doSomeThingElse(String arg);
}
interface Person2{
    void run();
}

class Peter implements Person{
    @Override
    public void doSomeThing() {
        System.out.println("Peter likes fishing!");
    }

    @Override
    public void doSomeThingElse(String arg) {
        System.out.println("Peter else likes swimming!"+arg);
    }
}
class Peter2 implements Person2{
    @Override
    public void run() {
        System.out.println("Peter2 likes run!");
    }
}
class David implements Person{

    @Override
    public void doSomeThing() {
        System.out.println("David likes fishing!");
    }

    @Override
    public void doSomeThingElse(String arg) {
        System.out.println("David else likes swimming!"+arg);
    }
}

//class Merry implements Person{
//
//    @Override
//    public void doSomeThing() {
//        System.out.println("Merry likes dancing!");
//    }
//    @Override
//    public void doSomeThingElse(String arg) {
//        System.out.println("Merry else likes watching movies!"+arg);
//
//    }
//}
/**
 * 静态代理类
 **/
class Lucy implements Person{
    private Person person;
    public Lucy(Person person){
        this.person=person;
    }
    public void getPerson(Person person){
        this.person=person;
    }
    @Override
    public void doSomeThing() {
        System.out.println("Lucy代理:"+this.person);
        this.person.doSomeThing();
    }
    @Override
    public void doSomeThingElse(String arg) {
        System.out.println("Lucy代理："+this.person);
        this.person.doSomeThingElse(arg);
    }
}

/*
 * 动态代理类
 */
class Maria implements InvocationHandler{
    private Object person;
    public Maria(Object person){
        this.person=person;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("Maria代理:"+this.person);
//        System.out.println("person:"+person.getClass()+ "\nmethod:"+method+"\nargs"+args);
        if(args!=null){
            for(Object arg:args){
                System.out.println("arg："+arg);
            }
        }
        return method.invoke(person, args);
    }
}

public class Afgency{
    public static void doWork(Person person){
        person.doSomeThing();
        System.out.println("***");
        person.doSomeThingElse("doSomeThingElse");
    }
    public static void doWork2(Person2 person){
        person.run();
        System.out.println("***");
    }
    public static void main(String [] args){
        //静态代理
        doWork(new Lucy(new Peter()));
        doWork(new Lucy(new David()));
//        doWork(new Lucy(new Peter2()));
        System.out.println("-----------------------------------------");
        //动态代理
        Person person=(Person)Proxy.newProxyInstance(Person.class.getClassLoader()
                , new Class[]{Person.class}, new Maria(new Peter()));
        doWork(person);
        person=(Person)Proxy.newProxyInstance(Person.class.getClassLoader()
                , new Class[]{Person.class}, new Maria(new David()));
        doWork(person);
        Person2 person2=(Person2)Proxy.newProxyInstance(Person.class.getClassLoader()
                , new Class[]{Person2.class}, new Maria(new Peter2()));
        doWork2(person2);

    }
}
