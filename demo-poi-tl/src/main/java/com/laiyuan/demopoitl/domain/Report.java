package com.laiyuan.demopoitl.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author laiyuan
 * @date 2020/12/31
 */
@Data
@Builder
public class Report {
   private Demand demand;
   private List<Expert> experts;
   private String zonghepingjia;
}
