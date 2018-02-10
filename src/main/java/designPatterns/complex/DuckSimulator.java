package designPatterns.complex;

/**
 * DuckSimulator 鸭子模拟器
 *
 * @author wqc
 * @create 2017-12-09 16:59
 **/
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
    }
    void simulate(){
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redHeadDuck = new QuackCounter(new RedHeadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseDuck = new GooseAdapter(new Goose());

        Flock flock = new Flock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(duckCall);



        System.out.println("\nDuck Simulator:with Observer");
        Quackologist quackologist = new Quackologist();
        flock.registerObserver(quackologist);
        simulate(flock);

//        simulate(mallardDuck);
//        simulate(redHeadDuck);
//        simulate(duckCall);
//        simulate(rubberDuck);
//        simulate(gooseDuck);
//
//        System.out.println("\nDuck Simulator Flock duck:");


        System.out.println("The ducks quacked "+ QuackCounter.getNumberOfQuacks());
    }

    void simulate(Quackable duck){
        duck.quack();
    }
}
