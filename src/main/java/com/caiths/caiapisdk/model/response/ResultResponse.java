package com.caiths.caiapisdk.model.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回类
 * <p>
 * 用于封装 API 返回的通用数据结构，支持动态扩展字段。
 * <p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Data
@NoArgsConstructor
public class ResultResponse implements Serializable {

    private static final long serialVersionUID = -6486005224268968744L;

    /**
     * 数据内容，存储 API 返回的字段
     */
    private Map<String, Object> data = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
