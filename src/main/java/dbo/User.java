package dbo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "users")
public class User {
    @Id
    private UUID userId;

    @Column(name = "name")
    private String name;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;

    public User() {
    }

    public User(String name, int age) {
        this.userId = UUID.randomUUID();
        this.name = name;
        this.age = age;
        cars = new ArrayList<>();
    }

    public void addAuto(Car auto) {
        auto.setUser(this);
        cars.add(auto);
    }

    public void removeAuto(Car auto) {
        cars.remove(auto);
    }

    public UUID getUserId() {
        return userId;
    }

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

    public List<Car> getAutos() {
        return cars;
    }

    public void setAutos(List<Car> autos) {
        this.cars = autos;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
