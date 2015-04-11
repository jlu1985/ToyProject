package jl.playground.java8.methodreference;

import java.util.function.Supplier;

public class MethodReference {
    
    public static void main(String[] args) {
        ClassA a = new ClassA();
        System.out.println(a.doWork(()-> "hello lambda"));
        
        System.out.println(a.doWork(ClassB::doWork));
        
       System.out.println(a.doWorkWithString(ClassB::changeToLower));
    }
    
}
interface SomeInterface {
    public String changeString(String a);
}
class ClassA {
    public <T> T doWork (Supplier<T> s){
        return s.get();
    }
    
    public String doWorkWithString(SomeInterface i){
        return i.changeString("STRING FROM CLASS A IN ALL CAPS");
    }
}

class ClassB {
    public static String doWork(){
        return "hello reference";
    }
    
    public static String changeToLower(String s){
        return s.toLowerCase();
    }
}
