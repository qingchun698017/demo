package designPatterns.commandPattern;

/**
 * Created by wqc on 2017/10/15.
 * 开灯命令
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light)
    {
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
