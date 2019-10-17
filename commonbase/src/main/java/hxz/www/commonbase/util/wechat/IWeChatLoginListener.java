package hxz.www.commonbase.util.wechat;

/**
 * Dec: 微信登录回调接口
 */
public interface IWeChatLoginListener extends IWeChatListener {

    void onLoginSuccess(String code);
}
