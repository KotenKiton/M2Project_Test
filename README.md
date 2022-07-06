## Проект автоматизации тестирования веб-приложения на ресурсе hh.ru

---
### Вакансия [QA Engineer](https://novgorod.hh.ru/vacancy/67054923?from=vacancy_search_list&hhtmFrom=vacancy_search_list&query=Qa%20java)

<a id="anchor"></a>

:closed_book: __Содержание__
+ Технологии и инструменты
+ Реализованные проверки
+ Сборка в Jenkins
+ Запуск из терминала
+ Отчет Allure Report
+ Отчет в Telegram
+ Видео примера прохождения теста




:toolbox:__Технологии и инструменты__

<img width="10%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg"><img width="10%" title="Gradle" src="images/logo/Gradle.svg"><img width="10%" title="Java" src="images/logo/Java.svg"><img width="10%" title="Jenkins" src="images/logo/Jenkins.svg"><img width="10%" title="JUnit5.svg" src="images/logo/JUnit5.svg"><img width="10%" title="Selenide.svg" src="images/logo/Selenide.svg"><img width="10%" title="Selenoid.svg" src="images/logo/Selenoid.svg"><img width="10%" title="GitHub.svg" src="images/logo/GitHub.svg"><img width="10%" title="Allure_Report.svg" src="images/logo/Allure_Report.svg"><img width="10%" title="Telegram.svg" src="images/logo/Telegram.svg">

---
__Пример Smoke тестов__

:white_check_mark: _Позитивные проверки:_

- [ ]  Купить комнату в Санкт-Петербурге
- [ ]  Подача заявки на консультацию с неполным номером телефона
- [ ]  Открытие формы оставить заявку на ремонт
- [ ]  Купить Дом до 5 млн в Москве
- [ ]  Поиск по предустановленному фильтру (Пример проваваленного теста)

---

:x: _Негатитвные проверки_
- [ ] Подача заявки на консультацию с неполным номером телефона 
- [ ] Заполнение адреса значением из цифр при подаче обьявления
---
:toolbox: __Сборка в Jenkins__

[Проект M2_Project_SmokeTests](https://jenkins.autotests.cloud/job/M2_Project_SmokeTests/)


<img width="100%" title="AssembleInJenkins.png" src="images/screenshot/AssembleInJenkins.png">


__Параметризированная сборка в Jenkins__

Мы можем собрать задачу с предложенными параметрами, выбрав из выпадающих вариантов:

<img width="100%" title="ParametrsInJenkins.png" src="images/screenshot/ParametrsInJenkins.png">

---
:computer: __Запуск из терминала__

Локальный запуск теста:

```
gradle clean test  
```
Удаленный запуск теста:
```
clean
vacancy
-DremoteUrl=${REMOTE_URL}
-Dbrowser=${BROWSER}
-DbrowserSize=${BROWSER_SIZE}
```

---
:bar_chart: __Allure отчётность__

<img width="100%" title="AllureReport.png" src="images/screenshot/AllureReport.png">

Проведенные тесты с шагами, возможностью просмотра скриншота, лога и видео

<img width="100%"  title="Tests.png" src="images/screenshot/Tests.png">

---
:incoming_envelope: __Отчёт в Telegram__

<img width="30%"  title="TelegramAllure.png" src="images/screenshot/TelegramAllure.png">

Кроме красочной инфографики доступна возможность перейти по ссыле для просмотра отчета:
[просмотреть сейчас ](https://jenkins.autotests.cloud/job/M2_Project_SmokeTests/5/allure/)

---
:clapper: __Видео примера прохождения теста__

Запуск проходит на удаленном веб-драйвере Selenoid
<img title="Selenoid Video" src="images/video/ExampleAttach.gif">

:arrow_up: [Вверх страницы](#anchor)

:new_moon_with_face: <a target="_blank" href="https://t.me/BiLLGradLe"></a>

---



