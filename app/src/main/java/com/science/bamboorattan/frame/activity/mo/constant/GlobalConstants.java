package com.science.bamboorattan.frame.activity.mo.constant;

public class GlobalConstants {

    /**
     * sharepreference 常量
     */
    public static final String SP_USER_LOGGED_ON = "sp_user_logged_on";
    public static final String SP_USER_NAME = "sp_user_name";
    public static final String SP_PASSWORD = "sp_password";

    /***
     * 接口
     */
    private static final String SERVER_IP = "http://47.104.26.79:8081";

    /**
     * 登录
     */

    public static final String USER_LOGIN = SERVER_IP + "/user/login ";
    /**
     * 登出
     */
    public static final String USER_LOGOUT = SERVER_IP + "/user/logout ";

    /**
     * 注册
     */

    public static final String USER_REGISTER = SERVER_IP + "/app/anno/doRegister";

    public static final String USER_INFO = SERVER_IP + "/system/user/userInfo";

    /**
     * 获取图形验证码
     */

    public static final String SECURITY_CODE = SERVER_IP + "/security/securityCodeImage";

    /**
     * 1、添加属表
     */

    public static final String GENUS_ADD = SERVER_IP + "/cat/genus/genusAdd";

    /**
     * 2、种表添加
     */

    public static final String SPEC_ADD = SERVER_IP + "/cat/spec/specAdd";

    /**
     * 3、地下茎表添加
     */

    public static final String UNDERS_TEM_ADD = SERVER_IP + "/bam/understem/understemAdd";

    /**
     * 4、竹秆表添加
     */

    public static final String CULM_ADD = SERVER_IP + "/bam/culm/culmAdd";

    /**
     * 5、竹叶表添加
     */

    public static final String LEAF_ADD = SERVER_IP + "/bam/leaf/leafAdd";

    /**
     * 6、箨环表添加
     */

    public static final String SHEATH_NODE_ADD = SERVER_IP + "/bam/sheathnode/sheathnodeAdd";

    /**
     * 7、箨鞘表添加
     */

    public static final String SHEATH_ADD = SERVER_IP + "/bam/sheath/sheathAdd";

    /**
     * 8、箨耳表添加
     */

    public static final String SHEATH_EAR_ADD = SERVER_IP + "/bam/sheathear/sheathearAdd";

    /**
     * 9、箨舌表添加
     */

    public static final String SHEATH_TONGUE_ADD = SERVER_IP + "/bam/sheathtongue/sheathtongueAdd";

    /**
     * 10、箨片表添加
     */

    public static final String SHEATH_SHELL_ADD = SERVER_IP + "/bam/sheathshell/sheathshellAdd";

    /**
     * 11、花果形态表添加
     */

    public static final String FLOWER_FRUIT_ADD = SERVER_IP + "/bam/flowerfruit/flowerfruitAdd";

    /**
     * 12、结构性质表添加
     */

    public static final String STRUCTURE_ADD = SERVER_IP + "/species/structure/structureAdd";

    /**
     * 13、物理性质表添加
     */

    public static final String PHYSICS_ADD = SERVER_IP + "/species/physics/physicsAdd";

    /**
     * 14、化学性质表添加
     */

    public static final String CHEMISTRY_ADD = SERVER_IP + "/species/chemistry/chemistryAdd";

    /**
     * 15、力学性质表添加
     */

    public static final String MECHANICS_ADD = SERVER_IP + "/species/mechanics/mechanicsAdd";

    /**
     * 16、导管形态表添加
     */

    public static final String CATHETER_MORPHOLOGY_ADD = SERVER_IP +
            "/species/cathetermorphology/cathetermorphologyAdd";

    /**
     * 17、维管束形态表添加
     */

    public static final String VASCULAR_BUNDLE_MORPHOLOGY_ADD = SERVER_IP +
            "/species/vascularbundelmorphology/vascularbundelmorphologyAdd";

    /**
     * 18、组织比量表添加
     */

    public static final String TISSUE_PROPORTION_ADD = SERVER_IP +
            "/species/tissueproportion/tissueproportionAdd";

    /**
     * 19、纤维形态表添加
     */

    public static final String FIBER_MORPHOLOGY_ADD = SERVER_IP +
            "/species/fibermorphology/fibermorphologyAdd";

    /**
     * 20、属表查询
     */
    public static final String GET_GENUS_LIST = SERVER_IP + "/cat/genus/genusList_json";

    /**
     * 21、种表查询
     */
    public static final String GET_SPEC_LIST = SERVER_IP + "/cat/spec/specList_json";
    /**
     * 视频上传
     */
    public static final String VIDEO_ADD = SERVER_IP + "/website/video/videoAdd";
    /**
     * 图片上传
     */
    public static final String IMAGE_ADD = SERVER_IP + "//common/fileUpload";

}
