package metier;

public class Compte {
	private int code; private double solde;
	public Compte() { }
	public void verser(double mt){
		solde+=mt; 
		}
	public void retirer(double mt){ 
		solde-=mt; 
		}
	public void virement(Compte cp2,double mt){
	this.retirer(mt);
	cp2.verser(mt);
	}
	public int getCode() { 
		return code; 
		}
	public void setCode(int code) { 
		this.code = code; 
		}
	public double getSolde() {
		return solde; 
		}
	@Override
	public String toString() { return "Compte [code=" + code + ", solde=" +
	solde + "]";
	}

}
