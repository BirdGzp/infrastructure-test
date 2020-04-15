package com.moon.infrastructure.base.schedule;

import java.util.List;

/**
 * @author gongzhipeng
 * @version $$ CircelSchedule, 2020/4/13 11:22 gongzhipeng $$
 */
public abstract class BaseCircleSchedule<V> {

    public int model(String start, int size) {
        validate();

        String key = start;
        int executeSize = 0;
        while (true) {
            List<V> result = listData(key, size);
            if (result == null || result.size() == 0) {
                break;
            }
            for (V v : result) {
                executeSize++;
                key = operate(v);

            }

            if (result.size() < size) {
                break;
            }
        }
        return executeSize;
    }

    public int model(String start, String end, int size, boolean strongModel) {
        validate();

        String key = start;
        int executeSize = 0;
        while (true) {
            List<V> result = listData(key, size);
            if (result == null || result.size() == 0) {
                break;
            }
            for (V v : result) {
                executeSize++;
                key = operate(v);

                if (strongModel && key.compareTo(end) >= 0) {
                    return executeSize;
                }

            }
            if (key.compareTo(end) >= 0) {
                break;
            }
            if (result.size() < size) {
                break;
            }
        }
        return executeSize;
    }

    public int model(String start, int size, int totalSize, boolean strongModel) {
        validate();
        String key = start;
        int executeSize = 0;
        while (true) {
            List<V> result = listData(key, size);
            if (result == null || result.size() == 0) {
                break;
            }
            for (V v : result) {
                executeSize++;
                key = operate(v);

                if (strongModel && executeSize >= totalSize) {
                    return executeSize;
                }
            }
            if (executeSize >= totalSize) {
                break;
            }
            if (result.size() < size) {
                break;
            }
        }
        return executeSize;
    }

    /**
     * 校验参数
     */
    public void validate() {

    }

    /**
     * 循环获取数据
     *
     * @param start 起始字符串
     * @param size  每次查询的容量
     * @return 返回查询的数据
     */
    public abstract List<V> listData(String start, int size);

    public abstract String operate(V v);

}
