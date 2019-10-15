package co.goho.qingxu.easy.bean;

import co.goho.qingxu.easy.conmmon.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity(name = "sys_dict")
@ToString
@EqualsAndHashCode(callSuper=true)//callSuper=true可以调用父类属性
@NoArgsConstructor
@AllArgsConstructor
public class SysDict extends BaseEntity {
    @Transient
    private static final long serialVersionUID = 1L;

    /** 字典值 */
    @Column
    private String value;

    /** 字典名称 */
    @Column
    private String label;

    /** 类型 */
    @Column
    private String type;

    /** 显示顺序 */
    @Column
    private Integer orderNum;

    /** 父ID */
    @Column
    private String parentId;

    @Column
    private String typeId;

    /** 类型 */
    @ManyToOne(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinColumn(name="typeId",insertable = false, updatable = false)
    private SysDictType dictType;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public SysDictType getDictType() {
        return dictType;
    }

    public void setDictType(SysDictType dictType) {
        this.dictType = dictType;
    }
}
