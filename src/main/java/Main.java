import dbo.Car;
import dbo.User;
import service.UserService;

import java.util.UUID;

public class Main {


    public static void main(String[] args) {
        User user = new User("name", 19);
        final Car auto = new Car();
        auto.setModel("model");
        auto.setId(UUID.randomUUID());
        user.addAuto(auto);

        UserService userService = new UserService();
        userService.saveUser(user);
    }
}
