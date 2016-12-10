package market.mymarket.entityclasses;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import market.mymarket.entityclasses.Goodslist;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-10T15:58:35")
@StaticMetamodel(Goods.class)
public class Goods_ { 

    public static volatile SingularAttribute<Goods, Integer> image;
    public static volatile SingularAttribute<Goods, String> gName;
    public static volatile SingularAttribute<Goods, String> unit;
    public static volatile SingularAttribute<Goods, Integer> gid;
    public static volatile SingularAttribute<Goods, Integer> price;
    public static volatile CollectionAttribute<Goods, Goodslist> goodslistCollection;
    public static volatile SingularAttribute<Goods, String> category;

}