package com.example.paymentservice;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.paymentservice.entities.MyOrder;
import com.example.paymentservice.repo.MyOrderRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
@SpringBootApplication
@CrossOrigin
@EnableDiscoveryClient
@RequestMapping("/user")
public class PaymentServiceApplication {
	
	@Autowired
	private MyOrderRepository myOrderRepository;

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}
	
	
	@PostMapping("/Create_Order")
	@ResponseBody
	public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException
	{
		int amt = Integer.parseInt(data.get("amount").toString());
		
		String pattern="dd-MM-yyyy HH:mm:ss";
		
		SimpleDateFormat dateformat=new SimpleDateFormat(pattern);
				
		var client =new RazorpayClient("rzp_test_aPJeknHS2DZpsD"
,"5kIV4oB4vvGs7D32OmTWC1Ns"
);
		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", amt*100); // amount in the smallest currency unit
		orderRequest.put("currency", "INR");
		orderRequest.put("receipt", "Payment receipt");

		Order order = client.orders.create(orderRequest);
		System.out.println(order);
		
		MyOrder myOrder = new MyOrder();
		
		int temp=order.get("amount");

		myOrder.setAmount((temp/100)+"");
		myOrder.setOrderId(order.get("id"));
		myOrder.setPaymentId(null);
		myOrder.setStatus("created");
		myOrder.setReceipt("Payment receipt");
		myOrder.setCreated_at(dateformat.format(order.get("created_at")));
		
		this.myOrderRepository.save(myOrder);
		
		return order.toString();
		
	}
	@PostMapping("/update_order")
	public ResponseEntity<?> updateOrder(@RequestBody Map<String,Object> data){
		
		MyOrder myorder =this.myOrderRepository.findByOrderId(data.get("order_id").toString());
		myorder.setPaymentId(data.get("payment_id").toString());
		myorder.setStatus(data.get("status").toString());
		
		this.myOrderRepository.save(myorder);
		return ResponseEntity.ok(Map.of("msg","updated"));
	}
	
	

}
