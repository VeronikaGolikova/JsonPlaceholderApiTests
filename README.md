## Проект по автоматизации тестирования API
### Веб сайт <a target="_blank" href="https://jsonplaceholder.typicode.com/">{JSON} Placeholder</a>

<p align="center">
<img title="restful-booker" src="images/screens/api.jpeg">
</p>


## :rocket: Содержание:

- Технологии и инструменты
- Список методов, на которые были реализованы тесты
- Запуск тестов (сборка в Jenkins)
- Allure-отчет
- Интеграция с Allure TestOps
- Уведомление в Telegram о результатах прогона тестов

## :rocket: Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="images/logo/Allure_TO.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

## :rocket:  Список тестов и проверок

- [x] getPostInformation - получение информации поста по его id
- [x] createNewPost - создание нового поста
- [x] updatePost - редактирование информации в посте
- [x] patchResource - обновление ирформации в посте
- [x] deleteResource - удаление поста по id

###  Локальный запуск :
Пример командной строки:
```bash
gradle clean test  
```

Получение отчёта:
```bash
gradle allureServe
```

###  :rocket:  Удаленный запуск (в Jenkins):
1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/24-ShocoArts-JSONPlaceholder/">проект</a> и нажать **Build with Parameters**

![This is an image](/images/screens/jenkins.png)


## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure.svg"> [Пример](https://jenkins.autotests.cloud/job/24-ShocoArts-JSONPlaceholder/3/allure/) Allure-отчета
### Основаня страница отчета

![This is an image](/images/screens/allureReport.png)

**Статус прогона тестов в диаграммах**

![This is an image](/images/screens/graph.png)

**Тесты**

<p align="center">
<img title="Allure Tests" src="images/screens/reports.png">
</p>

<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="images/logo/Allure_TO.svg" width="25"/></a> Интеграция с <a target="_blank" href="https://allure.autotests.cloud/launch/38188">Allure TestOps</a>

![This is an image](/images/screens/allureCases.png)

![This is an image](/images/screens/allureBoard.png)

## <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> [Уведомления в Telegram](https://t.me/Golikova_Veronika_Alert_Bot) с использованием бота

После завершения сборки и прохождения всех тестовых сценариев в [Telegram канал](https://t.me/Golikova_Veronika_Alert_Bot) приходит оповещение с отчетом о результатах прохождения автотестов.

<p align="center">
<img width="70%" title="Уведомление в Telegram" src="images/screens/tg.jpg">
</p>

