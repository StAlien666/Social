package Moe.Social;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Period;

public class Person {
    private String name;
    private LocalDate birthday;
    private final String numberID;
    private int socialRating;
    private ArrayList<Action> actions = new ArrayList<>();

    private static final String EMPTY_MSG = "Тут не должно быть пусто"; //Чтобы не дублировать


    public Person(String name, short year, byte month, byte day) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MSG);
        }
        this.name = name;
        this.birthday = LocalDate.of(year, month, day);
        this.numberID = generateUniqueID();
        this.socialRating = 1000; // Начальный рейтинг
    }

    private String generateUniqueID() {
        return java.util.UUID.randomUUID().toString(); // Уникальный номер пользователя
    }

    public void addAction(Action action) {
        if (action.realImpact() != 0) {
            actions.add(action);
            socialRating += action.realImpact();
        }
    }

    public void removeAction(Action action) { actions.remove(action); }


    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MSG);
        }
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getNumberID() {
        return numberID;
    }

    public int getSocialRating() {
        return socialRating;
    }

    public void showActions() {
        for (Action action : actions) {
            System.out.println(action.getDescription());
        }
    }

}
