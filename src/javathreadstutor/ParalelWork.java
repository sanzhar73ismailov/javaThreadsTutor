package javathreadstutor;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ParalelWork {

    public static void main(String[] args) {
        System.out.println("Main start");

        Thread theadTwo = new EggVoice();
        theadTwo.start();

        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Chicken");
        }
        if (theadTwo.isAlive()) {
            try {
                theadTwo.join();
                System.out.println("Egg is first");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Chicken is first");
        }
        System.out.println("Спор закончен");
    }
}

class EggVoice extends Thread {

    @Override
    public void run() {
        System.out.println("Start child: name: " + Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Egg");
        }
    }

}
