import java.util.*;

public class MiniAI {

    static Map<String,String> brain = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("AI启动成功");

        while(true){

            System.out.print("你: ");
            String question = sc.nextLine();

            //如果AI知道
            if(brain.containsKey(question)){
                System.out.println("AI: " + brain.get(question));
            }

            //如果AI不知道
            else{

                System.out.println("AI: 我不知道答案，请教我");

                System.out.print("你: ");
                String answer = sc.nextLine();

                brain.put(question,answer);

                System.out.println("AI: 学会了！");
            }

        }
    }
}
