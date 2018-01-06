class Undefine{
    public static void main(String[] a){
		System.out.println(new A().f());
    }
}
class A{
	public int func() {
		return a;
	}
}
class B extends A{
	int a;
	public int f() {
		return a;
	}
}
class D extends C{}

