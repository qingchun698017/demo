package designPatterns.commandPattern;

/**
 * Created by wqc on 2017/10/15.
 * 宏命令：一个命令启动多个操作
 */
public class MacroCommand implements Command{
    Command[] commands;

    public MacroCommand(Command[] commands)
    {
        this.commands = commands;
    }
    @Override
    public void execute() {
        for(int i=0;i<commands.length;i++)
        {
            commands[i].execute();
        }
    }

    @Override
    public void undo() {
        for(int i=0;i<commands.length;i++)
        {
            commands[i].undo();
        }
    }
}
