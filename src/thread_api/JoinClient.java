package thread_api;

public class JoinClient {

    public static void main(String[] args) throws InterruptedException {
        Thread backendDev = createWorker("backed dev", "backend coding");
        Thread frontendDev = createWorker("frontend dev", "frontend coding");
        Thread tester = createWorker("tester", "testing");

        backendDev.start();
        frontendDev.start();

        backendDev.join();
        frontendDev.join();

        tester.start();
    }

    public static Thread createWorker(String role, String work) {
        return new Thread(() -> {
            System.out.println("I finished " + work + " as a " + role);
        });
    }
}
