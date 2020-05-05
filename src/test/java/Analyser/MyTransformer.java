package Analyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyTransformer implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation annotation, Class testclass, Constructor constructor, Method testMothod) {
		
		annotation.setRetryAnalyzer(RetryAnalyser.class);
	}

}
