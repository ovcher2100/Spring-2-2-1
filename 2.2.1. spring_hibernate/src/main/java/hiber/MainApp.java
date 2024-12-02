package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      Car car1 = new Car("Audi",2020);
      Car car2 = new Car("BMW",2021);
      Car car3 = new Car("Shoda",2023);
      Car car4 = new Car("Lada",2024);

      userService.saveUserWithCar(user1,car1);
      userService.saveUserWithCar(user2,car2);
      userService.saveUserWithCar(user3,car3);
      userService.saveUserWithCar(user4,car4);

      User user5 = userService.getByCar("BMW",2021);
      System.out.println(user5);
      System.out.println();


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getUserCar());
         System.out.println();
      }

      context.close();
   }
}
