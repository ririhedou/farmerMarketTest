package market.mymarket.entityclasses;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import market.mymarket.entityclasses.Goodslist;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T12:41:55")
@StaticMetamodel(Cart.class)
public class Cart_ { 

    public static volatile SingularAttribute<Cart, Goodslist> glid;
    public static volatile SingularAttribute<Cart, String> image;
    public static volatile SingularAttribute<Cart, String> gName;
    public static volatile SingularAttribute<Cart, String> unit;
    public static volatile SingularAttribute<Cart, Integer> quantity;
    public static volatile SingularAttribute<Cart, BigDecimal> price;
    public static volatile SingularAttribute<Cart, Integer> cartID;
    public static volatile SingularAttribute<Cart, String> category;

}