package market.mymarket.entityclasses;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import market.mymarket.entityclasses.Category;
import market.mymarket.entityclasses.Goodslist;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T14:55:39")
@StaticMetamodel(Farm.class)
public class Farm_ { 

    public static volatile CollectionAttribute<Farm, Category> categoryCollection;
    public static volatile SingularAttribute<Farm, String> city;
    public static volatile SingularAttribute<Farm, BigDecimal> rating;
    public static volatile SingularAttribute<Farm, String> season2Date;
    public static volatile SingularAttribute<Farm, String> wic;
    public static volatile SingularAttribute<Farm, Integer> fmid;
    public static volatile SingularAttribute<Farm, String> street;
    public static volatile SingularAttribute<Farm, String> season3Time;
    public static volatile SingularAttribute<Farm, String> season1Date;
    public static volatile SingularAttribute<Farm, String> state;
    public static volatile SingularAttribute<Farm, String> credit;
    public static volatile SingularAttribute<Farm, String> organic;
    public static volatile CollectionAttribute<Farm, Goodslist> goodsListCollection;
    public static volatile SingularAttribute<Farm, String> zip;
    public static volatile SingularAttribute<Farm, String> season2Time;
    public static volatile SingularAttribute<Farm, String> website;
    public static volatile SingularAttribute<Farm, String> facebook;
    public static volatile SingularAttribute<Farm, String> wICcash;
    public static volatile SingularAttribute<Farm, String> marketName;
    public static volatile SingularAttribute<Farm, String> season1Time;
    public static volatile SingularAttribute<Farm, BigDecimal> x;
    public static volatile SingularAttribute<Farm, String> sfmnp;
    public static volatile SingularAttribute<Farm, BigDecimal> y;
    public static volatile SingularAttribute<Farm, String> season3Date;
    public static volatile SingularAttribute<Farm, String> snap;

}