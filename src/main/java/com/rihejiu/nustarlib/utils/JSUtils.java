package com.rihejiu.nustarlib.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.NumberFormat;

public class JSUtils {
    static final ScriptEngineManager manager = new ScriptEngineManager();
    public static double stringMath(String str) throws ScriptException {
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(2);
        return Double.parseDouble(formatter.format(Double.parseDouble(String.valueOf(engine.eval(str)))).replaceAll(",",""));
    }
}
