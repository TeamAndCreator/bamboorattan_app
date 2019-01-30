package com.science.androidbase.mvp;

import android.support.annotation.NonNull;

/**
 * 所有的类都必须添加创建者信息
 * Created by Administrator on 2016/10/28 0028.
 */

public abstract class PresenterCompat extends PresenterImpl {

    public PresenterCompat(IView view) {
        super(view);
    }

    @Override
    final public void execute(@NonNull Task task) {
        switch (task.getTaskType()) {
            case TaskType.Method.GET:
                get(task);
                break;
            case TaskType.Method.POST:
                post(task);
                break;
            case TaskType.Method.DELETE:
                delete(task);
                break;
            case TaskType.Method.PATCH:
                patch(task);
                break;
            case TaskType.Method.HEAD:
                head(task);
                break;
            case TaskType.Method.PUT:
                put(task);
                break;
            case TaskType.Local.SELECT:
                executeSelect(task);
                break;
            case TaskType.Local.DELETE:
                executeDelete(task);
                break;
            case TaskType.Local.UPDATE:
                executeUpdate(task);
                break;
            case TaskType.Local.INSERT:
                executeInsert(task);
                break;
            case TaskType.Method.POST_FILE:
                postFile(task);
                break;
            default:
                break;

        }
    }

    abstract protected void executeInsert(Task task);

    abstract protected void executeSelect(Task task);

    abstract protected void executeDelete(Task task);

    abstract protected void executeUpdate(Task task);

    abstract protected void post(Task task);

    abstract protected void get(Task task);

    abstract protected void put(Task task);

    abstract protected void delete(Task task);

    abstract protected void head(Task task);

    abstract protected void patch(Task task);

    abstract protected void postFile(Task task);
}
