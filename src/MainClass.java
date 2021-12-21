import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        String End_Game_Button = "L";
        System.out.println("Введте имя первого робота:");
        String robotAname = getLineFromConcole();
        Robot robot_A = new Robot(robotAname, End_Game_Button);
        System.out.println("You name:"+ robot_A.getRobotName());


        System.out.println("Введте имя второго робота:");
        String robotBname = getLineFromConcole();
        Robot robot_B = new Robot(robotBname, End_Game_Button);
        System.out.println("You name:"+ robot_B.getRobotName());

        while (robot_A.isAlive() || robot_B.isAlive()){
            System.out.printf("Кнопки которые принимают участие в игре: %s\n", robot_B.getAlphabet());
            System.out.printf("Для выхода с игры введите: %s\n",End_Game_Button);
            String hitA ;
            while (true) {
                System.out.println("Введите кнопку для нанесения удара роботу:" + robot_B.getRobotName());
                hitA = getLineFromConcole();

                if (hitA.length()>1){
                    hitA = hitA.substring(0,1);
                    System.out.printf("Вы ввели более чем один символ, мы берем первый: %s\n", hitA);

                }

                int position = robot_B.getAlphabet().indexOf(hitA);
                if (position >=0){
                    break;
                }
                else {
                    System.out.println("Эта кнопка не принимает участия в игре. Введите кнопку из списка");
                }
            }
            if (hitA.equals(End_Game_Button)) {
                System.out.println("Выход из игры!!!");
                break;
            }
            robot_B.hitMe(hitA);
            robot_A.printInfo();
            robot_B.printInfo();
            if (!robot_B.isAlive()){
                System.out.println("Победил робот:" + robot_A.getRobotName());
                break;
            }

            System.out.printf("Кнопки которые принимают участие в игре: %s\n", robot_A.getAlphabet());
            System.out.printf("Для выхода с игры введите: %s\n",End_Game_Button);
            String hitB ;
            while (true) {
                System.out.println("Введите кнопку для нанесения удара роботу:" + robot_A.getRobotName());
                hitB = getLineFromConcole();

                if (hitB.length()>1){
                    hitA = hitB.substring(0,1);
                    System.out.printf("Вы ввели более чем один символ, мы берем первый: %s\n", hitB);

                }

                int position = robot_A.getAlphabet().indexOf(hitB);
                if (position >=0){
                    break;
                }
                else {
                    System.out.println("Эта кнопка не принимает участия в игре. Введите кнопку из списка");
                }
            }

            if(hitB.equals(End_Game_Button)){
                System.out.println("Выход из игры!!!");
                break;
            }
            robot_A.hitMe(hitB);
            robot_A.printInfo();
            robot_B.printInfo();
            if (!robot_A.isAlive()){
                System.out.println("Победил робот:" + robot_B.getRobotName());
                break;
            }
        }

    }
    public static String getLineFromConcole() {
        Scanner scanner = new Scanner(System.in); // умеет работать с системным вводом
            return scanner.nextLine();// считай цифру

    }
}
