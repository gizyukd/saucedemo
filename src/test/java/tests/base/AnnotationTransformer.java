package tests.base;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//класс который позволяет вместо написания в аннотациях для каждого тестового метода отдельно какого-то параметра (например, retryAnalyzer-а) повесить сразу его на все методы за один раз
//заработает, когда добавим тэг listeners в xml с конфигами testng (в данном проекте находится в regression.xml)
public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(Retry.class);  // эта строчка как раз и повесит параметр retry на все тестовые методы
    }

}