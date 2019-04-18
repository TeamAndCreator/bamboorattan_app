package com.science.bamboorattan.frame.activity.mo.util;

public class TableUtil {

    public static String getTableName(Table table) {
        switch (table) {
            case TGENUS:
                return "藤属";
            case TSPEC:
                return "藤种";
            case TUNDERSTEM:
                return "藤地下茎";
            case TCULM:
                return "藤秆";
            case TLEAF:
                return "藤叶";
            case TSHEATH:
                return "藤箨鞘";
            case TSHEATHEAR:
                return "藤箨耳";
            case TSHEATHNODE:
                return "藤箨环";
            case TSHEATHSHELL:
                return "藤箨片";
            case TSHEATHTONGUE:
                return "藤箨舌";
            case TFLOWERFRUIT:
                return "藤花果形态";
            case TPHYSICS:
                return "藤物理性质";
            case TCHEMISTRY:
                return "藤化学性质";
            case TMECHANICS:
                return "藤力学性质";
            case TSTRUCTURE:
                return "藤结构性质";
            case TFIBERMORPHOLOGY:
                return "藤纤维形态";
            case TTISSUEPROPORTION:
                return "藤组织比量";
            case TCATHETERMORPHOLOGY:
                return "藤导管形态";
            case TVASCULARBUNDLEMORPHOLOGY:
                return "藤维管束形态";
            case GENUS:
                return "竹属";
            case SPEC:
                return "竹种";
            case UNDERSTEM:
                return "地下茎";
            case CULM:
                return "竹秆";
            case LEAF:
                return "竹叶";
            case SHEATH:
                return "箨鞘";
            case SHEATHEAR:
                return "箨耳";
            case SHEATHNODE:
                return "箨环";
            case SHEATHSHELL:
                return "箨片";
            case SHEATHTONGUE:
                return "箨舌";
            case FLOWERFRUIT:
                return "花果形态";
            case PHYSICS:
                return "物理性质";
            case CHEMISTRY:
                return "化学性质";
            case MECHANICS:
                return "力学性质";
            case STRUCTURE:
                return "结构性质";
            case FIBERMORPHOLOGY:
                return "纤维形态";
            case TISSUEPROPORTION:
                return "组织比量";
            case CATHETERMORPHOLOGY:
                return "导管形态";
            case VASCULARBUNDLEMORPHOLOGY:
                return "维管束形态";
            default:
                return "维管束形态";

        }
    }
}
