<?php

    include('config.php');

    # Fetching data using POST method...
    $username = $_POST["email"];
    $password = $_POST["feedback"];
    

   
    $q = "INSERT INTO feedbacktable VALUES ('', '$username','$password')";
    $result = mysqli_query($conn, $q);

    if ($result) {
        $response['status'] = "1";
        $response['message'] = "sending...";
    }
    else {
        $response['status'] = "0";
        $response['message'] = "Registration failed. Please try again!";
    }

    
    echo json_encode($response);
?>