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
            case SHEATHEAR:
                return GlobalConstants.SHEATH_EAR_ADD;
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
            case PHYSICS:
                return GlobalConstants.PHYSICS_ADD;
            case CHEMISTRY:
                return GlobalConstants.CHEMISTRY_ADD;
            case MECHANICS:
                return GlobalConstants.MECHANICS_ADD;
            case STRUCTURE:
                return GlobalConstants.STRUCTURE_ADD;
            case FIBERMORPHOLOGY:
                return GlobalConstants.FIBER_MORPHOLOGY_ADD;
            case TISSUEPROPORTION:
                return GlobalConstants.TISSUE_PROPORTION_ADD;
            case CATHETERMORPHOLOGY:
                return GlobalConstants.CATHETER_MORPHOLOGY_ADD;
            case VASCULARBUNDLEMORPHOLOGY:
                return GlobalConstants.VASCULAR_BUNDLE_MORPHOLOGY_ADD;
            case TCULM:
                return GlobalConstants.T_CULM_ADD;
            case TLEAF:
                return GlobalConstants.T_LEAF_ADD;
            case TSHEATH:
                return GlobalConstants.T_SHEATH_ADD;
            case TSHEATHEAR:
                return GlobalConstants.T_SHEATH_EAR_ADD;
            case TUNDERSTEM:
                return GlobalConstants.T_UNDERS_TEM_ADD;
            case TSHEATHNODE:
                return GlobalConstants.T_SHEATH_NODE_ADD;
            case TFLOWERFRUIT:
                return GlobalConstants.T_FLOWER_FRUIT_ADD;
            case TSHEATHSHELL:
                return GlobalConstants.T_SHEATH_SHELL_ADD;
            case TSHEATHTONGUE:
                return GlobalConstants.T_SHEATH_TONGUE_ADD;
            case TPHYSICS:
                return GlobalConstants.T_PHYSICS_ADD;
            case TCHEMISTRY:
                return GlobalConstants.T_CHEMISTRY_ADD;
            case TMECHANICS:
                return GlobalConstants.T_MECHANICS_ADD;
            case TSTRUCTURE:
                return GlobalConstants.T_STRUCTURE_ADD;
            case TFIBERMORPHOLOGY:
                return GlobalConstants.T_FIBER_MORPHOLOGY_ADD;
            case TTISSUEPROPORTION:
                return GlobalConstants.T_TISSUE_PROPORTION_ADD;
            case TCATHETERMORPHOLOGY:
                return GlobalConstants.T_CATHETER_MORPHOLOGY_ADD;
            case TVASCULARBUNDLEMORPHOLOGY:
                return GlobalConstants.T_VASCULAR_BUNDLE_MORPHOLOGY_ADD;
            case TSPEC:
                return GlobalConstants.RATTAN_SPEC_ADD;
            case TGENUS:
                return GlobalConstants.RATTAN_GENUS_ADD;
            default:
                return GlobalConstants.RATTAN_GENUS_ADD;
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
            case TGENUS:
                return addRattanGenus(pairList);
            case TSPEC:
                return addRattanSpec(id, name, pairList);
            case TCULM:
                return addRattanCulm(id, name, pairList);
            case TLEAF:
                return addRattanLeaf(id, name, pairList);
            case TSHEATH:
                return addRattanSheath(id, name, pairList);
            case TPHYSICS:
                return addRattanPhysics(id, name, pairList);
            case TCHEMISTRY:
                return addRattanChemistry(id, name, pairList);
            case TMECHANICS:
                return addRattanMechanics(id, name, pairList);
            case TSHEATHEAR:
                return addRattanSheathEar(id, name, pairList);
            case TSTRUCTURE:
                return addRattanStructure(id, name, pairList);
            case TUNDERSTEM:
                return addRattanUnderStem(id, name, pairList);
            case TSHEATHNODE:
                return addRattanSheathNode(id, name, pairList);
            case TFLOWERFRUIT:
                return addRattanFlowerFruit(id, name, pairList);
            case TSHEATHSHELL:
                return addRattanSheathShell(id, name, pairList);
            case TSHEATHTONGUE:
                return addRattanSheathTongue(id, name, pairList);
            case TFIBERMORPHOLOGY:
                return addRattanFiberMorphology(id, name, pairList);
            case TTISSUEPROPORTION:
                return addRattanTissueProportion(id, name, pairList);
            case TCATHETERMORPHOLOGY:
                return addRattanCatheterMorphology(id, name, pairList);
            case TVASCULARBUNDLEMORPHOLOGY:
                return addRattanVascularBundelMorphology(id, name, pairList);
            default:
                return addRattanVascularBundelMorphology(id, name, pairList);
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
        String vidio = pairs.get(i++).getValue();
        if (!TextUtils.isEmpty(vidio)) {
            params.put("specVidio", vidio);
        }
        String img = pairs.get(i++).getValue();
        if (!TextUtils.isEmpty(img)) {
            params.put("specImgs", img);
        }
        String desc = pairs.get(i).getValue();
        if (!TextUtils.isEmpty(desc)) {
            params.put("specDesc", desc);
        }
        params.put("addTime", pairs.get(i++).getValue());
        params.put("specLocation",pairs.get(i++).getValue());
        return params;
    }

    /**
     * 3、地下茎
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
     * 4、竹秆信息
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
     * 5、竹叶信息
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
     * 6、箨环信息
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
     * 7、箨鞘信息
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
     * 8、箨耳信息
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
     * 9、箨舌信息
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
     * 10、箨片信息
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
     * 11、花果形态信息
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
     * 12、结构性质
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
     * 13、物理性质
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
     * 14、化学性质
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
     * 15、力学性质
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
     * 16、导管形态
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
     * 17、维管束形态
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
     * 18、组织比量
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
     * 19、纤维形态
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
     * 20、藤属表添加
     *
     * @param pairs
     * @return
     */

    private static Map<String, String> addRattanGenus(List<Pair> pairs) {
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
     * 21、藤种表添加
     *
     * @param id
     * @param pairs
     * @return
     */

    private static Map<String, String> addRattanSpec(String id, String genusName, List<Pair> pairs) {
        Map<String, String> params = new HashMap<>();
        int i = 0;
        params.put("genusId", id);
        params.put("specNameCh", pairs.get(i++).getValue());
        params.put("specNameEn", pairs.get(i++).getValue());
//        params.put("specNameLd", pairs.get(i++).getValue());
//        params.put("specNameOth", pairs.get(i++).getValue());
//        params.put("specCode", pairs.get(i++).getValue());
//        params.put("specBarCode", pairs.get(i++).getValue());
//        params.put("specDna", pairs.get(i++).getValue());
//        params.put("specDomestic", pairs.get(i++).getValue());
//        params.put("specForeign", pairs.get(i++).getValue());
//        params.put("specVidio", pairs.get(i++).getValue());
//        params.put("specImgs", pairs.get(i++).getValue());
//        params.put("specSortNum", pairs.get(i++).getValue());
//        params.put("specDesc", pairs.get(i++).getValue());
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
        params.put("specImgs", pairs.get(i++).getValue());
        String desc = pairs.get(i).getValue();
        if (!TextUtils.isEmpty(desc)) {
            params.put("specDesc", desc);

        }
        params.put("addTime", pairs.get(i++).getValue());
        params.put("infoLocation",pairs.get(i++).getValue());
        return params;
    }

    /**
     * 22、藤地下茎
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanUnderStem(String specId, String specName, List<Pair>
            pairs) {
        Map<String, String> params = new HashMap<>(3);
        int i = 0;
        params.put("specId", specId);
        params.put("specName", specName);
        params.put("underStem", pairs.get(i).getValue());
        return params;
    }

    /**
     * 23、藤竹秆信息
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanCulm(String specId, String specName, List<Pair> pairs) {
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
     * 24、藤叶信息
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanLeaf(String specId, String specName, List<Pair> pairs) {
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
     * 25、藤箨环信息
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanSheathNode(String specId, String specName, List<Pair>
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
     * 26、藤箨鞘信息
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanSheath(String specId, String specName, List<Pair> pairs) {
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
     * 27、藤箨耳信息
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanSheathEar(String specId, String specName, List<Pair>
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
     * 28、藤箨舌信息
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanSheathTongue(String specId, String specName, List<Pair>
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
     * 29、藤箨片信息
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanSheathShell(String specId, String specName, List<Pair>
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
     * 30、藤花果形态信息
     *
     * @param specId
     * @param pairs
     * @return
     */
    public static Map<String, String> addRattanFlowerFruit(String specId, String specName, List<Pair>
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
     * 31、藤结构性质
     *
     * @param specId
     * @param pairs
     * @return 请求参数
     */
    private static Map<String, String> addRattanStructure(String specId, String specName, List<Pair>
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
     * 32、藤物理性质
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanPhysics(String specId, String specName, List<Pair>
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
     * 33、藤化学性质
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanChemistry(String specId, String specName, List<Pair>
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
     * 34、藤力学性质
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanMechanics(String specId, String specName, List<Pair>
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
     * 35、藤导管形态
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanCatheterMorphology(String specId, String specName,
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
     * 36、藤维管束形态
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanVascularBundelMorphology(String specId, String specName,
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
     * 37、藤组织比量
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanTissueProportion(String specId, String specName,
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
     * 38、纤维形态
     *
     * @param specId
     * @param pairs
     * @return
     */
    private static Map<String, String> addRattanFiberMorphology(String specId, String specName,
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
     * 39、用户登录
     *
     * @param userName 账号
     * @param password  密码
     * @return
     */
    public static Map<String, String> login(String userName, String password) {

        Map<String, String> params = new HashMap<>(2);
        params.put("userName", userName);
        params.put("password", password);
        return params;
    }

    /**
     * 40、用户注册
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
