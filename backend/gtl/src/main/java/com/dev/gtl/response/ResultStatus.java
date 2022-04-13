package com.dev.gtl.response;

public class ResultStatus {
    
    /**
     * successful return
     * 
     * @param <T>
     * @param data
     * @return
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(200, data, "succeed");
    }

    /**
     * failed 
     * 
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> fail(String message) {
        return new BaseResponse<>(500, null, message);
    }
}
