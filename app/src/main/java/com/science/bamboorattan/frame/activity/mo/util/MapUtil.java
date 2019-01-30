package com.science.bamboorattan.frame.activity.mo.util;

import com.science.bamboorattan.frame.activity.mo.bean.Pair;

import java.util.ArrayList;
import java.util.List;

public class MapUtil {


    public static List<Pair> getList(Table table) {

        switch (table) {
            case GENUS:
                return getGenusList();
            case SPEC:
                return getSpecList();
            case CULM:
                return getCulmList();
            case LEAF:
                return getLeafList();
            case SHEATH:
                return getSheathList();
            case PHYSICS:
                return getPhysicsList();
            case CHEMISTRY:
                return getChemistryList();
            case MECHANICS:
                return getMechanicsList();
            case SHEATHEAR:
                return getSheathEarList();
            case STRUCTURE:
                return getStructureList();
            case UNDERSTEM:
                return getUnderStemList();
            case SHEATHNODE:
                return getSheathNodeList();
            case FLOWERFRUIT:
                return getFlowerFruitList();
            case SHEATHSHELL:
                return getSheathShellList();
            case SHEATHTONGUE:
                return getSheathTongueList();
            case FIBERMORPHOLOGY:
                return getFiberMorphologyList();
            case TISSUEPROPORTION:
                return getTissueProportionList();
            case CATHETERMORPHOLOGY:
                return getCatheterMorphologyList();
            case VASCULARBUNDLEMORPHOLOGY:
            default:
                return getVascularBundelMorphologyList();
        }
    }

