package com.science.bamboorattan.frame.activity.mo.constant;

public class GlobalConstants {

    /**
     * sharepreference 常量
     */
    public static final String SP_USER_LOGGED_ON = "sp_user_logged_on";
    public static final String SP_USER_NAME = "sp_user_name";
    public static final String SP_PASSWORD = "sp_password";
    public static double LONGITUDE = 0; //经度
    public static double LATITUDE = 0; //纬度
    public static String  ADDRESS = ""; //地址
    public static String SEARCHTEXT = null;//检索关键字

    /***
     * 接口
     */
    private static final String SERVER_IP = "http://47.106.74.107:8081";

    /**
     * 登录
     */

    public static final String USER_LOGIN = SERVER_IP + "/user/login ";
    /**
     * 登出
     */
    public static final String USER_LOGOUT = SERVER_IP + "/user/logOut ";

    /**
     * 注册
     */

    public static final String USER_REGISTER = SERVER_IP + "/user/save";

    /**
     * 竹类图像分类
     */
    public static final String IMAGE_CLASSIFICATION = "http://47.104.26.79:7808/test";
    /**
     * 用户信息查询
     */

    public static final String USER_INFO = SERVER_IP + "/user/findByUserName/";
//    public static final String USER_INFO = SERVER_IP + "/user/findId/{userId}";

    /**
     * 获取图形验证码
     */

    public static final String SECURITY_CODE = SERVER_IP + "/security/securityCodeImage";

    /**
     * 1、添加属表
     */

    public static final String GENUS_ADD = SERVER_IP + "/genus/save";

    /**
     * 2、种表添加
     */

    public static final String SPEC_ADD = SERVER_IP + "/spec/save";

    /**
     * 3、地下茎表添加
     */

    public static final String UNDERS_TEM_ADD = SERVER_IP + "/understem/save";

    /**
     * 4、竹秆表添加
     */

    public static final String CULM_ADD = SERVER_IP + "/culm/save";

    /**
     * 5、竹叶表添加
     */

    public static final String LEAF_ADD = SERVER_IP + "/leaf/save";

    /**
     * 6、箨环表添加
     */

    public static final String SHEATH_NODE_ADD = SERVER_IP + "/sheathnode/save";

    /**
     * 7、箨鞘表添加
     */

    public static final String SHEATH_ADD = SERVER_IP + "/sheath/save";

    /**
     * 8、箨耳表添加
     */

    public static final String SHEATH_EAR_ADD = SERVER_IP + "/sheathear/save";

    /**
     * 9、箨舌表添加
     */

    public static final String SHEATH_TONGUE_ADD = SERVER_IP + "/sheathtongue/save";

    /**
     * 10、箨片表添加
     */

    public static final String SHEATH_SHELL_ADD = SERVER_IP + "/sheathshell/save";

    /**
     * 11、花果形态表添加
     */

    public static final String FLOWER_FRUIT_ADD = SERVER_IP + "/flowerfruit/save";

    /**
     * 12、结构性质表添加
     */

    public static final String STRUCTURE_ADD = SERVER_IP + "/structure/save";

    /**
     * 13、物理性质表添加
     */

    public static final String PHYSICS_ADD = SERVER_IP + "/physics/save";

    /**
     * 14、化学性质表添加
     */

    public static final String CHEMISTRY_ADD = SERVER_IP + "/chemistry/save";

    /**
     * 15、力学性质表添加
     */

    public static final String MECHANICS_ADD = SERVER_IP + "/mechanics/save";

    /**
     * 16、导管形态表添加
     */

    public static final String CATHETER_MORPHOLOGY_ADD = SERVER_IP + "/cathermorphology/save";

    /**
     * 17、维管束形态表添加
     */

    public static final String VASCULAR_BUNDLE_MORPHOLOGY_ADD = SERVER_IP + "/vascularbundelmorphology/save";

    /**
     * 18、组织比量表添加
     */

    public static final String TISSUE_PROPORTION_ADD = SERVER_IP + "/tissueproportion/save";

    /**
     * 19、纤维形态表添加
     */

