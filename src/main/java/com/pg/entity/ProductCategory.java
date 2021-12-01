package com.pg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class ProductCategory implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 主键
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 名称
     */
      private String name;

      /**
     * 父级目录id
     */
      private Integer parentId;

      /**
     * 级别(1:一级 2：二级 3：三级)
     */
      private Integer type;


}
