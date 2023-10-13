<?php
 
 include('config.php');

 # Fetching data using POST method...
 $id = $_POST["id"];
 $latitude = $_POST["latitude"];
 $longitude = $_POST["longitude"];

    $q = "UPDATE regtable SET latitude='$latitude', longitude='$longitude' WHERE id='$id' ";
    $result = mysqli_query($conn, $q);

    if ($result) {
        $response['status'] = "1";
        $response['message'] = "Location updated successfully";
    }
    else {
        $response['status'] = "0";
        $response['message'] = "Updation failed..Please try again!";
    }

    echo json_encode($response);
?>