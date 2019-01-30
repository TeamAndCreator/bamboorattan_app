package com.science.bamboorattan.frame.activity.mo.util;

public class TableUtil {

    public static String getTableName(Table table) {
        switch (table) {
            case GENUS:
                return "属";
            case SPEC:
                return "种";
            case CULM:
                return "竹秆";
            case LEAF:
                return "竹叶";
            case SHEATH:
                return "箨鞘";
            case PHYSICS:
                return "物理性质";
            case CHEMISTRY:
                return "化学性质";
            case MECHANICS:
                return "力学性质";
            case SHEATHEAR:
                return "箨耳";
            case STRUCTURE:
                return "结构性质";
            case UNDERSTEM:
                return "地下茎";
            case SHEATHNODE:
                return "箨环";
            case FLOWERFRUIT:
                return "花果形态";
            case SHEATHSHELL:
                return "箨片";
            case SHEATHTONGUE:
                return "箨舌";
            case FIBERMORPHOLOGY:
                return "纤维形态";
            case TISSUEPROPORTION:
                return "组织比量";
            case CATHETERMORPHOLOGY:
                return "导管形态";
            case VASCULARBUNDLEMORPHOLOGY:
            default:
                return "维管束形态";

        }
    }
}
