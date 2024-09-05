package com.andersen;

import java.lang.reflect.Field;

public class CheckNullFields {

	public static void checkNullFields(Object obj) {
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields(); // gets all declared fields

		for (Field field : fields) {
			if (field.isAnnotationPresent(NullableWarning.class)) {
				field.setAccessible(true); // allow access to private fields
				try {
					Object value = field.get(obj);
					if (value == null) {
						System.out.println("Field '" + field.getName() + "' in class '"
						+ clazz.getSimpleName() + "' is null");
					}
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
