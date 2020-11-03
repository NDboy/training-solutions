package Introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl introControl = new IntroControl(10);


        System.out.println(introControl.substractTenIfGreaterThanTen(introControl.getNumber()));
        System.out.println(introControl.describeNumber(introControl.getNumber()));
        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.calculateBonus(2000000));
        System.out.println(introControl.calculateConsumption(7995, 2565));
        introControl.printNumbers(7);
        introControl.printNumbersBetween(89,215);
        introControl.printNumbersBetweenAnyDirection(215, 155);
        introControl.printOddNumbers(21);






    }
}
