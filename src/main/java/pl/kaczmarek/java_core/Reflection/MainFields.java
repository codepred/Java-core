package pl.kaczmarek.java_core.Reflection;

import java.lang.reflect.Field;

public class MainFields {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {

        User user = new User();
        user.firstName = "Jan";
        user.setLastName("Kowalski");

        Class<? extends User> userClass = user.getClass();

        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(user);
            System.out.println(field.getName() + " ->" + value);
        }

        Field age = userClass.getDeclaredField("age");
        age.setAccessible(true);
        age.setInt(user , 5);

        Field lastName = userClass.getDeclaredField("lastName");
        lastName.setAccessible(true);
        lastName.set(user , "Kofsdfgs");
        System.out.println(user);

    }



}
