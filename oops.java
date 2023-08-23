class A{    // encapsulation implemented	
    
    private String name;    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;    // this refrence 
    }
    
}

interface C{   // interface
    void call();
}

class D implements C{
    public void call(){
        System.out.println("interface called");
    }
}

class Maths{        //overloading(compile time polymorphism)
    
    static int add(int a , int b){
        return a+b;
    }
    
    static double add(double a, double b){
        return a+b;
    }
}

class Parent{
    void show(){
        System.out.println("parent class");  //overriding(runtime polymorphism)
    }
}

class Child extends Parent{    //inheritance
    void show(){
        System.out.println("child class");
    }
}

class Main{

    public static void main(String[] args){
        
        A a =new A();
        a.setName("shreyansh");
        System.out.println("name: "+a.getName());
        
        
        System.out.println(Maths.add(2,3));
        System.out.println(Maths.add(2.2,3.3));
        
        
        Parent p=new Parent();
        p.show();
        Parent c=new Child();
        c.show();
        
        D inter =new D();
        inter.call();
        
        
    }
}

