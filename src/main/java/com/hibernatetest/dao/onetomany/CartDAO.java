package com.hibernatetest.dao.onetomany;

import com.hibernatetest.HibernateUtils;
import com.hibernatetest.dao.AbstractDAO;
import com.hibernatetest.entity.onetomany.Cart;
import com.hibernatetest.entity.onetomany.CartItem;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CartDAO extends AbstractDAO {
    public void createCart(Cart cart) {
        Session session = openTransactSession();
        session.save(cart);
        closeTransactSession(session);
    }

    public CartItem getItemById(long id) {
        CartItem result = null;
        Session session = openSession();
        result = session.get(CartItem.class, id);
        session.close();
        return result;
    }

    public void removeItem(CartItem item) {
        Session session = openTransactSession();
        session.delete(item);
        closeTransactSession(session);
    }

    public Cart getCartById(long id) {
        Cart cart = null;
        Session session = openSession();
        cart = session.get(Cart.class, id);
        session.close();
        return cart;
    }

    public void updateCart(Cart cart) {
        Session session = openTransactSession();
        session.update(cart);
        closeTransactSession(session);
    }

    public void deleteCart(Cart cart) {
        Session session = openTransactSession();
        session.delete(cart);
        closeTransactSession(session);
    }

    public List<Cart> listAll() {
        List<Cart> carts = new ArrayList<>();
        String hql = "from Cart";
        Session session = openSession();
        carts = session.createQuery(hql, Cart.class).list();
        session.close();
        return carts;
    }

    public static void main(String[] args) {
        CartDAO dao = new CartDAO();

        List<Cart> carts = dao.listAll();
        for(Cart cart: carts) {
            System.out.println(cart);
        }

        HibernateUtils.getInstance().close();
    }
}
