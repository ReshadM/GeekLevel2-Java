package Lesson1;

public class Robot {

    public String name;
    public int run;
    public int jump;
    boolean isValid;

    public Robot(String name, int run, int jump) {

        this.name = name;
        this.jump = jump;
        this.run = run;
        this.isValid = true;

    }

    public static void run(Robot[] robot, RunningTrack runTrack) {

        for (Robot runing : robot) {
            if (!runing.isValid) {
                continue;
            }
            if (runing.run >= runTrack.runDistance) {
                System.out.println(runing.name + " смог пробежать: " + runTrack.runDistance + " метров");
            } else {
                System.out.println(runing.name + " не смог пробежать: " + runTrack.runDistance + " метров");
                runing.isValid = false;
            }
        }

    }



    public static void jump (Robot[]robot, Wall jump){

        for (Robot jumping : robot) {
            if (!jumping.isValid) {
                continue;
            }
            if (jumping.jump >= jump.jumpHeight) {
                System.out.println(jumping.name + " перепрыгнул стену: " + jump.jumpHeight + " метров");
            } else {
                System.out.println(jumping.name + " не смог перепрыгнуть стену: " + jump.jumpHeight + " метров");
                jumping.isValid = false;
            }
        }

    }


}

