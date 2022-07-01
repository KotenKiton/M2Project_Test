package ru.m2.tests;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class FormTest extends TestBase {

    @BeforeEach
    @DisplayName("Проверка поиска в разделе “Купить” на стартовой странице")
    void firstTest() {
        step("Открыть главную страницу", () -> {
            Selenide.open("https://m2.ru/");
            $$("p.home-hero-block-module--title--1HwUe").first()
                    .shouldHave(text("Потому что квартиру  сейчас  покупают на m2.ru"));
        });
    }

    @Test
    @DisplayName("Купить Дом до 5 мл в Москве")
    void buyHouseTest() {
        step("В селекторе с типом объекта из выпадающего списка выбрать 'Дом'", () -> {
            $("[data-test=categoryType-button]")
                    .shouldBe(visible).click();
            $("[data-test='categoryType-option:HOUSE']").click();
        });

        step("В селекторе с типом дома выбрать из выпадающего списка чек-бокс “Таунхаус”", () -> {
            $("[data-test='house-select-button']")
                    .shouldBe(visible).click();
            $("[data-test='house-select-option:TOWNHOUSE']").click();
        });

        step("В селекторе с ценой выбрать из выпадающего списка установить значение до 5 млн", () -> {
            $(byText("Цена")).click();
            $("[name=priceTo]").setValue("5000000");
        });

        step("В селекторе с регионом/городом выбрать из выпадающего списка “Москва”", () -> {
            $("[data-test='region-select-button']").click();
            $("[data-test='region-select-option:3']").click();
        });

        step("Нажать кнопку Найти", () -> {
            $("[data-test=search-button]").click();
            $(".OffersSearch__title")
                    .shouldHave(text("Купить таунхаус до 5 млн в Москве"));
        });
    }

    @Test
    @DisplayName("Купить комнату в Санкт-Петербурге")
    void buyRoomTest() {
        step("В селекторе с типом объекта из выпадающего списка выбрать 'Квартира'", () -> {
            $("[data-test=categoryType-button]")
                    .shouldBe(visible).click();
            $("[data-test='categoryType-option:ROOM']").click();
        });

        step("В селекторе региона выбрать значение “Санкт-Питербург”", () -> {
            $("[data-test='region-select-button']").click();
            $("[data-test='region-select-option:444']").click();
        });

        step("Нажать кнопку Найти", () -> {
            $("[data-test=search-button]").click();
            $(".OffersSearch__title")
                    .shouldHave(text("Купить комнату в Санкт-Петербурге"));
        });
    }

    @Test
    @DisplayName("Cнять комнату в Московской области")
    void rentRoomTest() {
        step("Перейти во вкладку 'Cнять'", () ->
                $(".search-section-module--tabItem--3iJUl [data-test=rent-tab]").click()
        );

        step("В селекторе с типом объекта выбрать из выпадающего списка Комната", () -> {
            $$("[data-test=categoryType-button]").last().click();
            $(byText("Комнату")).click();
        });

        step("В селекторе региона выбрать значение “Московская область”", () -> {
            $$("[data-test='region-select-button']").get(1).click();
            $("[data-test='region-select-option:108']").click();
        });

        step("Нажать кнопку 'Найти'", () -> {
            $$("[data-test=search-button]").get(1).click();
            $(".OffersSearch__title")
                    .shouldHave(text("Снять комнату в Московской области"));
        });
    }

    @Test
    @DisplayName("Открытие формы оставить заявку на ремонт")
    void repairButtonTest() {
        step("Нажать кнопку 'Cделать ремонт качественно'", () ->
                $("[data-test=client-path-remont]").click()
        );

        step("Нажать кнопку 'Оставить заявку'", () -> {
            $("[data-test=actions]").click();
            $(".modal-module--title--34Jnb")
                    .shouldHave((text("Первый шаг к ремонту")));
        });
    }

    @Test
    @DisplayName("Поиск по предустановленному фильтру")
    void saveFilterTest() {
        step("Выбрать предустановленный фильтр 'Студии'", () ->
                $(byText("Студии")).click()
        );

        step("Указан заголовок поиска 'Купить студию в Москве' ", () -> {
            $(".OffersSearch__title")
                    .shouldHave((text("Купить студию в Москве")));
        });
    }

    @Test
    @DisplayName("Подача заявки на консультацию с неполным номером телефона")
    void failedPhoneTest() {
        step("Нажать кнопку купить онлайн", () ->
                $("[data-test=client-path-online-deal]").click());

        step("Нажать кнопку 'Получить консультацию'", () ->
                $(byText("Получить консультацию")).click());

        step("Ввести в поле 'Телефон'неполный номер", () -> {
            $$("input.input-module--control--mTJZU").get(1).setValue("123456789");
            $$("input.input-module--control--mTJZU").first().click();

            step("Текст ошибки 'Введён некоректный номер'", () ->
                    $("[data-test=error]")
                            .shouldHave(text("Введён некорректный номер")));

        });
    }

    @Test
    @DisplayName("Подача обьявления с адресом из цифр")
        // отредачить тайтл
    void adWithNumbers() {
        step("Нажать кнопку 'новое обьявление'", () ->
                $(".offerPlacementLinkText").click());

        step("В строке адрес ввести '00000'", () ->
                $("[data-test=form-input-address-suggest-input] input").setValue("00000"));

        step("Текст ошибки 'Не удалось определить адрес'", () ->
                $("[data-test=form-input-region]").click());
        $(".FormError").shouldHave(text("Не удалось определить адрес"));
    }
}