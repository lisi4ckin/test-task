# test-app Project

Действия могут отличаться зависит от ОС, в которой развёртывается система.
Сначала необходимо поставить maven.
Например, для Linux:
```shell
sudo apt install maven
```
Для Windows - скачать с официального сайта.

## Запуск серверной части

Необходимо ввести команду в терминале (или командной строке), находясь в корне проекта.
```shell script
./mvnw quarkus:dev
```
Подгрузятся все необходимые для запуска файлы
> **_NOTE:_**   Приложение запустится на http://localhost:8080.