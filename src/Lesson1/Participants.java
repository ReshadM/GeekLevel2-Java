package Lesson1;

public class Participants {

   public int runDistance;
   public int jumpHeight;

    public static void main(String[] args){
        RunningTrack runTrack = new RunningTrack(400);
        Wall jump = new Wall(25);


        Cat[] cat = {
                new Cat("Garfield",200,15),
                new Cat("Bastian", 150, 10),
        };


        Human[] human = {
                new Human("Maksim", 500, 5),
                new Human("Pasha", 150, 3),
        };

        Robot[] robot = {
                new Robot("Chappie", 700, 20),
                new Robot("Arnold", 1000, 25),
        };
        

        Human.run(human, runTrack);
        Human.jump(human, jump);
        Cat.run(cat, runTrack);
        Cat.jump(cat, jump);
        Robot.run(robot, runTrack);
        Robot.jump(robot, jump);

    }
}
