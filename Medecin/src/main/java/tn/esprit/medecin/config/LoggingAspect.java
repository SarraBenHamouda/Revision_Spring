package tn.esprit.medecin.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.*;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger l = LogManager.getLogger(LoggingAspect.class);

    @After("execution(* tn.esprit.medecin.service.ServiceExamenImpl.add*(..))")
    public void logMethodeExist(JoinPoint joinPoint) {
        l.info("After method executed: " + joinPoint.getSignature());
    }

    @Before("execution(* tn.esprit.medecin.service.ServiceExamenImpl.add*(..))")
    public void logMethodeExistBefore(JoinPoint joinPoint) {
        l.info("Before method execution: " + joinPoint.getSignature());
    }

    @Around("execution(* tn.esprit.medecin.service.ServiceExamenImpl.add*(..))")
    public Object logMethodeExistAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        l.info("Around method execution took: " + (end - start) + "ms for method: "
                + proceedingJoinPoint.getSignature());
        return obj;
    }
}
