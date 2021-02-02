package Lesson1;

public class Cat {

    public String name;
    public int run;
    public int jump;


    public Cat(String name, int run, int jump) {

        this.name = name;
        this.jump = jump;
        this.run = run;

    }

    public static void run(Cat[] cat, RunningTrack runTrack) {

        for(Cat runing : cat){
            if(runing.run < runTrack.runDistance){
                System.out.println(runing.name + " смог пробежать: " + runTrack.runDistance + " метров");
            }
            else {
                System.out.println(runing.name + " не смог пробежать: " + runTrack.runDistance + " метров");
            }
        }

    }


    public static void jump(Cat[] human, Wall jump) {

        for (Cat jumping : human) {
            if (jumping.jump < jump.jumpHeight) {
                System.out.println(jumping.name + " перепрыгнул стену: " + jump.jumpHeight + " метров");
            }
            else {
                System.out.println(jumping.name + " не смог перепрыгнуть стену: " + jump.jumpHeight + " метров");
            }
        }

    }
}
