# Simple application with Spring Boot and PostgreSQL.
1. Для запуска приложения необходима БД PostgreSQL (можно воспользоваться докером и запустить из папки проекта docker-compose up).
2. Создать базу данные studentTest.
3. Ссылка на Swagger: http://localhost:8090/testtask/swagger-ui/index.html#/
4. Описание EndPoints:
   1) POST /api/AddStudent
      Метод добавления нового студента.
   2) DELETE /api/DeleteStudent
      Метод удаления существующего студента
   3) POST /api/EditStudent
      Метод редактирования существующего студента
   4) POST /api/EditStudyProgressDict
      Метод изменения названия полей в справочнике успеваимости.
   5) GET /api/GetStudents
      Метод получения списка студентов.
   6) GET /api/GetStudyProgressDictionary
      Метод получения справочника успеваимости.


