import java.util.concurrent.TimeUnit;

public class Test {
    private static boolean stopped = false;
    public static void main( String[] args ) throws InterruptedException {
        Thread threadC = new Thread( new C() );
        Thread threadD = new Thread( new D() );
        threadC.start();
        threadD.start();
        TimeUnit.SECONDS.sleep( 5);
        System.out.println( "Done" );
        threadC.join();
        threadD.join();
        stopped = true;
    }
    static class C implements Runnable {
        @Override
        public void run() {
            while( !stopped ) {
            }
            System.out.println( "Out" );
        }
    }

    static class D implements Runnable {
        @Override
        public void run() {
            while( true ) {
                if( stopped ) {
                    break;
                }
            }
            System.out.println( "Out" );
        }
    }
}
