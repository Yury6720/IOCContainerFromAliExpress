package com.IOCContainerFromAliExpress.Scanner.ReflectionsScanner;

import com.IOCContainerFromAliExpress.Annotations.Inject;
import org.reflections.Reflections;
import java.util.HashSet;
import java.util.Set;

/**
 * "ClassScanner" использует библиотеку "Reflections Api" для получение доступа к всему массиву
 * классов в директории "IOCContainerFromAliExpress" (далее "Контейнер").
 *
 * <p>"ClassScanner" реализует способ №1 для автоматического сканирования Контейнера.
 *
 * <p>Далее происходит фильтрация классов.
 *
 * @param <T>
 * @param "reflections" - экземпляр класса "Reflections" внедряется в "ClassScanner" с помощью
 *     фабрики "com.IOCContainerFromAliExpress.Utils.ReflectionsAccessor"
 *
 * <p>@Constructors
 *     <li>1. Default constructor without params
 *     <li>2. Constructor with @param "reflections"
 */
public class ClassesScanner<T> {

  Reflections reflections = new ReflectionAccessor().getReflections();

  public ClassesScanner() {}

  public ClassesScanner(Reflections reflections) {
    this.reflections = reflections;
  }

  /**
   * @Method "getAllClassesWithAnnotations"
   *
   * <p>@param "reflections" принимает на вход класс Аннотации ("Inject.class") и находит все
   * помеченные конструкторы в директории.
   *
   * <p>сохранение помеченных конструкторов в Set.
   *
   * <p>с помощью цикла foreach из конструкторов получаем имена классов которым они принадлежат.
   *
   * <p>сохраняем найденные классы.
   *
   * @return Set<Class>- набор классов которые будут в последствии инстанцированы
   *     <p>@NB replace checking by JUnit test @NB delete checking
   */
  public <t> Set<t> getAllClassesWithAnnotations() {

    var constructorsAnnotatedWith = reflections.getConstructorsAnnotatedWith(Inject.class);

    //    @Depricated
    //    Set<Constructor> constructorsAnnotatedWith =
    //        new Reflections("com.IOCContainerFromAliExpress", new MethodAnnotationsScanner())
    //            .getConstructorsAnnotatedWith(Inject.class);

    Set<t> classesWithAnnotatedConstructor = new HashSet<>();

    for (var constructor : constructorsAnnotatedWith) {
      classesWithAnnotatedConstructor.add((t) constructor.getDeclaringClass());
      // Check
      System.out.println("This Constructor " + constructor);
    }

    return classesWithAnnotatedConstructor;
  }

  /**
   * @Method "getAllImplementations"
   *
   * <p>@param "Class<T> intf" - входной параметр представляющий собой интерфейс
   *
   * <p>@param "reflections" - находит все классы в директории Контейнера которые являются
   * имплементацией интерфейса "intf".
   *
   * <p>сохранение результатов в Set
   *
   * @return "Set<Class<? extends T>> impl" - набор классов имплементаций нужного интерфейса
   *     <p>@NB replace checking by JUnit test @NB delete checking
   */
  public <T> Set<Class<? extends T>> getAllImplementations(Class<T> intf) {
    Set<Class<? extends T>> impl = reflections.getSubTypesOf(intf);
    // @Check
    for (var clazz : impl) {
      System.out.println("Implementations of EventDAO: " + clazz);
    }
    return impl;
  }
}
