package brokerUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.theplu.controllers.ZahteviController;

import controllers.KlasifikacijaController;
import controllers.PostrojenjaController;
import controllers.TestController;

public class ReflectUtils {

	public static List<Method> getMethodsAnnotatedWith(final Class<?> type, final Class<? extends Annotation> annotation) {
	    final List<Method> methods = new ArrayList<Method>();
	    Class<?> klass = type;
	    while (klass != Object.class) { // need to iterated thought hierarchy in order to retrieve methods from above the current instance
	        // iterate though the list of methods declared in the class represented by klass variable, and add those annotated with the specified annotation
	        final List<Method> allMethods = new ArrayList<Method>(Arrays.asList(klass.getDeclaredMethods()));       
	        for (final Method method : allMethods) {
	            if (method.isAnnotationPresent(annotation)) {
	                Annotation annotInstance = method.getAnnotation(annotation);
	                // TODO process annotInstance
	                methods.add(method);
	            }
	        }
	        // move to the upper class in the hierarchy in search for more methods
	        klass = klass.getSuperclass();
	    }
	    return methods;
	}
	
	public static String getMethod(String path){
		
		List<Class<?>> klase = new LinkedList<>();
		klase.add(ZahteviController.class);
		klase.add(KlasifikacijaController.class);
		klase.add(PostrojenjaController.class);
		klase.add(TestController.class);
		
		path = path.substring(path.indexOf("/"));
		
		for(Class<?> klass:klase){
			
			
		    while (klass != Object.class) {
		        final List<Method> allMethods = new ArrayList<Method>(Arrays.asList(klass.getDeclaredMethods()));       
		        for (final Method method : allMethods) {
		            if (method.isAnnotationPresent(Path.class)) {
		                // TODO process annotInstance
		            	String test1,test2;
		            	test1 = method.getAnnotation(Path.class).value();
		       
		                if(method.getAnnotation(Path.class).value().equals(path)){
		                	if(method.isAnnotationPresent(GET.class)){
		                		
		                		return "GET";
		                		
		                	}else if(method.isAnnotationPresent(POST.class)){
		                		
		                		return "POST";
		                		
		                	}else{
		                		System.out.println("ERROR ERROR ERROR");
		                	}
		                }
		            }
		        }
		        // move to the upper class in the hierarchy in search for more methods
		        klass = klass.getSuperclass();
		    }
		}
		
		return "ERROR";
	}
	
	
}
