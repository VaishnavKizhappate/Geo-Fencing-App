<?php

    include('config.php');

    # Fetching data using POST method...
    $username = $_POST["user_name"];
    $password = $_POST["password"];
    $address = $_POST["address"];
    $landmark = $_POST["landmark"];
    $city = $_POST["city"];
    $emailid = $_POST["email"];
    $phone_number = $_POST["phone"];
    $guardian_and_relation = $_POST["guardian"];
    $nationality = $_POST["nationality"];
    $dob = $_POST["dob"];
    $gender = $_POST["gender"];

    $q = "INSERT INTO regtable VALUES ('', '$username','$password', '$address', '$landmark','$city','$emailid','$phone_number','$guardian_and_relation','$nationality','$dob','$gender')";
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