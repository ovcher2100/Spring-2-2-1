package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    void saveUserWithCar(User user, Car car);

    User getUserByCarModelAndSeries(String model, int series);
}
