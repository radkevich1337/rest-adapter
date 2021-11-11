Spring Boot REST сервис-адаптер к SOAP веб-сервису.

Приложение использует 80 порт.
При обращении к SOAP сервису применяется задержка 2 секунды с целью 
имитации длительной работы сервиса и  тестирования кеширования.

Реализовано:
 - валидация запросов
 - кеширование запросов
 - генерация спецификации в формате OpenAPI
 - интеграционные тесты 