package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    public void testSimpleTaskMatchesTrue() {
        SimpleTask task = new SimpleTask(111, "Позвони домой");
        boolean actual = task.matches("Позвони");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskMatchesFalse() {
        SimpleTask task = new SimpleTask(111, "Позвони домой");
        boolean actual = task.matches("Домой");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMatchesTrue() {
        Epic task = new Epic(11, new String[]{"Чай", "Молоко", "Сахар", "Печенье"});
        boolean actual = task.matches("Сахар");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicMatchesFalse() {
        Epic task = new Epic(11, new String[]{"Чай", "Молоко", "Сахар", "Печенье"});
        boolean actual = task.matches("Coffee");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingMatchesTrueTopic() {
        Meeting task = new Meeting(11, "Тестирование", "Домашнее задание", "Сегодня");
        boolean actual = task.matches("Тестирование");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingMatchesTrueProject() {
        Meeting task = new Meeting(11, "Тестирование", "Домашнее задание", "Сегодня");
        boolean actual = task.matches("Домашнее задание");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingMatchesFalse() {
        Meeting task = new Meeting(11, "Тестирование", "Домашнее задание", "Сегодня");
        boolean actual = task.matches("Авто тестирование");
        Assertions.assertFalse(actual);
    }


}