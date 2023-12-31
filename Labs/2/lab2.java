// Абстрактный класс
abstract class Animals {
    // Поля
    private String name;
    private int age;
    private String color;

    // Конструктор
    public Animals(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    // конструктор по умолчанию
    public Animals() { 
        this.name = ""; 
        this.age = 0; 
        this.color = ""; 
    } 

    // Геттеры и сеттеры
    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public int getAge() { 
        return age; 
    }

    public void setAge(int age) { 
        this.age = age; 
    }

    public String getColor() { 
        return color; 
    }

    public void setColor(String color) { 
        this.color = color; 
    }

    // Абстрактный метод (Абстракция)
    public abstract void behavior();

    // Переопределение метода toString
    @Override
    public String toString() {
        return "Имя: " + name + ", Возраст: " + age + ", Расцветка: " + color;
    }
}

class Cat extends Animals {
    private String breed;
    // Статическая переменная для счетчика
    private static int count = 0;

    // Конструктор
    public Cat(String name, int age, String color, String breed) {
        super(name, age, color);
        this.breed = breed;
        count++; // увеличиваем счетчик при создании объекта
    }

    // Геттеры и сеттеры
    public String getBreed() { 
        return breed; 
    }
    public void setBreed(String breed) { 
        this.breed = breed; 
    }

    // Переопределение абстрактного метода (Полиморфизм)
    @Override
    public void behavior() {
        System.out.println("Кот мурлыкает.");
    }

    // Геттер для статической переменной
    public static int getCount() {
        return count;
    }
}

class Kitten extends Cat {
    private String gender;

    public Kitten(String name, int age, String color, String breed, String gender) {
        super(name, age, color, breed);
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void behavior() {
        System.out.println("Котенок играет.");
    }
}

class Parrot extends Animals {
    private String language;

    // Конструктор с перегрузкой (перегруженный конструктор)
    public Parrot(String name, String color) {
        super(name, 0, color);
        this.language = "неизвестно";
    }

    // Конструктор
    public Parrot(String name, int age, String color, String language) {
        super(name, age, color);
        this.language = language;
    }

    // Геттеры и сеттеры
    public String getLanguage() { 
        return language; 
    }
    public void setLanguage(String language) { 
        this.language = language; 
    }

    // Переопределение абстрактного метода (Полиморфизм)
    @Override
    public void behavior() {
        System.out.println("Попугай повторяет.");
    }
}

class Fish extends Animals {
    private String habitat;

    // Конструктор
    public Fish(String name, int age, String color, String habitat) {
        super(name, age, color);
        this.habitat = habitat;
    }

    // Геттеры и сеттеры
    public String getHabitat() { 
        return habitat; 
    }
    public void setHabitat(String habitat) { 
        this.habitat = habitat; 
    }

    // Переопределение абстрактного метода (Полиморфизм)
    @Override
    public void behavior() {
        System.out.println("Рыба плавает.");
    }
}

public class lab2 {
    public static void main(String[] args) {
        Cat cat = new Cat("Кирилл", 3, "Серый", "Персидский");
        Parrot parrot = new Parrot("Григорий", 5, "Черный", "Русский");
        Parrot parrot2 = new Parrot("Джек", "Зеленый");  // Использование перегруженного конструктора
        Fish fish = new Fish("Николай", 1, "Белый", "Коралловый Риф");
        Kitten kitten = new Kitten("Мурзик", 1, "Белый", "Британская", "Мальчик");

        System.out.println(cat.toString());
        cat.behavior();

        System.out.println(kitten.toString());
        kitten.behavior();

        System.out.println(parrot.toString());
        parrot.behavior();

        System.out.println(parrot2.toString());
        parrot2.behavior();

        System.out.println(fish.toString());
        fish.behavior();

        System.out.println("Количество созданных котов: " + Cat.getCount());
    }
}