package hxz.www.commonbase.event;

/**
 * Dec: 事件通用类
 */
public class CommonMessageEvent {


    public enum MESSAGE_TYPE {
        //通用
        ALL,

    }


    public String message;
    public boolean isSuccess;
    public MESSAGE_TYPE viewEventType;
    public Object dataObject;
    private String className;

    public boolean isThisClass(String className) {

        return this.className.equals(className);
    }

    /**
     * 普通消息
     *
     * @param className
     * @param message
     * @param isSuccess
     * @param viewEventType
     */
    public CommonMessageEvent(
            String className,
            String message,
            boolean isSuccess,
            MESSAGE_TYPE viewEventType) {

        this.className = className;
        this.message = message;
        this.isSuccess = isSuccess;
        this.viewEventType = viewEventType;
    }

    /***
     *  消息+object
     * @param className
     * @param message
     * @param isSuccess
     * @param viewEventType
     * @param dataObject
     */
    public CommonMessageEvent(
            String className,
            String message,
            boolean isSuccess,
            MESSAGE_TYPE viewEventType,
            Object dataObject) {

        this.dataObject = dataObject;
        this.className = className;
        this.message = message;
        this.isSuccess = isSuccess;
        this.viewEventType = viewEventType;
    }


}
