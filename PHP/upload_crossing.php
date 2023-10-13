<?php

    include('config.php');

    # Fetching data using POST method...
    $username = $_POST["username"];
    $date = $_POST["date"];
    $time = $_POST["time"];
    $latitude = $_POST["latitude"];
    $longitude = $_POST["longitude"];

    $q = "INSERT INTO restricted_crossing (username,date,time,latitude,longitude) VALUES ('$username','$date', '$time', '$latitude','$longitude')";
    $result = mysqli_query($conn, $q);

    if ($result) {
        $response['status'] = "1";
        $response['message'] = "Added successfully";
    }
    else {
        $response['status'] = "0";
        $response['message'] = "Adding failed. Please try again!";
    }

    
    echo json_encode($response);
?>