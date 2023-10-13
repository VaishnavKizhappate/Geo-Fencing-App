<?php

    include('config.php');

    # Fetching data using POST method...
    $username = $_POST["email"];
    $password = $_POST["complaint"];
    

   
    $q = "INSERT INTO complainttable VALUES ('', '$email','$complaint')";
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