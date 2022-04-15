public class Test extends MyAbstract1 implements MyInterface1, MyInterface2 {
    public static void main(String[] args){
        // Можем напрямую ссылаться на переменные из имплементированного интерфейса
        System.out.println(c);

        //
        new Test().secondMethod();

        /* Если присутсвует конфликт между интерфейсами (одинаковые названия переменных или методов),
        то можно обращаться к этим переменным через точку по имени интерфейса */
        System.out.println(MyInterface2.b);

    }

    @Override // <-- индикация переопределения
    public void Bye(){
        System.out.println("Bye!");
    }

    @Override
    public void firstName(){}


}

// Реализуется с помощью команды extends
// Множественное наследование невозможно
abstract class MyAbstract1 {
    // Может содеражть пустые и заполненные переменные
    int a;
    String s = "some text";

    // Может содеражть готовые методы
    void Hello(){
        System.out.println("Hello!");
    };

    // Может содержать абстрактные методы
    // обязателен к определению в дочернем классе
    abstract void Bye();
}

// Реализуется с помощью команды implements,
// Доступна множественная имплементация
interface MyInterface1 {
    // Может содеражть только явно определенные final static константы
    int b = 10; // final static int b = 10;
    String c = "abc";
    // Переменные видны в импламентируемом классе

    // Может содержать только пустые методы, которые надо обязательно объявить в реализующем классе
    void firstName();

    // C java 8 интерфейс может иметь методы по умолчанию
    default void secondMethod(){
        System.out.println(100);
    }
    // Нужно, если вы хотите использовать одну из реализаций метода много раз
}

interface MyInterface2 {
    int b = 10; // final static int b = 10;
    String z = "abc";
}

// Интерфейс может реализоваывать другой интерфейс, но не может наследовать класс
