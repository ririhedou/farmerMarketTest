package market.mymarket.entityclasses;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import market.mymarket.entityclasses.Goodslist;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T16:27:39")
@StaticMetamodel(Goods.class)
public class Goods_ { 

    public static volatile SingularAttribute<Goods, String> image;
    public static volatile SingularAttribute<Goods, String> gName;
    public static volatile SingularAttribute<Goods, String> unit;
    public static volatile SingularAttribute<Goods, Integer> gid;
    public static volatile SingularAttribute<Goods, BigDecimal> price;
    public static volatile SingularAttribute<Goods, String> category;
    public static volatile CollectionAttribute<Goods, Goodslist> goodsListCollection;

}