<?php
 
 include('config.php');

    # Fetching data using POST method...
 $userid = $_POST["userid"];
 $latitude = $_POST["latitude"];
 $longitude = $_POST["longitude"];
 $q = "INSERT INTO location VALUES ('', '$userid','$latitude', '$longitude')";
    $result = mysqli_query($conn, $q);

   
    if ($result) {
        $response['status'] = "1";
        $response['message'] = "location fetched successfully";
    }
    else {
        $response['status'] = "0";
        $response['message'] = "location fetching failed.please check your internet connection";
    }

    
    echo json_encode($response);
?>