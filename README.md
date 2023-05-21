# Labs on "Programming in High Level Languages" (BSUIR, 4 term)

## Вариант исполнения сервисов:
19. Сервис должен принимать один параметр (порядковый номер в ряду Фибоначчи) и вернуть результат нахождения в ряду Фибоначчи числа с предоставленным порядковым номером

___________________________________________

## Лабораторные работы

### 1. Intro [[Code]](https://github.com/moodtodie/term4-java/tree/7ee1b255dab2952d080ce97b2524b9ffb4c527cd)
1. Создать и запустить локально простой веб/REST сервис, используя любой открытый (например, в открытом доступе в сети  интернет) пример с использованием Java stack: Spring (Spring Boot)/maven/gradle/Jersey/ Spring MVC. 
2. Добавить GET ендпоинт, принимающий входные параметры в качестве queryParams в URL и возвращающий результат в виде JSON согласно варианту.

## 

### 2. Error logging/handling [[Code]](https://github.com/moodtodie/term4-java/tree/6952f1fb2a46eab5d54ce3f8304ac1d71a2a15d9)
1. Добавить валидацию входных параметров с возвращением 400 ошибки, 
2. Добавить обработку внутренних unchecked ошибок с возвратом 500 ошибки 
3. Добавить логирование действий и ошибок 
4. Написать unit test

## 

### 3. Collections intro, project structure [[Code]](https://github.com/moodtodie/term4-java/tree/550c929ceb5332aca08b80056c0f2c6e0617b2ad)
1. Добавить простейший кэш в виде in-memory Map для сервиса. Map должна содержаться в отдельном бине/классе, который должен добавляться в основной сервис с помощью dependency injection механизм Spring

## 

### 4. Concurrency [[Code]](https://github.com/moodtodie/term4-java/tree/df460905842ce1ea3ed0e0aab0c3fe1455889d4e)
1. Добавить сервис для подсчёта обращений к основному сервису. Счётчик должен быть реализован в виде отдельного класса, доступ к которому должен быть синхронизирован. 
2. Используя jmeter/postman или любые другие средвста сконфигурировать нагрузочный тест и убедиться, что счётчик обращений работает правильно при большой нагрузке.

## 

### 5. Functional programming with Java 8 [[Code]](https://github.com/moodtodie/term4-java/tree/c0f2b35a6d86e9d957565c40171b69010396b43c)
1. Преобразовать исходный сервис для работы со списком параметров для bulk операций используя Java 8 лямбда выражения. 
2. Добавить POST метод для вызова bulk операции и передачи списка параметров в виде JSON

## 

### 6. Functional filtering and mapping [[Code]](https://github.com/moodtodie/term4-java/tree/5b63da2f50704aa5186e57743c3574c1f9d24cfd)
1. Добавить аггрегирующий функционал (подсчёт макс, мин, средних значений) для входных параметров и результатов с использованием Java 8 map/filters функций. Расширить результат POST соотвественно.

## 

### 7. Data persistence [[Code]](https://github.com/moodtodie/term4-java/tree/be02d28884f9ff57be0d93791fbd51ccd5abf85b)
1. Добавить возможность сохранения всех результатов вычислений в базе данных или файле, используя стандартные persistence фреймворки Java (Spring Data/Hibernate/MyBatis)

## 

### 8. Asynchronous calls [[Code]](https://github.com/moodtodie/term4-java/tree/3d6cb53c5a7d3d718fe3ab3f6fc1019573538140)
1. Добавить возможность асинхронного вызова сервиса используя future, возвращать статус вызова REST сервиса не дожидаясь результатов подсчётов. Результаты подсчётов должны быть представлены в БД по предопределённой ID

## 
