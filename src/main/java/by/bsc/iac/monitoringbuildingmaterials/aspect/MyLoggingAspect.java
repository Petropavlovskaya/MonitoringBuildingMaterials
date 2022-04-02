package by.bsc.iac.monitoringbuildingmaterials.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
@Aspect
public class MyLoggingAspect {
//    private static final Logger APP_LOGGER = LoggerFactory.getLogger(MyLoggingAspect.class);
//    private static final Logger APP_LOGGER = LoggerFactory.getLogger(MyLoggingAspect.class);
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

    @Pointcut("execution(* by.bsc.iac.monitoringbuildingmaterials.controller.MainController.*(..))")
    private void allMethodsFromMainController() {
    }

    @Pointcut("execution(* by.bsc.iac.monitoringbuildingmaterials.controller.ReferenceBookController.*(..))")
    private void allMethodsFromReferenceBookController() {
    }

    @Pointcut("execution(* by.bsc.iac.monitoringbuildingmaterials.controller.PageController.*(..))")
    private void allMethodsFromPageController() {
    }

    @Pointcut("allMethodsFromMainController() || allMethodsFromReferenceBookController() " +
            "|| allMethodsFromPageController()")
    private void allMethodsFromAnyController() {
    }

    @Before("allMethodsFromAnyController()")
    public void beforeMainControllerMethodsAdvice(JoinPoint joinPoint) {
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        log.info("User " + username + " is calling method: "
                + joinPoint.getSignature().getName() + " from class: " + joinPoint.getSignature().getDeclaringTypeName());

/*        APP_LOGGER.info(DATE_FORMATTER.format(new Date()) + " User " + username + " is calling method: "
                + joinPoint.getSignature().getName() + " from class: " + joinPoint.getSignature().getDeclaringTypeName());*/
/*        System.out.println("getClass() - " + joinPoint.getClass()); // class org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint
        System.out.println("getArgs() - " + joinPoint.getArgs());   // [Ljava.lang.Object;@3bddeada
        System.out.println("getKind() - " + joinPoint.getKind());   //method-execution
        System.out.println("getSignature() - " + joinPoint.getSignature()); //String by.bsc.iac.monitoringbuildingmaterials.controller.MainController.mainPage()
        System.out.println("getSourceLocation() - " + joinPoint.getSourceLocation());   //org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint$SourceLocationImpl@720047f5
        System.out.println("getStaticPart() - " + joinPoint.getStaticPart());   // execution(String by.bsc.iac.monitoringbuildingmaterials.controller.MainController.mainPage())
        System.out.println("getTarget() - " + joinPoint.getTarget());   // by.bsc.iac.monitoringbuildingmaterials.controller.MainController@57a982f9*/

    }


}
