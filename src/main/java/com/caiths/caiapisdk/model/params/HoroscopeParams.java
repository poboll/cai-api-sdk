package com.caiths.caiapisdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * HoroscopeParams 类，用于表示请求随机情话所需的参数。
 * <p>
 * 该类封装了请求参数，包括星座类型和时间，用于获取某一星座在指定时间的情话。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Data
@Accessors(chain = true)
public class HoroscopeParams implements Serializable {
    private static final long serialVersionUID = 3815188540434269370L;

    /**
     * 十二星座对应的英文小写，取值包括：aries, taurus, gemini, cancer, leo, virgo, libra, scorpio, sagittarius, capricorn, aquarius, pisces
     * <p>
     * 例如，"aries" 表示白羊座，"taurus" 表示金牛座，以此类推。
     * </p>
     */
    private String type;

    /**
     * 时间参数，指定查询某一时间点的星座情话。格式为具体时间，使用字符串表示。
     * <p>
     * 例如，"morning" 表示早晨，"evening" 表示傍晚。
     * </p>
     */
    private String time;
}
