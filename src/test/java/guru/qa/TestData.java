package guru.qa;

import com.github.javafaker.Faker;

public  class TestData {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress("qa_guru"),
            studentGender = faker.demographic().sex(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            dayCalendar = faker.random().nextInt(10,30).toString(),
            monthCalendar = "July",
            yearCalendar = faker.random().nextInt(1923,2020).toString(),
            subjectValue1 = "Maths",
            subjectValue2 = "Chemistry",
            rndHobbies1 = "Sports",
            rndHobbies2 = "Reading",
            picture = "BoJack-on-Behance.png",
            rndAddres = faker.address().fullAddress(),
            rndState = "Haryana",
            rndCity = "Panipat";
}