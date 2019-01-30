package com.science.androidbase.mvp;

/**
 * author: Administrator
 * date: 2017/3/9 000910:55.
 * email:looper@126.com
 */

public interface TaskType {

    interface Method {
        String GET = "GET";
        String POST = "POST";
        String PUT = "PUT";
        String HEAD = "HEAD";
        String DELETE = "DELETE";
        String PATCH = "PATCH";
        String POST_FILE = "POST_FILE";
    }

    interface Local {
        String INSERT = "INSERT";
        String SELECT = "SELECT";
        String UPDATE = "UPDATE";
        String DELETE = "CRUD_DELETE";
    }
}
