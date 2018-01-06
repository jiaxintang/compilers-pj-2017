class ExtendsMethods{
    public static void main(String[] a){
		System.out.println(new test().test());
    }
}
class A{
	public int f(){
		return 1;
	}
}
class B extends A{}
class C extends B{}
class D{}
class E extends D{
	public int f(){
		return 1;
	}
}
class test {
	public int test(){
		System.out.println(new A().f());
		System.out.println(new B().f());
		System.out.println(new C().f());
		System.out.println(new D().f());
		System.out.println(new E().f());
		return 1;
	}

}