    /**
     * 1、属表添加
     *
     * @return
     */
    private static List<Pair> getGenusList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("中文名称："));
        pairs.add(new Pair().setKey("英文名称："));
        pairs.add(new Pair().setKey("拉丁名称："));
        pairs.add(new Pair().setKey("别名："));
        pairs.add(new Pair().setKey("描述："));
        pairs.add(new Pair().setKey("排序序号："));
        return pairs;
    }

    /**
     * 2、种表添加
     *
     * @return
     */
    private static List<Pair> getSpecList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("中文名称："));
        pairs.add(new Pair().setKey("英文名称："));
        pairs.add(new Pair().setKey("拉丁名称："));
        pairs.add(new Pair().setKey("种别名："));
        pairs.add(new Pair().setKey("种类编码："));
        pairs.add(new Pair().setKey("种类条形码："));
        pairs.add(new Pair().setKey("种类DNA码："));
        pairs.add(new Pair().setKey("国内分布："));
        pairs.add(new Pair().setKey("国外分布："));
        pairs.add(new Pair().setKey("视频："));
        pairs.add(new Pair().setKey("图片："));
        pairs.add(new Pair().setKey("排序序号："));
        pairs.add(new Pair().setKey("种描述："));
        return pairs;
    }

    /**
     * 3、地下茎表添加
     *
     * @return
     */
    private static List<Pair> getUnderStemList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("地下茎类型："));
        return pairs;
    }

    /**
     * 4、竹秆表添加
     *
     * @return
     */
    private static List<Pair> getCulmList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("竿高度："));
        pairs.add(new Pair().setKey("竿直径："));
        pairs.add(new Pair().setKey("竿颜色："));
        pairs.add(new Pair().setKey("竿稍头："));
        pairs.add(new Pair().setKey("竿身形态："));
        pairs.add(new Pair().setKey("节间长度："));
        pairs.add(new Pair().setKey("节间形状："));
        pairs.add(new Pair().setKey("节间有无气生根："));
        pairs.add(new Pair().setKey("节间被毛："));
        pairs.add(new Pair().setKey("节间竿壁厚："));
        pairs.add(new Pair().setKey("幼时竿被毛："));
        pairs.add(new Pair().setKey("幼时竿被粉："));
        pairs.add(new Pair().setKey("竿环是否隆起："));
        return pairs;
    }

    /**
     * 5、竹叶表添加
     *
     * @return
     */
    private static List<Pair> getLeafList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("叶片形状："));
        pairs.add(new Pair().setKey("叶片长度："));
        pairs.add(new Pair().setKey("叶片宽度："));
        pairs.add(new Pair().setKey("每小枝具叶片数目："));
        pairs.add(new Pair().setKey("叶片背面被毛："));
        pairs.add(new Pair().setKey("叶片边缘锯齿："));
        pairs.add(new Pair().setKey("叶舌形状："));
        pairs.add(new Pair().setKey("叶舌高度："));
        pairs.add(new Pair().setKey("叶柄长度："));
        pairs.add(new Pair().setKey("叶片基部形状："));
        pairs.add(new Pair().setKey("叶尖形态："));
        return pairs;
    }

    /**
     * 6、箨环表添加
     *
     * @return
     */
    private static List<Pair> getSheathNodeList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("箨环是否隆起："));
        pairs.add(new Pair().setKey("箨环被毛："));
        return pairs;
    }

    /**
     * 7、箨鞘表添加
     *
     * @return
     */
    private static List<Pair> getSheathList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("箨鞘早落："));
        pairs.add(new Pair().setKey("箨鞘质地："));
        pairs.add(new Pair().setKey("箨鞘先端形状："));
        pairs.add(new Pair().setKey("箨鞘背面被毛被粉："));
        pairs.add(new Pair().setKey("箨鞘边缘形状："));
        return pairs;
    }

    /**
     * 8、箨耳表添加
     *
     * @return
     */
    private static List<Pair> getSheathEarList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("箨耳发达情况："));
        pairs.add(new Pair().setKey("箨耳形状："));
        pairs.add(new Pair().setKey("箨耳边缘繸毛："));
        return pairs;
    }

    /**
     * 9、箨舌表添加
     *
     * @return
     */
    private static List<Pair> getSheathTongueList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("箨舌颜色："));
        pairs.add(new Pair().setKey("箨舌高度："));
        pairs.add(new Pair().setKey("箨舌边缘形状："));
        pairs.add(new Pair().setKey("箨舌被毛被粉："));
        return pairs;
    }

    /**
     * 10、箨片表添加
     *
     * @return
     */
    private static List<Pair> getSheathShellList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("箨片形状："));
        pairs.add(new Pair().setKey("箨片颜色："));
        pairs.add(new Pair().setKey("箨片是否易脱落："));
        pairs.add(new Pair().setKey("箨片先端形："));
        pairs.add(new Pair().setKey("箨片基部形状："));
        pairs.add(new Pair().setKey("箨片边缘形态："));
        pairs.add(new Pair().setKey("箨片背面被毛被粉："));
        pairs.add(new Pair().setKey("箨片基底与箨鞘宽度之比："));
        return pairs;
    }

    /**
     * 11、花果形态表添加
     *
     * @return
     */
    private static List<Pair> getFlowerFruitList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("小穗形态："));
        pairs.add(new Pair().setKey("小穗被毛："));
        pairs.add(new Pair().setKey("小穗含花朵数："));
        pairs.add(new Pair().setKey("雄蕊数目："));
        pairs.add(new Pair().setKey("颖片："));
        pairs.add(new Pair().setKey("鳞被："));
        pairs.add(new Pair().setKey("内稃："));
        pairs.add(new Pair().setKey("外稃："));
        return pairs;
    }


    /**
     * 12、结构性质表添加
     *
     * @return
     */
    private static List<Pair> getStructureList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("胸高处的秆径：").setUnit("mm"));
        pairs.add(new Pair().setKey("竹筒壁厚：").setUnit("mm"));
        pairs.add(new Pair().setKey("最长节间长：").setUnit("cm"));
        pairs.add(new Pair().setKey("2m处的藤径(mm)：").setUnit("mm"));
        return pairs;
    }


    /**
     * 13、物理性质表添加
     *
     * @return
     */
    private static List<Pair> getPhysicsList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("相对含水率：").setUnit("%"));
        pairs.add(new Pair().setKey("绝对含水率：").setUnit("%"));
        pairs.add(new Pair().setKey("生材密度：").setUnit("Midu"));
        pairs.add(new Pair().setKey("基本密度：").setUnit("Midu"));
        pairs.add(new Pair().setKey("气干密度：").setUnit("Midu"));
        pairs.add(new Pair().setKey("绝干密度：").setUnit("Midu"));
        pairs.add(new Pair().setKey("湿材到气干（气干率）：").setUnit("%"));
        pairs.add(new Pair().setKey("湿材到全干（线干缩性）：").setUnit("%"));
        pairs.add(new Pair().setKey("湿材到气干（体积干缩性）").setUnit("%"));
        pairs.add(new Pair().setKey("湿材到全干（体积干缩性）：").setUnit("%"));
        pairs.add(new Pair().setKey("气干缩率：").setUnit("%"));
        pairs.add(new Pair().setKey("气干缩率（弦向）：").setUnit("%"));
        pairs.add(new Pair().setKey("气干缩率（径向）").setUnit("%"));
        pairs.add(new Pair().setKey("气干缩率（纵向）：").setUnit("%"));
        pairs.add(new Pair().setKey("气干缩率（体积）：").setUnit("%"));
        pairs.add(new Pair().setKey("全干缩率（弦向）：").setUnit("%"));
        pairs.add(new Pair().setKey("全干缩率（径向）：").setUnit("%"));
        pairs.add(new Pair().setKey("全干缩率（纵向）：").setUnit("%"));
        pairs.add(new Pair().setKey("全干缩率（体积）：").setUnit("%"));
        return pairs;
    }

    /**
     * 14、化学性质表添加
     *
     * @return
     */
    private static List<Pair> getChemistryList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("综纤维素：").setUnit("%"));
        pairs.add(new Pair().setKey("纤维素：").setUnit("%"));
        pairs.add(new Pair().setKey("半纤维素：").setUnit("%"));
        pairs.add(new Pair().setKey("a纤维素：").setUnit("%"));
        pairs.add(new Pair().setKey("酸不溶木质素：").setUnit("%"));
        pairs.add(new Pair().setKey("苯醇抽提物：").setUnit("%"));
        pairs.add(new Pair().setKey("热水抽提物：").setUnit("%"));
        pairs.add(new Pair().setKey("冷抽提物：").setUnit("%"));
        pairs.add(new Pair().setKey("灰分：").setUnit("%"));
        return pairs;
    }


    /**
     * 15、力学性质表添加
     *
     * @return
     */
    private static List<Pair> getMechanicsList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("抗弯弹性模量：").setUnit("Gpa"));
        pairs.add(new Pair().setKey("抗弯强度：").setUnit("Gpa"));
        pairs.add(new Pair().setKey("顺纹抗压强度(压缩)：").setUnit("Gpa"));
        pairs.add(new Pair().setKey("抗剪强度：").setUnit("Gpa"));
        pairs.add(new Pair().setKey("顺纹抗拉强度(拉伸)：").setUnit("Gpa"));
        pairs.add(new Pair().setKey("冲击韧性：").setUnit("Renxiang"));
        pairs.add(new Pair().setKey("柔量：").setUnit("m㎡/N"));
        return pairs;
    }

    /**
     * 16、导管形态表添加
     *
     * @return
     */
    private static List<Pair> getCatheterMorphologyList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("导管长度：").setUnit("um"));
        pairs.add(new Pair().setKey("导管直径：").setUnit("um"));
        pairs.add(new Pair().setKey("导管密度：").setUnit("个/m㎡"));
        pairs.add(new Pair().setKey("导管形态指数："));
        return pairs;
    }


    /**
     * 17、维管束形态表添加
     *
     * @return
     */
    private static List<Pair> getVascularBundelMorphologyList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("维管束径向直径：").setUnit("um"));
        pairs.add(new Pair().setKey("维管束弦向直径：").setUnit("um"));
        pairs.add(new Pair().setKey("维管束密度：").setUnit("个/m㎡"));
        return pairs;
    }

    /**
     * 18、组织比量表添加
     *
     * @return
     */
    private static List<Pair> getTissueProportionList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("纤维比量：").setUnit("%"));
        pairs.add(new Pair().setKey("导管比量：").setUnit("%"));
        pairs.add(new Pair().setKey("筛管比量：").setUnit("%"));
        pairs.add(new Pair().setKey("薄壁细胞比量：").setUnit("%"));
        return pairs;
    }

    /**
     * 19、纤维形态表添加
     *
     * @return
     */
    private static List<Pair> getFiberMorphologyList() {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair().setKey("纤维长度：").setUnit("um"));
        pairs.add(new Pair().setKey("纤维宽度：").setUnit("um"));
        pairs.add(new Pair().setKey("纤维双壁厚：").setUnit("um"));
        pairs.add(new Pair().setKey("纤维长宽比："));
        pairs.add(new Pair().setKey("纤维腔径：").setUnit("um"));
        pairs.add(new Pair().setKey("纤维壁腔比："));
        pairs.add(new Pair().setKey("纤维腔径比："));
        return pairs;
    }

}
