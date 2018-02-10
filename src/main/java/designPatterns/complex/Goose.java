package designPatterns.complex;

/**
 * Goose 鹅
 *
 * @author wqc
 * @create 2017-12-09 17:06
 **/
public class Goose {
    public void honk(){
        System.out.println("鹅 咯咯咯！");
    }

    @Override
    public String toString() {
        return "鹅";
    }
}
