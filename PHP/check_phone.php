<?php

    include('config.php');
    
    $phone= $_POST["phone"];
    
    $qry = "select * from regtable where phone='$phone' ";
    
    $result = mysqli_query($conn, $qry) or die("error in selection".mysqli_error($conn));
    
    if(mysqli_num_rows($result) > 0) 
    {
    	$arr['StatusID'] = "1";
    }
    else 
    {
        $arr['StatusID'] = "0";
    }
    
    echo json_encode($arr);

?>