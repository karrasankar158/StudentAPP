package com.in.dummy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
public class StudentAppCheckTest {

	@Test
	public void testToAccessPrivateFieldsMethodsAndConstrctor() throws Exception {
		Constructor<StudentAppCheck> constructor=
				StudentAppCheck.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		StudentAppCheck studentAppCheck=constructor.newInstance();
		Assertions.assertNotNull(studentAppCheck);
		
		Field field=StudentAppCheck.class.getDeclaredField("name");//Accessing field.
		field.setAccessible(true);
		field.set(studentAppCheck, "Sankar");
		String name=(String)field.get(studentAppCheck);
		Assertions.assertNotNull(name);
		
		Method method=StudentAppCheck.class.getDeclaredMethod("getNumber", Integer.class);
		method.setAccessible(true);
		Integer number=(Integer)method.invoke(studentAppCheck,100);
		Assertions.assertNotNull(number);
		
		ReflectionTestUtils.setField(studentAppCheck, "name", "Hello");
		String name1=(String)ReflectionTestUtils.getField(studentAppCheck, "name");
		System.out.println(name1);
		
		Integer response=(Integer)ReflectionTestUtils.invokeMethod(studentAppCheck, "getNumber", 10);
		System.out.println(response);
	}
}
