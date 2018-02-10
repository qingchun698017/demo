package designPatterns.templatePattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tea extends CaffeineBeverageWithHook {

    void brew() {
        System.out.println("steeping the tea");
    }

    void addCondiments() {
        System.out.println("add lemon");
    }

    public boolean customerWantsCondiments()
    {
        String answer = getUserInput();
        if(answer.toLowerCase().startsWith("y"))
        {
            return true;
        }else{
            return false;
        }
    }

    private String getUserInput()
    {
        String answer = null;
        System.out.println("Would you like lemon with your tea?");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer=in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(answer == null)
        {
            answer = "no";
        }
        return answer;
    }
}
