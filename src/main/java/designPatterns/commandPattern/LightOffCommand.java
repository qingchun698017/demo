package designPatterns.commandPattern;

/**
 * Created by wqc on 2017/10/15.
 */
public class LightOffCommand implements Command{
    Light light;

    public LightOffCommand(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
