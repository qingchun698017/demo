package designPatterns.commandPattern;

/**
 * Created by wqc on 2017/10/15.
 * 命令接口类，所有命令必须实现
 */
public interface Command {
    //执行命令
    public void execute();
    //撤销命令
    public void undo();
}
