package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTheMethodZeroTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Яйцо");

        String[] subtasks = {"Молоко", "Яйцо", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Велосипед");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTheMethodOnlyTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Яйцо");

        String[] subtasks = {"Молоко", "Яйцо", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("НетоБанка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSearchMultipleTasks() {

        Todos todos = new Todos();
        SimpleTask task1 = new SimpleTask(1, "Купить Хлеб");
        Epic task2 = new Epic(2, new String[]{"Молоко", "Хлеб"});
        Meeting task3 = new Meeting(3, "Обсудить Хлеб", "Продукты", "Завтра");

        todos.add(task1);
        todos.add(task2);
        todos.add(task3);
        Task[] result = todos.search("Хлеб");

        Task[] expected = {task1, task2, task3};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void shouldFindSingleSimpleTaskWhenTitleMatches() {
        Todos todos = new Todos();

        SimpleTask targetTask = new SimpleTask(1, "Обновить документацию");

        todos.add(targetTask);
        todos.add(new Epic(2, new String[]{"Проверить стили", "Тестирование"}));
        todos.add(new Meeting(3, "Планирование релиза", "Документация", "Завтра"));

        Task[] result = todos.search("документацию");


        Assertions.assertArrayEquals(new Task[]{targetTask}, result);
    }

    @Test
    public void shouldFindSingleEpicWhenSubtaskMatches() {
        Todos todos = new Todos();

        Epic targetEpic = new Epic(1, new String[]{"Интеграционное тестирование", "Нагрузочное тестирование"});

        todos.add(targetEpic);
        todos.add(new SimpleTask(2, "Подготовить тестовые данные"));
        todos.add(new Meeting(3, "Обсуждение тестов", "Разработка", "Понедельник"));

        Task[] result = todos.search("Нагрузочное");

        Assertions.assertArrayEquals(new Task[]{targetEpic}, result);
    }

    @Test
    public void shouldFindSingleMeetingWhenProjectMatches() {
        Todos todos = new Todos();


        Meeting targetMeeting = new Meeting(1, "Релиз", "Мобильное приложение", "Пятница");


        todos.add(targetMeeting);
        todos.add(new SimpleTask(2, "Доработать мобильный интерфейс"));
        todos.add(new Epic(3, new String[]{"Тест сервера", "Настройка сети"}));

        Task[] result = todos.search("Мобильное");

        Assertions.assertArrayEquals(new Task[]{targetMeeting}, result);
    }

    @Test
    public void shouldReturnEmptyArrayWhenNoMatchesFound() {

        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Обновить зависимости"));
        todos.add(new Epic(2, new String[]{"Оптимизация кода", "Улучшение UI"}));
        todos.add(new Meeting(3, "Еженедельный митинг", "Общие вопросы", "Сегодня"));

        Task[] result = todos.search("Безопасность");

        Assertions.assertEquals(0, result.length);
    }
}