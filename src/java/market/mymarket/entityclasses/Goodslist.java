/*
 * Created by Zhen Guo on 2016.12.10  * 
 * Copyright © 2016 Zhen Guo. All rights reserved. * 
 */
package market.mymarket.entityclasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZG
 */
@Entity
@Table(name = "goodslist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Goodslist.findAll", query = "SELECT g FROM Goodslist g")
    , @NamedQuery(name = "Goodslist.findByGlid", query = "SELECT g FROM Goodslist g WHERE g.glid = :glid")
    , @NamedQuery(name = "Goodslist.findByMarketName", query = "SELECT g FROM Goodslist g WHERE g.marketName = :marketName")
    , @NamedQuery(name = "Goodslist.findByWebsite", query = "SELECT g FROM Goodslist g WHERE g.website = :website")
    , @NamedQuery(name = "Goodslist.findByCategory", query = "SELECT g FROM Goodslist g WHERE g.category = :category")
    , @NamedQuery(name = "Goodslist.findByGName", query = "SELECT g FROM Goodslist g WHERE g.gName = :gName")
    , @NamedQuery(name = "Goodslist.findByImage", query = "SELECT g FROM Goodslist g WHERE g.image = :image")
    , @NamedQuery(name = "Goodslist.findByPrice", query = "SELECT g FROM Goodslist g WHERE g.price = :price")
    , @NamedQuery(name = "Goodslist.findByUnit", query = "SELECT g FROM Goodslist g WHERE g.unit = :unit")})
public class Goodslist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GLID")
    private Integer glid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "MarketName")
    private String marketName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 43)
    @Column(name = "Website")
    private String website;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Category")
    private String category;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "GName")
    private String gName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Image")
    private int image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "Unit")
    private String unit;
    @JoinColumn(name = "FMID", referencedColumnName = "FMID")
    @ManyToOne(optional = false)
    private Farm fmid;
    @JoinColumn(name = "GID", referencedColumnName = "GID")
    @ManyToOne(optional = false)
    private Goods gid;

    public Goodslist() {
    }

    public Goodslist(Integer glid) {
        this.glid = glid;
    }

    public Goodslist(Integer glid, String marketName, String website, String category, String gName, int image, int price, String unit) {
        this.glid = glid;
        this.marketName = marketName;
        this.website = website;
        this.category = category;
        this.gName = gName;
        this.image = image;
        this.price = price;
        this.unit = unit;
    }

    public Integer getGlid() {
        return glid;
    }

    public void setGlid(Integer glid) {
        this.glid = glid;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Farm getFmid() {
        return fmid;
    }

    public void setFmid(Farm fmid) {
        this.fmid = fmid;
    }

    public Goods getGid() {
        return gid;
    }

    public void setGid(Goods gid) {
        this.gid = gid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (glid != null ? glid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Goodslist)) {
            return false;
        }
        Goodslist other = (Goodslist) object;
        if ((this.glid == null && other.glid != null) || (this.glid != null && !this.glid.equals(other.glid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "market.mymarket.entityclasses.Goodslist[ glid=" + glid + " ]";
    }
    
}
