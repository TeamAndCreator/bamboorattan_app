package com.library.http.okhttp.utils;

/**
 *
 * @author zhy
 * @date 15/12/14
 */
public class Exceptions
{
    public static void illegalArgument(String msg, Object... params)
    {
        throw new IllegalArgumentException(String.format(msg, params));
    }


}
