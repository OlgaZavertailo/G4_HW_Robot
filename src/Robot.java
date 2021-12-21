import java.util.Random;

public class Robot {
    private String name;
    private int health = 100;
    String alphabet = "QWEASDZXC";
    String alphabet_copy = alphabet;
    private String end_Game;
    private String hit_List = ""; // удары

    public Robot (String  name, String exit_button){
        this.name = name;
        this.end_Game = exit_button;

      for (int i = 0; i < 5; i++){
            hit_List += getRandomKey();
       }
//        System.out.println("hit_list "+ hit_List+ "  "+ this.getRobotName());


    }
    public String getRobotName(){
        return this.name;
    }
    public  boolean isAlive (){
        return health > 0;
    }
    char getRandomKey(){
        int randIdx = new Random().nextInt(alphabet.length());
        char randChar = alphabet.charAt(randIdx);
        alphabet = alphabet.replace(String.valueOf(randChar), "");
        return randChar;
    }
    public void hitMe(String key){
        int position = hit_List.indexOf(key);
        if (position >=0){
            health = health - 20;
            hit_List = hit_List.replace(key,"");
           // System.out.println("hitlist: '" + hit_List + "'");
        } else {
            System.out.println("Кнопка не нанесла удар");
            System.out.printf("Кнопки которые принимают участие в игре: %s\n",alphabet_copy);
            System.out.printf("Для выхода с игры введите: %s\n",end_Game);
        }
//        System.out.println("hit_list  "+ hit_List + "  "+ this.getRobotName());

    }
    public void printInfo(){
        System.out.println("Имя робота: " + this.name + " Здоровье:  "  + this.health);
    }

    public String getAlphabet(){return alphabet_copy;
    }
}
