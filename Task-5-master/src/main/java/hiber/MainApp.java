package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");


      Car car1 = new Car("Audi", 4);
      Car car2 = new Car("Lada", 114);
      Car car3 = new Car("Kia", 1);
      Car car4 = new Car("BMW", 5);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));
      /*
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      */

      //for (User user : userService.listUsers()) {
        // System.out.println(user + " " + user.getCar());

         List<User> users = userService.listUsers();
         for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
         }
      System.out.println(userService.getUserByCar("BMW", 5));

        context.close();
      }
   }


/*
Создайте соединение к своей базе данных и схему. Запустите приложение. Проверьте, что оно полностью работает.
Создайте сущность Car с полями String model и int series, на которую будет ссылаться User с помощью связи one-to-one.
Добавьте этот класс в настройки hibernate.
Создайте несколько пользователей с машинами, добавьте их в базу данных, вытащите обратно.
В сервис добавьте метод, который с помощью hql-запроса будет доставать юзера, владеющего машиной по ее модели и серии.
 */