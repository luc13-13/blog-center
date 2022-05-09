package com.lc.blog.center.bo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * (Tags)业务对象
 *
 * @author lucheng
 * @since 2022-05-04 22:12:40
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagsBO implements Serializable {

    private static final long serialVersionUID = 424334272454516346L;

        
    private Long id;

    /*** 标题 */    
    private String tagTitle;

    /*** 引用数量 */    
    private Integer referenceCount;

    private Integer referenceAdd;

    /*** 是否删除 0 删除 1 正常 */    
    private Integer state;

        
    private Date gmtCreate;

        
    private Date gmtModified;

}
