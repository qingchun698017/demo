package designPatterns.complex;

/**
 * Quackologist
 *
 * @author wqc
 * @create 2017-12-09 19:52
 **/
public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("quackologist : "+duck +" just quacked.");
    }
}
