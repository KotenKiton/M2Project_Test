package ru.m2.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class FormTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Проверка поиска в разделе “Купить” на стартовой странице")
    void buyHomeTest() {
        step("Открыть главную страницу", () -> {
            Selenide.open("https://m2.ru/");
            $$("p.home-hero-block-module--title--1HwUe").first()
                    .shouldHave(text("Потому что квартиру  сейчас  покупают на m2.ru"));
        });

        step("В селекторе с типом объекта из выпадающего списка выбрать 'Дом'", () -> {
            $("[data-test=categoryType-button]").shouldBe(visible).click();
            $("[data-test='categoryType-option:HOUSE']").click();
        });

        step("В селекторе с типом дома выбрать из выпадающего списка чек-бокс “Таунхаус”", () -> {
            $("[data-test='house-select-button']").shouldBe(visible).click();
            $("[data-test='house-select-option:TOWNHOUSE']").click();
        });

        step("В селекторе с ценой выбрать из выпадающего списка “5 млн", () -> {
            $(byText("Цена")).click();
            $("[name=priceTo]").setValue("5000000");
        });

        step("В селекторе с регионом/городом выбрать из выпадающего списка “Москва”", () -> {
            $("[data-test='region-select-button']").click();
            $("[data-test='region-select-option:3']").click();
        });

        step("Нажать кнопку Найти", () -> {
            $("[data-test=search-button]").click();
            $(".OffersSearch__title").shouldHave(text("Купить таунхаус до 5 млн в Москве"));

        });

    }

}


