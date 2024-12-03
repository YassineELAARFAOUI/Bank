package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import metier.Compte;

@Aspect
public class SoldeSuffisant_Aspect {
	@Pointcut("call(* metier.Compte.retirer(..)) && args(mt)")
	public void pathPointCut(double mt,ProceedingJoinPoint pjp){}
	@Around("pathPointCut(mt,pjp)")
	public void patch(double mt,JoinPoint joinPoint,ProceedingJoinPoint pjp){
	Compte compte=(Compte)joinPoint.getTarget();
	if(compte.getSolde()>mt){
	try {
	pjp.proceed(new Object[]{mt});
	} catch (Throwable e) {
	e.printStackTrace();
	}
	}
	else{
	throw new RuntimeException("Solde insuffisant [mt="+mt+"Solde="+compte.getSolde()+"]");
	}
	}
}
