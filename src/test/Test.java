package test;

import metier.Compte;

public class Test {
	public Test() {
		Compte cp1=new Compte();
		Compte cp2=new Compte();
		cp1.setCode(1); 
		cp1.verser(800); 
		cp1.retirer(9000);
		cp2.setCode(2);
		cp1.virement(cp2, 9000);
		System.out.println(cp1.toString());
		System.out.println(cp2.toString());
		}
		public static void main(String[] args) { new Test(); }

}
