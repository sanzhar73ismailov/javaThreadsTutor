package javathreadstutor;

/**
 *
 * @author admin
 */
public class CreatingThreads {

    public static void main(String[] args) {
        //approach0101();
        //approach0102();
        approach02();
    }

    static void approach0101() {
        Thread.currentThread().setName("Main thread");
        System.out.println("Главный поток начат - approach0101: " + Thread.currentThread().getName());
        SomeThing someThing = new SomeThing();
        Thread newThread = new Thread(someThing);
        newThread.setName("second thread");
        newThread.start();
        System.out.println("Главный поток завершён...");
    }

    static void approach0102() {
        System.out.println("Главный поток начат - approach0102" + Thread.currentThread().getName());
        Thread threadNew = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Привет из побочного потока!" + Thread.currentThread().getName());
            }
        });
        threadNew.start();
        System.out.println("Главный поток завершён...");
    }

    static void approach02() {
        System.out.println("Главный поток начат - approach02, thread name:" + Thread.currentThread().getName());
        AffableThread theadNew = new AffableThread();
        theadNew.start();
        System.out.println("Главный поток завершён...");
    }
}

class SomeThing implements Runnable {

    @Override
    public void run() {
        System.out.println("Привет из побочного потока!" + Thread.currentThread().getName());
    }
}

class AffableThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hi from AffableThread");
    }
}
