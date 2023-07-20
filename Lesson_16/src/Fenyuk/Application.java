package Fenyuk;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Application {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException,
	InvocationTargetException, NoSuchFieldException, ClassNotFoundException {
		
		// min
		
		Class stc = Student.class;
		
		String nameOfClass = stc.getName();
		System.out.println("Name of class = " + nameOfClass);
		
		String simpleName = stc.getSimpleName();
		System.out.println("Simple name of class = " + simpleName);
		
		int modifier = stc.getModifiers();
		String modifierText = Modifier.toString(modifier);
		System.out.println("Class modifier = " + modifierText + " int = " + modifier);
		
		System.out.println("Is static = " + Modifier.isStatic(modifier));
		System.out.println("Is public = " + Modifier.isPublic(modifier));
		System.out.println("Is abstract = " + Modifier.isAbstract(modifier));
		
		Package classPackage = stc.getPackage();
		System.out.println("Package of curent class = " + classPackage);
		
		Class superClass = stc.getSuperclass();
		System.out.println("Super class = " + superClass);
		
		Class[] interfaces = stc.getInterfaces();
		System.out.println("Interfaces = " + Arrays.toString(interfaces));
		
		Constructor<Student>[] studentConstructor = stc.getConstructors();
		
		for (int i = 0; i < studentConstructor.length; i++) {
			Constructor<Student> constructor = studentConstructor[i];
			System.out.println("Constructor = " + constructor);
		}

		System.out.println("Constructor length = " + studentConstructor.length);
		
		System.out.println();

		Constructor<Student> constructor = studentConstructor[0];
		
		Class<?>[] parameterTypes = constructor.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			Class<?> class1 = parameterTypes[i];
			System.out.println("Type of parameters = " + class1);
		}
		
		System.out.println();
		
		Field[] fields = stc.getDeclaredFields();
		for(int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println("Fields of constructor" + field);
		}
		
		System.out.println();
		
	    fields = stc.getFields();
		for(int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println("Public fields of constructor" + field);
		}
		
		System.out.println();
	
		
		// max
		
		Constructor<Student> singleConstructor = stc.getConstructor(String.class,int.class,double.class);
		System.out.println("Single constructor = " + singleConstructor);
		
		System.out.println();
		
		Student newInstanceStudent = singleConstructor.newInstance("Peter",25,150.2);
		System.out.println("Reflection Student = " + newInstanceStudent);
		
		System.out.println();
		
		Field nameField = stc.getField("name");
		nameField.set(newInstanceStudent, "Bob");
		System.out.println("Student new name - " + newInstanceStudent);
		
        System.out.println();
		
        Method [] methods = stc.getMethods();
        for (int i = 0; i < methods.length; i++) {
        	Method method = methods[i];
        	System.out.println("Methods of class Student = " + method);
        }
		
		System.out.println();
		
	    try {
	    	Class<Student> classStudent = Student.class;
	    	Method methodStud = classStudent.getMethod("changeOfCourse", new Class[] {String.class, int.class});
	    	
	    	Student changeOfCourseStud = classStudent.newInstance();
	    	
	    	methodStud.invoke(changeOfCourseStud, "Peter", 2);	
	    }
	    catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException |
	    		InvocationTargetException  e) {
	       e.printStackTrace();
	    }
	    
	    System.out.println();
	    
	    try {
	    	Class<?> classSt = Class.forName("Fenyuk.Student");
	    	Method methodSt = classSt.getDeclaredMethod("studentChangeOfCourse", String.class);
	    	methodSt.setAccessible(true);
	    	Object object = methodSt.invoke(new Student(), "Wolkov");
	    }
	    catch (NoSuchMethodException | SecurityException | IllegalArgumentException | ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    
	    
	}

}