    public static final String FIBER_MORPHOLOGY_ADD = SERVER_IP + "/fibermorphology/save";

    /**
     * 20、属表查询
     */
    public static final String GET_GENUS_LIST = SERVER_IP + "/genus/findAll";

    /**
     * 21、种表查询
     */
    public static final String GET_SPEC_LIST = SERVER_IP + "/spec/findAll";
    /**
     * 视频上传
     */
    public static final String VIDEO_ADD = SERVER_IP + "/website/video/videoAdd";
    /**
     * 图片上传
     */
    public static final String IMAGE_ADD = SERVER_IP + "//common/fileUpload";
    /**
     * 增加藤属表
     */
    public static final String RATTAN_GENUS_ADD = SERVER_IP + "/rattanGenus/save";
    /**
     * 增加藤种表
     */
    public static final String RATTAN_SPEC_ADD = SERVER_IP + "/rattanSpec/save";

    /**
     * 3、藤地下茎表添加
     */

    public static final String T_UNDERS_TEM_ADD = SERVER_IP + "/tUnderstem/save";

    /**
     * 4、藤秆表添加
     */

    public static final String T_CULM_ADD = SERVER_IP + "/tCulm/save";

    /**
     * 5、藤叶表添加
     */

    public static final String T_LEAF_ADD = SERVER_IP + "/tLeaf/save";

    /**
     * 6、藤箨环表添加
     */

    public static final String T_SHEATH_NODE_ADD = SERVER_IP + "/tSheathnode/save";

    /**
     * 7、藤箨鞘表添加
     */

    public static final String T_SHEATH_ADD = SERVER_IP + "/tSheath/save";

    /**
     * 8、藤箨耳表添加
     */

    public static final String T_SHEATH_EAR_ADD = SERVER_IP + "/tSheathear/save";

    /**
     * 9、藤箨舌表添加
     */

    public static final String T_SHEATH_TONGUE_ADD = SERVER_IP + "/tSheathtongue/save";

    /**
     * 10、藤箨片表添加
     */

    public static final String T_SHEATH_SHELL_ADD = SERVER_IP + "/tSheathshell/save";

    /**
     * 11、藤花果形态表添加
     */

    public static final String T_FLOWER_FRUIT_ADD = SERVER_IP + "/tFlowerfruit/save";
    /**
     * 藤结构性质表添加
     */
    public static final String T_STRUCTURE_ADD = SERVER_IP + "/tStructure/save";
    /**
     * 藤物理性质表添加
     */
    public static final String T_PHYSICS_ADD = SERVER_IP + "/tPhysics/save";
    /**
     * 藤化学性质表添加
     */
    public static final String T_CHEMISTRY_ADD = SERVER_IP + "/tChemistry/save";
    /**
     * 藤力学性质表添加
     */
    public static final String T_MECHANICS_ADD = SERVER_IP + "/tMechanics/save";
    /**
     * 藤导管形态表添加
     */
    public static final String T_CATHETER_MORPHOLOGY_ADD = SERVER_IP + "/tCathetermorphology/save";
    /**
     * 藤维管束形态表添加
     */
    public static final String T_VASCULAR_BUNDLE_MORPHOLOGY_ADD = SERVER_IP + "/tVascularbundelmorphology/save";
    /**
     * 藤组织比量表添加
     */
    public static final String T_TISSUE_PROPORTION_ADD = SERVER_IP + "/tTissueproportion/save ";
    /**
     * 藤纤维形态表添加
     */
    public static final String T_FIBER_MORPHOLOGY_ADD = SERVER_IP + "/tFibermorphology/save ";

    /**
     * 20、藤属表查询
     */
    public static final String GET_RATTANGENUS_LIST = SERVER_IP + "/rattanGenus/findAll";

    /**
     * 21、藤种表查询
     */
    public static final String GET_RATTANSPEC_LIST = SERVER_IP + "/rattanSpec/findAll";
    /**
     * 图片上传
     */

    /**
     * 图片上传
     */

    /**
     * 图片上传
     */
}
