package problems.jvm.generics;

public class Test {
    static <T extends Number> T getObject() {
        return (T)Long.valueOf(1L);
    }

    public static void main(String... args) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(getObject());
    }
}
