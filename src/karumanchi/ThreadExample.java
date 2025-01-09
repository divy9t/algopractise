package karumanchi;

public class ThreadExample {
}

Thread t1 = new Thread();

t1.start();  ------> Fetch txns notify();

Thread t2 = new Thread();

t2.start();   send mail (wait();)


Thread t3 = new Thread();

t3.start();   send mail (wait();)