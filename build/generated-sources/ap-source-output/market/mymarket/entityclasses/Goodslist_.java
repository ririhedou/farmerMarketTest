package market.mymarket.entityclasses;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import market.mymarket.entityclasses.Cart;
import market.mymarket.entityclasses.Farm;
import market.mymarket.entityclasses.Goods;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T14:05:48")
@StaticMetamodel(Goodslist.class)
public class Goodslist_ { 

    public static volatile SingularAttribute<Goodslist, Integer> glid;
    public static volatile CollectionAttribute<Goodslist, Cart> cartCollection;
    public static volatile SingularAttribute<Goodslist, String> image;
    public static volatile SingularAttribute<Goodslist, String> marketName;
    public static volatile SingularAttribute<Goodslist, String> website;
    public static volatile SingularAttribute<Goodslist, String> gName;
    public static volatile SingularAttribute<Goodslist, String> unit;
    public static volatile SingularAttribute<Goodslist, Farm> fmid;
    public static volatile SingularAttribute<Goodslist, Goods> gid;
    public static volatile SingularAttribute<Goodslist, BigDecimal> price;
    public static volatile SingularAttribute<Goodslist, String> category;

}