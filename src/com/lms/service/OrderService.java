package com.lms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lms.model.Machines;
import com.lms.model.Order;
import com.lms.util.DBconnect;

public class OrderService {

    public static boolean insertOrder(String orderId, String custId, Double weight, String orderDate,
                                      String deliveryDate) {
        boolean isSuccess = false;

        
        String sql = "insert into orders ( custId, weight, orderDate, deliveryDate) values(?,?,?,?);";
		try (Connection connection = DBconnect.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			
	            preparedStatement.setInt(1,Integer.parseInt(custId));
	            preparedStatement.setDouble(2, weight);
	            preparedStatement.setString(3, orderDate);
	            preparedStatement.setString(4, deliveryDate);
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();

	            System.out.println(preparedStatement);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		return isSuccess;
    }

    public ArrayList<Order> getOrderDetails() {
        
        ArrayList<Order> ordRecSet = new ArrayList<Order>();
        try {
            Connection connection = DBconnect.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from orders";
            ResultSet resultset = statement.executeQuery(sql);
           // System.out.println(resultset);

            while (resultset.next()) {
                int OrderId = Integer.parseInt(resultset.getString("OrderId"));
                Double weight = Double.parseDouble(resultset.getString("weight"));
                String orderDate = resultset.getString("orderDate");
                String deliveryDate = resultset.getString("deliveryDate");
                int custId = Integer.parseInt(resultset.getString("custId"));

                Order order1 = new Order(OrderId,custId, weight, orderDate, deliveryDate);
                ordRecSet.add(order1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ordRecSet;
    }

    public static boolean deleteOrder(Order order) {
        boolean rowDelete = false;
        try (Connection connection = DBconnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE orderId=?");) {

            preparedStatement.setInt(1, order.getOrderId());
            rowDelete = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }


    public static boolean updateOrder(Order order) {
        boolean rowUpdate = false;

        try {
        	Connection connection = DBconnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orders SET custId = ?, weight = ?, orderDate = ?, deliveryDate = ? WHERE orderId = ?;");
            
            preparedStatement.setInt(1, order.getCustId());
            preparedStatement.setDouble(2, order.getWeight());
            preparedStatement.setString(3, order.getOrderDate());
            preparedStatement.setString(4, order.getDeliveryDate());
            preparedStatement.setInt(5, order.getOrderId());

            rowUpdate = preparedStatement.executeUpdate() > 0;
            System.out.println(preparedStatement);
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }


    public static Order selectOrder(int orderId) {

        Order order = new Order();

        try (Connection connection = DBconnect.getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement("SELECT * FROM orders WHERE orderId = ?");) {

            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int orderid = resultSet.getInt("orderId");
                int custId = resultSet.getInt("custId");
                double weight = resultSet.getDouble("weight");
                String orderDate = resultSet.getString("orderDate");
                String deliveryDate = resultSet.getString("deliveryDate");

                order = new Order(orderid, custId, weight, orderDate, deliveryDate);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
}
