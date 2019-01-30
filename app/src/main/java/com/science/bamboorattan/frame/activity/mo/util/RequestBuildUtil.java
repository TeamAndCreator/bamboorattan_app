package com.science.bamboorattan.frame.activity.mo.util;

import com.science.androidbase.utils.TextUtils;
import com.science.bamboorattan.frame.activity.mo.bean.Pair;
import com.science.bamboorattan.frame.activity.mo.constant.GlobalConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class RequestBuildUtil {


    public static String getRequestUrl(Table catalog) {
        switch (catalog) {
            case GENUS:
                return GlobalConstants.GENUS_ADD;
            case SPEC:
                return GlobalConstants.SPEC_ADD;
            case CULM:
                return GlobalConstants.CULM_ADD;
            case LEAF:
                return GlobalConstants.LEAF_ADD;
            case SHEATH:
                return GlobalConstants.SHEATH_ADD;
            case PHYSICS:
                return GlobalConstants.PHYSICS_ADD;
            case CHEMISTRY:
                return GlobalConstants.CHEMISTRY_ADD;
            case MECHANICS:
                return GlobalConstants.MECHANICS_ADD;
            case SHEATHEAR:
                return GlobalConstants.SHEATH_EAR_ADD;
            case STRUCTURE:
                return GlobalConstants.STRUCTURE_ADD;
            case UNDERSTEM:
                return GlobalConstants.UNDERS_TEM_ADD;
            case SHEATHNODE:
                return GlobalConstants.SHEATH_NODE_ADD;
            case FLOWERFRUIT:
                return GlobalConstants.FLOWER_FRUIT_ADD;
            case SHEATHSHELL:
                return GlobalConstants.SHEATH_SHELL_ADD;
            case SHEATHTONGUE:
                return GlobalConstants.SHEATH_TONGUE_ADD;
            case FIBERMORPHOLOGY:
                return GlobalConstants.FIBER_MORPHOLOGY_ADD;
            case TISSUEPROPORTION:
                return GlobalConstants.TISSUE_PROPORTION_ADD;
            case CATHETERMORPHOLOGY:
                return GlobalConstants.CATHETER_MORPHOLOGY_ADD;
            case VASCULARBUNDLEMORPHOLOGY:
                return GlobalConstants.VASCULAR_BUNDLE_MORPHOLOGY_ADD;
            default:
                return GlobalConstants.VASCULAR_BUNDLE_MORPHOLOGY_ADD;
        }
    }

    public static Map<String, String> getRequestParams(Table catalog, String id, String name,
                                                       List<Pair>
                                                               pairList) {
        if (pairList == null || pairList.isEmpty()) {
            return null;
        }
        switch (catalog) {
            case GENUS:
                return addGenus(pairList);
            case SPEC:
                return addSpec(id, name, pairList);
            case CULM:
                return addCulm(id, name, pairList);
            case LEAF:
                return addLeaf(id, name, pairList);
            case SHEATH:
                return addSheath(id, name, pairList);
            case PHYSICS:
                return addPhysics(id, name, pairList);
            case CHEMISTRY:
                return addChemistry(id, name, pairList);
            case MECHANICS:
                return addMechanics(id, name, pairList);
            case SHEATHEAR:
                return addSheathEar(id, name, pairList);
            case STRUCTURE:
                return addStructure(id, name, pairList);
            case UNDERSTEM:
                return addUnderStem(id, name, pairList);
            case SHEATHNODE:
                return addSheathNode(id, name, pairList);
            case FLOWERFRUIT:
                return addFlowerFruit(id, name, pairList);
            case SHEATHSHELL:
                return addSheathShell(id, name, pairList);
            case SHEATHTONGUE:
                return addSheathTongue(id, name, pairList);
            case FIBERMORPHOLOGY:
                return addFiberMorphology(id, name, pairList);
            case TISSUEPROPORTION:
                return addTissueProportion(id, name, pairList);
            case CATHETERMORPHOLOGY:
                return addCatheterMorphology(id, name, pairList);
            case VASCULARBUNDLEMORPHOLOGY:
                return addVascularBundelMorphology(id, name, pairList);
            default:
                return addVascularBundelMorphology(id, name, pairList);
        }
    }

    /**
     * 1、属表添加
     *
     * @param pairs
     * @return
     */

    private static Map<String, String> addGenus(List<Pair> pairs) {
        Map<String, String> params = new HashMap<>();
        int i = 0;
        params.put("genusNameCh", pairs.get(i++).getValue());
        params.put("genusNameEn", pairs.get(i++).getValue());
        params.put("genusNameLd", pairs.get(i++).getValue());
        params.put("genusNameOth", pairs.get(i++).getValue());
        params.put("genusDesc", pairs.get(i++).getValue());
        params.put("sortNum", pairs.get(i).getValue());
        return params;
    }

    /**
     * 2、种表添加
     *
     * @param id
     * @param pairs
     * @return
     */

    private static Map<String, String> addSpec(String id, String genusName, List<Pair> pairs) {
        Map<String, String> params = new HashMap<>();
        int i = 0;
        params.put("genusId", id);
        params.put("genusName", genusName);
        params.put("specNameCh", pairs.get(i++).getValue());
        params.put("specNameEn", pairs.get(i++).getValue());
        String ld = pairs.get(i++).getValue();
        if (!TextUtils.isEmpty(ld)) {
            params.put("specNameLd", ld);
        }
        String oth = pairs.get(i++).getValue();
        if (!TextUtils.isEmpty(oth)) {
            params.put("specNameOth", oth);
        }
        String code = pairs.get(i++).getValue();
        if (!TextUtils.isEmpty(code)) {
            params.put("specCode", code);
        }
        String barCode = pairs.get(i++).getValue();
        if (!TextUtils.isEmpty(barCode)) {
            params.put("specBarCode", barCode);
        }
        String dna = pairs.get(i++).getValue();
        if (!TextUtils.isEmpty(dna)) {
            params.put("specDna", dna);
        }
        String domestic = pairs.get(i++).getValue();
        if (TextUtils.isEmpty(domestic)) {
            params.put("specDomestic", domestic);
        }
        String foreign = pairs.get(i++).getValue();
        if (!TextUtils.isEmpty(foreign)) {
            params.put("specForeign", foreign);
        }
        params.put("specVidio", pairs.get(i++).getValue());
        params.put("specVidioName", pairs.get(i++).getValue());
        params.put("specImgs", "");
        params.put("specSortNum", pairs.get(i++).getValue());
        String desc = pairs.get(i).getValue();
        if (!TextUtils.isEmpty(desc)) {
            params.put("specDesc", desc);

        }
        return params;
    }

    /**
     * 3、地下茎表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addUnderStem(String specId, String specName, List<Pair>
            pairs) {
        Map<String, String> params = new HashMap<>(3);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("underStem", pairs.get(i).getValue());
        return params;
    }

    /**
     * 4、竹秆表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addCulm(String specId, String specName, List<Pair> pairs) {
        Map<String, String> params = new HashMap<>(15);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("leafTopShape", pairs.get(i++).getValue());
        params.put("culmDiameter", pairs.get(i++).getValue());
        params.put("culmColor", pairs.get(i++).getValue());
        params.put("culmTop", pairs.get(i++).getValue());
        params.put("culmStem", pairs.get(i++).getValue());
        params.put("internodeLength", pairs.get(i++).getValue());
        params.put("internodeShape", pairs.get(i++).getValue());
        params.put("internodeAerialRoot", pairs.get(i++).getValue());
        params.put("internodeBack", pairs.get(i++).getValue());
        params.put("internodeCulmWall", pairs.get(i++).getValue());
        params.put("youngStemBack", pairs.get(i++).getValue());
        params.put("youngStemPowder", pairs.get(i++).getValue());
        params.put("culmNode", pairs.get(i).getValue());
        return params;
    }

    /**
     * 5、竹叶表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addLeaf(String specId, String specName, List<Pair> pairs) {
        Map<String, String> params = new HashMap<>(13);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("leafShape", pairs.get(i++).getValue());
        params.put("leafLength", pairs.get(i++).getValue());
        params.put("leafWidth", pairs.get(i++).getValue());
        params.put("leafNum", pairs.get(i++).getValue());
        params.put("leafBack", pairs.get(i++).getValue());
        params.put("leafMargin", pairs.get(i++).getValue());
        params.put("leafTongueShape", pairs.get(i++).getValue());
        params.put("leafTongueHeight", pairs.get(i++).getValue());
        params.put("leafStalkLength", pairs.get(i++).getValue());
        params.put("leafBaseShape", pairs.get(i++).getValue());
        params.put("leafTopShape", pairs.get(i).getValue());
        return params;
    }

    /**
     * 6、箨环表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addSheathNode(String specId, String specName, List<Pair>
            pairs) {
        Map<String, String> params = new HashMap<>(4);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("sheathNode", pairs.get(i++).getValue());
        params.put("sheathNodeBack", pairs.get(i).getValue());
        return params;
    }

    /**
     * 7、箨鞘表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addSheath(String specId, String specName, List<Pair> pairs) {
        Map<String, String> params = new HashMap<>(7);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("sheathShedTime", pairs.get(i++).getValue());
        params.put("sheathChar", pairs.get(i++).getValue());
        params.put("sheathTopForm", pairs.get(i++).getValue());
        params.put("sheathBackPowder", pairs.get(i++).getValue());
        params.put("sheathMarginForm", pairs.get(i).getValue());
        return params;
    }

    /**
     * 8、箨耳表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addSheathEar(String specId, String specName, List<Pair>
            pairs) {
        Map<String, String> params = new HashMap<>(5);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("sheathEarDev", pairs.get(i++).getValue());
        params.put("sheathEarShape", pairs.get(i++).getValue());
        params.put("sheathEarMargin", pairs.get(i).getValue());
        return params;
    }


    /**
     * 9、箨舌表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addSheathTongue(String specId, String specName, List<Pair>
            pairs) {
        Map<String, String> params = new HashMap<>(6);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("sheathTongueColor", pairs.get(i++).getValue());
        params.put("sheathTongueHeight", pairs.get(i++).getValue());
        params.put("sheathTongueMarginShape", pairs.get(i++).getValue());
        params.put("sheathTongueBackPowderv", pairs.get(i).getValue());
        return params;
    }

    /**
     * 10、箨片表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addSheathShell(String specId, String specName, List<Pair>
            pairs) {
        Map<String, String> params = new HashMap<>(10);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("sheathShellShape", pairs.get(i++).getValue());
        params.put("sheathShellColor", pairs.get(i++).getValue());
        params.put("sheathShellFall", pairs.get(i++).getValue());
        params.put("sheathShellTopShape", pairs.get(i++).getValue());
        params.put("sheathShellBaseShape", pairs.get(i++).getValue());
        params.put("sheathShellMargin", pairs.get(i++).getValue());
        params.put("sheathShellBackPowder", pairs.get(i++).getValue());
        params.put("sheathRatioOf", pairs.get(i).getValue());
        return params;
    }

    /**
     * 11、花果形态表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    public static Map<String, String> addFlowerFruit(String specId, String specName, List<Pair>
            pairs) {
        Map<String, String> params = new HashMap<>(10);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("spikeletShape", pairs.get(i++).getValue());
        params.put("spikeletBack", pairs.get(i++).getValue());
        params.put("spikeletFloret", pairs.get(i++).getValue());
        params.put("stamenNum", pairs.get(i++).getValue());
        params.put("glume", pairs.get(i++).getValue());
        params.put("lodicule", pairs.get(i++).getValue());
        params.put("palea", pairs.get(i++).getValue());
        params.put("lemma", pairs.get(i).getValue());
        return params;
    }

    /**
     * 12、结构性质表添加
     *
     * @param specId
     * @param pairs
     * @return 请求参数
     */
    private static Map<String, String> addStructure(String specId, String specName, List<Pair>
            pairs) {
        Map<String, String> params = new HashMap<>(6);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("stStemDiameterUnitMm", pairs.get(i++).getValue());
        params.put("stWallThicknessUnitMm", pairs.get(i++).getValue());
        params.put("stMaximumInternodeLengthUnitCm", pairs.get(i++).getValue());
        params.put("stRattanDiameterUnitMm", pairs.get(i).getValue());
        return params;
    }

    /**
     * 13、物理性质表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addPhysics(String specId, String specName, List<Pair>
            pairs) {
        Map<String, String> params = new HashMap<>(21);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("phyRelativeUnitPercent", pairs.get(i++).getValue());
        params.put("phyAbsoluteUnitPercent", pairs.get(i++).getValue());
        params.put("phyGreenDensityUnitMidu", pairs.get(i++).getValue());
        params.put("phyBasicDensityUnitMidu", pairs.get(i++).getValue());
        params.put("phyAirDryDensityUnitMidu", pairs.get(i++).getValue());
        params.put("phyAbsoluteDryDensityUnitMidu", pairs.get(i++).getValue());
        params.put("phyAirDryingLineUnitPercent", pairs.get(i++).getValue());
        params.put("phyWholeDryLineUnitPercent", pairs.get(i++).getValue());
        params.put("phyAirDryVolumeUnitPercent", pairs.get(i++).getValue());
        params.put("phyWholeDryVolumeUnitPercent", pairs.get(i++).getValue());
        params.put("phyAirShrinkageUnitPercent", pairs.get(i++).getValue());
        params.put("phyAirShrinkageChordwiseUnitPercent", pairs.get(i++).getValue());
        params.put("phyAirShrinkageRadialUnitPercent", pairs.get(i++).getValue());
        params.put("phyAirShrinkageEdnwiseUnitPercent", pairs.get(i++).getValue());
        params.put("phyAirShrinkageVolumeUnitPercent", pairs.get(i++).getValue());
        params.put("phyWholeShrinkageChordwiseUnitPercent", pairs.get(i++).getValue());
        params.put("phyWholeShrinkageRadialUnitPercent", pairs.get(i++).getValue());
        params.put("phyWholeShrinkageEdnwiseUnitPercent", pairs.get(i++).getValue());
        params.put("phyWholeShrinkageVolumeUnitPercent", pairs.get(i).getValue());
        return params;
    }

    /**
     * 14、化学性质表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addChemistry(String specId, String specName, List<Pair>
            pairs) {
        Map<String, String> params = new HashMap<>(11);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("chemHolocelluloseUnitPercent", pairs.get(i++).getValue());
        params.put("chemCelluloseUnitPercent", pairs.get(i++).getValue());
        params.put("chemHemicelluloseUnitPercent", pairs.get(i++).getValue());
        params.put("chemACelluloseUnitPercent", pairs.get(i++).getValue());
        params.put("chemAcidInsolubleLigninUnitPercent", pairs.get(i++).getValue());
        params.put("chemBenzeneAlcoholExtractionUnitPercent",
                pairs.get(i++).getValue());
        params.put("chemHotWaterExtractionUnitPercent", pairs.get(i++).getValue());
        params.put("chemColdWaterExtractionUnitPercent", pairs.get(i++).getValue());
        params.put("chemAshContentUnitPercent", pairs.get(i).getValue());
        return params;
    }

    /**
     * 15、力学性质表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addMechanics(String specId, String specName, List<Pair>
            pairs) {
        Map<String, String> params = new HashMap<>(9);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("mechBendingModulusElastictyUnitGpa", pairs.get(i++).getValue());
        params.put("mechBendingStrenghtUnitMpa", pairs.get(i++).getValue());
        params.put("mechCompressionStrenghtUnitMpa", pairs.get(i++).getValue());
        params.put("mechShearStrenghtUnitMpa", pairs.get(i++).getValue());
        params.put("mechTensileStrenghtUnitMpa", pairs.get(i++).getValue());
        params.put("mechImpactDuctilityUnitRenxiang", pairs.get(i++).getValue());
        params.put("mechComplianceUnitRouliang", pairs.get(i).getValue());
        return params;
    }

    /**
     * 16、导管形态表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addCatheterMorphology(String specId, String specName,
                                                             List<Pair> pairs) {
        Map<String, String> params = new HashMap<>(6);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("chmCatheterLenghtUnitMicrom", pairs.get(i++).getValue());
        params.put("chmCatheterDiameterUnitMicrom", pairs.get(i++).getValue());
        params.put("chmCatheterDensityUnitVcmidu", pairs.get(i++).getValue());
        params.put("chmIndex", pairs.get(i).getValue());
        return params;
    }

    /**
     * 17、维管束形态表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addVascularBundelMorphology(String specId, String specName,
                                                                   List<Pair> pairs) {
        Map<String, String> params = new HashMap<>(5);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("vbmRadialDiameterUnitMicrom", pairs.get(i++).getValue());
        params.put("vbmChordDiameterUnitMicrom", pairs.get(i++).getValue());
        params.put("vbmDensityUnitVcmidu", pairs.get(i).getValue());
        return params;
    }

    /**
     * 18、组织比量表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addTissueProportion(String specId, String specName,
                                                           List<Pair> pairs) {
        Map<String, String> params = new HashMap<>(6);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("tpFiberPeoportionUnitPercent", pairs.get(i++).getValue());
        params.put("tpVesselProportionUnitPercent", pairs.get(i++).getValue());
        params.put("tpSieveTubeProportionUnitPercent", pairs.get(i++).getValue());
        params.put("tpParenchymaCellProportionUnitPercent", pairs.get(i).getValue());
        return params;
    }

    /**
     * 19、纤维形态表添加
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addFiberMorphology(String specId, String specName,
                                                          List<Pair> pairs) {
        Map<String, String> params = new HashMap<>(9);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("fmLengthUnitMicron", pairs.get(i++).getValue());
        params.put("fmWidthUnitMicron", pairs.get(i++).getValue());
        params.put("fmDwallThicknessUnitMicron", pairs.get(i++).getValue());
        params.put("fmLetWidthRatio", pairs.get(i++).getValue());
        params.put("fmCavityDeameterUnitMicrom", pairs.get(i++).getValue());
        params.put("fmWallCavityRatio", pairs.get(i++).getValue());
        params.put("fmCavityDiameterRatio", pairs.get(i++).getValue());
        return params;
    }


    /**
     * 20、用户登录
     *
     * @param userAcct 账号
     * @param userPwd  密码
     * @return
     */
    public static Map<String, String> login(String userAcct, String userPwd) {

        Map<String, String> params = new HashMap<>(2);
        params.put("userAcct", userAcct);
        params.put("userPwd", userPwd);
        return params;
    }

    /**
     * 21、用户注册
     *
     * @param userAcct 登录账号
     * @param userPwd  密码
     * @param userName 用户姓名
     * @param orgName  所在部门
     * @param orgPhone 办公电话
     * @return
     */
    public static Map<String, String> register(String userAcct, String userPwd, String userName,
                                               String orgName,
                                               String orgPhone) {
        Map<String, String> params = new HashMap<>(5);
        params.put("userAcct", userAcct);
        params.put("userPwd", userPwd);
        params.put("userName", userName);
        params.put("orgName", orgName);
        params.put("orgPhone", orgPhone);
        return params;

    }

}
