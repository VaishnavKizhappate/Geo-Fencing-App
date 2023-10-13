<?php

    include('config.php');
    
    $password= $_POST["password"];
    $phone = $_POST["phone"];
    
    $qry = "UPDATE regtable SET password='$password' WHERE phone='$phone' ";
    
    $result = mysqli_query($conn, $qry) or die("error in selection".mysqli_error($conn));
    
    if($result) 
    {
    	$arr['StatusID'] = "1";
    }
    else 
    {
        $arr['StatusID'] = "0";
    }
    
    echo json_encode($arr);

?>