package designModel.service;

import org.junit.Test;

import java.lang.reflect.Method;

public class TestAnnotation {

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("ssss") String aaa){
    }

    @Test
    public void test() throws Exception {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method show = clazz.getMethod("show");
        MyAnnotation[] annotationsByType = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : annotationsByType) {
            System.out.println(myAnnotation.value());
        }
    }
}
