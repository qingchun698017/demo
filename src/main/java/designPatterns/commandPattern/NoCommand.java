package designPatterns.commandPattern;

/**
 * Created by wqc on 2017/10/15.
 */
public class NoCommand  implements Command{
    @Override
    public void execute() {
        System.out.println("没有命令~");
    }

    @Override
    public void undo() {

    }
}
