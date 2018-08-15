package reflection;



public class TestReflection2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(){
            public void run(){
                //����method1
                TestReflection2.method1();
            }
        };
        t1.setName("��һ���߳�+��һ��");
        t1.start();
         
        //��֤��һ���߳��ȵ���method1
       Thread.sleep(5000);
       System.out.println("����������");
         
        Thread t2= new Thread(){
            public void run(){
                //����method2
                TestReflection2.method2();
            }
        };
        t2.setName("�ڶ����߳�");
        t2.start();
    }
 
    public static void method1() {
 
        synchronized (TestReflection2.class) {
            // ����method1���ԣ�ͬ��������TestReflection.class��ֻ��ռ��TestReflection.class�ſ���ִ�е�����
            System.out.println(Thread.currentThread().getName() + " ������method1����");
            try {
            	Thread.sleep(5000);
                System.out.println("M1����5��");
                
            } catch (InterruptedException e) {
 
                e.printStackTrace();
            }
        }
    }
 
    public static synchronized void method2() {
        // ����mehotd2���ԣ���Ȼ�и�ͬ������ͨ���۲췢�֣���ĳ���߳���method1�У�ռ����TestReflection.class֮��
        // ���޷�����method2���ƶϳ���method2��ͬ�����󣬾���TestReflection.class
        System.out.println(Thread.currentThread().getName() + " ������method2����");
        try {
            System.out.println("M2����5��");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
 
            e.printStackTrace();
        }
 
    }
}