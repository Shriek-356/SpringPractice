/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.vdk.pojo.Cart;
import com.vdk.pojo.OrderDetail;
import com.vdk.pojo.SaleOrder;
import com.vdk.repositories.ProductRepository;
import com.vdk.repositories.ReceiptRepository;
import com.vdk.repositories.UserRepository;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.smartcardio.Card;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asus
 */
@Repository
@Transactional
public class ReceiptRepositoryImpl implements ReceiptRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private ProductRepository productRepo;

    public void addReceipt(List<Cart> carts){
     
        Session s = this.factory.getObject().getCurrentSession();
            SaleOrder r = new SaleOrder();
            r.setCreatedDate(new Date());
            r.setUserId(this.userRepo.getUserByName("dhthanh"));
            s.persist(r);
            
            for(var c:carts){
                OrderDetail d = new OrderDetail();
                d.setQuantity(c.getQuantity());
                d.setUnitPrice(c.getPrice());
                d.setProductId(this.productRepo.getProductById(c.getId()));
                d.setOrderId(r);
                
                s.persist(d);
            }
    }
    
}
