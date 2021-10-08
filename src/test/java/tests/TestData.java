package tests;

import com.github.javafaker.Faker;

import java.util.Random;

public  class TestData {


    public String firstName = new Faker().name().firstName();
    public String lastName = new Faker().name().lastName();
    public String userEmail = new Faker().internet().emailAddress("qa_guru");
    public String studentGender = "Male";
    public String phoneNumber = new Faker().phoneNumber().subscriberNumber(10);

    public String dayCalendar = new Faker().random().nextInt(10,30).toString();
    public String monthCalendar = "July";
    public String yearCalendar = new Faker().random().nextInt(1923,2020).toString();

    public String subjectValue1 = "Maths";
    public String subjectValue2 = "Chemistry";

    public String rndHobbies1 = "Sports";
    public String rndHobbies2 = "Reading";

    public String rndAddres = new Faker().address().fullAddress();
    public String rndState = "Haryana";
    public String rndCity = "Panipat";

}
