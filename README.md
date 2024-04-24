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
allure serve build/allure-results
```

###  :rocket:  Удаленный запуск (в Jenkins):
1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/24-ShocoArts-JSONPlaceholder/">проект</a> и нажать **Build with Parameters**

![This is an image](/images/screens/jenkins.png)


###  Отчет в Allure report

![This is an image](/images/screens/allureReport.png)

**Статус прогона тестов в диаграммах**
![This is an image](/images/screens/graph.png)

**Тесты**

<p align="center">
<img title="Allure Tests" src="images/screens/reports.png">
</p>

## :rocket: Интеграция с Allure TestOps

![This is an image](/images/screens/allureCases.png)

![This is an image](/images/screens/allureBoard.png)

## :rocket: Получение отчетов о прохождении тестов в telegram

![This is an image](/images/screens/tg.jpg)
