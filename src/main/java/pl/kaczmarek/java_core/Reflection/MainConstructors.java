package pl.kaczmarek.java_core.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MainConstructors {

    public static void main(String[] args)
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Class<? extends User> userClass = User.class;

        Constructor<? extends User> constructor = userClass.getConstructor();// kontruktor bezargumentowy
        Constructor<? extends User> constructor1 = userClass.getConstructor(String.class, String.class);// konstruktor przyjmujący imię i nazwisko

        User user1 = constructor.newInstance();
        System.out.println(user1);

        User user2 = constructor1.newInstance("Anna", "Nowak");
        System.out.println(user2);

        printObject(user2);
    }


    private static void printObject(Object object) throws IllegalAccessException {

        Class<?> clazz = object.getClass();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clazz.getSimpleName());
        stringBuilder.append("{");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            stringBuilder.append(declaredField.getName());
            stringBuilder.append("='");
            stringBuilder.append(declaredField.get(object));
            stringBuilder.append("', ");
        }
        String substring = stringBuilder.substring(0, stringBuilder.length() - 2);
        System.out.println(substring + "}");

    }

}
