WITH AugmentedOrders AS (
    SELECT
        delivery_id,
        customer_id,
        order_date,
        MIN(order_date) OVER(PARTITION BY customer_id) AS min_order_date,
        IF(customer_pref_delivery_date = order_date, 1, NULL) AS immediate
    FROM Delivery
),
FirstOrders AS (
    SELECT
        delivery_id,
        immediate
    FROM AugmentedOrders
    WHERE order_date = min_order_date
)
SELECT ROUND((COUNT(immediate) / COUNT(delivery_id)) * 100, 2) AS immediate_percentage 
FROM FirstOrders;
