package metier;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		try {
		Compte compte =new Compte(); 
		Scanner clavier=new Scanner(System.in);
		System.out.print("Code :"); 
		int code=clavier.nextInt();
		compte.setCode(code);
		while(true){
		System.out.print("Montant à verser :");
		double mt1=clavier.nextDouble();
		compte.verser(mt1);
		System.out.println(compte.toString());
		System.out.print("Montant à Retirer :");
		double mt2=clavier.nextDouble();
		compte.retirer(mt2);
		System.out.println(compte.toString());
		}}
		catch (Exception e) {
		System.out.println(e.getMessage());
		}}

}
