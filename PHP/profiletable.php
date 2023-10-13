<?php

    include('config.php');

    # Fetching data using POST method...
    $username = $_POST["user_name"];
    $address = $_POST["address"];
    $email = $_POST["email"];
    $phone = $_POST["phone"];
    

    $q = "INSERT INTO profiletable VALUES ('', '$username', '$address', '$email','$contact')";
    $result = mysqli_query($conn, $q);

    if ($result) {
        $response['status'] = "1";
        $response['message'] = "Registration successful";
    }
    else {
        $response['status'] = "0";
        $response['message'] = "Registration failed. Please try again!";
    }

    
    echo json_encode($response);
?>