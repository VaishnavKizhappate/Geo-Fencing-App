<?php

	include('config.php');
	
	//creating a query
	$stmt = $conn->prepare("SELECT district,area,name,contact FROM rescue_team");

	//executing the query 
	$stmt->execute();
	
	//binding results to the query 
	$stmt->bind_result($district,$area,$name,$contact);
	
	$products = array(); 
	
	//traversing through all the result 
	while($stmt->fetch()){
		$temp = array();
		$temp['district'] = $district; 
		$temp['area'] = $area; 
		$temp['name'] = $name;
        $temp['contact'] = $contact;
	
		array_push($products, $temp);
	}
	
	//displaying the result in json format 
	echo json_encode($products);
?>


