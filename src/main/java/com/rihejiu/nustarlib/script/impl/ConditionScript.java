package com.rihejiu.nustarlib.script.impl;

import com.rihejiu.nustarlib.script.NuStarScript;
import com.rihejiu.nustarlib.script.ScriptResult;

public class ConditionScript implements NuStarScript {
    private final String[] scriptBody;
    public ConditionScript(String script) {
        scriptBody = script.split(" ");
    }
    @Override
    public ScriptResult execute() {
        switch (scriptBody[2]) {
            case ">=":
                if (Double.parseDouble(scriptBody[1]) >= Double.parseDouble(scriptBody[3])) {
                    return ScriptResult.SUCCESS;
                } else {
                    return ScriptResult.FAIL;
                }
            case "<=":
                if (Double.parseDouble(scriptBody[1]) <= Double.parseDouble(scriptBody[3])) {
                    return ScriptResult.SUCCESS;
                } else {
                    return ScriptResult.FAIL;
                }
            case "==":
                if (Double.parseDouble(scriptBody[1]) == Double.parseDouble(scriptBody[3])) {
                    return ScriptResult.SUCCESS;
                } else {
                    return ScriptResult.FAIL;
                }
            case "===":
                if (scriptBody[1].equals(scriptBody[3])) {
                    return ScriptResult.SUCCESS;
                } else {
                    return ScriptResult.FAIL;
                }
            case "!=":
                if (!scriptBody[1].equals(scriptBody[3])) {
                    return ScriptResult.SUCCESS;
                } else {
                    return ScriptResult.FAIL;
                }
            case ">":
                if (Double.parseDouble(scriptBody[1]) > Double.parseDouble(scriptBody[3])) {
                    return ScriptResult.SUCCESS;
                } else {
                    return ScriptResult.FAIL;
                }
            case "<":
                if (Double.parseDouble(scriptBody[1]) < Double.parseDouble(scriptBody[3])) {
                    return ScriptResult.SUCCESS;
                } else {
                    return ScriptResult.FAIL;
                }
        }
        return null;
    }
}
