package Moe.Social;

public class Main {
    public static void main(String[] args) {


        Person person = new Person("Вася", (short) 1990, (byte) 1, (byte) 1);

        var action1 = new Action("Драка недавняя", -50, 2025, 2, 11);
        var action2 = new Action("Драка средняя", -50, 2025, 1, 1);
        var action3 = new Action("Драка давняя", -50, 2023, 2, 11);
        var action4 = new Action("Драка за честь давняя", 50, 2023, 2, 11);
        var action5 = new Action("Драка за честь средняя", 50, 2025, 1, 1);
        var action6 = new Action("Драка за честь недавняя", 50, 2025, 2, 11);

        System.out.println(action1.getDaysSinceAction());
        System.out.println(action1.realImpact());
        System.out.println(person.getAge());
        System.out.println(person.getBirthday());
        person.addAction(action1);
        person.addAction(action2);
        person.addAction(action3);
        person.addAction(action4);
        person.addAction(action5);
        person.addAction(action6);
        person.showActions();
        System.out.println(person.getSocialRating());
        System.out.println(action6.realImpact() + " - драка хорошая недавняя");
        System.out.println(action5.realImpact() + " - драка хорошая средняя");
        System.out.println(action1.realImpact() + " - драка плохая недавняя");
        System.out.println(action2.realImpact() + " - драка плохая средняя");



    }
}
