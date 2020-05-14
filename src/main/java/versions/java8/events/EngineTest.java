package versions.java8.events;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author xiaoy
 * @date 2020/05/13
 */
public class EngineTest {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        System.out.println(engine.getClass().getName());
        try {
            System.out.println("Result: " + engine.eval("funsction f() { return 1; }; f() + 1;"));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
