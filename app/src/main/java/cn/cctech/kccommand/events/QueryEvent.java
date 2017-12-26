package cn.cctech.kccommand.events;

public abstract class QueryEvent extends Event {

    public abstract boolean inflate(String content);
}
