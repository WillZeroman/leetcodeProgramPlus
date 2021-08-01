import java.util.concurrent.CompletableFuture;

public class TestFuture {
    public static void main(String[] args) {
        CompletableFuture.runAsync(()->{
            System.out.println("hello aysnc");
        });


    }
}
