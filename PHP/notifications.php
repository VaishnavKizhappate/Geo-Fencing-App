<?php

	include('config.php');
	
	//creating a query
	$stmt = $conn->prepare("SELECT title,notifications,date FROM notifications");

	//executing the query 
	$stmt->execute();
	
	//binding results to the query 
	$stmt->bind_result($title,$notifications,$date);
	
	$products = array(); 
	
	//traversing through all the result 
	while($stmt->fetch()){
		$temp = array();
		$temp['title'] = $title; 
		$temp['notifications'] = $notifications; 
		$temp['date'] = $date;
	
		array_push($products, $temp);
	}
	
	//displaying the result in json format 
	echo json_encode($products);
?>


