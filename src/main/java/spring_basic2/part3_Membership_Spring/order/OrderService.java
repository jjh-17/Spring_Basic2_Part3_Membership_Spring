package spring_basic2.part3_Membership_Spring.order;

public interface OrderService {
    Order createOrder(Long memberId, String productName, int productPrice);
}
