package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import java.util.Scanner;

@Aspect
public class SecurityAspect {
    private String login;
    private String pass;

    // Définition du pointcut
    @Around("execution(* *..main(..))") // Pointcut correspondant à toutes les méthodes `main`
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
        if (login == null) {
            Scanner clavier = new Scanner(System.in);
            System.out.print("Login: ");
            String l = clavier.next();
            System.out.print("Pass: ");
            String p = clavier.next();

            if (l.equals("root") && p.equals("root")) {
                login = l;
                pass = p;
                // Exécution de la méthode interceptée
                return joinPoint.proceed();
            } else {
                System.out.println("Accès refusé");
                return null;
            }
        } else {
            // Si déjà authentifié, procéder à l'exécution
            return joinPoint.proceed();
        }
    }
}
