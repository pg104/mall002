package com.pg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
    public class UserAddress implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 主键id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户主键
     */
      private Integer userId;

      /**
     * 地址
     */
      private String address;

      /**
     * 备注
     */
      private String remark;

      /**
     * 是否是默认地址（1:是 0否）
     */
      private Integer isdefault;

      /**
     * 创建时间
     */
        @TableField(fill = FieldFill.INSERT)
      private LocalDateTime createTime;

      @TableField(fill = FieldFill.INSERT_UPDATE)
      private LocalDateTime updateTime;


}
