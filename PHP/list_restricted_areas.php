<?php

	include('config.php');
	
	//creating a query
	$stmt = $conn->prepare("SELECT id,latitude,longitude,radius FROM restricted_areas");

	//executing the query 
	$stmt->execute();
	
	//binding results to the query 
	$stmt->bind_result($id,$latitude,$longitude,$radius);
	
	$products = array(); 
	
	//traversing through all the result 
	while($stmt->fetch()){
		$temp = array();
		$temp['id'] = $id; 
		$temp['latitude'] = $latitude; 
		$temp['longitude'] = $longitude;
		$temp['radius'] = $radius;
	
		array_push($products, $temp);
	}
	
	//displaying the result in json format 
	echo json_encode($products);
?>