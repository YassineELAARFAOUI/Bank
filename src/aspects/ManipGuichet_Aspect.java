package aspects;

import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ManipGuichet_Aspect {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private long t1, t2;

    @Before("call(* metier.Compte.*(..))")
    public void avant(JoinPoint thisJoinPoint) {
        t1 = System.currentTimeMillis();
        logger.info(() -> "*************************\nAvant " + thisJoinPoint.getSignature());
    }

    @After("call(* metier.Compte.*(..))")
    public void apres(JoinPoint thisJoinPoint) {
        t2 = System.currentTimeMillis();
        logger.info(() -> "*************************\nAprès " + thisJoinPoint.getSignature() +
                          "\nDurée d'exécution=" + (t2 - t1) + "ms");
    }
}
