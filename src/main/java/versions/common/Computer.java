package versions.common;

/**
 * @author xiaoy
 * @date 2020/05/15
 */
public class Computer implements Electronic {

    public static void main(String[] args) {
        new Computer();
    }

    @Override
    public int getElectricityUse() {
        return 0;
    }
}
