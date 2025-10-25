package Interview;

public class ThreadLocalManager {

    private static final ThreadLocal<String> th = new ThreadLocal<>();

    public static String getThreadVariable() {
        return th.get();
    }

    public static void setThreadVariable(String token) {
        th.set(token);
    }


}
