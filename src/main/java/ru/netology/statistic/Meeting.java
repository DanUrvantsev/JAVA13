package ru.netology.statistic;

public class Meeting extends Task{
    private String topic;
    private String project;
    private String start;

    public Meeting(int id, String topic, String project, String start){
        super(id);
        this.topic=topic;
        this.project=project;
        this.start=start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    /**
     * Метод, проверяющий подходит ли эта задача поисковому запросу.
     * Эта логика должна быть определена в наследниках, у каждого она будет своя
     *
     * @param query Поисковый запрос
     * @return Ответ на вопрос, подходит ли эта задача под поисковый запрос
     */
    @Override
    public boolean matches(String query) {
        if(topic.contains(query)){
            return true;
        } else if (project.contains(query)){
            return true;
        }else {
            return false;
        }
    }
}