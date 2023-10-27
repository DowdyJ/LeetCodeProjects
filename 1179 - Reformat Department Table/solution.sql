SELECT DISTINCT
  d.id, 
  Jan_Revenue, 
  Feb_Revenue, 
  Mar_Revenue, 
  Apr_Revenue, 
  May_Revenue, 
  Jun_Revenue, 
  Jul_Revenue,
  Aug_Revenue,
  Sep_Revenue,
  Oct_Revenue,
  Nov_Revenue,
  Dec_Revenue
FROM Department d 
LEFT JOIN (SELECT id, SUM(revenue) AS Jan_Revenue FROM Department WHERE month = "Jan" GROUP BY id) jr ON jr.id = d.id
LEFT JOIN (SELECT id, SUM(revenue) AS Feb_Revenue FROM Department WHERE month = "Feb" GROUP BY id) fr ON fr.id = d.id 
LEFT JOIN (SELECT id, SUM(revenue) AS Mar_Revenue FROM Department WHERE month = "Mar" GROUP BY id) mr ON mr.id = d.id 
LEFT JOIN (SELECT id, SUM(revenue) AS Apr_Revenue FROM Department WHERE month = "Apr" GROUP BY id) ar ON ar.id = d.id 
LEFT JOIN (SELECT id, SUM(revenue) AS May_Revenue FROM Department WHERE month = "May" GROUP BY id) yr ON yr.id = d.id 
LEFT JOIN (SELECT id, SUM(revenue) AS Jun_Revenue FROM Department WHERE month = "Jun" GROUP BY id) ur ON ur.id = d.id 
LEFT JOIN (SELECT id, SUM(revenue) AS Jul_Revenue FROM Department WHERE month = "Jul" GROUP BY id) lr ON lr.id = d.id 
LEFT JOIN (SELECT id, SUM(revenue) AS Aug_Revenue FROM Department WHERE month = "Aug" GROUP BY id) gr ON gr.id = d.id 
LEFT JOIN (SELECT id, SUM(revenue) AS Sep_Revenue FROM Department WHERE month = "Sep" GROUP BY id) sr ON sr.id = d.id 
LEFT JOIN (SELECT id, SUM(revenue) AS Oct_Revenue FROM Department WHERE month = "Oct" GROUP BY id) cr ON cr.id = d.id 
LEFT JOIN (SELECT id, SUM(revenue) AS Nov_Revenue FROM Department WHERE month = "Nov" GROUP BY id) nr ON nr.id = d.id 
LEFT JOIN (SELECT id, SUM(revenue) AS Dec_Revenue FROM Department WHERE month = "Dec" GROUP BY id) dr ON  dr.id = d.id;

