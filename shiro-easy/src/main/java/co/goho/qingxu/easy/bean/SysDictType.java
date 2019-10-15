package co.goho.qingxu.easy.bean;

import co.goho.qingxu.easy.conmmon.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity(name = "sys_dict_type")
@ToString
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
public class SysDictType extends BaseEntity {
    @Transient
    private static final long serialVersionUID = 1L;

    /** 类型 */
    @Column
    private String type;

    /** 类型描述 */
    @Column
    private String typeLabel;

    /** 显示顺序 */
    @Column
    private Integer orderNum;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
