package com.laiyuan.demopoitl.domain;

import lombok.*;

import java.util.Date;

/**
 * @author laiyuan
 * @date 2020/12/31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Demand {
    private String code;
    private String title;
    private String content;
    private String subjects;
    private String coos;
    private String keywords;
    private String requirement;
    private Integer budget;
    private Boolean financing;
    private String source;
    private Date time;
}
